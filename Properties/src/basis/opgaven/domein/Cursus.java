
package basis.opgaven.domein;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class Cursus  {
    private String naam;
    private ArrayList<Cursist> cursisten;
    
    public Cursus(String naam){
        this.naam = naam;
        cursisten = new ArrayList();
    }
    
    public void addCursist(Cursist eenCursist){
        cursisten.add(eenCursist);
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<Cursist> getCursisten() {
        return cursisten;
    }

    @Override
    public String toString() {
        return "Cursus{" + "naam=" + naam + ", cursisten=" + cursisten + '}';
    }
   
    
}
