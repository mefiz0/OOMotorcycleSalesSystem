/*
This class defines the SQL to create and modify tables
to allow for easier maintenance of code and a cleaner structure 
 */
package oomotorcyclesalessystem;

public class DatabaseTables {
    
    //DEFINES THE TABLES FOR THIS DATABASE
    //creates the users table
    /*
    The users table contains the system users details.
    User ID is automatically generated and a username and password length is defined
    The role defines user permissions and level of access
    */
    public static final String CREATE_USERS_TABLE_SQL = "create table users ( "
                                                      + "UserID INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                                                      + "Username VARCHAR(10) NOT NULL WITH DEFAULT 'admin', "
                                                      + "Password VARCHAR(15) NOT NULL WITH DEFAULT 'admin123', "
                                                      + "Role VARCHAR(10) NOT NULL WITH DEFAULT 'administrator', "
                                                      + "PRIMARY KEY (UserID))";
    
    //this table contains the access history
    public static final String CREATE_USERS_ACCESS_HISTORY_TABLE_SQL = "CREATE TABLE accesshistory ("
                                                                     + "AccessID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,"
                                                                     + "UserID INTEGER NOT NULL,"
                                                                     + "AccessDateTime TIMESTAMP,"
                                                                     + "PRIMARY KEY (AccessID),"
                                                                     + "FOREIGN KEY (UserID) REFERENCES users(UserID))";
    //create the Customers Table
    /*
    The customers table contains details about the customers.
    */
    public static final String CREATE_CUSTOMERS_TABLE_SQL = "CREATE TABLE customers ("
                                                          + "CustomerID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,"
                                                          + "FirstName VARCHAR(30) NOT NULL,"
                                                          + "LastName VARCHAR(30) NOT NULL,"
                                                          + "NIDorPassport VARCHAR(20) NOT NULL,"
                                                          + "CurrentAddress VARCHAR(20) NOT NULL,"
                                                          + "ContactNumber INTEGER NOT NULL,"
                                                          + "BankAccount INTEGER NOT NULL,"
                                                          + "MotorcyclesBought INTEGER,"
                                                          + "PRIMARY KEY (CustomerID))";
    //create the motorcycles table
    /*
    This table contains details specific to a motorcycle
    */
    public static final String CREATE_MOTORCYCLES_TABLE_SQL = "CREATE TABLE motorcycles ("
                                                           + "MotorcycleID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,"
                                                           + "Brand VARCHAR(15) NOT NULL,"
                                                           + "Model VARCHAR(15) NOT NULL,"
                                                           + "PRIMARY KEY (MotorcycleID))";
    //create table inventory
    /*
    This table creates an inventory with quantity and prices
    */
    public static final String CREATE_INVENTORY_TABLE_SQL = "CREATE TABLE inventory ("
                                                          + "InventoryID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,"
                                                          + "MotorcycleID INTEGER NOT NULL,"
                                                          + "QuantityInStock INTEGER NOT NULL,"
                                                          + "Price INTEGER NOT NULL,"
                                                          + "PRIMARY KEY (InventoryID),"
                                                          + "FOREIGN KEY (MotorcycleID) REFERENCES motorcycles(MotorcycleID))";
    //create sold motorcycles
    /*
    This table contains details of motorcycles sold such as date of purchase, if installment etc.
    The table forms a history of motorcycles sold.
    */
    public static final String CREATE_SOLD_MOTORCYCLES_TABLE_SQL = "CREATE TABLE sold_motorcycles ("
                                                                 + "SoldID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,"
                                                                 + "MotorcycleID INTEGER NOT NULL,"
                                                                 + "BoardNumber VARCHAR(10) NOT NULL,"
                                                                 + "DateOfPurchase TIMESTAMP,"
                                                                 + "Installment BOOLEAN NOT NULL,"
                                                                 + "InstallmentDuration INTEGER,"
                                                                 + "MarkUp INTEGER,"
                                                                 + "PaymentInProgress BOOLEAN,"
                                                                 + "AmountPayed INTEGER,"
                                                                 + "PRIMARY KEY (SoldID))";
    //create purchase table
    /*
    This table keeps track of purchases made. links the sold motorcycles with the customer
    */
    public static final String CREATE_PURCHASES_TABLE_SQL = "CREATE TABLE purchases ("
                                                          + "PurchaseNumber INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,"
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
                                                         + "DueDate DATE NOT NULL,"
                                                         + "AmountDue DECIMAL,"
                                                         + "AmountPaid DECIMAL NOT NULL,"
                                                         + "PRIMARY KEY (DueDate),"
                                                         + "FOREIGN KEY (PurchaseNumber) REFERENCES purchases (PurchaseNumber))";
    
    
    
                                                                
}
