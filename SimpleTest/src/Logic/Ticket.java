package Logic;
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SJ
 */
public class Ticket {
    private String code;
    private String userCode;
    private String serialNumber;
    private Date ticketDate;
    private String tipoMulta;
    private String description;
    private String state;
    private int costoMulta;
    
    public Ticket(){
        
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
    
    public Date getTicketDate(){
        return ticketDate;
    }
    
    public String getTipoMulta(){
        return tipoMulta;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getState(){
        return state;
    }
    
    public int getCostoMulta(){
        return costoMulta;
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
    
    public void setTicketDate(Date ticketDate){
        this.ticketDate=ticketDate;
    }
    
    public void setTipoMulta(String tipoMulta){
        this.tipoMulta=tipoMulta;
    }
    
    public void setDescription(String description){
        this.description=description;
    }
    
    public void setState(String state){
        this.state=state;
    }
    
    public void setCostoMulta(int costoMulta){
        this.costoMulta=costoMulta;
    }
}
