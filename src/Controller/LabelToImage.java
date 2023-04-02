/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author dthie
 */
public class LabelToImage{

    public LabelToImage() {
    }
    

    public void saveImage(ArrayList<JLabel> labels) throws IOException {
                        
        BufferedImage image = new BufferedImage(400, 534, BufferedImage.TYPE_INT_RGB);
         
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 400, 534);
        
        for (JLabel label : labels) {
            label.paint(g2d);
        }
        g2d.dispose();

        // lưu ảnh PNG tổng thể
        File outputFile = new File("labels.png");
        ImageIO.write(image, "png", outputFile);
        
    }
    
}
