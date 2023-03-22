package View.Login;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
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
    
    private float alpha;

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
    
    @Override
    public void paint(Graphics grphc){
        super.paint(grphc);
        Graphics2D g2 = (Graphics2D) grphc.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha * 0.8f));
        g2.setColor(LoginAndRegister.mainColor);
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        g2.dispose();
    }
}
