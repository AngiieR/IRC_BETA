package Caja;//Empieza...
import Almacen.*;
import conexion.conexionSQL;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Caja_Inicio extends javax.swing.JFrame {

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("./Imagenes/logo_icon.png"));
        return retValue;
    }       
    
    public String varnombre="";
    public String vardescripcion="";
    public String varprecio="";
    
    conexionSQL cc=new conexionSQL();
    Connection con=cc.conexion();
        
    PreparedStatement ps;
    ResultSet rs;
   
    public void BotonIniciarServicio() {
        Login_Caja form = new Login_Caja();
        form.setVisible(true);
        this.dispose();        
 }

    public Caja_Inicio() {
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
        jLabelCantidad = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        jButtonCancelarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ventas = new javax.swing.JTable();
        jButtonBuscar = new javax.swing.JButton();
        jTxtCodigodeBarras = new javax.swing.JTextField();
        TextCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Te_Atiende = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        Txtdescripcion = new javax.swing.JTextField();
        jButtonIniciarServicio = new javax.swing.JButton();
        jButtonCancelarventa = new javax.swing.JButton();
        jButtonFinalizarVenta = new javax.swing.JButton();
        jButtonFinalizarServicio = new javax.swing.JButton();
        jLabelPrecio = new javax.swing.JLabel();
        Vendedor = new javax.swing.JTextField();
        TxtPrecio = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        txtRecibido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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
        jLabel1.setText("Bienvenido a Almacenes Beta");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1094, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabelCantidad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(51, 51, 51));
        jLabelCantidad.setText("Cantidad:");

        Total.setEditable(false);
        Total.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Total.setToolTipText("");
        Total.setName("Total"); // NOI18N
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total(evt);
            }
        });

        jButtonCancelarProducto.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonCancelarProducto.setText("Cancelar Producto");
        jButtonCancelarProducto.setToolTipText("");
        jButtonCancelarProducto.setActionCommand("");
        jButtonCancelarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarProductoActionPerformed(evt);
            }
        });

        Ventas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Código", "Nombre", "Precio", "Importe total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Ventas);

        jButtonBuscar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setToolTipText("");
        jButtonBuscar.setActionCommand("");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTxtCodigodeBarras.setEditable(false);
        jTxtCodigodeBarras.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTxtCodigodeBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigodeBarrasActionPerformed(evt);
            }
        });

        TextCantidad.setEditable(false);
        TextCantidad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TextCantidad.setText("1");
        TextCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextCantidadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Total M. N. $");

        Te_Atiende.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Te_Atiende.setForeground(new java.awt.Color(51, 51, 51));
        Te_Atiende.setText("Te atiende:");

        jLabelDescripcion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelDescripcion.setForeground(new java.awt.Color(51, 51, 51));
        jLabelDescripcion.setText("Descripción:");

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(51, 51, 51));
        jLabelCodigo.setText("Código de barras:");

        Txtdescripcion.setEditable(false);
        Txtdescripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Txtdescripcion.setBorder(null);

        jButtonIniciarServicio.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonIniciarServicio.setText("Iniciar Servicio");
        jButtonIniciarServicio.setToolTipText("");
        jButtonIniciarServicio.setActionCommand("");
        jButtonIniciarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarServicioActionPerformed(evt);
            }
        });

        jButtonCancelarventa.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonCancelarventa.setText("Cancelar Venta");
        jButtonCancelarventa.setToolTipText("");
        jButtonCancelarventa.setActionCommand("");
        jButtonCancelarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarventaActionPerformed(evt);
            }
        });

        jButtonFinalizarVenta.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonFinalizarVenta.setText("Cobrar");
        jButtonFinalizarVenta.setToolTipText("");
        jButtonFinalizarVenta.setActionCommand("");
        jButtonFinalizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarVentaActionPerformed(evt);
            }
        });

        jButtonFinalizarServicio.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonFinalizarServicio.setText("Finalizar Servicio");
        jButtonFinalizarServicio.setToolTipText("");
        jButtonFinalizarServicio.setActionCommand("");
        jButtonFinalizarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarServicioActionPerformed(evt);
            }
        });

        jLabelPrecio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelPrecio.setForeground(new java.awt.Color(51, 51, 51));
        jLabelPrecio.setText("Precio:");

        Vendedor.setEditable(false);
        Vendedor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Vendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Vendedor.setBorder(null);
        Vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VendedorActionPerformed(evt);
            }
        });

        TxtPrecio.setEditable(false);
        TxtPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtPrecio.setBorder(null);
        TxtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPrecioActionPerformed(evt);
            }
        });

        txtCambio.setEditable(false);
        txtCambio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioActionPerformed(evt);
            }
        });

        txtRecibido.setEditable(false);
        txtRecibido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRecibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecibidoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dinero Recibido");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cambio");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButtonIniciarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonFinalizarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(jLabelCantidad))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonCancelarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelCodigo, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txtdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(TextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPrecio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTxtCodigodeBarras)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(176, 176, 176)
                                        .addComponent(Te_Atiende))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonFinalizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(109, 109, 109)))
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(Vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(767, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Te_Atiende, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFinalizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTxtCodigodeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonFinalizarServicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonIniciarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(Vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(532, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCodigodeBarras4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodigodeBarras4
     
    }//GEN-LAST:event_TxtCodigodeBarras4

    private void jButtonCancelarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarProductoActionPerformed

    }//GEN-LAST:event_jButtonCancelarProductoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling Fcode here:
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void Total(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total
        //aqui
    }//GEN-LAST:event_Total

    private void jButtonIniciarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarServicioActionPerformed
        BotonIniciarServicio();
    }//GEN-LAST:event_jButtonIniciarServicioActionPerformed

    private void jButtonCancelarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarventaActionPerformed

    }//GEN-LAST:event_jButtonCancelarventaActionPerformed

    private void jButtonFinalizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarVentaActionPerformed

    }//GEN-LAST:event_jButtonFinalizarVentaActionPerformed

    private void jButtonFinalizarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFinalizarServicioActionPerformed

    private void TxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPrecioActionPerformed

    private void jTxtCodigodeBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigodeBarrasActionPerformed

    }//GEN-LAST:event_jTxtCodigodeBarrasActionPerformed

    private void TextCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCantidadActionPerformed

    private void VendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VendedorActionPerformed

    private void txtRecibidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecibidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecibidoActionPerformed

    private void txtCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCambioActionPerformed
 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caja_Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Te_Atiende;
    private javax.swing.JTextField TextCantidad;
    private javax.swing.JTextField Total;
    private javax.swing.JTextField TxtCodigodeBarras4;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField Txtdescripcion;
    private javax.swing.JTextField Vendedor;
    private javax.swing.JTable Ventas;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelarProducto;
    private javax.swing.JButton jButtonCancelarventa;
    private javax.swing.JButton jButtonFinalizarServicio;
    private javax.swing.JButton jButtonFinalizarVenta;
    private javax.swing.JButton jButtonIniciarServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtCodigodeBarras;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtRecibido;
    // End of variables declaration//GEN-END:variables
}
