
package oomotorcyclesalessystem;

import java.sql.Timestamp;

public class SoldMotorcycle extends Motorcycle{
    
    private String boardNumber;
    public void setBoardNumber(String boardNumber){
        this.boardNumber = boardNumber;
    }
    public String getBoardNumber(){
       return boardNumber;
    }
    
    private Timestamp dateOfPurchase; //creates a timestamp object
    
    private boolean installment;
    public void setInstallment(boolean installment){ //setter
        this.installment = installment;
    }
    public boolean getInstallment(){ //getter
        return installment;
    }
    
    private int installmentDuration;
    public void setInstallmentDuration(int installmentDuration){ //setter
        this.installmentDuration = installmentDuration;
    }
    public int getInstallmentDuration(){ //getter
        return installmentDuration;
    }
    
    //do the rest. moved to finish the inventory motorcycle
    public SoldMotorcycle(String Brand, String model) {
        super(Brand, model);
    }
    
}
