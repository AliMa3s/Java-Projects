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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Verplaatsing Tram = new VerplaatsingPerBusTram("Voskenslaan Gent", "Veldstraat", 4.2, 1, false, true);
        System.out.println(Tram.toString());
        Ticket ticket1 = new Ticket("Parkeerticket Flanders Expo", 5);
        System.out.println(ticket1.toString());
        Verplaatsing auto = new VerplaatsingPerAuto("Gent", "Oudenaarde", 29.4, 1.591, 0.0538);
        System.out.println(auto.toString());
        Ticket t2 = new Ticket("Toegangsticket beurs", 10);
        System.out.println(t2.toString());
        Verplaatsing Bus = new VerplaatsingPerBusTram("Laarne dorp", "Gent Sint-Pieters", 4.2, 1, true,false);
        System.out.println(Bus.toString());
        Verplaatsing auto2 = new VerplaatsingPerAuto("Gent", "Brussel", 53.7, 1.488, 0.0692);
        System.out.println(auto2.toString());
        
    }
    
}
