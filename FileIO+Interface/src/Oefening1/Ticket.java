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
public class Ticket{
    protected String omschrijving;
    protected double prijs;

    public Ticket(String omschrijving, double prijs) {
        this.omschrijving = omschrijving;
        this.prijs = prijs;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return "Ticket voor " + omschrijving + " en prijs is :" + prijs + " Euro";
    }
    
    
   
    
}
