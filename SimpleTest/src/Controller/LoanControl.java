/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccess.LoanDAO;
import Logic.Loan;
import java.util.ArrayList;

/**
 *
 * @author SJ
 */
public class LoanControl {
    LoanDAO loanDAO;
    
    public LoanControl(){
        loanDAO = new LoanDAO();
    }
    
    public ArrayList<Object[]> listProfileLoan(String identification){
       ArrayList <Object[]> myLoans = new ArrayList <>();
         myLoans = loanDAO.listMyLoans(identification);
        
        return myLoans;
    }
    
    public ArrayList<Object[]> listLoan(){
       ArrayList <Object[]> loans = new ArrayList <>();
       loans = loanDAO.listLoan();
       return loans;
    }
    
    public void takeOutEquipment(String userCode, String serialNumber){
        
        loanDAO.takeOutEquipment(userCode, serialNumber);
    }
    
    public boolean verifyEquipment(String serialNumber){
        if(loanDAO.verifyEquipmentStatus(serialNumber).equals("Libre")){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean verifyReserve(String loanCode){
        if(loanDAO.verifyEquipmentStatus(loanCode).equals("Ocupado")){
            return true;
        }else{
            return false;
        }
    }
    
    public int verifyLoan(String code){
        if(loanDAO.verifyLoanStatus(code).equals("Activo")){
            return 0;
        } else {
            if(loanDAO.verifyLoanStatus(code).equals("Entregado")){
                return 1;
            } else {
                if(loanDAO.verifyLoanStatus(code).equals("Validado")){
                    return 2;
                } else{
                    return 3; // Cuando state sea igual a retrasado
                }
            }  
        }
    }
    
    public int renewLoan(Loan loan){
        if(loanDAO.renewLoan(loan) == 0) {
            return 0;
        } else {
            if(loanDAO.renewLoan(loan) == 1){
                return 1;
        } else {
                return 2;
                }
        }
        
    }
    
    public Loan getLoan(String loanCode){
        Loan loan = loanDAO.searchLoan(loanCode);
        return loan;
    }
    
    public Loan getLoanReserve(String serialNumber){
        Loan loan = loanDAO.searchLoanReserve(serialNumber);
        return loan;
    }
    
    public boolean reserveEquipment(String userCode, Loan loan){
        return loanDAO.reserveEquipment(userCode, loan);
    }
    
    public String getLoanFinalDate(Loan loan){
        String output="";
        output=""+loan.getFinalDate();
        return output;
    }
    
    public void returnEquipment(Loan loan){
        loanDAO.returnEquipment(loan);
    }
    
    public void validateDelivery(Loan loan){
        loanDAO.validateDelivery(loan);
    }
    
    public Loan searchProfileLoan(String inputValue,String typeSearch, String userIdentification){
        
        Loan loan = new Loan();
        
        System.out.println("Se va a Buscar un Proyecto");

        loan = loanDAO.searchProfileLoan(inputValue, typeSearch, userIdentification);
      
       return loan;       
    }
    
    public ArrayList<Object[]> listSearchProfileLoan(String inputValue, String typeSearch, String userIdentification){
    
         ArrayList <Object[]> loans = new ArrayList <>();
         loans = loanDAO.listSearchProfileLoan(inputValue, typeSearch, userIdentification);
         
         return loans;      
    }
    
    public Loan searchLoan(String inputValue,String typeSearch){
        
        Loan loan = new Loan();
        
        System.out.println("Se va a Buscar un Proyecto");

        loan = loanDAO.searchLoan(inputValue, typeSearch);
      
       return loan;       
    }
    
    public ArrayList<Object[]> listSearchLoan(String inputValue, String typeSearch){
    
         ArrayList <Object[]> loans = new ArrayList <>();
         loans = loanDAO.listSearchLoan(inputValue, typeSearch);
         
         return loans;      
    }
    
    public Loan getInfoLoan(String code){
        Loan loan = new Loan();
        
        loan = loanDAO.getInfoLoan(code);
                
        return loan;
        
    }
}
