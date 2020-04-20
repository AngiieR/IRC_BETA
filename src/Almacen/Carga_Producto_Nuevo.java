package Almacen;

import conexion.conexionSQL;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Carga_Producto_Nuevo extends javax.swing.JFrame {

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("./Imagenes/logo_icon.png"));


        return retValue;
    }    
    
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();

    PreparedStatement ps;
    ResultSet rs;
    
    
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
   
    public void insertarProducto() {

        String id = TxtCodigodeBarras.getText();
        String departamento = TxtDepartamento.getText();
        String producto = TxtNombredelproducto.getText();
        String costo_unitario = Txtcosto.getText();
        String precio_unitario = TxtPrecio.getText();
        String existencia = TxtExistencia.getText();
        String proveedor = Txtproveedor.getText();
        String descripcion = Txtdescripcion.getText();

        //Imagen
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.PNG", "png");
        fc.setFileFilter(filtro);
        
        int seleccion = fc.showOpenDialog(this);       
        
        String barras = TxtCodigodeBarras.getText();
        String SQL_consulta = "select * from productos where id = '" + barras + "';";
        String SQL_insertar = "INSERT INTO productos (ID, DEPARTAMENTO, PRODUCTO, COSTO_UNITARIO, PRECIO_UNITARIO, EXISTENCIA, PROVEEDOR, DESCRIPCION) VALUES ('" + id + "', '" + departamento + "', '" + producto + "', " + costo_unitario + ", " + precio_unitario + ", " + existencia + ", '" + proveedor + "', '" + descripcion + "');";      
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_consulta);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Producto ya existe");
            } else {
                try {
                    if (seleccion == JFileChooser.APPROVE_OPTION) {
                        File fichero = fc.getSelectedFile();
                        String ruta = fichero.getAbsolutePath();
                        
                        //Datos de Formulario
                        
                        try {
                            FileInputStream fis = new FileInputStream(fichero);
                            Connection con = cc.conexion();
                            try {
                                PreparedStatement ps;
                                ResultSet rsimg;

                                ps = con.prepareStatement("INSERT INTO productos (ID, DEPARTAMENTO, PRODUCTO, COSTO_UNITARIO, PRECIO_UNITARIO, EXISTENCIA, PROVEEDOR, DESCRIPCION, imagen_d) VALUES (?,?,?,?,?,?,?,?,?);");
                                ps.setString(1, id);
                                ps.setString(2, departamento);
                                ps.setString(3, producto);
                                ps.setString(4, costo_unitario);
                                ps.setString(5, precio_unitario);
                                ps.setString(6, existencia);
                                ps.setString(7, proveedor);
                                ps.setString(8, descripcion);
                                                                
                                ps.setBinaryStream(9, fis, (int) fichero.length());
                                ps.execute();
                                ps.close();
                                JOptionPane.showMessageDialog(null, "Imagen Guardada");

                                //Mostrar imagen
                                int x = TxtImagen.getWidth();
                                int y = TxtImagen.getHeight();
                                Imagen img = new Imagen(x, y, ruta);
                                TxtImagen.add(img);
                                TxtImagen.repaint();
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(Carga_Producto_Nuevo.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null, "Error en cargar Imagen");
                            }
                        
                        ps.close();
                        con.close();                            

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Carga_Producto_Nuevo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        Statement sti = con.createStatement();
                        sti.executeUpdate(SQL_insertar);

                        JOptionPane.showMessageDialog(null, "Producto agregado");
                        this.dispose();
                        this.setVisible(true);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void botonVolver() {
        Inicio_Almacen form = new Inicio_Almacen();
        form.setVisible(true);
        this.dispose();
    }

    public void mostrarImagen(){
        
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.PNG", "png");
        fc.setFileFilter(filtro);
        
        int seleccion = fc.showOpenDialog(this);     
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            String ruta = fichero.getAbsolutePath();

            int x = TxtImagen.getWidth();
            int y = TxtImagen.getHeight();
            Imagen imgExt = new Imagen(x, y, ruta);
            TxtImagen.add(imgExt);
            TxtImagen.repaint();
        }

    }
        
    public Carga_Producto_Nuevo() {
        initComponents();   
    }


    
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxtCodigodeBarras4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TxtCodigodeBarras = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        Txtproveedor = new javax.swing.JTextField();
        TxtDepartamento = new javax.swing.JTextField();
        TxtNombredelproducto = new javax.swing.JTextField();
        TxtExistencia = new javax.swing.JTextField();
        Txtdescripcion = new javax.swing.JTextField();
        TxtPrecio = new javax.swing.JTextField();
        Txtcosto = new javax.swing.JTextField();
        jButtonLimpiar = new javax.swing.JButton();
        TxtImagen = new javax.swing.JPanel();

        TxtCodigodeBarras4.setToolTipText("");
        TxtCodigodeBarras4.setName("TxtCodigodeBarras"); // NOI18N
        TxtCodigodeBarras4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodigodeBarras4(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("      Añadir Nuevo Producto");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Ingrese Codigo de Barras:");

        jLabel4.setText("Nombre del producto:");

        jLabel5.setText("Departamento:");

        jLabel6.setText("Existencia:");

        jLabel7.setText("Proveedor:");

        jLabel8.setText("Descripcion:");

        jLabel10.setText("Precio:");

        jLabel11.setText("Costo:");

        jLabel12.setText("Imagen:");

        TxtCodigodeBarras.setToolTipText("");
        TxtCodigodeBarras.setName("TxtCodigodeBarras"); // NOI18N
        TxtCodigodeBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodigodeBarras(evt);
            }
        });

        jButtonGuardar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setActionCommand("");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
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

        Txtproveedor.setToolTipText("");
        Txtproveedor.setName("TxtCodigodeBarras"); // NOI18N
        Txtproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txtproveedor(evt);
            }
        });

        TxtDepartamento.setToolTipText("");
        TxtDepartamento.setName("TxtCodigodeBarras"); // NOI18N
        TxtDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDepartamento(evt);
            }
        });

        TxtNombredelproducto.setToolTipText("");
        TxtNombredelproducto.setName("TxtCodigodeBarras"); // NOI18N
        TxtNombredelproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombredelproducto(evt);
            }
        });

        TxtExistencia.setToolTipText("");
        TxtExistencia.setName("TxtCodigodeBarras"); // NOI18N
        TxtExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtExistencia(evt);
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

        javax.swing.GroupLayout TxtImagenLayout = new javax.swing.GroupLayout(TxtImagen);
        TxtImagen.setLayout(TxtImagenLayout);
        TxtImagenLayout.setHorizontalGroup(
            TxtImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );
        TxtImagenLayout.setVerticalGroup(
            TxtImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );

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
                            .addComponent(TxtNombredelproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtCodigodeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Txtcosto, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(TxtPrecio)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(TxtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtCodigodeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(TxtNombredelproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addContainerGap(25, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCodigodeBarras(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodigodeBarras
        insertarProducto();
    }//GEN-LAST:event_TxtCodigodeBarras

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        insertarProducto();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        botonVolver();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void Txtproveedor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txtproveedor
        // TODO add your handling code here:
    }//GEN-LAST:event_Txtproveedor

    private void TxtDepartamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDepartamento
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDepartamento

    private void TxtNombredelproducto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombredelproducto
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombredelproducto

    private void TxtCodigodeBarras4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodigodeBarras4
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCodigodeBarras4

    private void TxtExistencia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtExistencia
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtExistencia

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiarCajas();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Carga_Producto_Nuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carga_Producto_Nuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carga_Producto_Nuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carga_Producto_Nuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carga_Producto_Nuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtCodigodeBarras;
    private javax.swing.JTextField TxtCodigodeBarras4;
    private javax.swing.JTextField TxtDepartamento;
    private javax.swing.JTextField TxtExistencia;
    private javax.swing.JPanel TxtImagen;
    private javax.swing.JTextField TxtNombredelproducto;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField Txtcosto;
    private javax.swing.JTextField Txtdescripcion;
    private javax.swing.JTextField Txtproveedor;
    private javax.swing.JButton jButtonGuardar;
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
