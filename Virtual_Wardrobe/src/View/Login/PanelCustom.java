package View.Login;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.text.StyleConstants;
public class PanelCustom extends JComponent{
    
    public PanelCustom(){
        
    }
    
    @Override
    protected void paintComponent(Graphics grphics){
        Graphics2D g2 = (Graphics2D) grphics.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
        g2.dispose();
        super.paintComponent(grphics);
    }
}
