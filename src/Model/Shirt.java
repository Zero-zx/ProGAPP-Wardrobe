/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author dthie
 */
public class Shirt extends Outfit{
    private String finalPath = "/Shirt";
    public Shirt(String filePath, String tag) {
        super(filePath, tag);
    }

    @Override
    public String toString() {
        return super.getDefaultPath() + finalPath;
    }
    
    
    
}
