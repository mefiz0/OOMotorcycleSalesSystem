
package database;

import static database.CustomerFormAutoComplete.checkCustomerExists;
import java.sql.SQLException;

public class CustomerUpdateDB {
    
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
        
        if(checkCustomerExists(identityNumber) == 0){
            String insertToCustomer = "INSERT INTO customers "
                                    + "(FirstName, LastName, NID, PermanentAddress, CurrentAddress, ContactNumber, BankAccount) "
                                    + "VALUES "
                                    + "('" + firstName + "', "
                                    + "'" + lastName + "', "
                                    + "'" + identityNumber + "', "
                                    + "'" + permanentAddress + "', "
                                    + "'" + currentAddress + "', "
                                    + "'" + contactNumber + "', "
                                    + "'" + bankAccountNum + "') ";
        }//end if
    }//end 
}
