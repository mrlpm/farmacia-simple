/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.farmacia.simple;

import java.nio.file.Path;

/**
 *
 * @author Monica Ranchos y Luis Pérez
 */
public class Farmacia {
    
    public static boolean configuracion(){
        String home = System.getProperty("user.home");
        Path path = java.nio.file.Paths.get(home, ".farmacia", "config.ini");
        boolean config_file = java.nio.file.Files.exists(path);
        return config_file;
    }
    public static void main(String[] args) {

        if (configuracion()){
            Login frmLogin = new Login();
            frmLogin.setVisible(true);
        } else {
            Configuracion frmConfig = new Configuracion();
            frmConfig.setVisible(true);
        }
        
    }
}
