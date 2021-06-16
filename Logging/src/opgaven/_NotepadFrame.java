package opgaven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * - de dialog toont enkel de .txt bestanden en gebruikt daarvoor een speciale
 * filter (niet de klassieke java.io.FileFilter) nl
 * javax.swing.filechooser.FileFilter - exception voor 't openen van de file
 * locaal opvangen en loggen in een eigen logbestand via een eenvoudige
 * boodschap - exception voor 't lezen van de file propageren naar de caller,
 * zodat deze een popup kan laten verschijnen
 */
public class _NotepadFrame extends javax.swing.JFrame {

    /**
     * wordt eenmalig aangemaakt
     */
    private JFileChooser fileChooser;
    private File logging;
    private File currentFile;
     
        /**
         * Uitbreiding: maak een logbestand aan en log tijdstip + bepaalde
         * acties die hier gebeuren vb <ol>
         * <li>de applicatie wordt gestart,</li>
         * <li>een bestand + naam wordt geopend,</li>
         * <li>een bestand + naam wordt bewaard,</li>
         * <li>er gebeurt een fout,</li>
         * <li>enz...</li></ol>
         */
    public _NotepadFrame() throws IOException {
        initComponents();
        /* instantieer de fileChooser slechts 1 keer, dus niet in menuOpen*/
        initFileDialog();
        String gestart = " applicatie wordt gestart";
        if(logging == null){
           logging = new File("src/logging/Java-editor.log");
           
       }
           try(PrintWriter pw = new PrintWriter(new FileWriter(logging, true))) {
              pw.println(String.format("%tc", new Date()));
             pw.print(String.format("%tR", new Date()));
               pw.println(" applicatie word gestart");
        } catch (IOException ex) {
           Logger.getLogger(_NotepadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initFileDialog() {
        /**
         * je kan ook een fileChooser via Design naar form plaatsen, maar ook
         * dan nog moet je hier een eigen fileFilter op toepassen
         */
        /**
         * je kan aan de constructor ook een opstartdirectory opgeven
         */
        fileChooser = new JFileChooser("C:\\Users\\alima\\OneDrive\\Documents\\NetBeansProjects\\2021-02-03");
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().endsWith(".txt");
//                return true;
            }

            @Override
            public String getDescription() {
                return ("tekstbestanden");
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMessage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areText = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnBestand = new javax.swing.JMenu();
        mnOpen = new javax.swing.JMenuItem();
        mnSave = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("...: Notepad :...");

        lblMessage.setForeground(new java.awt.Color(0, 0, 255));
        lblMessage.setText("Open een bestand...");

        areText.setColumns(20);
        areText.setRows(5);
        areText.setText("Open via menubalk een bestand waarna hier \nde inhoud zal verschijnen.\nVia menubalk kan je nadien dit bestand bewaren");
        jScrollPane1.setViewportView(areText);

        mnBestand.setText("Bestand");

        mnOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnOpen.setMnemonic('O');
        mnOpen.setText("Open");
        mnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOpenActionPerformed(evt);
            }
        });
        mnBestand.add(mnOpen);

        mnSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnSave.setMnemonic('b');
        mnSave.setText("Bewaren");
        mnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveActionPerformed(evt);
            }
        });
        mnBestand.add(mnSave);

        jMenuBar1.add(mnBestand);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessage))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void mnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnOpenActionPerformed
    // 1. toon de popup om een bestand te kiezen. De FileFilter zorgt ervoor dat
    // enkel .txt bestanden worden getoond
   
        int keuze = fileChooser.showOpenDialog(null);
        
        areText.setText(null);
        
        if(keuze == JFileChooser.CANCEL_OPTION){
            areText.append(" gecancelled ");
        }else{
            currentFile = fileChooser.getSelectedFile();
//            areText.append(" Selectie : "+ fileChooser.getSelectedFile());
        }
   
        try (BufferedReader br = new BufferedReader(new FileReader(currentFile));){
            // 2. daarna toon je de inhoud van het bestand in het tekstgebied
//            String eenLijn = br.readLine();
//            if(eenLijn != null){
//                areText.append(eenLijn);
//            }
//Zelfde als code er boven maar update niet als je tekst woensdag update
            String eenLijn;
            while((eenLijn = br.readLine()) != null){
                areText.append(eenLijn);
                //puts a new line
                areText.append("\n");
            }
            
            //GEBRUIK OF ERBOVEN OF ERONDER BEIDE DOET HETZELFDE
            /*
            do{
                eenLijn = br.readLine();
                if(eenLijn != null){
                    areText.append(eenLijn);
                //puts a new line
                areText.append("\n");
                }
            }while(eenLijn != null);
            */
            // 3. gebruik lblMessage indien iets fout gaat
            // 4. Uitbreiding: log de bestandsnaam en tijdstip waarop het bestand werd geopend
        } catch (FileNotFoundException ex) {
            Logger.getLogger(_NotepadFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(_NotepadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         try(PrintWriter pw = new PrintWriter(new FileWriter(logging, true))) {
             pw.println(String.format("%tc", new Date()));
             pw.print(String.format("%tR", new Date()));
               pw.println(" Openen van het bestand");
               
        } catch (IOException ex) {
           Logger.getLogger(_NotepadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}//GEN-LAST:event_mnOpenActionPerformed

    private void mnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaveActionPerformed
       //SAVING FILE ITS EASY AS HELL
        try(FileWriter fw = new FileWriter(currentFile)) {
            /**
             * 1. instantier een fileWriter en schrijf de inhoud van het tekstgebied
             * naar het bestand 2. Uitbreiding: log de bestandsnaam en tijdstip waarop het
             * bestand werd bewaard
             *
             */
            areText.write(fw);
            
        } catch (IOException ex) {
            Logger.getLogger(_NotepadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         try(PrintWriter pw = new PrintWriter(new FileWriter(logging, true))) {
               pw.println(String.format("%tc", new Date()));
               pw.println(String.format("%tR", new Date()));
               pw.println(" opslaan van het bestand");
               
               pw.flush();
        } 
         
         catch (IOException ex) {
           Logger.getLogger(_NotepadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new _NotepadFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(_NotepadFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areText;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JMenu mnBestand;
    private javax.swing.JMenuItem mnOpen;
    private javax.swing.JMenuItem mnSave;
    // End of variables declaration//GEN-END:variables

}
