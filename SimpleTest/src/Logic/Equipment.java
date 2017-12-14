/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Diego
 */
public class Equipment {
    
    String numberEquipment;
    String nameEquipment;
    String serieEquipment;
    String descriptionEquipment;
    String stateEquipment;
    
 public Equipment(){}   
 
 
public String getNumberEquipment(){
     return numberEquipment;
 }
 
public String getNameEquipment(){
     return nameEquipment;
 }

public String getSerieEquipment(){
     return serieEquipment;
 }

public String getDescriptionEquipment(){
     return descriptionEquipment;
 }

public String getStateEquipment(){
     return stateEquipment;
 }

////////////////////////////////////////////////////////////

public void setNumberEquipment(String numberEquipment){
     this.numberEquipment=numberEquipment;
 }

public void setNameEquipment(String nameEquipment){
     this.nameEquipment=nameEquipment;
 }

public void setSerieEquipment(String serieEquipment){
     this.serieEquipment=serieEquipment;
 }

public void setDescriptionEquipment(String descriptionEquipment){
     this.descriptionEquipment=descriptionEquipment;
 }

public void setStateEquipment(String stateEquipment){
     this.stateEquipment=stateEquipment;
 }

}
