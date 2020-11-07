/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.farmacia.simple.modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Monica Ranchos y Luis Pérez
 */
public class conexion {
    String db_url;
    String usuario;
    String clave;

    public conexion() {
    }
    
    
    public conexion(String db_url, String username, String password) {
        this.db_url = db_url;
        this.usuario = username;
        this.clave = password;
    }
    
    public Connection conectar(){
        Connection link=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            link = DriverManager.getConnection(this.db_url, this.usuario, this.clave);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }
}
