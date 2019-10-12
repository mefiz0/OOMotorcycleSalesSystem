
package oomotorcyclesalessystem;
import static database.PurchaseConfirmedSQL.addToCustomers;
import java.sql.SQLException;
        

public class Customer {
        
    private String firstName;
    public void setFirstName(String firstName){ //setter
        this.firstName = firstName;
    }
    public String getFirstName(){ //getter
        return firstName;
    }
    
    private String lastName;
    public void setLastName(String lastName){ //setter
        this.lastName = lastName;
    }
    public String getLastName(){ //getter
        return lastName;
    }
    
    private String identityNumber;
    public void setIdentityNumber(String identityNumber){ //setter
        this.identityNumber = identityNumber;
    }
    public  String getIdentityNumber(){ //getter
        return identityNumber;
    }
    
    private int contactNumber;
    public void setContactNumber(int contactNumber){ //setter
        this.contactNumber = contactNumber;
    }
    public int getContactNumber(){
        return contactNumber;
    }
    
    private String permanentAddress;
    public void setPermanentAddress(String permanentAddress){ //setter
        this.permanentAddress = permanentAddress;
    }
    public String getPermanentAddress(){ //getter
        return permanentAddress;
    }
    
    private String currentAddress;
    public void setCurrentAddress(String currentAddress){ //setter
        this.currentAddress = currentAddress;
    }
    public String getCurrentAddress(){ //getter
        return currentAddress;
    }
    
    private int bankAccountNumber;
    public void setBankAccountNumber(int bankAccountNumber){ //setter
        this.bankAccountNumber = bankAccountNumber;
    }
    public int getBankAccountNumber(){ //getter
        return bankAccountNumber;
    }
    
    public Customer(){
        //empty
    }
    
    public Customer(String firstName, String lastName, String idNumber,
                              String permanentAddress, String currentAddress,
                              int contactNum, int bankAccountNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = idNumber;
        this.permanentAddress = permanentAddress;
        this.currentAddress = currentAddress;
        this.contactNumber = contactNum;
        this.bankAccountNumber = bankAccountNum;
        
    }
    
    public void updateCustomerDatabase() throws ClassNotFoundException, SQLException{
       String firstName = this.getFirstName();
       String lastName = this.getLastName();
       String idNumber = this.getIdentityNumber();
       String permanentAddress = this.getPermanentAddress();
       String currentAddress = this.getCurrentAddress();
       int ContactNumber = this.getContactNumber();
       int bankAccountNum = this.getBankAccountNumber();
       
       addToCustomers(idNumber, firstName, lastName, permanentAddress, currentAddress, ContactNumber, bankAccountNum);
    }
}
