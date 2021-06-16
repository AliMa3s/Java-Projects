
package basis.opgaven.domein;

import java.util.ArrayList;
import org.json.JSONArray;


public class School {
 private String naam;
   private String website;
   private String provincie;
   private ArrayList<Afdeling> afdelingen;
   public School school;

    public School(String naam, String provincie , String  website) {
        this.naam = naam;
        this.website = website;
        this.provincie = provincie;
       }
    public School(String naam){
        this.naam = naam;
        this.website = website;
        this.provincie = provincie;
        afdelingen = new ArrayList();
    }

    public String getNaam() {
        return naam;
    }

    public String getWebsite() {
        return website;
    }

    public String getProvincie() {
        return provincie;
    }

    public ArrayList<Afdeling> getAfdelingen() {
        return afdelingen;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    
   
   public void addAfdeling(Afdeling afdeling){
       afdelingen.add(afdeling);
   }

    @Override
    public String toString() {
        return naam + " in " + provincie+  " meer info op " +website ;
    }
   
   
   
}
