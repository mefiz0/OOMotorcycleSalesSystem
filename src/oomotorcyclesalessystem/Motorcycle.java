
package oomotorcyclesalessystem;

import database.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Motorcycle {
    
    private String brand;
    public void setBrand(String brand){ //setter
        this.brand = brand;
    }
    public String getBrand(){ //getter
        return brand;
    }
    
    private String model;
    public void setModel(String model){ //setter
        this.model = model;
    }
    public String getModel(){ //getter
        return model;
    }
    
    private String clutchType;
    public void setClutchType(String clutchType){ //setter
        this.clutchType = clutchType;
    }
    public String getClutchType(){ //getter
        return clutchType;
    }
    
    //constructor
    public Motorcycle(String brand, String model, String clutchType){
        this.brand = brand;
        this.model = model;
        this.clutchType = clutchType;
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
        statement = connection.DatabaseConnection().prepareStatement("INSERT INTO inventory"
                                                        + " VALUES ('" + this.brand + "', '" + this.model + "')");
        statement.execute();
    }
    
    //delete the database record
    public void deleteFromMotorcycleDatabase() throws ClassNotFoundException, SQLException{
        DatabaseConnection connection = new DatabaseConnection();
        
        PreparedStatement statement;
        statement = connection.DatabaseConnection().prepareStatement("DELETE FROM inventory WHERE model = '"
                                                                     +this.model+"'");
    }
}
