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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Monica Ranchos y Luis Pérez
 */
public class Operaciones {

    Connection conn;
    
    public Operaciones(Connection cn){
        this.conn = cn;
    }
    
    
    public void ConsultarTabla(DefaultTableModel modelo, String table){
        String query = "SELECT * FROM "+table+";";
        Object[] values = null;
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            final int columnCount = resultSetMetaData.getColumnCount();
            while (rs.next()){
                values = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    values[i - 1] = rs.getObject(i);
                }
                modelo.addRow(values);
            }
        } catch (SQLException e) {
        }
    }
    
    public void UltimoRegistro(DefaultTableModel modelo, String table, String PK){
        String query = "SELECT * FROM "+table+" ORDER BY "+PK+" DESC LIMIT 1;";
        System.out.println(query);
        Object[] values = null;
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            final int columnCount = resultSetMetaData.getColumnCount();
            while (rs.next()){
                values = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    values[i - 1] = rs.getObject(i);
                }
                modelo.addRow(values);
            }
        } catch (SQLException e) {
        }
    }
    public DefaultTableModel Buscar(String table,String criterio, String objeto){
        String query = "SELECT * FROM "+table+" where "+criterio+" like '%"+objeto+"%';";
        System.out.println(query);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        Object[] values = null;
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            final int columnCount = resultSetMetaData.getColumnCount();
            while (rs.next()){
                values = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    values[i - 1] = rs.getObject(i);
                    System.out.println(values[i-1]);
                }
                modelo.addRow(values);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo;
    }
    
    public void Insertar(String query, String objeto){
        try {
            Statement stmt = conn.createStatement();
            int n = stmt.executeUpdate(query);
            if (n != 0) {
                JOptionPane.showMessageDialog(null, objeto);
            }
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void actualizarRegistro(String query, String objeto) {
        try {
            Statement stmt = conn.createStatement();
            int n = stmt.executeUpdate(query);
            if (n != 0) {
                JOptionPane.showMessageDialog(null, objeto);
            }
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
