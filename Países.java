/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.osgg.xmldomparser;

/**
 *
 * @author Homero
 */
public class Países {
    private String país;
    private int females;
    private int males;

    public Países(String país, int females, int males) {
        this.país = país;
        this.females = females;
        this.males = males;
    }

    public String getPaís() {
        return país;
    }

    public void setPaís(String país) {
        this.país = país;
    }

    public int getFemales() {
        return females;
    }

    public void setFemales(int females) {
        this.females = females;
    }

    public int getMales() {
        return males;
    }

    public void setMales(int males) {
        this.males = males;
    }
    

   
    
}
