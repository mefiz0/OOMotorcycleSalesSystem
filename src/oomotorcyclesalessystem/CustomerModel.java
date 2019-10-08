
package oomotorcyclesalessystem;

public class CustomerModel {
    
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

}
