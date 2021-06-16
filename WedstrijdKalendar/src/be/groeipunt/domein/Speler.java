/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.groeipunt.domein;

import java.util.ArrayList;

public class Speler {
    public String naam;
    public Ploeg ploeg;
    public int geboortejaar;
    
    public String ploegnaam;

    public Speler(String naam, String geboortejaar,  String ploegnaam) {
        this.naam = naam;
        this.geboortejaar = Integer.parseInt(geboortejaar);
        this.ploegnaam = ploegnaam;
    }


    public Speler(String naam, String geboortejaar) {
        this.naam = naam;
        this.geboortejaar = Integer.parseInt(geboortejaar);
        
    }

    public Speler(Ploeg ploeg) {
        this.ploeg = ploeg;
    }

    public Ploeg getPloeg() {
        return ploeg;
    }


  
    public void setPloeg(Ploeg ploegnaam) {
        this.ploeg = ploegnaam;
    }
      
    


    @Override
    public String toString() {
        return naam+ " ("+geboortejaar+") " + " ploeg= " + ploegnaam;
    }


    
}
