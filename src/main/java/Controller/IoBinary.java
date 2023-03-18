/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dthie
 */
public class IoBinary {
    public static <T> void writeToFile(ArrayList<T> list, String Filename){
        
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }
    
public static <T> void readDataFromFile(ArrayList<T> list, String Filename){
        
        try {
            FileInputStream fileInputStream = new FileInputStream(Filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            list = (ArrayList<T>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }
}
