/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author SJ
 */
public class Loan {
    //Attributes
    String userCode;
    String equipmentCode;
    String startDate;
    String finalDate;
    String state;

    //Builder
    public Loan(){
    }

    //Methods
    public String getUserCode(){
        return userCode;
    }

    public String getEquipmentCode(){
        return equipmentCode;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getFinalDate(){
        return finalDate;
    }

    public String getState(){
        return state;
    }

    public void setUserCode(String userCode){
        this.userCode=userCode;
    }

    public void setEquipmentCode(String equipmentCode){
        this.equipmentCode=equipmentCode;
    }

    public void setStartDate(String startDate){
        this.startDate=startDate;
    }

    public void setFinalDate(String finalDate){
        this.finalDate=finalDate;
    }

    public void setState(String state){
        this.state=state;
    }
}
