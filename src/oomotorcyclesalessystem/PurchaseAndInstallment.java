/*
 */
package oomotorcyclesalessystem;

import static database.PurchaseConfirmedSQL.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

public class PurchaseAndInstallment {
    
        public BigDecimal rate = new BigDecimal(1.75).setScale(2, RoundingMode.HALF_UP); //define rate
        
        public Date getDueDate(int installmentPeriod){ //get the dueDate for the installment
        Calendar cal  = Calendar.getInstance();
        
        cal.add(Calendar.MONTH, installmentPeriod);
        
        Date dueDate = new java.sql.Date(cal.getTime().getTime());
        
        return dueDate;
        }
        
        public Date getNextPaymentDate(){  //get the nex payment date
            Calendar cal  = Calendar.getInstance();
        
            cal.add(Calendar.MONTH, 1); //add a month to the current time
        
            Date dueDate = new java.sql.Date(cal.getTime().getTime());
        
            return dueDate;
            
        }
        
        //get update the purchasesTable
        public void updatePurchaseTable(String boardNumber, String idNumber) throws ClassNotFoundException, SQLException{
            //get the ids
            int customerID = getCustomerID(idNumber);
            int soldID = getSoldID(boardNumber);
            
            updatePurchasesTableSQL(customerID, soldID);
        }
        
        //calculate the total for the installment duration
        public BigDecimal calculateTotalInstallment(int price, int months, int downPayment){
            //convert the price integer to a big decimal for monetary calculations
            BigDecimal initialPrice = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
            BigDecimal downPaymentBigDecimal = new BigDecimal(downPayment);
            //divide the month by 100 for use in calculations
            float monthsDividedByHundred = months / 100;
            BigDecimal numOfMonths = new BigDecimal(monthsDividedByHundred).setScale(2, RoundingMode.HALF_UP);
            
            /*
            The formula for calculating the total installment is 
            (price * rate) + (price * (months / 100)) - (downpayment + (downpayment - 2000))
            which brings it to a reasonable level.
            */
            
            //step 1. get the price * rate
            BigDecimal firstStep = initialPrice.multiply(rate).setScale(2, RoundingMode.HALF_UP);
            
            //step 2 - get price * months/100
            BigDecimal secondStep = initialPrice.multiply(numOfMonths).setScale(2, RoundingMode.HALF_UP);
            
            //step 3 - get downPayment + downpayment - 2000
            BigDecimal thirdStep = downPaymentBigDecimal.add((downPaymentBigDecimal.subtract(new BigDecimal(2000)))).setScale(2, RoundingMode.HALF_UP);
            
            //step 4 - get total Installment
            BigDecimal totalInstallment = ((firstStep.add(secondStep)).subtract(thirdStep)).setScale(2, RoundingMode.HALF_UP);
            
            return totalInstallment;  
        }
        
        //calculate how much has to be paid each month
        public BigDecimal calculateMonthlyInstallment(BigDecimal totalInstallment, int months){
            //convert month to a bigDecimal
            BigDecimal numOfMonths = new BigDecimal(months);
            
            BigDecimal monthlyInstallment = totalInstallment.divide(numOfMonths, 2, RoundingMode.HALF_UP);
            
            return monthlyInstallment;
        }
        
        public void updateInstallmentsTable(String boardNumber, String idNumber, int installmentPeriod,
                                            int price, int downPayment) throws SQLException, ClassNotFoundException{
            
            //get the purchase id
            int customerID = getCustomerID(idNumber);
            int soldID = getSoldID(boardNumber);
            int purchaseID = getPurchaseID(customerID, soldID);
            
            //get the due date
            Date dueDate = getDueDate(installmentPeriod);
            //get the next payment date
            Date nextPayment = getNextPaymentDate();
            
            //get the total amount due
            BigDecimal amountDue = calculateTotalInstallment(price, installmentPeriod, downPayment);
            //get the monthly amount to be paid
            BigDecimal rate = calculateMonthlyInstallment(amountDue, installmentPeriod);
            //convert the down payment to a big decimal
            BigDecimal amountPayed = new BigDecimal(downPayment).setScale(2, RoundingMode.HALF_UP);
            
            //update the installments table
            updateInstallmentsSQL(purchaseID, dueDate, amountDue, rate, nextPayment, amountPayed);
        }
}
