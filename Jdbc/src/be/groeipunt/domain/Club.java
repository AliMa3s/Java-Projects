/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.groeipunt.domain;

/**
 *
 * @author rosev
 */
public class Club {

    private String naam, sporttak, stad;
    private Number id;

    public Club(Number id, String naam, String sporttak, String stad) {
        this(naam,sporttak,stad);
        this.id = id;             
    }
    
     public Club(String naam, String sporttak, String stad) {
        this.naam = naam;
        this.sporttak = sporttak;
        this.stad = stad;
    }

    @Override
    public String toString() {
        return "Club{" + "naam=" + naam + ", sporttak=" + sporttak + ", stad=" + stad + ", id=" + id + '}';
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getSporttak() {
        return sporttak;
    }

    public void setSporttak(String sporttak) {
        this.sporttak = sporttak;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public Number getId() {
        return id;
    }
    
     
}
