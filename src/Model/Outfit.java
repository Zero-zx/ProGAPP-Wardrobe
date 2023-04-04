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
    public String ShirtPath = "/Assets/Shirt/";
    public String DressPath = "/Assets/Dress/";
    public String PantPath = "/Assets/Pant/";
    public String ShoePath = "/Assets/Shoe/";


    private String defaultPath = "/Assets/";
    private String filePath, tag;
    private String defaultModelPath;
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

    public String getDefaultModelPath() {
        return defaultModelPath;
    }

    public void setDefaultModelPath(String defaultModelPath) {
        this.defaultModelPath = defaultModelPath;
    }
    
}
