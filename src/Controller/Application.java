/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Outfit;
import View.MainFrame.LoginAndRegisterFrame;
import View.MainFrame.LoginAndRegisterFrame;

/**
 *
 * @author dthie
 */
public class Application {
    LoginAndRegisterFrame loginFrame;
    
    public void run(){
        loginFrame = new LoginAndRegisterFrame();
        loginFrame.setVisible(true);
        
    }
}
