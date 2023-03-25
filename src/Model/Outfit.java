/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author dthie
 */
public class Outfit {
    public String ShirtPath = "src/Assets/Shirt/";
    public String DressPath = "src/Assets/Dress/";
    public String PantPath = "src/Assets/Pant/";
    public String ShoePath = "src/Assets/Shoe/";


    private String defaultPath = "src/Assets/";
    private String filePath, tag;
    //private int Sw = 497, Sh = 480;
    public Outfit(String filePath, String tag) {
        this.filePath = filePath;
        this.tag = tag;
    }

    public String getDefaultPath() {
        return defaultPath;
    }

    public Outfit() {
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
}
