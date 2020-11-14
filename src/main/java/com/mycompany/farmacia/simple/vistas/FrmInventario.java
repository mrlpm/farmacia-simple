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

import com.mycompany.farmacia.simple.controladores.Auth;
import com.mycompany.farmacia.simple.controladores.Operaciones;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author Monica Ranchos y Luis Pérez
 */
public class FrmInventario extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    private Connection conn;
    Operaciones ops;
    ArrayList<String> proveedores = new ArrayList();
    Auth auth = new Auth();
    String queryAll = "SELECT "
            + "p.pk_inventario,p.producto,p.descripcion,p.cantidad,p.precio,rb.nombre "
            + "FROM inventario p INNER JOIN proveedores rb ON p.fk_proveedores = rb.pk_proveedores;";

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setColumns() {
        modelo.addColumn("ID");
        modelo.addColumn("Producto");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Proveedor");
    }

    /**
     * Creates new form FrmProveedores
     *
     * @param cn
     */
    public FrmInventario(Connection cn) {
        this.conn = cn;
        this.ops = new Operaciones(conn);
        IconFontSwing.register(FontAwesome.getIconFont());
        Icon iconNew = IconFontSwing.buildIcon(FontAwesome.USER_PLUS, 15);
        Icon iconSave = IconFontSwing.buildIcon(FontAwesome.FLOPPY_O, 15);
        Icon iconSearch = IconFontSwing.buildIcon(FontAwesome.SEARCH, 15);
        Icon iconDelete = IconFontSwing.buildIcon(FontAwesome.USER_TIMES, 15);
        Icon iconChange = IconFontSwing.buildIcon(FontAwesome.LOCK, 15);
        initComponents();
        btnNuevo.setIcon(iconNew);
        btnGuardar.setIcon(iconSave);
        btnBuscar.setIcon(iconSearch);
        btnEliminar.setIcon(iconDelete);

        tblInventario.setModel(modelo);
        setColumns();
        ops.consultaGenerica(modelo, queryAll);
        proveedores = ops.getProveedores();
        for (Object proveedor : proveedores) {
            cmbProveedor.addItem(proveedor.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProducto = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        lblPrecio = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventario");
        setResizable(false);

        lblProducto.setText("Producto");

        lblDescripcion.setText("Descripcion");

        lblCantidad.setText("Cantidad");

        txtProducto.setEnabled(false);

        txtCantidad.setEnabled(false);
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInventario);

        lblPrecio.setText("Precio");

        lblProveedor.setText("Proveedor");

        lblBuscar.setText("Buscar");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setTabSize(4);
        txtDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(txtDescripcion);

        txtPrecio.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProducto)
                            .addComponent(lblDescripcion)
                            .addComponent(lblCantidad)
                            .addComponent(lblPrecio)
                            .addComponent(lblProveedor))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProducto)
                            .addComponent(txtCantidad)
                            .addComponent(cmbProveedor, 0, 271, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(txtPrecio)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblBuscar)
                            .addGap(35, 35, 35)
                            .addComponent(txtBuscar))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNuevo)
                            .addGap(18, 18, 18)
                            .addComponent(btnGuardar)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addComponent(btnEliminar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescripcion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProveedor)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitarTextos();
        if (btnGuardar.getText().equals("Editar")) {
            btnGuardar.setText("Guardar");
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void habilitarTextos() {
        txtProducto.setEnabled(true);
        txtProducto.grabFocus();
        txtDescripcion.setEnabled(true);
        txtCantidad.setEnabled(true);
        txtPrecio.setEnabled(true);
    }

    private void deshabilitarTextos() {
        txtProducto.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtCantidad.setEnabled(false);
        txtPrecio.setEnabled(false);
    }

    private void limpiarTextos() {
        txtProducto.setText("");
        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtBuscar.setText("");
        txtPrecio.setText("");
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling
        String query, producto, descripcion, cantidad, precio, proveedor;
        producto = txtProducto.getText();
        descripcion = txtDescripcion.getText();
        cantidad = txtCantidad.getText();
        precio = txtPrecio.getText();
        proveedor = cmbProveedor.getSelectedItem().toString();
        String fk_proveedor = "SELECT pk_proveedores from proveedores where nombre='" + proveedor + "'";
        if (btnGuardar.getText().equals("Guardar")) {

            query = "INSERT INTO inventario (producto,descripcion,cantidad,precio,fk_proveedores) values ('"
                    + producto + "','" + descripcion + "','" + cantidad + "','" + precio + "',(" + fk_proveedor + "));";
            System.out.println(query);
            ops.Insertar(query, "Producto Agregado", true);
            limpiarTextos();
            modelo.setNumRows(0);
            ops.consultaGenerica(modelo, queryAll);
            deshabilitarTextos();
            txtBuscar.setEnabled(true);
        }
        if (btnGuardar.getText().equals("Editar")) {
            Integer pk = Integer.parseInt(tblInventario.getValueAt(tblInventario.getSelectedRow(), 0).toString());
            query = "UPDATE inventario set producto='" + producto + "',"
                    + "descripcion='" + descripcion + "',cantidad=" + cantidad + ",precio=" + precio
                    + ",fk_proveedores=(" + fk_proveedor + ") where pk_inventario=" + pk + ";";
            System.out.println(query);
            ops.actualizarRegistro(query, "Producto Editado");
            limpiarTextos();
            modelo.setNumRows(0);
            ops.consultaGenerica(modelo, queryAll);
            deshabilitarTextos();
            txtBuscar.setEnabled(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String query = "delete from inventario where producto='" + txtProducto.getText() + "';";
        ops.actualizarRegistro(query, "Producto Eliminado");
        limpiarTextos();
        modelo.setNumRows(0);
        ops.consultaGenerica(modelo, queryAll);
        deshabilitarTextos();
        txtBuscar.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String word = txtBuscar.getText();
        setColumns();
        ArrayList<String> columnas = new ArrayList<String>(Arrays.asList("ID", "Producto", "Descripcion", "Cantidad", "Precio", "Proveedor"));
        String queryBuscar = "SELECT p.pk_inventario,p.producto,p.descripcion,p.cantidad,p.precio,rb.nombre "
                + "FROM inventario p INNER JOIN proveedores rb ON "
                + "p.fk_proveedores = rb.pk_proveedores where p.producto like '%" + word + "%';";
        //modelo = ops.Buscar(columnas, "empleados", "nombres", word);
        modelo = ops.buscarGenerico(columnas, queryBuscar);
        tblInventario.setModel(modelo);
        limpiarTextos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseClicked
        // TODO add your handling code here:
        Integer fila_seleccionada = tblInventario.getSelectedRow();
        txtProducto.setText(tblInventario.getValueAt(fila_seleccionada, 1).toString());
        txtDescripcion.setText(tblInventario.getValueAt(fila_seleccionada, 2).toString());
        txtCantidad.setText(tblInventario.getValueAt(fila_seleccionada, 3).toString());
        txtPrecio.setText(tblInventario.getValueAt(fila_seleccionada, 4).toString());
        cmbProveedor.setSelectedItem(tblInventario.getValueAt(fila_seleccionada, 5).toString());

        habilitarTextos();
        btnGuardar.setText("Editar");
    }//GEN-LAST:event_tblInventarioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbProveedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
