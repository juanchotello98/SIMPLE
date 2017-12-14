/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Date;

/**
 *
 * @author SJ
 */
public class Reserve {
    private String code;
    private String userCode;
    private String serialNumber;
    private Date startDate;
    private Date finalDate;
    private Date loanDate;
    private String state;
    boolean ticket;
    
    public Reserve(){
        
    }
   
    public String getCode(){
        return code;
    }
    
    public String getUserCode(){
        return userCode;
    }
    
    public String getSerialNumber(){
        return serialNumber;
    }
    
    public Date getStartDate(){
        return startDate;
    }
    
    public Date getFinalDate(){
        return finalDate;
    }
    
    public Date getLoanDate(){
        return loanDate;
    }
    
    public String getState(){
        return state;
    }
    
    public void setCode(String code){
        this.code=code;
    }
    
    public void setUserCode(String userCode){
        this.userCode=userCode;
    }
    
    public void setSerialNumber(String serialNumber){
        this.serialNumber=serialNumber;
    }
    
    public void setStartDate(Date startDate){
        this.startDate=startDate;
    }
    
    public void setFinalDate(Date finalDate){
        this.finalDate=finalDate;
    }
    
    public void setLoanDate(Date loanDate){
        this.loanDate=loanDate;
    }
    
    public void setState(String state){
        this.state=state;
    }
    
    public boolean getTicket(){
        return ticket;
    }
    
    public void setTicket(boolean ticket){
        this.ticket=ticket;
    }
}

