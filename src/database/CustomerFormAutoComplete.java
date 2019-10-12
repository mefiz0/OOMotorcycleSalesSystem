/*
This class will update the database
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author sath
 */
public class CustomerFormAutoComplete {
   
   //checks if the customer exists in the database 
   public static int checkCustomerExists(String identityNumber) throws ClassNotFoundException, SQLException{
       int customerExists = 0;
       
       DatabaseConnection connection = new DatabaseConnection();
       Statement statement = connection.DatabaseConnection().createStatement();
       
       ResultSet rs = statement.executeQuery("SELECT CustomerID from customers WHERE NID='"
                                             + identityNumber +"'"); //get the user id
       if(rs.next()){
           customerExists = rs.getInt("CustomerID");
       }
       rs.close();
       statement.close();
       connection.DatabaseConnection().close();
       return customerExists;
   } 
   
   /*autocompletes the customer form if the customer exists in the database
   and prevents the user from editing them. otherwise clears out the fields and lets the user edit them.
   */
   public static void autoCompleteSalesForm(JTextField idNumField,
                                    JTextField firstNameField, JTextField lastNameField,
                                    JFormattedTextField contactNumberField,
                                    JFormattedTextField bankAccountNumField,
                                    JTextField permanentAddressField,
                                    JTextField currentAddressField) throws ClassNotFoundException, SQLException{
       
       DatabaseConnection connection = new DatabaseConnection(); //create connection object
       
       int customerID = checkCustomerExists(idNumField.getText());
       
       if(customerID != 0){
           
           Statement statement = connection.DatabaseConnection().createStatement(); //create a statement
           
           ResultSet rs = statement.executeQuery("SELECT * from customers WHERE CustomerID = " 
                        + customerID + "");
           //set the values
           while(rs.next()){
               firstNameField.setText(rs.getString("FirstName"));
               firstNameField.setEditable(false);
               lastNameField.setText(rs.getString("LastName"));
               lastNameField.setEditable(false);
               contactNumberField.setText(rs.getString("ContactNumber"));
               contactNumberField.setEditable(false);
               bankAccountNumField.setText(rs.getString("BankAccount"));
               bankAccountNumField.setEditable(false);
               permanentAddressField.setText(rs.getString("PermanentAddress"));
               permanentAddressField.setEditable(false);
               currentAddressField.setText(rs.getString("CurrentAddress"));
               currentAddressField.setEditable(false);
               break;
           } //end while
           
            rs.close();
            statement.close();
       
           //if the user doesn't exist
       } else{
           firstNameField.setText("");
               firstNameField.setEditable(true);
               lastNameField.setText("");
               lastNameField.setEditable(true);
               contactNumberField.setText("");
               contactNumberField.setEditable(true);
               bankAccountNumField.setText("");
               bankAccountNumField.setEditable(true);
               permanentAddressField.setText("");
               permanentAddressField.setEditable(true);
               currentAddressField.setText("");
               currentAddressField.setEditable(true);
       }// end if
   }
   
}
