
package oomotorcyclesalessystem;

import database.DatabaseConnection;
import userinterface.LoginPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

public class OOMotorcycleSalesSystem {

    public static void main(String[] args) {
        
        DatabaseConnection connect = new DatabaseConnection();
        try {
            connect.initDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OOMotorcycleSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OOMotorcycleSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setLookAndFeel("Windows"); //set the look and feel to windows default
        
        SwingUtilities.invokeLater(new Runnable(){ //executes as a runnable on the AWT event dispatching thread, to make it more threadsafe.
            
            @Override
            public void run() {
                LoginPage login = new LoginPage();
                login.setVisible(true);
            }
            
        });
    }
    
    //this method sets the look and feel of the UI
    public static void setLookAndFeel(String laf){
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (laf.equals(info.getName())) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(OOMotorcycleSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(OOMotorcycleSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(OOMotorcycleSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(OOMotorcycleSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
    }
}
