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

import com.mycompany.farmacia.simple.modelos.Proveedores;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Monica Ranchos y Luis Pérez
 */
public class Operaciones {

    Connection conn;
    
    public Operaciones(Connection cn){
        this.conn = cn;
    }
    
    public void Insertar(String query){
        try {
            Statement stmt = conn.createStatement();
            int n = stmt.executeUpdate(query);
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Producto Ingresado");
            }
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void Consultar(String query){
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){}
        } catch (SQLException e) {
        }
    }
    
    public ArrayList<Proveedores> ConsultarProveedores(){
        String query = "SELECT * FROM proveedores";
        ArrayList<Proveedores> proveedores = new ArrayList();
        Proveedores provtmp = new Proveedores();
        Integer contador = 0;
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                provtmp.setId(rs.getString("pk_proveedores"));
                provtmp.setNombre(rs.getString("nombre"));
                provtmp.setDireccion(rs.getString("direccion"));
                provtmp.setTelefono(rs.getString("telefono"));
                contador++;
                proveedores.add(provtmp);
            }
        } catch (SQLException e) {
        }
        return proveedores;
    }
    public void InsertarProveedores(String query, String objeto){
        try {
            Statement stmt = conn.createStatement();
            int n = stmt.executeUpdate(query);
            if (n != 0) {
                JOptionPane.showMessageDialog(null, objeto + " Ingresado");
            }
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
