/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author dthie
 */
public class Dress extends Outfit{
    private String finalPath = "/Dress";
    public Dress(String filePath, String tag) {
        super(filePath, tag);
    }
    
    @Override
    public void setDefaultModelPath(String filePath) {
        super.setDefaultModelPath(filePath);
    }
}
