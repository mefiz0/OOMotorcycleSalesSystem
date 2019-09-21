
package oomotorcyclesalessystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class OOMotorcycleSalesSystem {

    public static void main(String[] args) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        // test 
        Statement stmt;
        try {
            stmt = connect.DatabaseConnection().createStatement();
     
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OOMotorcycleSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OOMotorcycleSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(new Runnable(){
            
            @Override
            public void run() {
                LoginPage login = new LoginPage();
                login.setVisible(true);
            }
            
        });
    }
    
}
