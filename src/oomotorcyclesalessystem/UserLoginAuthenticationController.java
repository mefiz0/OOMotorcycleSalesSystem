
package oomotorcyclesalessystem;

import java.sql.SQLException;

public class UserLoginAuthenticationController {
    //create an object
    UserLoginAuthenticationModel model = new UserLoginAuthenticationModel();
    UserLoginAuthenticationView view = new UserLoginAuthenticationView();
    
    public UserLoginAuthenticationController(UserLoginAuthenticationModel model, UserLoginAuthenticationView view){
        this.model = model;
        this.view = view;
    }
    
    //set the username
    public void setUsername(String username){
        model.setUsername(username);
    }
    //get the username
    public void getUsername(){
        model.getUsername();
    }
    
    //set the password
    public void setPassword(String password){
        model.setPassword(password);
    }
    //get the password
    public void getPassword(){
        model.getPassword();
    }
    
    public UserLoginAuthenticationController(){
        //empty
    }
    //authenticate with the database and update the view
    public void updateView() throws SQLException{
        view.updateView(model.getUsername(), model.getPassword());
    }
}
