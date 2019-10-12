
package oomotorcyclesalessystem;

import static database.PurchaseConfirmedSQL.deductFromInventory;
import static database.PurchaseConfirmedSQL.getQuantityInStock;
import static database.PurchaseConfirmedSQL.updateSoldMotorcyclesTableSQL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class SoldMotorcycle extends Motorcycle{

    private String boardNumber;
    public void setBoardNumber(String boardNumber){ //setter
        this.boardNumber = boardNumber;
    }
    public String getBoardNumber(){ //getter
        return boardNumber;
    }
    
    private int soldAmount;
    public void setSoldAmount(int soldAmount){ //setter
        this.soldAmount = soldAmount;
    }
    public int getSoldAmount(){ //getter
        return soldAmount;
    }
    
    private boolean installmentChecked;
    public void setInstallmentChecked(boolean installmentChecked){ //setter
        this.installmentChecked = installmentChecked;
    }
    public boolean getInstallmentChecked(){ //getter
        return installmentChecked;
    }
    
    private int downPayment;
    public void setDownPayment(int downPayment){ //setter
        this.downPayment = downPayment;
    }
    public int getDownPayment(){ //getter
        return downPayment;
    }
    
    private int installmentPeriod;
    public void setInstallmentPeriod(int installmentPeriod){ //setter
        this.installmentPeriod = installmentPeriod;
    }
    public int getInstallmentPeriod(){ //getter
        return installmentPeriod;
    }

    public SoldMotorcycle(String brand, String model, String boardNumber,
                          int downPayment, int installmentPeriod, boolean installmentChecked) {
        super(brand, model);
        
        this.boardNumber = boardNumber;
        this.downPayment = downPayment;
        this.installmentPeriod = installmentPeriod;
        this.installmentChecked = installmentChecked;
    }
    
    public SoldMotorcycle(String brand, String model, String boardNumber, int soldAmount, boolean installmentChecked) {
        super(brand, model);
        
        this.boardNumber = boardNumber;
        this.soldAmount = soldAmount;
        this.installmentChecked = installmentChecked;
    }
    
    //deduct from motorcycle Inventory
    public void deductMotorcycleFromInventory() throws ClassNotFoundException, SQLException{
        int quantityInStock = getQuantityInStock(this.model);
        
        deductFromInventory(this.model, quantityInStock);
    }
    
    //update the table
    public void updateSoldMotorcycleTable() throws ClassNotFoundException, SQLException{
        if(this.installmentChecked == true){
            updateSoldMotorcyclesTableSQL(this.brand, this.model, this.boardNumber, this.downPayment, this.installmentPeriod);
            
        }else if(this.installmentChecked == false){
            updateSoldMotorcyclesTableSQL(this.brand, this.model, this.boardNumber, this.soldAmount);
        }
    }
    
}
