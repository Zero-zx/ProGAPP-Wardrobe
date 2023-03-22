/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.MainFrame;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author dthie
 */
public class CustomeBorder extends AbstractBorder{
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y,
            int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = (Graphics2D)g;
        Paint COLOR_BORDE_SIMPLE = null;
        g2d.setPaint(COLOR_BORDE_SIMPLE);
        Shape shape = new RoundRectangle2D.Float(0, 0, c.getWidth()-1, c.getHeight()-1,9, 9);
        g2d.draw(shape);
    }
}
