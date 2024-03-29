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
    public InventoryMotorcycle(String brand, String model, String clutchType, int quantityInStock, int price) {
        super(brand, model, clutchType);
        
        this.quantityInStock = quantityInStock;
        this.price = price;
    }
    
    //this constructors is for updating the database
    public InventoryMotorcycle(String model, int quantityInStock, int price){
        super(model);
        
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
        statement = connection.DatabaseConnection().prepareStatement("INSERT INTO inventory (Brand, Model, ClutchType, QuantityInStock, Price)"
                                                        + " VALUES ('" + this.getBrand() + "', '" + this.getModel() + "', "
                                                        + "'" + this.getClutchType() +"', " 
                                                        + this.quantityInStock + ", " + this.price + ")");
        statement.execute();
        statement.close();
        connection.DatabaseConnection().close();
    }
    

    public void deleteFromMotorcycleDatabase() throws ClassNotFoundException, SQLException{
        //get the motorcycleID
        DatabaseConnection connection = new DatabaseConnection();
        //creates a sql statement and gets the id from motorcycle table
        String deleteQuery = "DELETE FROM inventory WHERE model = '" + this.getModel() + "'" ;
        PreparedStatement deleteStatement = connection.DatabaseConnection().prepareStatement(deleteQuery); //creates a sql statement
        deleteStatement.execute();
        
        deleteStatement.close();
        connection.DatabaseConnection().close();
        
    }
    
    public void modifyMotorcycleDatabase() throws ClassNotFoundException, SQLException{
        String modifyQuery = "UPDATE inventory SET QuantityInStock = " +this.quantityInStock + ", "
                           + "Price = " + this.price + " WHERE Model = '" + this.getModel() + "'";
        
        //create connection
        DatabaseConnection connection = new DatabaseConnection();
        PreparedStatement statement = connection.DatabaseConnection().prepareStatement(modifyQuery);
        statement.execute();
        statement.close();
        connection.DatabaseConnection().close();
    }
}
