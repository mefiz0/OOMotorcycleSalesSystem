/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author sath
 */
public class UpdateUISQL {
    
    public static final String VIEW_INVENTORY_TABLE_SQL = "SELECT inventory.InventoryID,"
                                                        + "motorcycles.Brand,"
                                                        + "motorcycles.Model,"
                                                        + "inventory.QuantityInStock,"
                                                        + "inventory.Price"
                                                        + " FROM inventory"
                                                        + " JOIN motorcycles "
                                                        + " ON inventory.MotorcycleID = motorcycles.MotorcycleID";
    
    public static final String VIEW_CUSTOMERS_TABLE_SQL = "SELECT * FROM customers";
    
    public static final String VIEW_USERS_TABLE_SQL = "SELECT * FROM users";
    
    public static final String VIEW_SALES_HISTORY_TABLE_SQL = "SELECT purchases.PurchaseNumber,"
                                                            + "customers.FirstName,"
                                                            + "customers.LastName,"
                                                            + "customers.NID,"
                                                            + "motorcycles.Brand,"
                                                            + "motorcycles.Model,"
                                                            + "sold_motorcycles.BoardNumber,"
                                                            + "sold_motorcycles.Installment,"
                                                            + "sold_motorcycles.AmountPaid"
                                                            + " FROM purchases"
                                                            + " LEFT JOIN customers"
                                                            + " ON purchases.CustomerID = customers.CustomerID"
                                                            + " LEFT JOIN sold_motorcycles"
                                                            + " ON purchases.SoldID = sold_motorcycles.SoldID"
                                                            + " LEFT JOIN motorcycles"
                                                            + " ON sold_motorcycles.MotorcycleID = motorcycles.MotorcycleID";
    
    public static final String VIEW_INSTALLMENTS_TABLE_SQL = "SELECT payments.PurchaseNumber,"
                                                           + "payments.DueDate,"
                                                           + "customers.FirstName,"
                                                           + "customers.NID,"
                                                           + "motorcycles.Brand,"
                                                           + "motorcycles.Model,"
                                                           + "payments.AmountDue,"
                                                           + "payments.AmountPaid"
                                                           + " FROM payments"
                                                           + " JOIN purchases"
                                                           + " ON payments.PurchaseNumber = purchases.PurchaseNumber"
                                                           + " JOIN customers"
                                                           + " ON purchases.CustomerID = customers.CustomerID"
                                                           + " JOIN motorcycles"
                                                           + " ON payments.MotorcycleID = motorcycles.MotorcycleID";
    
    public static final String INSERT_BRAND_TO_COMBO_BOX = "SELECT Brand FROM motorcycles";
    
    public static final String INSERT_MODEL_TO_COMBO_BOX = "SELECT Model FROM motorcycles WHERE Brand = '"; //concat the brand name in the insert function
    
}
