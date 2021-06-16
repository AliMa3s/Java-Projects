/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oefening2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alima
 */
public class Main {

    Map<String, TreeSet<String>> map = new HashMap<>();
    String path = "C:\\Users\\alima\\OneDrive\\Documents\\Java projects\\Java2Opdracht1\\vlaams.txt";

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        String path = "C:\\Users\\alima\\OneDrive\\Documents\\Java projects\\Java2Opdracht1\\vlaams.txt";
//
//        Map<String, TreeSet<String>> deelgemeente =  leesGemeente(path);
//        System.out.println(deelgemeente.get("Anzegem"));
//        
//        
//    }
//
//    private static Map<String, TreeSet<String>> leesGemeente(String filename) {
//        
//        Map<String, TreeSet<String>> tekst = new HashMap<>();
//        
//        try {
//            FileReader fr = new FileReader(filename);
//            BufferedReader br = new BufferedReader(new FileReader(filename));
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] stukkje = line.split("\t");
//
//                String Steden = stukkje[1];
////                System.out.println(Steden);
//                String deelSteden = stukkje[0];
//                 
//                if(tekst.containsKey(Steden)){
//                    
//                    tekst.get(Steden).add(deelSteden);
////                    System.out.println(tekst);
//                }else{
//                    tekst.put(deelSteden, new TreeSet<>());
//                    tekst.get(deelSteden).add(Steden);
//                } 
//            } 
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return tekst;
//        
//}
//
//    }
    public static void main(String[] args) {
        // TODO code application logic here
        Map<String, TreeSet<String>> map = new HashMap<>();
        String path = "C:\\Users\\alima\\OneDrive\\Documents\\Java projects\\Java2Opdracht1\\vlaams.txt";
        Map <String, TreeSet<String>> deelgemeente = getGemeente(path);
        System.out.println(deelgemeente.get("Anzegem"));
    }
    
    private static Map<String, TreeSet<String>> getGemeente(String filename) {
        Map<String, TreeSet<String>> tekst = new HashMap<>();
        
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            
            while((line = bufferedReader.readLine()) != null) {
                String[] stukje = line.split("\t");
                
//                System.out.println(stukje[0]);
                String steden = stukje[1];
                String deelSteden = stukje[0];
                
                if (tekst.containsKey(steden)){
                    tekst.get(steden).add(deelSteden);
                } else {
                    tekst.put(deelSteden, new TreeSet<>());
                    tekst.get(deelSteden).add(steden);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tekst;
    }
}