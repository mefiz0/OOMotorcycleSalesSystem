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
                                                        + "inventory.Brand,"
                                                        + "inventory.Model,"
                                                        + "inventory.QuantityInStock,"
                                                        + "inventory.Price"
                                                        + " FROM inventory";
    
    public static final String VIEW_CUSTOMERS_TABLE_SQL = "SELECT * FROM customers";
    
    public static final String VIEW_USERS_TABLE_SQL = "SELECT userID,"
                                                    + "Username,"
                                                    + "Role FROM users";
    
    public static final String VIEW_USERS_ACCESS_HISTORY_TABLE_SQL = "SELECT access_history.AccessID,"
                                                                   + "users.Username,"
                                                                   + "users.Role"
                                                                   + " FROM access_history"
                                                                   + " LEFT JOIN users"
                                                                   + " ON access_history.UserID = users.UserID";
    
    public static final String VIEW_SALES_HISTORY_TABLE_SQL = "SELECT purchases.PurchaseNumber,"
                                                            + "customers.FirstName,"
                                                            + "customers.LastName,"
                                                            + "customers.NID,"
                                                            + "sold_motorcycles.Brand,"
                                                            + "sold_motorcycles.Model,"
                                                            + "sold_motorcycles.BoardNumber,"
                                                            + "sold_motorcycles.Installment,"
                                                            + "sold_motorcycles.Paid"
                                                            + " FROM purchases"
                                                            + " LEFT JOIN customers"
                                                            + " ON purchases.CustomerID = customers.CustomerID"
                                                            + " LEFT JOIN sold_motorcycles"
                                                            + " ON purchases.SoldID = sold_motorcycles.SoldID";
    
    public static final String VIEW_INSTALLMENTS_TABLE_SQL = "SELECT payments.PurchaseNumber,"
                                                           + "customers.FirstName,"
                                                           + "customers.NID,"
                                                           + "sold_motorcycles.Brand,"
                                                           + "sold_motorcycles.Model,"
                                                           + "sold_motorcycles.BoardNumber,"
                                                           + "payments.AmountDue,"
                                                           + "payments.DueDate,"
                                                           + "payments.AmountPaid,"
                                                           + "payments.NextPayment"
                                                           + " FROM payments"
                                                           + " LEFT JOIN purchases"
                                                           + " ON payments.PurchaseNumber = purchases.PurchaseNumber"
                                                           + " LEFT JOIN customers"
                                                           + " ON purchases.CustomerID = customers.CustomerID"
                                                           + " LEFT JOIN sold_motorcycles"
                                                           + " ON purchases.SoldID = sold_motorcycles.SoldID";
    
    public static final String INSERT_BRAND_TO_COMBO_BOX = "SELECT Brand FROM inventory";
    
    public static final String INSERT_MODEL_TO_COMBO_BOX = "SELECT Model FROM inventory WHERE Brand = '"; //concat the brand name in the insert function
    
    public static final String INSERT_USER_TO_COMBO_BOX = "SELECT Username FROM users";
    
}
