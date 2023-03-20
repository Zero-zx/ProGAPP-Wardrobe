/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Outfit;
import View.SigninJFrame;

/**
 *
 * @author dthie
 */
public class Application {
    SigninJFrame loginFrame;
    
    public void run(){
        loginFrame = new SigninJFrame();
        loginFrame.setVisible(true);
        
    }
}
