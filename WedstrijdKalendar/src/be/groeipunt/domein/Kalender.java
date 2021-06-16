
package be.groeipunt.domein;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author alima
 */
public class Kalender {
    private ArrayList<Wedstrijd> wedstrijdLijst = new ArrayList<Wedstrijd>();
    private Ploeg ploeg;
    private GregorianCalendar datum;

    public void setPloeg(Ploeg ploeg) {
        this.ploeg = ploeg;
    }

    public Kalender() {
        this.ploeg = ploeg;
        this.datum = datum;
    }

    public GregorianCalendar getDatum() {
        return datum;
    }

    public void setDatum(GregorianCalendar datum) {
        this.datum = datum;
    }
    
    public void voegToe(Wedstrijd wedstrijdDag){
        wedstrijdLijst.add(wedstrijdDag);
    }

    @Override
    public String toString() {
        return "Kalender{" + "wedstrijdLijst=" + wedstrijdLijst + ", ploeg=" + ploeg + ", datum=" + datum + '}';
    }
    
}
