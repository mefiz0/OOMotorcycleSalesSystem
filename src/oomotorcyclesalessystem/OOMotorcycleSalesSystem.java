
package oomotorcyclesalessystem;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class OOMotorcycleSalesSystem {

    public static void main(String[] args) {
        
        DatabaseConnection connect = new DatabaseConnection();   
        try {
            connect.initDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OOMotorcycleSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OOMotorcycleSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
        } //end try
        
       SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new LoginPage();
                ///throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
           
       });
               
    }
    
}
