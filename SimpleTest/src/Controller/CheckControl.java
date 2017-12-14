/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccess.CheckDAO;
import Logic.Loan;
import Logic.Reserve;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author SJ
 */
public class CheckControl {
    CheckDAO checkDAO;
    
    public CheckControl(){
        checkDAO = new CheckDAO();
    }
    
    public void checkLoans(){
        ArrayList <Loan> loans = new ArrayList <>();
        loans = checkDAO.getLoans();
        for(int i = 0; i<loans.size(); i++){
            checkLoan(loans.get(i));
        }
    }
    
    public void checkLoan(Loan loan){
        Calendar actualDate = Calendar.getInstance();
        Calendar loanDate = Calendar.getInstance();
        actualDate.setTime(new Date());
        loanDate.setTime(loan.getFinalDate());
        if(actualDate.compareTo(loanDate)==1){
            checkDAO.makeTicket(loan);
            checkDAO.changeTicketLoan(loan);
        }
    }
    
    public void checkAvailableReserves(){
        ArrayList <Reserve> reserves = new ArrayList <>();
        reserves = checkDAO.getAvailablesReserves();
        for(int i = 0; i<reserves.size(); i++){
            checkAvailableReserve(reserves.get(i));
        }
    }
    
    public void checkAvailableReserve(Reserve reserve){
        Calendar actualDate = Calendar.getInstance();
        Calendar reserveDate = Calendar.getInstance();
        actualDate.setTime(new Date());
        reserveDate.setTime(reserve.getFinalDate());
        if(actualDate.compareTo(reserveDate)==1){
            checkDAO.makeTicketReserve(reserve);
            checkDAO.changeTicketReserve(reserve);
        }
    }
}
