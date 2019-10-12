/*
Defiines classes for database operations
*/
package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver"; //specifies the driver
    public final String JDBC_URL = "jdbc:derby:Database;create=true"; //specifies the database URL


    //Establishes a database connection
    public Connection DatabaseConnection() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(JDBC_URL);
        System.out.println("Connected to DB Successfully");

        return connection;
    }//end connection

    /*
    This functions checks if a given table exists by looking at the database metadata,
    and creates if a table is missing. This allows the application to start from scratch
    in the event the database gets deleted.
    */
    public void checkTable(String tableName, DatabaseMetaData dbmd, Statement stmt,
                              String createTable) throws SQLException{
        //gets the result set from the metadata
        boolean checkStatus;
        ResultSet rs = dbmd.getTables(null, null, tableName.toUpperCase() , null);
        //checks the metadata
        if(rs.next()){
            System.out.println("Table " + tableName + " already exists.");
        }else{

            System.out.println("Table " + tableName + " does not exist");
            stmt.execute(createTable); //create the users table
            System.out.println(tableName + " Table Created");
            if(tableName == "users"){
                stmt.executeUpdate(DatabaseTables.ADD_DEFAULT_VALUES_TO_USERS_TABLE_SQL);
            }
        }
    }//end checkTable

    //initializes the db with the tables
    public Connection initDB() throws ClassNotFoundException, SQLException{
        //establish a connection, this will also create a db if there is none
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(JDBC_URL);
        System.out.println("Connected to DB Successfully");

        Statement initTables = connection.createStatement(); //creates a statment object

        //check if the tables are created
        DatabaseMetaData dbmd = connection.getMetaData(); //gets the database metadata
        //gets the result set for the specific tables
        //check the users table
        checkTable("users", dbmd, initTables, DatabaseTables.CREATE_USERS_TABLE_SQL);

        //check user access history table
        checkTable("access_history", dbmd, initTables, DatabaseTables.CREATE_USERS_ACCESS_HISTORY_TABLE_SQL);

        //check customers table
        checkTable("customers", dbmd, initTables, DatabaseTables.CREATE_CUSTOMERS_TABLE_SQL);

        //check inventory table
        checkTable("inventory", dbmd, initTables, DatabaseTables.CREATE_INVENTORY_TABLE_SQL);

        //check sold_motorcycles table
        checkTable("sold_motorcycles", dbmd, initTables, DatabaseTables.CREATE_SOLD_MOTORCYCLES_TABLE_SQL);

        //check purchases table
        checkTable("purchases", dbmd, initTables, DatabaseTables.CREATE_PURCHASES_TABLE_SQL);

        //check payments table
        checkTable("payments", dbmd, initTables, DatabaseTables.CREATE_PAYMENTS_TABLE_SQL);

        return connection;
    }//end initDB
    
    //this function checks the status of all the tables
    public boolean checkAllTablesStatus() throws ClassNotFoundException, SQLException{
        boolean checkOK = true;
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(JDBC_URL);

        Statement checkTables = connection.createStatement();
        DatabaseMetaData dbmd = connection.getMetaData();
        
        //contains all the tables names
        String[] tableName = {"users", "access_history", "customers", "motorcycles", "inventory",
                                            "sold_motorcycles", "purchases", "payments"};
        
        //loop through all the tables
        for(String s: tableName){
            ResultSet rs = dbmd.getTables(null, null, s.toUpperCase() , null);
            //checks the metadata
            if(rs.next()){
            checkOK = true;
            }else{

            checkOK = false;
            break;
            }
        }
        return checkOK;
    }
}
