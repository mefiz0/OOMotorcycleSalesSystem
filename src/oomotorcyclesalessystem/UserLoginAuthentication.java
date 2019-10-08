
package oomotorcyclesalessystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLoginAuthentication {
    
    private String username;
    public void setUsername(String username){ //set username
        this.username = username;
    }
    public String getUsername(){ //getter
        return username;
    }
    
    private String password;
    public void setPassword(String password){ //setter
        this.password = password;
    }
    public String getPassword(){ //getter
        return password;
    }
    
    public UserLoginAuthentication(){
        //empty
    } 
    
    //connects to the db to cross check username and password
    /*
    Checks if there is a user ID with the username and password given
    if there is the user id is returned to the loginstatuscheck so it will be >1
    however if there isnt the loginstatuscheck will be at 0.
    so the user can be authenticated based on that
    */
    public int updateView() throws SQLException{
        
        int loginStatusCheck = 0; //this stores the values of the login status. true if login is a success
       
        Connection connection = DriverManager.getConnection("jdbc:derby:Database;create=true");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT UserID FROM users WHERE Username='" + username 
                + "' AND Password='" + password + "'");
        if(rs.next()){
            loginStatusCheck = rs.getInt("UserID");
        }//end while
        
        
       return loginStatusCheck;
    }
}
