package Logic;

import java.util.Date;

/**
 *
 * @author SJ
 */
public class Loan {
    //Attributes
    String code;
    String userCode;
    String equipmentCode;
    Date startDate;
    Date finalDate;
    String state;
    Date returnEquipment;
    int renew;
    boolean ticket;

    //Builder
    public Loan(){
    }

    //Methods
    public int getRenew(){
        return renew;
    }
    
    public void setRenew(int renew){
        this.renew=renew;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getUserCode(){
        return userCode;
    }

    public String getEquipmentCode(){
        return equipmentCode;
    }

    public Date getStartDate(){
        return startDate;
    }

    public Date getFinalDate(){
        return finalDate;
    }

    public String getState(){
        return state;
    }
    
    public boolean getTicket(){
        return ticket;
    }
    
    public void setTicket(boolean ticket){
        this.ticket=ticket;
    }
    
    public Date returnEquipment(){
        return returnEquipment;
    }

    public void setCode(String code){
    this.code=code;
    }
    
    public void setUserCode(String userCode){
        this.userCode=userCode;
    }

    public void setEquipmentCode(String equipmentCode){
        this.equipmentCode=equipmentCode;
    }

    public void setStartDate(Date startDate){
        this.startDate=startDate;
    }

    public void setFinalDate(Date finalDate){
        this.finalDate=finalDate;
    }

    public void setState(String state){
        this.state=state;
    }
    
    public void setReturnEquipment(Date returnEquipment){
        this.returnEquipment=returnEquipment;
    }
}
