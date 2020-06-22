package Almacen;

import conexion.conexionSQL;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Consulta_del_producto extends javax.swing.JFrame {

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("./Imagenes/logo_icon.png"));

        return retValue;
    }

    public String varnombre = "";
    public String vardepartamento = "";
    public String varexistencia = "";
    public String varproveedor = "";
    public String vardescripcion = "";
    public String varprecio = "";
    public String varcosto = "";

    private void limpiarCajas() {

        TxtCodigodeBarras.setText(null);
        TxtNombredelproducto.setText(null);
        TxtDepartamento.setText(null);
        Txtcosto.setText(null);
        TxtPrecio.setText(null);
        Txtproveedor.setText(null);
        Txtdescripcion.setText(null);
        TxtExistencia.setText(null);
        TxtImagen.removeAll();
        TxtImagen.repaint();

        TxtCodigodeBarras.requestFocus();
    }

    public int deleteRecordProducto(String ID) {

        conexionSQL cc = new conexionSQL();
        Connection con = cc.conexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            String id_barras = TxtCodigodeBarras.getText();
            String table_name = "productos";
            String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + id_barras + "\"";
            Statement st = con.createStatement();
            st.executeUpdate(Query);
            return 1;
            //    JOptionPane.showMessageDialog(this, "Se borro el registro especificado");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
            // JOptionPane.showMessageDialog(this, "Error borrando el registro especificado");
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta_del_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificarProducto() {
        
        int valida = 0;
        valida = updateDataProducto(varprecio, vardepartamento, varexistencia, varproveedor, varexistencia, varcosto, vardescripcion);
        if (valida == 0) {
            JOptionPane.showMessageDialog(this, "No se modificaron los productos");

        } else {
            JOptionPane.showMessageDialog(this, "Se modificaron los productos con éxito");
            validarProducto();
        }
    }

    public int updateDataProducto(String producto,
            String departamento,
            String existencia,
            String proovedor,
            String precio_unitario,
            String costo_unitario,
            String descripcion) {
        
        conexionSQL cc = new conexionSQL();
        Connection con = cc.conexion();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            producto = TxtNombredelproducto.getText();
            departamento = TxtDepartamento.getText();
            existencia = TxtExistencia.getText();
            proovedor = Txtproveedor.getText();
            precio_unitario = TxtPrecio.getText();
            costo_unitario = Txtcosto.getText();
            descripcion = Txtdescripcion.getText();

            byte[] image = null;
            String table_name = "productos";
            String id_barras = TxtCodigodeBarras.getText();
            //int response;
            String sql = ("UPDATE  " + table_name + " "
                    + "SET producto =  '" + producto + "', "
                    + "departamento = '" + departamento + "', "
                    + "existencia = '" + existencia + "', "
                    + "proveedor = '" + proovedor + "', "
                    + "precio_unitario = '" + precio_unitario + "', "
                    + "costo_unitario = '" + costo_unitario + "', "
                    + "descripcion = '" + descripcion + "' "
                    + "WHERE  id = '" + id_barras + "'");
            System.out.println("ConsultaPreparada" + sql);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            //System.out.println(" Response: "+ response);
            //JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
            return 0;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta_del_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminarProducto() {

        int valida = 0;
        valida = deleteRecordProducto("");

        if (valida == 0) {
            JOptionPane.showMessageDialog(this, "Se eliminaron los productos");

        } else {
            JOptionPane.showMessageDialog(this, "Se eliminaron los productos con éxito");
            validarProducto();
        }
    }

    public void validarProducto() {
        
        conexionSQL cc = new conexionSQL();
        Connection con = cc.conexion();

        int resultado = 0;
        String barras = TxtCodigodeBarras.getText();
        String SQL = "select * from productos where id = '" + barras + "';";
        //Imagen
        BufferedImage buffimg = null;
        byte[] image = null;

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;
                //Imagen
                //image = rs.getBytes("imagen_d");
                //InputStream img = rs.getBinaryStream(1);
                if (resultado == 1) {
                    varnombre = rs.getString("PRODUCTO");
                    TxtNombredelproducto.setText(rs.getString("PRODUCTO"));

                    vardepartamento = rs.getString("DEPARTAMENTO");
                    TxtDepartamento.setText(rs.getString("DEPARTAMENTO"));

                    varexistencia = rs.getString("EXISTENCIA");
                    TxtExistencia.setText(rs.getString("EXISTENCIA"));

                    varproveedor = rs.getString("PROVEEDOR");
                    Txtproveedor.setText(rs.getString("PROVEEDOR"));

                    varprecio = rs.getString("PRECIO_UNITARIO");
                    TxtPrecio.setText(rs.getString("PRECIO_UNITARIO"));

                    varcosto = rs.getString("COSTO_UNITARIO");
                    Txtcosto.setText(rs.getString("COSTO_UNITARIO"));

                    vardescripcion = rs.getString("DESCRIPCION");
                    Txtdescripcion.setText(rs.getString("DESCRIPCION"));

                    image = rs.getBytes("imagen_d");
                    InputStream img = rs.getBinaryStream("imagen_d");
                    buffimg = ImageIO.read(img);
                    int x = TxtImagen.getWidth();
                    int y = TxtImagen.getHeight();
                    ImagenMySQL imagen = new ImagenMySQL(x, y, buffimg);

                    TxtImagen.add(imagen);
                    TxtImagen.repaint();

                    this.dispose();
                    this.setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta_del_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void botonVolver() {
        Inicio_Almacen form = new Inicio_Almacen();
        form.setVisible(true);
        this.dispose();
    }

    public Consulta_del_producto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtNombredelproducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtExistencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Txtproveedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Txtdescripcion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtPrecio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Txtcosto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtImagen = new javax.swing.JTextField();
        TxtCodigodeBarras = new javax.swing.JTextField();
        TxtDepartamento = new javax.swing.JTextField();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("      Consulta");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo_Peque.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Ingrese Codigo de Barras:");

        jLabel4.setText("Nombre del producto:");

        TxtNombredelproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombredelproductoActionPerformed(evt);
            }
        });

        jLabel5.setText("Departamento:");

        jLabel6.setText("Existencia:");

        TxtExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtExistenciaActionPerformed(evt);
            }
        });

        jLabel7.setText("Proveedor:");

        Txtproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtproveedorActionPerformed(evt);
            }
        });

        jLabel8.setText("Descripcion:");

        jLabel10.setText("Precio: $");

        TxtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setText("Costo: $");

        Txtcosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setText("Imagen:");

        TxtCodigodeBarras.setToolTipText("");
        TxtCodigodeBarras.setName("TxtCodigodeBarras"); // NOI18N
        TxtCodigodeBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodigodeBarras(evt);
            }
        });

        TxtDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDepartamentoActionPerformed(evt);
            }
        });

        jButtonLimpiar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.setActionCommand("");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonVolver.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonVolver.setText("Volver");
        jButtonVolver.setToolTipText("");
        jButtonVolver.setActionCommand("");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxtCodigodeBarras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(TxtNombredelproducto)
                                    .addComponent(TxtExistencia)
                                    .addComponent(TxtDepartamento, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(Txtcosto)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(223, 223, 223))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(TxtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jButtonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtCodigodeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtNombredelproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(Txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addComponent(Txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNombredelproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombredelproductoActionPerformed

    }//GEN-LAST:event_TxtNombredelproductoActionPerformed

    private void TxtExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtExistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtExistenciaActionPerformed

    private void TxtproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtproveedorActionPerformed

    private void TxtCodigodeBarras(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodigodeBarras
        validarProducto();
    }//GEN-LAST:event_TxtCodigodeBarras

    private void TxtDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDepartamentoActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiarCajas();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        botonVolver();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Modificar
        modificarProducto();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        eliminarProducto();     //Eliminar
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Consulta_del_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_del_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_del_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_del_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta_del_producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtCodigodeBarras;
    private javax.swing.JTextField TxtDepartamento;
    private javax.swing.JTextField TxtExistencia;
    private javax.swing.JTextField TxtImagen;
    private javax.swing.JTextField TxtNombredelproducto;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField Txtcosto;
    private javax.swing.JTextField Txtdescripcion;
    private javax.swing.JTextField Txtproveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
