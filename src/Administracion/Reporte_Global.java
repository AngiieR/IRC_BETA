package Administracion;//Empieza...
import Caja.*;
import Almacen.*;
import Inicio.*;
import conexion.conexionSQL;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Reporte_Global extends javax.swing.JFrame {

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("./Imagenes/logo_icon.png"));
        return retValue;
    }       
    
    public float sumaTotal() {
        float sumaTotal = 0;
        int contar = jTReporte.getRowCount();

        for (int i = 0; i < contar; i++) {
            sumaTotal = sumaTotal + Float.parseFloat(jTReporte.getValueAt(i, 5).toString());
        }
        return sumaTotal;
    }
    
    public void ReporteGlobal(){
        String SQL = "select ID, ID_USUARIO, FECHA_CREACION, ID_PRODUCTO, CANTIDAD, COSTO_TOTAL from ventas;";
    
        conexionSQL cc = new conexionSQL();
        Connection con = cc.conexion();
        
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            jTReporte.setModel(modelo);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
                        
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Registro");
            modelo.addColumn("Usuario");
            modelo.addColumn("Fecha");
            modelo.addColumn("Producto");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Total Vendido");
                        
            while(rs.next()){
            
                Object[] filas = new Object[cantidadColumnas];
            
                for(int i = 0; i< cantidadColumnas; i++)
                {
                    filas[i] = rs.getObject(i + 1);                    
                }
            modelo.addRow(filas);
            }
        Total.setText(Float.toString(sumaTotal()));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta_del_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void ReporteDiario(){
        
        int resultado = 0;
        String Dia = jTxtDia.getText();
        String SQL = "select ID, ID_USUARIO, FECHA_CREACION, ID_PRODUCTO, CANTIDAD, COSTO_TOTAL from ventas where cast(FECHA_CREACION as date) = '"+ Dia +"';";
        conexionSQL cc = new conexionSQL();
        Connection con = cc.conexion();
        
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            jTReporte.setModel(modelo);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Registro");
            modelo.addColumn("Usuario");
            modelo.addColumn("Fecha");
            modelo.addColumn("Producto");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Total Vendido");
            
            while(rs.next()){
            
                Object[] filas = new Object[cantidadColumnas];
            
                for(int i = 0; i< cantidadColumnas; i++)
                {
                    filas[i] = rs.getObject(i + 1);
                }
            modelo.addRow(filas);
            }
        Total.setText(Float.toString(sumaTotal()));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta_del_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void ReporteMensual(){
        
        int resultado = 0;
        String Mes = jTxtMes.getText();
        String Anio = jTxtAnio.getText();
        String SQL = "select ID, ID_USUARIO, FECHA_CREACION, ID_PRODUCTO, CANTIDAD, COSTO_TOTAL from ventas where YEAR (FECHA_CREACION) = '"+ Anio +"' AND MONTH (FECHA_CREACION) = '"+ Mes +"';";
        conexionSQL cc = new conexionSQL();
        Connection con = cc.conexion();
        
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            jTReporte.setModel(modelo);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Registro");
            modelo.addColumn("Usuario");
            modelo.addColumn("Fecha");
            modelo.addColumn("Producto");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Total Vendido");
            
            while(rs.next()){
            
                Object[] filas = new Object[cantidadColumnas];
            
                for(int i = 0; i< cantidadColumnas; i++)
                {
                    filas[i] = rs.getObject(i + 1);
                }
            modelo.addRow(filas);
            }
        Total.setText(Float.toString(sumaTotal()));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta_del_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void BotonSalir() {
         Inicio_Administrador form = new Inicio_Administrador();
        form.setVisible(true);
        this.dispose();       
 }

    public Reporte_Global() {
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
        Total = new javax.swing.JTextField();
        jButtonReporteMensual = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTReporte = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButtonReporteGeneral = new javax.swing.JButton();
        jButtonReporteDiario = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jTxtDia = new javax.swing.JTextField();
        jTxtMes = new javax.swing.JTextField();
        jTxtAnio = new javax.swing.JTextField();

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
        jLabel1.setText("Almacenes Beta");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        Total.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total.setToolTipText("");
        Total.setName("Total"); // NOI18N
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total(evt);
            }
        });

        jButtonReporteMensual.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonReporteMensual.setText("Reporte por Mes");
        jButtonReporteMensual.setToolTipText("");
        jButtonReporteMensual.setActionCommand("");
        jButtonReporteMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteMensualActionPerformed(evt);
            }
        });

        jTReporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registro", "Usuario", "Fecha", "Producto", "Cantidad", "Total Vendido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTReporte.setRowHeight(30);
        jScrollPane1.setViewportView(jTReporte);
        if (jTReporte.getColumnModel().getColumnCount() > 0) {
            jTReporte.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Total de Ventas M. N. $");

        jButtonReporteGeneral.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonReporteGeneral.setText("Reporte General");
        jButtonReporteGeneral.setToolTipText("");
        jButtonReporteGeneral.setActionCommand("");
        jButtonReporteGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteGeneralActionPerformed(evt);
            }
        });

        jButtonReporteDiario.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonReporteDiario.setText("Reporte por día");
        jButtonReporteDiario.setToolTipText("");
        jButtonReporteDiario.setActionCommand("");
        jButtonReporteDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteDiarioActionPerformed(evt);
            }
        });

        jButtonSalir.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.setToolTipText("");
        jButtonSalir.setActionCommand("");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jTxtDia.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTxtDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtDia.setText("YYYY-MM-DD");
        jTxtDia.setToolTipText("");
        jTxtDia.setName("Total"); // NOI18N
        jTxtDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtDia(evt);
            }
        });

        jTxtMes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTxtMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtMes.setText("MM");
        jTxtMes.setToolTipText("");
        jTxtMes.setName("Total"); // NOI18N
        jTxtMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtMes(evt);
            }
        });

        jTxtAnio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTxtAnio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtAnio.setText("YYYY");
        jTxtAnio.setToolTipText("");
        jTxtAnio.setName("Total"); // NOI18N
        jTxtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAnio(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonReporteMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonReporteGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButtonReporteDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonReporteGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonReporteMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonReporteDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCodigodeBarras4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodigodeBarras4
     
    }//GEN-LAST:event_TxtCodigodeBarras4

    private void jButtonReporteMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteMensualActionPerformed
            ReporteMensual();
    }//GEN-LAST:event_jButtonReporteMensualActionPerformed

    private void Total(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total
     
    }//GEN-LAST:event_Total

    private void jButtonReporteGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteGeneralActionPerformed
        ReporteGlobal();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReporteGeneralActionPerformed

    private void jButtonReporteDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteDiarioActionPerformed
            ReporteDiario();
    }//GEN-LAST:event_jButtonReporteDiarioActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        BotonSalir();// TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jTxtDia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtDia
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtDia

    private void jTxtMes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtMes
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtMes

    private void jTxtAnio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAnio
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAnio
 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte_Global().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Total;
    private javax.swing.JTextField TxtCodigodeBarras4;
    private javax.swing.JButton jButtonReporteDiario;
    private javax.swing.JButton jButtonReporteGeneral;
    private javax.swing.JButton jButtonReporteMensual;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTReporte;
    private javax.swing.JTextField jTxtAnio;
    private javax.swing.JTextField jTxtDia;
    private javax.swing.JTextField jTxtMes;
    // End of variables declaration//GEN-END:variables

    private void initcomponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

