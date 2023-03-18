/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.LoginFrame;
import javax.swing.UIManager;

/**
 *
 * @author dthie
 */
public class Application {
    LoginFrame loginFrame;
    
    public void run(){
        
        
        loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}
