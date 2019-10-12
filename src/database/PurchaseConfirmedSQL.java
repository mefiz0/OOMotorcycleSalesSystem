/*
This class contains methods that are called when the purchase is confirmed
*/
package database;

import static database.CustomerFormAutoComplete.checkCustomerExists;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PurchaseConfirmedSQL {
    
    /*
    If the customer already doesn't exist in the database,add to the database.
    */
    public static void addToCustomers(String identityNumber,
                               String firstName,
                               String lastName,
                               String permanentAddress,
                               String currentAddress,
                               int contactNumber,
                               int bankAccountNum) throws ClassNotFoundException, SQLException{
        
        if(checkCustomerExists(identityNumber) == 0){ //check if the customer exists
            String insertToCustomer = "INSERT INTO customers "
                                    + "(FirstName, LastName, NID, PermanentAddress, CurrentAddress, ContactNumber, BankAccount) "
                                    + "VALUES "
                                    + "('" + firstName + "', "
                                    + "'" + lastName + "', "
                                    + "'" + identityNumber + "', "
                                    + "'" + permanentAddress + "', "
                                    + "'" + currentAddress + "', "
                                    + "" + contactNumber + ", "
                                    + "" + bankAccountNum + ") ";
            
            //create connection object
            DatabaseConnection connection = new DatabaseConnection();
            PreparedStatement statement = connection.DatabaseConnection().prepareStatement(insertToCustomer);
            //insert to database
            statement.execute();
            statement.close();
            
            connection.DatabaseConnection().close();
        }//end if
        
    }//end addToCustomers
    
    public static int getQuantityInStock(String model) throws ClassNotFoundException, SQLException{
        //create the sql statement
        String selectQuery = "SELECT QuantityInStock FROM inventory WHERE Model = '" + model +"'"; 
        int quantity = 0; //hold the value of motorcycleID
        
        DatabaseConnection connection = new DatabaseConnection(); //create the connection object
        PreparedStatement getQuantityInStockQuery; 
        getQuantityInStockQuery = connection.DatabaseConnection().prepareStatement(selectQuery);
        
        ResultSet rs;
        rs = getQuantityInStockQuery.executeQuery(); 
        if(rs.next()){
            quantity = Integer.parseInt(rs.getString("QuantityInStock")); //set the value
        }//end if(rs.next())
        
        System.out.println(quantity);
        rs.close();
        getQuantityInStockQuery.close();
        connection.DatabaseConnection().close();
        
        return quantity;
    }//end get quantityInStock
    
    //deduct 1 bike of the selected model from the inventory
    public static void deductFromInventory(String model, int quantity) throws ClassNotFoundException, SQLException{
        
        DatabaseConnection connection = new DatabaseConnection(); //create the connection object
        String selectIDSQL = "SELECT InventoryID FROM inventory WHERE Model = '" + model + "'";
        PreparedStatement getInventoryID = connection.DatabaseConnection().prepareStatement(selectIDSQL);
        ResultSet rs = getInventoryID.executeQuery();
        int inventoryID = 0;
        
        if(rs.next()){
            inventoryID =  Integer.parseInt(rs.getString("InventoryID"));
        }
        
        rs.close();
        getInventoryID.close();
        
        
        //calculate the new quantity
        quantity = quantity - 1;
        
        /*
        String deductFromInventoryQuery = "UPDATE inventory SET QuantityInStock = " + quantity + ""
                                        + " WHERE Model = '" + model + "'";
        this is throwin a db lock. so we will get the id number at that position and update that instead*/
        
        String deductFromInventoryQuery = "UPDATE inventory SET QuantityInStock = " + quantity + ""
                                        + " WHERE InventoryID = " + inventoryID + "";
                
        //prepare the query
        PreparedStatement updateQuantity = connection.DatabaseConnection().prepareStatement(deductFromInventoryQuery);
                
        //execute statement
        updateQuantity.execute();
        updateQuantity.close();
        connection.DatabaseConnection().close();
    }//end deductFromInventory
    
    //update the table of sold motorcycles - if there is installment
    public static void updateSoldMotorcyclesTableSQL(String brand, String model,
                                                  String boardNum,
                                                  int downPayment, int installmentPeriod
                                                  ) throws ClassNotFoundException, SQLException{
        //init variables
        String isInstallment;
        
        //prep the connection
        DatabaseConnection connection = new DatabaseConnection(); //create a connection object
        PreparedStatement updateDatabase; //create a prepared statement
        String insertToSoldMotorcycleSQL; //string to hold the query
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            
        isInstallment = "Yes"; //set installment to yes
            
        insertToSoldMotorcycleSQL = "INSERT INTO sold_motorcycles "
                                  +  " (Brand, Model, BoardNumber, DateOfPurchase, Installment, Paid) "
                                  +  "VALUES "
                                  +  "('" + brand + "', "
                                  +  "'" + model + "', "
                                  +  "'" + boardNum + "', "
                                  +  "'" + currentTime + "', "
                                  +  "'" + isInstallment + "', "
                                  +  + downPayment + ")";
            
        updateDatabase = connection.DatabaseConnection().prepareStatement(insertToSoldMotorcycleSQL);
        updateDatabase.execute(); //execute the query
        updateDatabase.close();
        connection.DatabaseConnection().close();
    }//end updateSoldMotorcycleTable
    
    //update the table of sold motorcycles - if there is no installment
    public static void updateSoldMotorcyclesTableSQL(String brand, String model,
                                                  String boardNum, int soldAmount
                                                  ) throws ClassNotFoundException, SQLException{
        //init variables
        String isInstallment;
        
        //prep the connection
        DatabaseConnection connection = new DatabaseConnection(); //create a connection object
        PreparedStatement updateDatabase; //create a prepared statement
        String insertToSoldMotorcycleSQL; //string to hold the query
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            
        isInstallment = "-";
            
        System.out.println(currentTime);
        System.out.println(soldAmount);
        insertToSoldMotorcycleSQL = "INSERT INTO sold_motorcycles "
                                  +  " (Brand, Model, BoardNumber, DateOfPurchase, Installment, Paid) "
                                  +  "VALUES "
                                  +  "('" + brand + "', "
                                  +  "'" + model + "', "
                                  +  "'" + boardNum + "', "
                                  +  "'" + currentTime + "', "
                                  +  "'" + isInstallment + "', "
                                  +  soldAmount + ")";
        
        updateDatabase = connection.DatabaseConnection().prepareStatement(insertToSoldMotorcycleSQL);
        updateDatabase.execute(); //execute the query      
        updateDatabase.close();
        
        connection.DatabaseConnection().close();
    }//end updateSoldMotorcycleTable
    
    //get the customer id
    public static int getCustomerID(String idNumber) throws ClassNotFoundException, SQLException{
        //define the query
        String getCustomerID = "SELECT CustomerID FROM customers WHERE NID = '" + idNumber + "'";
        //define variables to gold customerID
        int customerID = 0;

        //create the connection objects and the statements
        DatabaseConnection connection = new DatabaseConnection();
        PreparedStatement statement;  
        
        //get customerID
        statement = connection.DatabaseConnection().prepareStatement(getCustomerID);
        ResultSet rs = statement.executeQuery();
        
        if(rs.next()){
            customerID = Integer.parseInt(rs.getString("CustomerID"));
        }
        
        rs.close();
        statement.close();
        
        connection.DatabaseConnection().close();
        
        return customerID;
    }//end get customerID
    
    public static int getSoldID(String boardNumber) throws ClassNotFoundException, SQLException{
        //define the queries
        String getSoldMotorcycleID = "SELECT SoldID FROM sold_motorcycles WHERE BoardNumber = '" + boardNumber + "'"; 
        //define variables to gold soldID
        int soldID = 0;
   
        //create the connection objects and the statements
        DatabaseConnection connection = new DatabaseConnection();
        PreparedStatement statement;

        //get the soldID
        statement = connection.DatabaseConnection().prepareStatement(getSoldMotorcycleID);
        ResultSet rs = statement.executeQuery();
        
        if(rs.next()){
            soldID = Integer.parseInt(rs.getString("SoldID"));
        }
        
        rs.close();
        statement.close();
        
        connection.DatabaseConnection().close();
        
        return soldID;
    }//end getSoldID
    
    public static void updatePurchasesTableSQL(int customerID, int soldID) throws ClassNotFoundException, SQLException{
        
        //create the connection objects and the statements
        DatabaseConnection connection = new DatabaseConnection();
        PreparedStatement statement;
        
        //insert into the purchase table
        String insertIntoPurchaseTable = "INSERT INTO purchases (CustomerID, SoldID) "
                                       + "VALUES (" + customerID + ", " + soldID + ")";
        
        if((customerID != 0) && (soldID != 0)){ //if the ids are 0, it means the record doesnt exist
            
            statement = connection.DatabaseConnection().prepareStatement(insertIntoPurchaseTable);
            statement.execute();
            
            statement.close();
        }//end if
        
        connection.DatabaseConnection().close();
        
    }//end updatePurchaseTable
   
    public static int getPurchaseID(int customerID, int soldID) throws SQLException, ClassNotFoundException{
        //create the query
        String getPurchaseIDQuery = "SELECT PurchaseNumber FROM purchases WHERE "
                                  + "CustomerID = " + customerID + " AND SoldID = " + soldID + "";
        
        //create the connection object
        DatabaseConnection connection = new DatabaseConnection();
        PreparedStatement statement;
        statement = connection.DatabaseConnection().prepareStatement(getPurchaseIDQuery);
        int purchaseID = 0;
        
        //get the results
        ResultSet rs = statement.executeQuery();
        
        if(rs.next()){
            purchaseID = Integer.parseInt(rs.getString("PurchaseNumber"));
        }
        
        rs.close();
        statement.close();
        
        connection.DatabaseConnection().close();
        
        return purchaseID;
    }//end getPurchaseID
    
    public static void updateInstallmentsSQL(int purchaseID, Date dueDate, BigDecimal amountDue,
                                              BigDecimal rate, Date nextPayment, BigDecimal amountPayed) throws ClassNotFoundException, SQLException{
        //create the connection object
        DatabaseConnection connection = new DatabaseConnection();
        PreparedStatement statement;
        
        //define the query
        String insertPaymentsTable = "INSERT INTO payments (PurchaseNumber, DueDate, AmountDue, Rate, NextPayment, AmountPaid) "
                                   + "VALUES "
                                   + "(" + purchaseID + ", "
                                   + "'" + dueDate + "', "
                                   + amountDue + ", "
                                   + rate + ", "
                                   + "'" + nextPayment + "', "
                                   + amountPayed + ")";
        
        //insert into the database
        statement = connection.DatabaseConnection().prepareStatement(insertPaymentsTable);
        statement.execute();
        
        statement.close();
        connection.DatabaseConnection().close();
    }//end updateInstallmentsSQL
}
