
package basis.opgaven.domein;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author alima
 */
public class SchoolParser {
    private String bestandnaam;
    
    public SchoolParser(String padNaarBestand){
        bestandnaam = padNaarBestand;
    }
    
    public School haalInfoOp(){
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(bestandnaam)))){
 JSONTokener tokener1 = new JSONTokener(reader);
            JSONObject hoofdObject1 = new JSONObject(tokener1);
           
            School school = new School(hoofdObject1.opt("school").toString());
            
//            String naam = (String) jsonObject.get("naam");
//            JSONArray schoolInfo = (JSONArray) jsonObject.get("school");
//            Iterator<Object> iterator = schoolInfo.iterator();
//            while(iterator.hasNext()){
//                System.out.println("iterator" + iterator.next());
//            }
            //haal alle afdelingen op van de school
//            JSONObject school = hoofdObject.getJSONObject("school");
//            JSONArray afdelingen = school.getJSONArray("afdelingen");
//            System.out.println("verschillende afdelingen in de steden : " );
//            for (int i = 0; i < afdelingen.length(); i++) {
//                System.out.println("\t- " + afdelingen.get(i));
//            }
                JSONObject json = hoofdObject1.getJSONObject("school");
                String naam = json.getString("naam");
                String provincie = json.getString("provincie");
                String website = json.getString("website");
                

                School s = new School(naam,provincie,website);
                school.setSchool(s);
               System.out.println(school);
               JSONObject sch = hoofdObject1.getJSONObject("school");
               JSONArray afd = sch.getJSONArray("afdelingen");
               
               
               for (Object object : afd) {
                   System.out.println(object);
                   Afdeling af = new Afdeling(object.toString());
                   school.addAfdeling(af);
            }
            
               
                
           return school;                  
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
    public Cursus haalCursusOp(){
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(bestandnaam)))){

           JSONTokener tokener = new JSONTokener(reader);
            JSONObject hoofdObject = new JSONObject(tokener);
           
            Cursus cursus = new Cursus(hoofdObject.opt("cursus").toString());
            
            JSONArray cursisten = hoofdObject.getJSONArray("cursisten");
            for(Object object : cursisten){
                System.out.println(object);
                
                Cursist c = new Cursist(((JSONObject) object).get("naam").toString());
                System.out.println(c);
                cursus.addCursist(c);
            }
            return cursus;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
}
