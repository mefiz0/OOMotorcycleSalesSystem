
package oomotorcyclesalessystem;
import static database.CustomerUpdateDB.addToCustomers;
import java.sql.SQLException;
        

public class CustomerController {
    CustomerModel model = new CustomerModel();
    
    public CustomerController(){
        //empty
    }
    
    public CustomerController(String firstName, String lastName, String idNumber,
                              String permanentAddress, String currentAddress,
                              int contactNum, int bankAccountNum){
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setIdentityNumber(idNumber);
        model.setPermanentAddress(permanentAddress);
        model.setCurrentAddress(currentAddress);
        model.setContactNumber(contactNum);
        model.setBankAccountNumber(bankAccountNum);
        
    }
    
    public void updateCustomerDatabase() throws ClassNotFoundException, SQLException{
       String firstName = model.getFirstName();
       String lastName = model.getLastName();
       String idNumber = model.getIdentityNumber();
       String permanentAddress = model.getPermanentAddress();
       String currentAddress = model.getCurrentAddress();
       int ContactNumber = model.getContactNumber();
       int bankAccountNum = model.getBankAccountNumber();
       
       addToCustomers(idNumber, firstName, lastName, permanentAddress, currentAddress, ContactNumber, bankAccountNum);
    }
}
