package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author AngelicaReyesChaparr
 */


public class conexionSQL {
    
    Connection conectar = null;
    
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=(Connection) DriverManager.getConnection("jdbc:mysql://bdxgc2vdsbugfcz0yisv-mysql.services.clever-cloud.com:3306/bdxgc2vdsbugfcz0yisv?autoReconnect=true&useSSL=false","uql2idnbovgs7tg3","lyCCfDbeS5GTNDBkLVhQ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion " + e.getMessage());
        }
        return conectar;
    }
    
}
