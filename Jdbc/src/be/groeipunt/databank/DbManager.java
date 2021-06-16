package be.groeipunt.databank;


import be.groeipunt.domain.Club;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbManager {
    public static final DbManager manager = new DbManager();
    
    private Properties props;
    private String url;
    
    public DbManager(){
                try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver niet gevonden");
        }
        props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "root");
        url="jdbc:mysql://localhost/sportinvlaanderen";
    }
    
    
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(url, props);
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void sluitConnectie(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) {
        Connection con = manager.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from club");
            while (rs.next()){
//                for (int i = 1; i < 5; i++) {
//                    System.out.print(rs.getObject(i) + " - ");                    
//                }
                Club club = new Club(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
                System.out.println(club);
            }
            manager.sluitConnectie(con);
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
