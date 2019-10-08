
package oomotorcyclesalessystem;

import database.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Motorcycle {
    
    String brand;
    public void setBrand(String brand){ //setter
        this.brand = brand;
    }
    public String getBrand(){ //getter
        return brand;
    }
    
    String model;
    public void setModel(String model){ //setter
        this.model = model;
    }
    public String getModel(){ //getter
        return model;
    }
    
    //constructor
    public Motorcycle(String brand, String model){
        this.brand = brand;
        this.model = model;
    }
    
    //this constructor is for deleting from the database
    //only model is needed to get the motorcycle id from the database
    //as the model is unique to each motorcycle
    public Motorcycle(String model){
        this.model = model;
    }
    
    //update the database record
    public void updateMotorcycleDatabase() throws ClassNotFoundException, SQLException{
        DatabaseConnection connection = new DatabaseConnection(); //create a database connection object
        
        PreparedStatement statement;
        statement = connection.DatabaseConnection().prepareStatement("INSERT INTO motorcycles"
                                                        + " VALUES ('" + this.brand + "', '" + this.model + "')");
        statement.execute();
    }
    
    //delete the database record
    public void deleteFromMotorcycleDatabase() throws ClassNotFoundException, SQLException{
        DatabaseConnection connection = new DatabaseConnection();
        
        PreparedStatement statement;
        statement = connection.DatabaseConnection().prepareStatement("DELETE FROM motorcycles WHERE model = '"
                                                                     +this.model+"'");
    }
}
