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
public class HomeFrame extends javax.swing.JPanel {

    private ArrayList<Outfit> outfit;
    private Outfit oft;
    CardLayout cardLayout;
    private EventLogin event;
    private String gender = "Female.png";
    
    public HomeFrame() {
        initComponents();
        init();
    }
    
    public void setEventLogin(EventLogin event){
        this.event = event;
    }
    
    private void init(){
        cardLayout = (CardLayout)(CLpanel.getLayout());
        outfit = new ArrayList<Outfit>();
        oft = new Outfit();
        addShirtList(outfit);
        addPantList(outfit);
        addDressList(outfit);
        addShoeList(outfit);
        generateList();
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/Assets/Model/" + gender));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Background.setIcon(new ImageIcon(image));
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
                Top.setIcon(img);
             }else if("Pant".equals(of.getTag())){
                Down.setIcon(img);
             }else if("Shoe".equals(of.getTag())){
                Below.setIcon(img);
             }
        });
        pnl.add(btn);
        return pnl;
    }
    
    private void generateList(){
        for(Outfit it : outfit){
            if(null != it.getTag())switch (it.getTag()) {
                case "Shirt":
                    card1.add(addNewButton(it));
                    break;
                case "Pant":
                    card2.add(addNewButton(it));
                    break;
                case "Dress":
                    card3.add(addNewButton(it));
                    break;
                case "Shoe":
                    card4.add(addNewButton(it));
                    break;
                default:
                    break;
            }
        }
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
        Image image = i.getImage().getScaledInstance(label.getWidth(), label.getWidth(), Image.SCALE_SMOOTH);
            
        label.setIcon(new ImageIcon(image));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    void createScrollPane(){
        JScrollPane scrollPane = new JScrollPane(card1);
        scrollPane.setPreferredSize(new Dimension(170,600));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        CLpanel.add(scrollPane, new GridLayout());
        scrollPane.getVerticalScrollBar().setUnitIncrement(13);
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

        jPanel1 = new javax.swing.JPanel();
        button1 = new View.Swing.Button();
        button2 = new View.Swing.Button();
        button3 = new View.Swing.Button();
        button4 = new View.Swing.Button();
        CLpanel = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        card2 = new javax.swing.JPanel();
        card3 = new javax.swing.JPanel();
        card4 = new javax.swing.JPanel();
        card5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Top = new javax.swing.JLabel();
        Down = new javax.swing.JLabel();
        Below = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        button5 = new View.Swing.Button();

        setBackground(new java.awt.Color(246, 207, 104));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1039, 591));
        setMinimumSize(new java.awt.Dimension(1039, 591));
        setName(""); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        button1.setBackground(new java.awt.Color(73, 73, 73));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Shirt");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(73, 73, 73));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Pant");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(73, 73, 73));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Dress");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(73, 73, 73));
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setText("Shoes");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 150, 600));

        CLpanel.setLayout(new java.awt.CardLayout());

        card1.setBackground(new java.awt.Color(73, 73, 73));
        card1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        card1.setLayout(new java.awt.GridLayout(5, 1));
        CLpanel.add(card1, "card1");

        card2.setBackground(new java.awt.Color(73, 73, 73));
        card2.setLayout(new java.awt.GridLayout(5, 1));
        CLpanel.add(card2, "card2");

        card3.setBackground(new java.awt.Color(73, 73, 73));
        card3.setLayout(new java.awt.GridLayout(5, 1));
        CLpanel.add(card3, "card3");

        card4.setBackground(new java.awt.Color(73, 73, 73));
        card4.setLayout(new java.awt.GridLayout(5, 1));
        CLpanel.add(card4, "car4");

        card5.setBackground(new java.awt.Color(73, 73, 73));
        card5.setLayout(new java.awt.GridLayout(5, 1));
        CLpanel.add(card5, "card6");

        add(CLpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 170, 600));

        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        Top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Top.setMaximumSize(new java.awt.Dimension(400, 534));
        Top.setMinimumSize(new java.awt.Dimension(400, 534));
        Top.setPreferredSize(new java.awt.Dimension(400, 534));
        jPanel2.add(Top);

        Down.setMaximumSize(new java.awt.Dimension(400, 534));
        Down.setName(""); // NOI18N
        jPanel2.add(Down);

        Below.setMaximumSize(new java.awt.Dimension(400, 543));
        jPanel2.add(Below);

        Background.setMaximumSize(new java.awt.Dimension(400, 534));
        Background.setPreferredSize(new java.awt.Dimension(400, 534));
        jPanel2.add(Background);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 30, 400, 534));
        jPanel2.getAccessibleContext().setAccessibleName("");

        button5.setBackground(new java.awt.Color(55, 55, 55));
        button5.setForeground(new java.awt.Color(51, 102, 255));
        button5.setText("Back");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CLpanel, "card1");
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CLpanel, "card2");
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CLpanel, "card3");
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CLpanel, "card4");
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        event.toChosingFrame();
    }//GEN-LAST:event_button5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Below;
    private javax.swing.JPanel CLpanel;
    private javax.swing.JLabel Down;
    private javax.swing.JLabel Top;
    private View.Swing.Button button1;
    private View.Swing.Button button2;
    private View.Swing.Button button3;
    private View.Swing.Button button4;
    private View.Swing.Button button5;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel card4;
    private javax.swing.JPanel card5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    void setGender(int i) {
        if(i == 1) this.gender = "Male.png";
        else this.gender = "Female.png";
    }
}
