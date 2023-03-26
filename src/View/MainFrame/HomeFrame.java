/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.MainFrame;

import Model.Outfit;
import Model.Pant;
import Model.Shirt;
import Model.Shoe;
import java.awt.CardLayout;
import java.awt.Dimension;
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


/**
 *
 * @author dthie
 */
public class HomeFrame extends javax.swing.JPanel {

    private ArrayList<Outfit> outfit;
    private Outfit oft;
    CardLayout cardLayout;
    public HomeFrame() {
        System.out.println("helo");
        initComponents();
        init();
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
            image = ImageIO.read(new File("src/Assets/Model/Male.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //createLabelIcon("src/Assets/Model/Male.png", jLabel1);
        Background.setIcon(new ImageIcon(image));
        //jLabel2.setIcon(new ImageIcon("src/Assets/Shirt/Shirt_1.png"));
        //jLabel1.setPreferredSize(new Dimension(400,534));
        //System.out.println(jLabel1.getIcon().getIconHeight() + " " + jLabel1.getIcon().getIconWidth());
    }
    
    private JButton addNewButton(Outfit of){
        JButton btn = new JButton(of.getTag());
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
        return btn;
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
    
//    void createScrollPane(){
//         JScrollPane scrollPane = new JScrollPane(jPanel2);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setBounds(50, 30, 50, 30);
//        scrollPane.getVerticalScrollBar().setUnitIncrement(13);
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(500, 400));
//        //getContentPane().add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 240, 620));
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
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

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jButton1.setText("Shirt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pant");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Dress");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Shoe");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CLpanel.setLayout(new java.awt.CardLayout());

        card1.setBackground(new java.awt.Color(0, 153, 153));
        card1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CLpanel.add(card1, "card2");

        card2.setBackground(new java.awt.Color(0, 102, 153));
        CLpanel.add(card2, "card3");

        card3.setBackground(new java.awt.Color(255, 204, 204));
        CLpanel.add(card3, "card4");

        card4.setBackground(new java.awt.Color(255, 255, 204));
        CLpanel.add(card4, "card5");

        card5.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout card5Layout = new javax.swing.GroupLayout(card5);
        card5.setLayout(card5Layout);
        card5Layout.setHorizontalGroup(
            card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        card5Layout.setVerticalGroup(
            card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );

        CLpanel.add(card5, "card6");

        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        Top.setText("jLabel1");
        Top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Top.setMaximumSize(new java.awt.Dimension(400, 534));
        Top.setMinimumSize(new java.awt.Dimension(400, 534));
        Top.setPreferredSize(new java.awt.Dimension(400, 534));
        jPanel2.add(Top);

        Down.setText("jLabel2");
        Down.setMaximumSize(new java.awt.Dimension(400, 534));
        Down.setName(""); // NOI18N
        jPanel2.add(Down);

        Below.setText("jLabel4");
        Below.setMaximumSize(new java.awt.Dimension(400, 543));
        jPanel2.add(Below);

        Background.setText("jLabel3");
        Background.setMaximumSize(new java.awt.Dimension(400, 534));
        Background.setPreferredSize(new java.awt.Dimension(400, 534));
        jPanel2.add(Background);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CLpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CLpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CLpanel, "card5");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CLpanel, "card4");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CLpanel, "card3");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CLpanel, "card2");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Below;
    private javax.swing.JPanel CLpanel;
    private javax.swing.JLabel Down;
    private javax.swing.JLabel Top;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel card4;
    private javax.swing.JPanel card5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
