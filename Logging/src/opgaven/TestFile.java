/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgaven;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestFile {
    
    public static void main(String[] args) {
        try {
            //First make the url then check the null point, after it rest
            URL url = TestFile.class.getResource("/opgaven/Woensdag.txt");
            if(url != null){
            File bestand = new File(url.toURI());
            if(bestand.exists()){
                System.out.println("aantal bytes : " + bestand.length());
            }else{
                System.out.println("Bestaat niet ");
            }
        }} catch (URISyntaxException ex ) {
            Logger.getLogger(TestFile.class.getName()).log(Level.SEVERE, null, ex);
            //ZELFDE RESULTAAT ALS ER BOVEN
//            ex.printStackTrace();
        }catch(Exception ex){
            Logger.getLogger(TestFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Einde");
    }
}
