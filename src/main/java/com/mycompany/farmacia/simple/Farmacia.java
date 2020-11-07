/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.farmacia.simple;

import com.mycompany.farmacia.simple.controladores.Auth;
import com.mycompany.farmacia.simple.vistas.FrmConfiguracion;
import com.mycompany.farmacia.simple.vistas.Login;
import com.mycompany.farmacia.simple.controladores.Configuracion;
import java.sql.Connection;
import com.mycompany.farmacia.simple.modelos.Conexion;

/**
 *
 * @author Monica Ranchos y Luis Pérez
 */
public class Farmacia {
    
    
    public static void main(String[] args) {
        Configuracion conf = new Configuracion(".farmacia","config.ini");
        Auth auth = new Auth();
        if (conf.Existe()){
            conf.Leer();
            String username, password, host, port, db_name, db_url;
            username = conf.getUsuario();
            password = conf.getClave();
            host = conf.getServidor();
            port = conf.getPuerto();
            db_name = conf.getDatabase();
            db_url = "jdbc:mysql://"+host+":"+port+"/"+db_name;
            Conexion mysql = new Conexion(db_url, username, password);
            Connection cn = mysql.conectar();
            Login frmLogin = new Login();
            frmLogin.setAuth(auth);
            frmLogin.setConn(cn);
            frmLogin.setVisible(true);
        } else {
            FrmConfiguracion frmConfig = new FrmConfiguracion(conf);
            frmConfig.setVisible(true);
        }
        
    }
}
