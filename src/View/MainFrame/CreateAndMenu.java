/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.MainFrame;

import net.miginfocom.swing.MigLayout;

/**
 *
 * @author dthie
 */
public class CreateAndMenu extends javax.swing.JPanel {

    private MigLayout layout;
    private Creating creating;
    private ScrollPane scr;
    
    public CreateAndMenu() {
        initComponents();
        init();
    }
        
    private void init(){
        layout = new MigLayout("fill", "fill", "fill");
        this.setLayout(layout);
        creating = new Creating();
        scr = new ScrollPane();
        add(creating, "pos (0%) 0.5al n n");
        add(scr, "pos (70%) 0.5al n n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
