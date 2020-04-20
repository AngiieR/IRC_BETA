package Almacen;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class ImagenMySQL extends javax.swing.JPanel {
   
    BufferedImage ruta;
    
    public ImagenMySQL(int x, int y, BufferedImage ruta){
        this.setSize(x, y);
        this.ruta = ruta;
    }
    
    public void paint(Graphics g){
        
        Dimension height = getSize();
        //ImageIcon img = new ImageIcon(getClass().getResource(ruta));
        //Image imgExt = new ImageIcon(ruta).getImage();
        BufferedImage img = ruta;
        g.drawImage(img, 0, 0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(g);
        
    }
    
}
