/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basis.opgaven.domein;

/**
 *
 * @author alima
 */
public class Cursist {
    private String naam;

    public Cursist(String naam) {
        this.naam = naam;
    }

  
    @Override
    public String toString() {
        return "Cursist{" + "naam=" + naam + '}';
    }
    
    
}
