    /*
This class defines the SQL to create and modify tables
 */
package database;

public class DatabaseTables {
    
    //DEFINES THE TABLES FOR THIS DATABASE
    //creates the users table
    /*
    The users table contains the system users details.
    User ID is automatically generated and a username and password length is defined
    The role defines user permissions and level of access
    */
    public static final String CREATE_USERS_TABLE_SQL = "create table users ( "
                                                      + "UserID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                      + "Username VARCHAR(10) NOT NULL UNIQUE,"
                                                      + "Password VARCHAR(15) NOT NULL, "
                                                      + "Role VARCHAR(20) NOT NULL, "
                                                      + "PRIMARY KEY (UserID))";
    
    public static final String ADD_DEFAULT_VALUES_TO_USERS_TABLE_SQL = "INSERT INTO users (Username, Password, Role) VALUES("
                                                                     + "'admin','admin123','Administrator')";
    
    //this table contains the access history
    public static final String CREATE_USERS_ACCESS_HISTORY_TABLE_SQL = "CREATE TABLE access_history ("
                                                                     + "AccessID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                                                     + "UserID INTEGER NOT NULL,"
                                                                     + "AccessTime TIMESTAMP,"
                                                                     + "PRIMARY KEY (AccessID),"
                                                                     + "FOREIGN KEY (UserID) REFERENCES users(UserID))";
    //create the Customers Table
    /*
    The customers table contains details about the customers.
    */
    public static final String CREATE_CUSTOMERS_TABLE_SQL = "CREATE TABLE customers ("
                                                          + "CustomerID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                                          + "FirstName VARCHAR(50) NOT NULL,"
                                                          + "LastName VARCHAR(50) NOT NULL,"
                                                          + "NID VARCHAR(50) NOT NULL UNIQUE,"
                                                          + "PermanentAddress VARCHAR(60) NOT NULL,"
                                                          + "CurrentAddress VARCHAR(20) NOT NULL,"
                                                          + "ContactNumber BIGINT NOT NULL,"
                                                          + "BankAccount BIGINT NOT NULL,"
                                                          + "PRIMARY KEY (CustomerID))";
    
    //create table inventory
    /*
    This table creates an inventory with quantity and prices
    */
    public static final String CREATE_INVENTORY_TABLE_SQL = "CREATE TABLE inventory ("
                                                          + "InventoryID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                                          + "Brand VARCHAR(15) NOT NULL,"
                                                          + "Model VARCHAR(15) NOT NULL UNIQUE,"
                                                          + "ClutchType VARCHAR(10) NOT NULL," 
                                                          + "QuantityInStock INTEGER NOT NULL,"
                                                          + "Price INTEGER NOT NULL,"
                                                          + "PRIMARY KEY (InventoryID))";
    //create sold motorcycles
    /*
    This table contains details of motorcycles sold such as date of purchase, if installment etc.
    The table forms a history of motorcycles sold. 
    */
    public static final String CREATE_SOLD_MOTORCYCLES_TABLE_SQL = "CREATE TABLE sold_motorcycles ("
                                                                 + "SoldID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                                                 + "Brand VARCHAR(15) NOT NULL,"
                                                                 + "Model VARCHAR(15) NOT NULL,"
                                                                 + "ClutchType VARCHAR(10) NOT NULL,"
                                                                 + "BoardNumber VARCHAR(10) NOT NULL UNIQUE,"
                                                                 + "DateOfPurchase TIMESTAMP,"
                                                                 + "Installment VARCHAR(3),"
                                                                 + "Paid INTEGER NOT NULL,"
                                                                 + "PRIMARY KEY (SoldID))";
    //create purchase table
    /*
    This table keeps track of purchases made. links the sold motorcycles with the customer
    */
    public static final String CREATE_PURCHASES_TABLE_SQL = "CREATE TABLE purchases ("
                                                          + "PurchaseNumber INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                                          + "CustomerID INTEGER NOT NULL,"
                                                          + "SoldID INTEGER NOT NULL,"
                                                          + "PRIMARY KEY (PurchaseNumber),"
                                                          + "FOREIGN KEY (CustomerID) REFERENCES customers(CustomerID),"
                                                          + "FOREIGN KEY (SoldID) REFERENCES sold_motorcycles(SoldID))";
    //create payments table
    /*
    This table keeps tracks of payments made for installments.
    installment is completed when amount due reaches 0
    */
    public static final String CREATE_PAYMENTS_TABLE_SQL = "CREATE TABLE payments ("
                                                         + "PurchaseNumber INTEGER NOT NULL,"
                                                         + "DueDate DATE,"
                                                         + "AmountDue DECIMAL,"
                                                         + "Rate DECIMAL,"
                                                         + "NextPayment DATE,"
                                                         + "AmountPaid DECIMAL NOT NULL,"
                                                         + "PRIMARY KEY (DueDate),"
                                                         + "FOREIGN KEY (PurchaseNumber) REFERENCES purchases (PurchaseNumber))";
                                                               
}
