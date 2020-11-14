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
package com.mycompany.farmacia.simple.vistas;

import com.mycompany.farmacia.simple.controladores.Operaciones;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Monica Ranchos y Luis Pérez
 */
public class Generic extends javax.swing.JFrame {

    Facturas frmFact = new Facturas();
    Operaciones ops;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Generic
     *
     * @param modelo
     * @param Fact
     * @param ocultar
     * @param ops
     */
    public Generic(DefaultTableModel modelo, Facturas Fact, boolean ocultar, Operaciones ops) {
        initComponents();
        this.model = modelo;
        jTable1.setModel(model);
        jTable1.setDefaultEditor(Object.class, null);
        frmFact = Fact;
        if (ocultar) {
            System.out.println("entro");
            lblCantidad.setVisible(false);
            txtCantidad.setVisible(false);
        }
        this.ops = ops;
    }
    
    public void disableSeleccionar(){
        btnSeleccionar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        lblCantidad.setText("Cantidad");

        txtBuscar.setText("Buscar");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeleccionar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionar)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        if (this.getTitle().equals("Clientes")) {
            Integer fila = jTable1.getSelectedRow();
            frmFact.txtCliente.setText(jTable1.getValueAt(fila, 1).toString());
            frmFact.txtNIT.setText(jTable1.getValueAt(fila, 2).toString());
            this.dispose();
        } else if (this.getTitle().equals("Productos")) {

            Integer fila = jTable1.getSelectedRow();
            String cantidad = "";
            if (txtCantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Debes ingresar una cantidad", "Mensaje", JOptionPane.ERROR_MESSAGE);
            } else {
                cantidad = txtCantidad.getText();
                String producto = jTable1.getValueAt(fila, 1).toString();
                String descripcion = jTable1.getValueAt(fila, 2).toString();
                String precio = jTable1.getValueAt(fila, 3).toString();
                frmFact.modeloFactura.addRow(new Object[]{cantidad, producto, descripcion, precio});
            }
        } 
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
        if (this.getTitle().equals("Productos")) {
            ArrayList<String> columnas = new ArrayList<>(Arrays.asList("ID", "Producto", "Descripcion", "Precio"));
            String producto = JOptionPane.showInputDialog(null, "Ingresa el nombre del producto");
            String query = "SELECT * FROM inventario WHERE producto like '%" + producto + "%';";
            model = ops.buscarGenerico(columnas, query);
            jTable1.setModel(model);
        } else if (this.getTitle().equals("Facturas")) {
            ArrayList<String> columnas = new ArrayList<>(Arrays.asList("ID", "Producto", "Descripcion", "Precio"));
            String fact = JOptionPane.showInputDialog(null, "Ingresa el nombre del cliente");
            String query = "SELECT fac.pk_factura,cl.nombre,inv.producto,det.cantidad,"
                + "det.precio,(det.cantidad*det.precio) as total FROM facturas fac "
                + "INNER JOIN detalle_factura det ON fk_factura = pk_factura INNER JOIN "
                + "clientes cl ON fk_cliente=pk_clientes INNER JOIN inventario inv "
                + "ON fk_producto=pk_inventario where cl.nombre like '%"+fact+"%';";
            model = ops.buscarGenerico(columnas, query);
            jTable1.setModel(model);        
        } 
    }//GEN-LAST:event_txtBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JButton txtBuscar;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}