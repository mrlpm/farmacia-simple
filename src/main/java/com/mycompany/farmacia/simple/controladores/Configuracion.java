/*
 * The MIT License
 *
 * Copyright 2020 Monica Ranchos y Luis Pérez.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mycompany.farmacia.simple.controladores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.ini4j.Ini;

/**
 *
 * @author Monica Ranchos y Luis Pérez
 */
public class Configuracion {

    String app_path;
    String config_name;
    String home;
    Path path;
    Path parentRuta;
    Path rutaFile;
    String usuario;
    String clave;
    String servidor;
    String puerto;
    String database;
    
    public Configuracion(String ruta, String archivo) {
        this.app_path = ruta;
        this.config_name = archivo;
        this.home = System.getProperty("user.home");
        this.parentRuta = java.nio.file.Paths.get(this.home, this.app_path);
        this.rutaFile = java.nio.file.Paths.get(this.parentRuta.toString(), this.config_name);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getApp_path() {
        return app_path;
    }

    public void setApp_path(String app_path) {
        this.app_path = app_path;
    }

    public String getConfig_name() {
        return config_name;
    }

    public void setConfig_name(String config_name) {
        this.config_name = config_name;
    }
    
    public void Leer(){
        try {
            Ini iniFile = new Ini(new File(this.rutaFile.toString()));
            Ini.Section seccion = iniFile.get("database");
            this.setUsuario(seccion.get("usuario"));
            this.setClave(seccion.get("clave"));
            this.setServidor(seccion.get("servidor"));
            this.setPuerto(seccion.get("puerto"));
            this.setDatabase(seccion.get("base"));
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean Existe(){
        home = System.getProperty("user.home");
        path = java.nio.file.Paths.get(home, this.app_path, this.config_name);
        boolean config_file;
        config_file = java.nio.file.Files.exists(path);
        return config_file;
    }
    
    public void Crear() {
        String content;
        content = "[database]\nusuario="+this.getUsuario()+"\nclave="+this.clave+
                "\nservidor="+this.servidor+"\npuerto="+this.puerto+"\nbase="+this.database;
        
        try {
            java.nio.file.Files.deleteIfExists(this.rutaFile);
            java.nio.file.Files.createDirectories(this.parentRuta);
            Files.writeString(this.rutaFile, content);
            System.out.println(content);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
