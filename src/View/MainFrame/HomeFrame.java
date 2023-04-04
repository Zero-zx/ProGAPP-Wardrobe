/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.MainFrame;

import Controller.LabelToImage;
import Model.Dress;
import Model.Outfit;
import Model.Pant;
import Model.Shirt;
import Model.Shoe;
import View.Swing.EventLogin;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author dthie
 */
public class HomeFrame extends javax.swing.JPanel {

    private ArrayList<Outfit> outfit;
    private ArrayList<JLabel> labels;
    private Outfit oft;
    CardLayout cardLayout;
    private EventLogin event;
    private String gender = "Male";
    private LabelToImage saveImg;
    
    public HomeFrame() {
        initComponents();
    }
    
    public void setEventLogin(EventLogin event){
        this.event = event;
    }
    
    private void init(){
        labels = new ArrayList<JLabel>();
        saveImg = new LabelToImage();
        cardLayout = (CardLayout)(CLpanel.getLayout());
        outfit = new ArrayList<Outfit>();
        oft = new Outfit();
        addShirtList(outfit);
        addPantList(outfit);
        addDressList(outfit);
        addShoeList(outfit);
        generateList();
        

        //createScrollPane();

    }
    
    private JPanel addNewButton(Outfit of){
        JButton btn = new JButton(of.getTag());
        JPanel pnl = new JPanel();
        pnl.setBackground(new Color(0,0,0,0));
        pnl.setPreferredSize(new Dimension(90, 100));
        btn.setPreferredSize(new Dimension(90,100));
        BufferedImage image = null;
        BufferedImage icon = null;
        try {
            icon = ImageIO.read(getClass().getResource(of.getDefaultModelPath()));
            //icon = ImageIO.read(getClass().getResource("/Assets/Shirt/Shirt_1.png"));
            image = ImageIO.read(getClass().getResource(of.getFilePath()));
            //image = ImageIO.read(getClass().getResource("/Assets/Shirt/Shirt_1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon img = new ImageIcon(image);
        Image tmp = icon.getScaledInstance(90, 100, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(tmp));
        btn.setVerticalTextPosition(SwingConstants.TOP);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setText("");
       
        
        btn.addActionListener((ActionEvent e) -> {
             if(null != of.getTag())switch (of.getTag()) {
                case "Shirt":
                    Top.setIcon(img);
                    Dress.setIcon(null);
                    break;
                case "Pant":
                    Down.setIcon(img);
                    Dress.setIcon(null);
                    break;
                case "Shoe":
                    Below.setIcon(img);
                    break;
                case "Dress":
                    Dress.setIcon(img);
                    Top.setIcon(null);
                    Down.setIcon(null);
                    break;
                default:
                    break;
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
        for(int i = 1; i <= 4; i++){
            shirt = new Shirt(oft.ShirtPath + gender + "Shirt_" + String.valueOf(i) + ".png", "Shirt");
            shirt.setDefaultModelPath(oft.ShirtPath + "Shirt_" + String.valueOf(i) + ".png");
            list.add(shirt);
        }

    }
    private void addPantList(ArrayList<Outfit> list){
        Pant pant;
        for(int i = 1; i <= 4; i++){
            pant = new Pant(oft.PantPath + gender + "Pant_" + String.valueOf(i) + ".png", "Pant");
            pant.setDefaultModelPath(oft.PantPath + "Pant_" + String.valueOf(i) + ".png");
            list.add(pant);
        }
    }
    private void addDressList(ArrayList<Outfit> list){
        Dress dress;
        for(int i = 1; i <= 2; i++){
            dress = new Dress(oft.DressPath + "Dress_" + String.valueOf(i) + ".png", "Dress");
            dress.setDefaultModelPath(oft.DressPath + "Dress_" + String.valueOf(i) + ".png");
            list.add(dress);
        }
    }
    
    private void addShoeList(ArrayList<Outfit> list){
        Shoe shoe;
        for(int i = 1; i <= 1; i++){
            shoe = new Shoe(oft.ShoePath + gender + "Shoe_" + String.valueOf(i) + ".png", "Shoe");
            shoe.setDefaultModelPath(oft.ShoePath + "Shoe_" + String.valueOf(i) + ".png");
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
        jPanel2 = new javax.swing.JPanel();
        Top = new javax.swing.JLabel();
        Face = new javax.swing.JLabel();
        Dress = new javax.swing.JLabel();
        Down = new javax.swing.JLabel();
        Below = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        Back = new View.Swing.Button();
        AddFace = new View.Swing.Button();
        button8 = new View.Swing.Button();

        setBackground(new java.awt.Color(246, 207, 104));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1039, 591));
        setMinimumSize(new java.awt.Dimension(1039, 591));
        setName(""); // NOI18N

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
        CLpanel.add(card4, "card4");

        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        Top.setForeground(new java.awt.Color(255, 255, 255));
        Top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Top.setMaximumSize(new java.awt.Dimension(400, 534));
        Top.setMinimumSize(new java.awt.Dimension(400, 534));
        Top.setPreferredSize(new java.awt.Dimension(400, 534));
        jPanel2.add(Top);

        Face.setForeground(new java.awt.Color(255, 255, 255));
        Face.setMaximumSize(new java.awt.Dimension(400, 534));
        Face.setMinimumSize(new java.awt.Dimension(400, 534));
        Face.setPreferredSize(new java.awt.Dimension(400, 534));
        jPanel2.add(Face);

        Dress.setForeground(new java.awt.Color(255, 255, 255));
        Dress.setMaximumSize(new java.awt.Dimension(400, 534));
        Dress.setMinimumSize(new java.awt.Dimension(400, 534));
        Dress.setPreferredSize(new java.awt.Dimension(400, 534));
        jPanel2.add(Dress);

        Down.setForeground(new java.awt.Color(255, 255, 255));
        Down.setMaximumSize(new java.awt.Dimension(400, 534));
        Down.setName(""); // NOI18N
        jPanel2.add(Down);

        Below.setForeground(new java.awt.Color(255, 255, 255));
        Below.setMaximumSize(new java.awt.Dimension(400, 543));
        Below.setMinimumSize(new java.awt.Dimension(400, 534));
        Below.setPreferredSize(new java.awt.Dimension(400, 534));
        jPanel2.add(Below);

        Background.setForeground(new java.awt.Color(255, 255, 255));
        Background.setMaximumSize(new java.awt.Dimension(400, 534));
        Background.setMinimumSize(new java.awt.Dimension(400, 534));
        Background.setPreferredSize(new java.awt.Dimension(400, 534));
        jPanel2.add(Background);

        Back.setBackground(new java.awt.Color(55, 55, 55));
        Back.setForeground(new java.awt.Color(0, 153, 255));
        Back.setText("Back");
        Back.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        AddFace.setBackground(new java.awt.Color(55, 55, 55));
        AddFace.setForeground(new java.awt.Color(0, 153, 255));
        AddFace.setText("Add Face");
        AddFace.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        AddFace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFaceActionPerformed(evt);
            }
        });

        button8.setBackground(new java.awt.Color(55, 55, 55));
        button8.setForeground(new java.awt.Color(0, 153, 255));
        button8.setText("Save Image");
        button8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CLpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AddFace, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(AddFace, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(CLpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.getAccessibleContext().setAccessibleName("");
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

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        removeAll();
        initComponents();
        event.toChosingFrame();
    }//GEN-LAST:event_BackActionPerformed

    private void AddFaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFaceActionPerformed
        JFileChooser browseImageFile = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);
        
        if(showOpenDialogue == JFileChooser.APPROVE_OPTION){
            File selectedImageFile = browseImageFile.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();
            JOptionPane.showMessageDialog(null, selectedImageFile);
            ImageIcon i = new ImageIcon(selectedImagePath);
            Image image = i.getImage().getScaledInstance(400, 534, Image.SCALE_SMOOTH);
            BufferedImage img = null;
            try {
                img = ImageIO.read(getClass().getResource("/Assets/Model/" + "After_" + gender + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Background.setIcon(new ImageIcon(img));
            Face.setIcon(new ImageIcon(image));
            
        }
    }//GEN-LAST:event_AddFaceActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        try {
            labels.add(Background);
            labels.add(Below);
            labels.add(Down);
            labels.add(Dress);
            labels.add(Top);
            labels.add(Face);
            // TODO add your        handling code here:
            saveImg.saveImage(labels);
//        for(JLabel it : labels){
//            System.out.println(it.getHeight());
            JOptionPane.showMessageDialog(null, "Image Saved", "Message", JOptionPane.INFORMATION_MESSAGE);
//        }
        } catch (IOException ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Swing.Button AddFace;
    private View.Swing.Button Back;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Below;
    private javax.swing.JPanel CLpanel;
    private javax.swing.JLabel Down;
    private javax.swing.JLabel Dress;
    private javax.swing.JLabel Face;
    private javax.swing.JLabel Top;
    private View.Swing.Button button1;
    private View.Swing.Button button2;
    private View.Swing.Button button3;
    private View.Swing.Button button4;
    private View.Swing.Button button8;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel card4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    void setGender(int i) {
        if(i == 1) this.gender = "Male";
        else this.gender = "Female";
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("/Assets/Model/" + gender +".png"));
            System.out.println(gender);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Background.setIcon(new ImageIcon(image));
        init();
    }
}
