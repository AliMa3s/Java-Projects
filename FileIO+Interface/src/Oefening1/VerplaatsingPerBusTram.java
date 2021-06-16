/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oefening1;

/**
 *
 * @author alima
 */
public class VerplaatsingPerBusTram extends Verplaatsing implements Kosten{
    
    protected int lijnnr;
    protected boolean bus;
    protected boolean stadslijn;
    protected double Prijs_Per_Halte = 2;

    public VerplaatsingPerBusTram(String X, String Y, double aantalKm, int lijnnr, boolean bus, boolean stadslijn) {
        super(X, Y, aantalKm);
        this.lijnnr = lijnnr;
        this.bus = bus;
        this.stadslijn = stadslijn;
    }

    public int getLijnnr() {
        return lijnnr;
    }

    public void setLijnnr(int lijnnr) {
        this.lijnnr = lijnnr;
    }

    public boolean isBus() {
        return bus;
    }

    public void setBus(boolean bus) {
        this.bus = bus;
    }

    public boolean isStadslijn() {
        return stadslijn;
    }

    public void setStadslijn(boolean stadslijn) {
        this.stadslijn = stadslijn;
    }
    
    
    
    @Override
    public double berkenPrijs() {
        double aantalHaltes=  Math.ceil(aantalKm);
        double totaalprijs = 2 * aantalHaltes * Prijs_Per_Halte;
        if(stadslijn == true){
            return totaalprijs - (totaalprijs / 100 * 20); 
        }
        return 2 * aantalHaltes * Prijs_Per_Halte;
        
    }

    @Override
    public String toString() {
        return "De kosten van verplaatsing met de Bus of Tram is : " + (String.format("%.2f", berkenPrijs()) + " Euro");
    }
    
}
