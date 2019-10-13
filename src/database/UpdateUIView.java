/*
This class contains various methods to update the tables in the ui
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sath
 */
public class UpdateUIView {
    
    //update the view of tables
    public static void updateTableView(JTable tableName, String sqlQuery) throws ClassNotFoundException, SQLException{
        DatabaseConnection connection = new DatabaseConnection(); //create connection object
        connection.DatabaseConnection(); //connect to the database
        
        PreparedStatement ps = connection.DatabaseConnection().prepareStatement(sqlQuery); 
        ResultSet rs = ps.executeQuery();
        tableName.setModel(DbUtils.resultSetToTableModel(rs)); //set the table model using the methods from rs2xml library
        rs.close();
        ps.close();
        connection.DatabaseConnection().close();
        
        tableName.setAutoCreateRowSorter(true); //creates a row sorter
    }
    
    //update the view of comboboxes
    public static void updateComboBoxView(JComboBox comboBox, String sqlQuery, String columnName) throws ClassNotFoundException, SQLException{
        DatabaseConnection connection = new DatabaseConnection(); //create the connection object
        connection.DatabaseConnection(); //connect to the database
        
        PreparedStatement ps = connection.DatabaseConnection().prepareStatement(sqlQuery); //prepare the sql statement
        
        ResultSet rs = ps.executeQuery(); //get the result set
        
        comboBox.removeAllItems(); //remove all the items from j combo box
        
        /*
        enter the data into the jcombobox
        */
        while(rs.next()){
            String columnData = rs.getString(columnName); //get the  current model
            
            if(columnData.equals("admin") == false){ //if there is no admin, the rest is carried out. this prevents admin from being
                                       //being seen and deleted, and doesn't impact the other combo boxes
            comboBox.setSelectedIndex(-1); //set the selected index to -1. this allows us to use the next function
            comboBox.setSelectedItem(columnData); //try and select the data we want to add
            }
            /*
            if the data is not there the selected index will be at -1. in that case we will add to the jcombobox
            otherwise we just move on
            */
            if(comboBox.getSelectedIndex() == -1){
                comboBox.addItem(columnData);
            }
        }//end while
        
        rs.close();
        ps.close();
        
        connection.DatabaseConnection().close();
    }//end uppdateComboBoxView
    
    //update the view of combo boxes based on the view of another combo box
    public static void updateComboBoxView(JComboBox comboBoxOne, JComboBox comboBoxTwo, String sqlQuery,
                                          String columnName) throws ClassNotFoundException, SQLException{
        
        //get the currently selected value of the other combobox and generate a sql query based on that
        try{
            String currentlySelected = comboBoxOne.getSelectedItem().toString();
            String selectQuery = sqlQuery +  currentlySelected + "'"; //concat the strings
            //sqlQuery = "SELECT Model FROM motorcycles WHERE Brand = '"
            
            DatabaseConnection connection = new DatabaseConnection(); //create the connection object
            connection.DatabaseConnection(); //connect to the database
        
            PreparedStatement ps = connection.DatabaseConnection().prepareStatement(selectQuery);
        
            ResultSet rs = ps.executeQuery(); //get the result set
            
            comboBoxTwo.removeAllItems(); //clear the jcombobox

            while(rs.next()){
                String columnData = rs.getString(columnName);
                comboBoxTwo.addItem(columnData);
            }//end while
            
            rs.close();
            ps.close();
            connection.DatabaseConnection().close();
        }catch (Exception e){
            System.out.println("No data in the combo box!"); //if there is nothing to view, this error will be thrown
        }
    }//end updateComboBoxView
    
    //update the price jlabel
    public static String updatePriceLabel(JComboBox modelComboBox) throws ClassNotFoundException, SQLException{
        
        String currentlySelected = modelComboBox.getSelectedItem().toString();

        DatabaseConnection connection = new DatabaseConnection(); //create the connection object
        //get the price
        String selectPriceQuery = "SELECT Price FROM inventory WHERE Model = '" + currentlySelected + "'";
        PreparedStatement statement = connection.DatabaseConnection().prepareStatement(selectPriceQuery);
        String price = null; //gets the price as a string value to return to the jlabel
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            price = rs.getString("Price");
            System.out.println(rs.getString("Price"));
            break;
        }
        
        System.out.println(price);
        
        rs.close();
        statement.close();
        connection.DatabaseConnection().close();
        
        return price;
    }
}
