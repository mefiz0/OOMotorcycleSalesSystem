/*

 */
package oomotorcyclesalessystem;

import database.DatabaseConnection;
import static database.PurchaseConfirmedSQL.getCustomerID;
import static database.PurchaseConfirmedSQL.getPurchaseID;
import static database.PurchaseConfirmedSQL.getSoldID;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class Payments {
    private String idNumber;
    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }
    public String getIdNumber(){
        return idNumber;
    }
    
    private String boardNumber;
    public void setBoardNumber(String boardNumber){
        this.boardNumber = boardNumber;
    }
    public String getBoardNumber(){
        return boardNumber;
    }
    
    private BigDecimal installmentPaid = BigDecimal.ZERO;
    public void setInstallmentPaid(BigDecimal installmentPaid){
        this.installmentPaid = installmentPaid;
    }
    public BigDecimal getInstallmentPaid(){
        return installmentPaid;
    }
    
    public Date getNextPaymentDate(){  //get the nex payment date
        Calendar cal  = Calendar.getInstance();
        
        cal.add(Calendar.MONTH, 1); //add a month to the current time
        
        Date dueDate = new java.sql.Date(cal.getTime().getTime());
        
        return dueDate;
            
    }
    
    public Payments(){
        //empty
    }
    
    public Payments(String idNumber, String boardNumber, BigDecimal installmentPaid){
        this.idNumber = idNumber;
        this.boardNumber = boardNumber;
        this.installmentPaid = installmentPaid;
    }
    
    //get the purchase number
    public int getPurchaseIDNum() throws ClassNotFoundException, SQLException{
        int customerID = getCustomerID(this.idNumber);
        int soldID = getSoldID(this.boardNumber);
        
        return getPurchaseID(customerID, soldID);
    }
    
    //update the payments
    public void updatePayments() throws ClassNotFoundException, SQLException{
        int purchaseID = getPurchaseIDNum();
        
        //define the queries
        String getAmountDue = "SELECT AmountDue FROM payments WHERE PurchaseNumber = "+ purchaseID;
        String getAmountPaid = "SELECT AmountPaid FROM payments WHERE PurchaseNumber = "+ purchaseID;
        
        BigDecimal amountDue = BigDecimal.ZERO;
        BigDecimal amountPaid = BigDecimal.ZERO;
        
        //create connection object
        DatabaseConnection connection = new DatabaseConnection();
        PreparedStatement statement;
        statement = connection.DatabaseConnection().prepareStatement(getAmountDue);
        ResultSet rs;
        
        //get the result for amountDue
        rs = statement.executeQuery();
        if(rs.next()){
            amountDue = rs.getBigDecimal("AmountDue");
        }
        rs.close();
        statement.close();
        connection.DatabaseConnection().close();
        
        //get the results for amountPaid
        statement = connection.DatabaseConnection().prepareStatement(getAmountPaid);
        rs = statement.executeQuery();
        if(rs.next()){
            amountPaid = rs.getBigDecimal("AmountPaid");
        }
        rs.close();
        statement.close();
        connection.DatabaseConnection().close();
        
        if((this.installmentPaid.add(amountPaid)).equals(amountDue)){ //if the remaining amount is paid
            String updateInstallment = "UPDATE payments SET DueDate = NULL, AmountDue = 0, NextPayment = 0,"
                                     + "AmountPaid = " + amountPaid + " WHERE PurchaseNumber = " + purchaseID;
            
            statement = connection.DatabaseConnection().prepareStatement(updateInstallment);
            statement.execute();
            
            statement.close();
            connection.DatabaseConnection().close();
            
        }else if(!((this.installmentPaid.add(amountPaid))).equals(amountDue)){ //if there is still payments to be made
            
            Date nextPaymentDate = getNextPaymentDate();
            
            amountDue = amountDue.subtract(this.installmentPaid);
            amountPaid = amountPaid.add(this.installmentPaid);
            
            String updateInstallment = "UPDATE payments SET AmountDue = " + amountDue +", "
                                     + "NextPayment = '" + nextPaymentDate + "', "
                                     + "AmountPaid = " + amountPaid + " WHERE PurchaseNumber = " + purchaseID;
            
            statement = connection.DatabaseConnection().prepareStatement(updateInstallment);
            statement.execute();
            
            statement.close();
            connection.DatabaseConnection().close();
        }//end if
        
        
    }//end updatePayments();
}
