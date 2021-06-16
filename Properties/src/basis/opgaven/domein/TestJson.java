
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


public class TestJson {
    public static void main(String[] args) {
        
        SchoolParser parser = new SchoolParser("src/basis/opgaven/domein/school.json");
        System.out.println(parser);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/basis/opgaven/domein/school.json")))){
//            ITS IS A TEST
//           String lijn = reader.readLine();
//           while(lijn!=null){
//               System.out.println(lijn);
//               lijn = reader.readLine();
//           }
            
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject hoofdObject = new JSONObject(tokener);
            System.out.println("huidige cursus : " + hoofdObject.opt("cursus"));
            Cursus cursus = new Cursus(hoofdObject.opt("cursus").toString());
            
            //haal alle afdelingen op van de school
            JSONObject school = hoofdObject.getJSONObject("school");
            JSONArray afdelingen = school.getJSONArray("afdelingen");
            System.out.println("verschillende afdelingen in de steden : " );
            for (int i = 0; i < afdelingen.length(); i++) {
                System.out.println("\t- " + afdelingen.get(i));
            }
            
            //haal alle cursisten op die van de cursisten:
//            JSONArray cursisten = hoofdObject.getJSONArray("cursisten");
//            System.out.println("De lessen wordt gegeven aan : ");
//            for(Object o : cursisten){
//                System.out.println("\t- " +((JSONObject) o));
//            }
            JSONArray cursisten = hoofdObject.getJSONArray("cursisten");
            for(Object object : cursisten){
                //System.out.println(object);
                Cursist c = new Cursist(((JSONObject) object).get("naam").toString());
                //System.out.println(c);
                cursus.addCursist(c);
            }
            System.out.println("de cursus : \n" + cursus);
//            ArrayList<Cursist> lijst = new ArrayList<>();
//            lijst.add(new Cursist("Jasson"));
//            lijst.add(new Cursist("James"));
//            lijst.add(new Cursist("nick"));
//            
//            for(Cursist cursit : lijst){
//                System.out.println("Nieuwe Cursist : " + cursit);
//            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
