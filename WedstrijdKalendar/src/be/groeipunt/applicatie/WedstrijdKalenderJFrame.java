package be.groeipunt.applicatie;

import be.groeipunt.domein.Kalender;
import be.groeipunt.domein.Ploeg;
import be.groeipunt.domein.Speler;
import be.groeipunt.domein.Wedstrijd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class WedstrijdKalenderJFrame extends javax.swing.JFrame {
    private File ploegenCSV;
    private File KalenderCSV;
    private File SpelerCSV;
    public WedstrijdKalenderJFrame() {
        JFileChooser fileChooser = new JFileChooser(
                "C:\\Users\\alima\\OneDrive\\Documents\\JAVA NETBEANS\\2021-05-12_FamilienaamVoornaam\\src\\be\\groeipunt\\data");
       
        initComponents();
        
        while(ploegenCSV == null || !ploegenCSV.getName().equals("Ploegen.csv")){
            fileChooser.setDialogTitle("selecteer de File: 'PLOEGEN.CSV'");
            fileChooser.showOpenDialog(this);
            ploegenCSV = fileChooser.getSelectedFile();
        }
        while(KalenderCSV == null || !KalenderCSV.getName().equals("Kalender.csv")){
            fileChooser.setDialogTitle("selecteer de File: 'Kalender.CSV'");
            fileChooser.showOpenDialog(this);
            KalenderCSV = fileChooser.getSelectedFile();
        }
        while(SpelerCSV == null || !SpelerCSV.getName().equals("Spelers.csv")){
            fileChooser.setDialogTitle("selecteer de File: 'Spelers.CSV'");
            fileChooser.showOpenDialog(this);
            SpelerCSV = fileChooser.getSelectedFile();
        }
//      
        setLocationRelativeTo(null);
        File ploegBestandCSV = null;

        setLocationRelativeTo(null);
        File spelerBestandCSV = null;

        setLocationRelativeTo(null);
        File WedstrijdBestand = null;
        
        
        ArrayList<Ploeg> ploegenLijst = verwerkPloegen(ploegBestandCSV);
        txaPloegen.append("-------\n JAVA object\n--------------\n ");
        for (Ploeg ploeg : ploegenLijst) {
            txaPloegen.append(ploeg+ "\n");
            
        }
        
        
        ArrayList<Wedstrijd> wedsrijdlijst = verwerkWedstrijd(WedstrijdBestand);
        txaWedstrijden.append("-------\n JAVA object\n--------------\n ");
         for(var wed : wedsrijdlijst){
             txaWedstrijden.append(wed + "\n");
         }
         

        ArrayList<Speler> spelerLijst = verwerkSpelers(spelerBestandCSV);
          txaSpelers.append("-------\n JAVA object\n--------------\n ");
            for (Speler speler : spelerLijst) {
                    txaSpelers.append("\n" + speler);
            }
        
        
    }
    
    
    
        private ArrayList<Ploeg> verwerkPloegen(File file){
            ArrayList<Ploeg> result = new ArrayList<>();
            String ploegCSV = "C:\\Users\\alima\\OneDrive\\Documents\\JAVA NETBEANS\\2021-05-12_FamilienaamVoornaam\\src\\be\\groeipunt\\data\\Ploegen.csv";
            txaPloegen.append("Gehald csv bestand \n-------------\n");
            try( BufferedReader reader = new BufferedReader(new FileReader(ploegCSV))){
                String line = reader.readLine();
            while((line = reader.readLine())!=null){
                txaPloegen.append(line + "\n");
                String[] split = line.split(";");
                Ploeg p = new Ploeg(split[0],split[1]);

                result.add(p);
            }
        }  catch (Exception ex) {
            Logger.getLogger(WedstrijdKalenderJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

         
        private ArrayList<Speler> verwerkSpelers(File spelerCSV) {
        ArrayList<Speler> result = new ArrayList<Speler>();
         String ploegCSV = "C:\\Users\\alima\\OneDrive\\Documents\\JAVA NETBEANS\\2021-05-12_FamilienaamVoornaam\\src\\be\\groeipunt\\data\\Spelers.csv";
        txaSpelers.append("Gehald csv bestand \n-------------\n");
        try ( BufferedReader reader = new BufferedReader(new FileReader(ploegCSV))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                txaSpelers.append(line + "\n");
                String[] splitted = line.split(";");
                String ploegnaam = splitted[0];
                Speler speler = new Speler(splitted[1],splitted[2],splitted[0]);
                result.add(speler);
                
               
                

            }
        } catch (Exception ex) {
            Logger.getLogger(WedstrijdKalenderJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
        private ArrayList<Wedstrijd> verwerkWedstrijd(File wedstrijdenCSV) {
        ArrayList<Wedstrijd> result = new ArrayList<Wedstrijd>();
         String ploegCSV = "C:\\Users\\alima\\OneDrive\\Documents\\JAVA NETBEANS\\2021-05-12_FamilienaamVoornaam\\src\\be\\groeipunt\\data\\Kalender.csv";
        txaWedstrijden.append("Gehald csv bestand \n-------------\n");
        try ( BufferedReader reader = new BufferedReader(new FileReader(ploegCSV))) {
            String line = reader.readLine();
            // de vorige lijn is de titellijn, dus deze skippen
            while ((line = reader.readLine()) != null) {
                txaWedstrijden.append(line + "\n");
                String[] splitted = line.split(";");
                Wedstrijd weds = new Wedstrijd(splitted[0],splitted[1] , splitted[2] );
                
                result.add(weds);
                
               
                

            }
        } catch (Exception ex) {
            Logger.getLogger(WedstrijdKalenderJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
        
//        private Kalender verwerkKalender(File wedstrijdenCSV, ArrayList<Ploeg> ploegenLijst) {
//        Kalender kalender = new Kalender();
//        String wedstrijdCSV = "C:\\Users\\alima\\OneDrive\\Documents\\JAVA NETBEANS\\2021-05-12_FamilienaamVoornaam\\src\\be\\groeipunt\\data\\kalender.csv";
//        txaWedstrijden.append("Gehald csv bestand .csv bestand\n----------------\n");
//        try (BufferedReader reader = new BufferedReader(new FileReader(wedstrijdCSV))) {
//            String line = reader.readLine();
//            // de vorige lijn is de titellijn, dus deze skippen
//            while ((line = reader.readLine()) != null) {
//                txaWedstrijden.append(line + "\n");
//                String[] splitted = line.split(";");
//                String datum = splitted[0];
//                String thuis = splitted[1];
//                String bezoekers = splitted[2];
//                Ploeg thuisPloeg = null;
//                for (Ploeg ploeg : ploegenLijst) {
//                    if (ploeg.zelfdeNaam(thuis)) {
//                        thuisPloeg = ploeg;
//                        break;
//                    }
//                }
//                Ploeg bezoekersPloeg = null;
//                for (Ploeg ploeg : ploegenLijst) {
//                    if (ploeg.zelfdeNaam(bezoekers)) {
//                        bezoekersPloeg = ploeg;
//                        break;
//                    }
//                }
//
//                kalender.voegToe(new Wedstrijd(datum, thuisPloeg, bezoekersPloeg));
//
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(WedstrijdKalenderJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return kalender;
//    }
//         private ArrayList<Speler> verwerkSpelers(File file, ArrayList<Ploeg> ploegenLijst) {
//        ArrayList<Speler> result = new ArrayList<Speler>();
//        
//         String spelerCSV = "C:\\Users\\alima\\OneDrive\\Documents\\JAVA NETBEANS\\2021-05-12_FamilienaamVoornaam\\src\\be\\groeipunt\\data\\Spelers.csv";
//        txaSpelers.append("Gehald csv bestand \n-------------\n");
//        try ( BufferedReader reader = new BufferedReader(new FileReader(spelerCSV))) {
//            String line = reader.readLine();
//            // de vorige lijn is de titellijn, dus deze skippen
//            while ((line = reader.readLine()) != null) {
//                txaSpelers.append(line + "\n");
//                String[] splitted = line.split(";");
//                String ploegnaam = splitted[0];
//                Speler speler = new Speler(splitted[1], splitted[2]);
//                for (Ploeg ploeg : ploegenLijst) {
//                    if (ploeg.zelfdeNaam(ploegnaam)) {
//                        ploeg.voegToe(speler);
//                        break;
//                    }
//                }
//                result.add(speler);
//
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(WedstrijdKalenderJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }

    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txaPloegen = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaSpelers = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaWedstrijden = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data uit CSV bestanden omzetten naar Java objecten");

        txaPloegen.setColumns(20);
        txaPloegen.setRows(5);
        txaPloegen.setBorder(javax.swing.BorderFactory.createTitledBorder("Ploegen"));
        jScrollPane1.setViewportView(txaPloegen);

        txaSpelers.setColumns(20);
        txaSpelers.setRows(5);
        txaSpelers.setBorder(javax.swing.BorderFactory.createTitledBorder("Spelers"));
        jScrollPane2.setViewportView(txaSpelers);

        txaWedstrijden.setColumns(20);
        txaWedstrijden.setRows(5);
        txaWedstrijden.setBorder(javax.swing.BorderFactory.createTitledBorder("Wedstrijden"));
        jScrollPane3.setViewportView(txaWedstrijden);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WedstrijdKalenderJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WedstrijdKalenderJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WedstrijdKalenderJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WedstrijdKalenderJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WedstrijdKalenderJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txaPloegen;
    private javax.swing.JTextArea txaSpelers;
    private javax.swing.JTextArea txaWedstrijden;
    // End of variables declaration//GEN-END:variables

}
