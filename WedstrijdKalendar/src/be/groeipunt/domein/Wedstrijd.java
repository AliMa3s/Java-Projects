/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.groeipunt.domein;


public class Wedstrijd {
    public String speeldag;
    public String thuis;
    public String bezoeker;
    public Ploeg ploegnaam;

    public Wedstrijd(String speeldag, String thuis, String bezoeker) {
        this.speeldag = speeldag;
        
        this.thuis = thuis;
        this.bezoeker = bezoeker;
    }


   
    @Override
    public String toString() {
        return speeldag + ", " + thuis +  "-- " + bezoeker;
    }
    
    
}
