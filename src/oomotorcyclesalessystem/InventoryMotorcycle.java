/*
This class defines the inventory
*/
package oomotorcyclesalessystem;

import database.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventoryMotorcycle extends Motorcycle {
    
    private int quantityInStock;
    public void setQuantityInStock(int quantityInStock){ //setter
        this.quantityInStock = quantityInStock;
    }
    public int getQuantityInStock(){ //getter
        return quantityInStock;
    }
    
    private int price;  //price is always set as a whole number
    public void setPrice(int price){ //setter
        this.price = price;
    }
    public int getPrice(){ //getter
        return price;
    }
    
    //this constructor is for inserting into the database 
    public InventoryMotorcycle(String brand, String model, int quantityInStock, int price) {
        super(brand, model);
        
        this.quantityInStock = quantityInStock;
        this.price = price;
    }
    
    //this constructor is for deleting from the database
    public InventoryMotorcycle(String model){
        super(model);
    }
    
    
    /*
    this method overrides the updateMotorcycleDatabase method from the Motorcycle class
    it inserts the brand and model into the motorcycles value, gets the motorcycle id for the inserted values
    and inserts that id and quantity in stock and price to the inventory table.
    */
    //if have time please create an if condition to check if the model already exists in the
    //database and if so a jframe to let the user know.
    @Override
    public void updateMotorcycleDatabase() throws ClassNotFoundException, SQLException{
        DatabaseConnection connection = new DatabaseConnection(); //create a database connection object
        
        PreparedStatement statement; //prepared statement improves perfomance
        
        //insert into the motorcycles table
        statement = connection.DatabaseConnection().prepareStatement("INSERT INTO motorcycles (Brand, Model)"
                                                        + " VALUES ('" + this.brand + "', '" + this.model + "')");
        statement.executeUpdate();
        
        //creates a sql statement and gets the id from motorcycle table
        Statement stmt = connection.DatabaseConnection().createStatement(); //creates a sql statement
        //gets the id 
        ResultSet rs = stmt.executeQuery("SELECT MotorcycleID FROM motorcycles WHERE model = '" + this.model + "'" );
        
        int motorcycleID = 0; //this variable holds the motorcycleID from the motorcycle table
        
        while(rs.next()){
            motorcycleID = rs.getInt("MotorcycleID");
            break;
        }
        
        //insert into the inventory table
        statement = connection.DatabaseConnection().prepareStatement("INSERT INTO inventory (MotorcycleID, QuantityInStock, Price) VALUES (" + motorcycleID + ", " + this.quantityInStock 
                         + ", " + this.price +")");
        
        statement.executeUpdate();
        
        connection.DatabaseConnection().close();
    }
    

    public void deleteFromMotorcycleDatabase() throws ClassNotFoundException, SQLException{
        //get the motorcycleID
        DatabaseConnection connection = new DatabaseConnection();
        //creates a sql statement and gets the id from motorcycle table
        Statement stmt = connection.DatabaseConnection().createStatement(); //creates a sql statement
        //gets the id 
        ResultSet rs = stmt.executeQuery("SELECT MotorcycleID FROM motorcycles WHERE model = '" + this.model + "'" );
        
        int motorcycleID = 0; //this variable holds the motorcycleID from the motorcycle table
        
        while(rs.next()){
            motorcycleID = rs.getInt("MotorcycleID");
            break;
        }
        System.out.println("Delete motorcycle  ID: " + motorcycleID);
        rs.close();
        
        PreparedStatement statement = connection.DatabaseConnection().prepareStatement("DELETE FROM inventory WHERE MotorcycleID = " + motorcycleID);
        statement.execute();
        statement.close();
        
        PreparedStatement ps = connection.DatabaseConnection().prepareStatement("DELETE FROM motorcycles WHERE MotorcycleID = " + motorcycleID);
        ps.execute();
        ps.close();
        
        connection.DatabaseConnection().close();
        
    }
}
