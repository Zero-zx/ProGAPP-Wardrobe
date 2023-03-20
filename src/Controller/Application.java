/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Outfit;
import View.LoginFrame;

/**
 *
 * @author dthie
 */
public class Application {
    LoginFrame loginFrame;
    
    public void run(){
        
        Outfit outf = new Outfit("male1", "Assets/Images/Male_1.png", "Male");
        loginFrame = new LoginFrame();
        loginFrame.addOutFit(outf);
        loginFrame.setVisible(true);
    }
}
