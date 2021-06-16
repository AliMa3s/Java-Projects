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
public class Verplaatsing {
    public String X;
    public String Y;
    public double aantalKm;

    public Verplaatsing(String X, String Y, double aantalKm) {
        this.X = X;
        this.Y = Y;
        this.aantalKm = aantalKm;
    }

    public String getX() {
        return X;
    }

    public void setX(String X) {
        this.X = X;
    }

    public String getY() {
        return Y;
    }

    public void setY(String Y) {
        this.Y = Y;
    }

    public double getAantalKm() {
        return aantalKm;
    }

    public void setAantalKm(double aantalKm) {
        this.aantalKm = aantalKm;
    }

    @Override
    public String toString() {
        return "Verplaatsing van X " + X + " naar Y " + Y + " met aantalKm " + aantalKm + '}';
    }
    
}
