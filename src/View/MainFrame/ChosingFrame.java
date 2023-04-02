/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.MainFrame;

import Model.Outfit;
import Model.Pant;
import Model.Shirt;
import Model.Shoe;
import View.Swing.EventLogin;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 *
 * @author dthie
 */
public class ChosingFrame extends javax.swing.JPanel {

    private ArrayList<Outfit> outfit;
    private Outfit oft;
    CardLayout cardLayout;
    private EventLogin event;
    
    public ChosingFrame() {
        System.out.println("helo");
        initComponents();
        init();
    }
    
    public void setEventLogin(EventLogin event){
        this.event = event;
    }
    
    private void init(){
        outfit = new ArrayList<Outfit>();
        oft = new Outfit();
        addShirtList(outfit);
        addPantList(outfit);
        addDressList(outfit);
        addShoeList(outfit);
        generateList();
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/Assets/Model/Male.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Background.setIcon(new ImageIcon(image));
        createButtonIcon("src/Assets/Model/Male.png", jButton1);
        createButtonIcon("src/Assets/Model/Female.png", jButton2);

        //createScrollPane();

    }
    
    private JPanel addNewButton(Outfit of){
        JButton btn = new JButton(of.getTag());
        JPanel pnl = new JPanel();
        pnl.setBackground(new Color(0,0,0,0));
        pnl.setPreferredSize(new Dimension(90, 100));
        btn.setPreferredSize(new Dimension(90,100));
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(of.getFilePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon img = new ImageIcon(image);
        btn.addActionListener((ActionEvent e) -> {
             if("Shirt".equals(of.getTag())){
                //Top.setIcon(img);
             }else if("Pant".equals(of.getTag())){
                //Down.setIcon(img);
             }else if("Shoe".equals(of.getTag())){
                //Below.setIcon(img);
             }
        });
        pnl.add(btn);
        return pnl;
    }
    
    private void generateList(){
        
    }
    
    private void addShirtList(ArrayList<Outfit> list){
        Shirt shirt;
        for(int i = 1; i <= 3; i++){
            shirt = new Shirt(oft.ShirtPath + "Shirt_" + String.valueOf(i) + ".png", "Shirt");
            list.add(shirt);
        }

    }
    private void addPantList(ArrayList<Outfit> list){
        Pant pant;
        for(int i = 1; i <= 2; i++){
            pant = new Pant(oft.PantPath + "Pant_" + String.valueOf(i) + ".png", "Pant");
            list.add(pant);
        }
    }
    private void addDressList(ArrayList<Outfit> list){
        Shirt shirt = new Shirt(oft.DressPath + "Dress_1.png", "Dress");
        list.add(shirt);
        for(Outfit it : list){
            System.out.println(it.getFilePath());
        }
    }
    
    private void addShoeList(ArrayList<Outfit> list){
        Shoe shoe;
        for(int i = 1; i <= 1; i++){
            shoe = new Shoe(oft.ShoePath + "Shoe_" + String.valueOf(i) + ".png", "Shoe");
            list.add(shoe);
        }
    }

    
    public void createLabelIcon(String fileName, JLabel label){
        try{
        ImageIcon i = new ImageIcon(fileName);
        Image image = i.getImage().getScaledInstance(label.getWidth(), label.getWidth(), Image.SCALE_SMOOTH);
            
        label.setIcon(new ImageIcon(image));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void createButtonIcon(String fileName, JButton label){
        try{
        ImageIcon i = new ImageIcon(fileName);
        //label.setPreferredSize(new Dimension(300, 400));

        Image image = i.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
            
        label.setIcon(new ImageIcon(image));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    void createScrollPane(){
//        scrollPane.setPreferredSize(new Dimension(170,600));
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.getVerticalScrollBar().setUnitIncrement(13);
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(170, 600));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        button1 = new View.Swing.Button();
        button2 = new View.Swing.Button();

        setBackground(new java.awt.Color(246, 207, 104));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1039, 586));
        setMinimumSize(new java.awt.Dimension(1039, 586));
        setName(""); // NOI18N

        jButton1.setText("jButton1");
        jButton1.setMaximumSize(new java.awt.Dimension(300, 400));
        jButton1.setMinimumSize(new java.awt.Dimension(300, 400));
        jButton1.setPreferredSize(new java.awt.Dimension(300, 400));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton1");
        jButton2.setPreferredSize(new java.awt.Dimension(300, 400));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        button1.setText("Logout");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(66, 164, 253));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Are you a boy or a girl?");
        button2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(168, 168, 168))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        event.toCustomFrame(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        event.toCustomFrame(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        event.logOut();
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Swing.Button button1;
    private View.Swing.Button button2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
