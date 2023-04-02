package View.Swing;

import View.Login.LoginAndRegister;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LabelField extends JLabel {

   
    public LabelField() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(new Color(0, 0, 0, 0));
        setHorizontalAlignment(JTextField.CENTER);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        int width = getWidth() - 1;
        int height = getHeight() - 1;
        g2.draw(new RoundRectangle2D.Double(0, 0, width, height, height, height));
        
        g2.dispose();
        super.paintComponent(grphcs);
    }

}
