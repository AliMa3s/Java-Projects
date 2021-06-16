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
public class VerplaatsingPerAuto extends Verplaatsing implements Kosten{
    protected double benzineprijs;
    protected double verbruik;
    
    public VerplaatsingPerAuto(String X, String Y,double aantalKm, double benzineprijs, double verbruik) {
        super(X, Y, aantalKm);
        this.benzineprijs = benzineprijs;
        this.verbruik = verbruik;
    }

    public double getBenzineprijs() {
        return benzineprijs;
    }

    public void setBenzineprijs(double benzineprijs) {
        this.benzineprijs = benzineprijs;
    }

    public double getVerbruik() {
        return verbruik;
    }

    public void setVerbruik(double verbruik) {
        this.verbruik = verbruik;
    }
    
    @Override
    public double berkenPrijs() {
        return  verbruik * benzineprijs * aantalKm *2;
    }

    @Override
    public String toString() {
        return "De kosten van verplaatsing met auto is : " + (String.format("%.2f", berkenPrijs()) + " Euro");
    }
    
}
