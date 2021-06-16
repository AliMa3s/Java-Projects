/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.groeipunt.databank;


import be.groeipunt.domain.Club;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rosev
 */
public class ClubDB {
    
    
    public ArrayList<Club> alleClubs(){
        Connection con = DbManager.manager.getConnection();
        ArrayList<Club> clubLijst = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from club");
            while (rs.next()){
//                for (int i = 1; i < 5; i++) {
//                    System.out.print(rs.getObject(i) + " - ");                    
//                }
                Club club = new Club(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
                System.out.println(club);
                clubLijst.add(club);
            }
            
            return clubLijst;
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            DbManager.manager.sluitConnectie(con);
        }
    }
    
}
