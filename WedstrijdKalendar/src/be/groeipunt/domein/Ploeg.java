
package be.groeipunt.domein;

import java.util.ArrayList;


public class Ploeg {
    public String naam;
    public String stad;
    public String mail;
    public ArrayList<Speler> spelersLijst;


    public Ploeg(String tekst) {
        String[] a = tekst.split(";");
        naam = a[0];
        stad = a[1];
        mail = a[2];
        spelersLijst = new ArrayList<>(); 
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Ploeg(String naam, String stad) {
        this.naam = naam;
        this.stad = stad;
    }

    public void setSpelersLijst(ArrayList<Speler> spelersLijst) {
        this.spelersLijst = spelersLijst;
    }
    
    public Boolean zelfdeNaam(String naam){
        return this.naam.equals(naam);
    }
    
    public void voegToe(Speler speler){
        spelersLijst.add(speler);
        speler.setPloeg(this);
    }

    @Override
    public String toString() {
        return naam + " (" + stad+ ")";
    }
    
}
