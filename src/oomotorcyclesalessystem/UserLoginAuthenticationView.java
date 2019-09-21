/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oomotorcyclesalessystem;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class UserLoginAuthenticationView {
    //create popup window components
    JFrame loginStatus = new JFrame();
    JPanel loginStatusPanel = new JPanel();
    JLabel loginStatusLabel = new JLabel();
    
    //gets the username and password from the user and notifies them of their login status
    //connects to the db to cross check username and password
    public void updateView(String username, String password) throws SQLException{
        
        int loginStatusCheck = 0; //this stores the values of the login status. true if login is a success
       
        Connection connection = DriverManager.getConnection("jdbc:derby:Database;create=true");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT UserID FROM users WHERE Username='" + username 
                + "' AND Password='" + password + "'");
        if(rs.next()){
            loginStatusCheck = rs.getInt("UserID");
        }//end while
        
        if(loginStatusCheck != 0){
            loginStatusLabel.setFont(new Font("NewsGoth Lt BT", 0, 14));
                

                
        }else if(loginStatusCheck == 0){
            

        }

    }
}
