/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccess.ReserveDAO;
import Logic.Reserve;
import java.util.ArrayList;

/**
 *
 * @author SJ
 */
public class ReserveControl {
    ReserveDAO reserveDAO;
    
    public ReserveControl(){
        reserveDAO = new ReserveDAO();
    }
    
    public ArrayList<Object[]> listReserves(){
       ArrayList <Object[]> reserves = new ArrayList <>();
         reserves = reserveDAO.listReserve();
        
        return reserves;
    }
    
    public ArrayList<Object[]> listProfileReserves(String userIdentification){
       ArrayList <Object[]> myReserves = new ArrayList <>();
       myReserves = reserveDAO.listProfileReserves(userIdentification); // Poner userCode member
        
        return myReserves;
    }
    
    public int verifyReserve(String code){
        if(reserveDAO.verifyReserveStatus(code).equals("Ocupada")){
            return 0;
        } else {
            if(reserveDAO.verifyReserveStatus(code).equals("Disponible")){
                return 1;
            } else {
                if(reserveDAO.verifyReserveStatus(code).equals("Terminada")){
                    return 2;
                } else{
                    if(reserveDAO.verifyReserveStatus(code).equals("Incumplida")){
                        return 3;
                    } else{
                        return 4;
                    }
                }
            }
            
        }
    }
    
    public void makeLoan(String userCode, String serialNumber){
        reserveDAO.makeLoan(userCode, serialNumber);
    }
    
    public void cancelReserve(String code){
        reserveDAO.cancelReserve(code);
    }
    
    public Reserve searchProfileReserve(String inputValue,String typeSearch, String userIdentification){
        
        Reserve reserve = new Reserve();
        
        System.out.println("Se va a Buscar un Proyecto");

        reserve = reserveDAO.searchProfileReserve(inputValue, typeSearch, userIdentification);
      
       return reserve;       
    }
    
    public ArrayList<Object[]> listSearchProfileReserve(String inputValue, String typeSearch, String userIdentification){
    
         ArrayList <Object[]> reserves = new ArrayList <>();
         reserves = reserveDAO.listSearchProfileReserve(inputValue, typeSearch, userIdentification);
         
         return reserves;      
    }
    
    public Reserve searchReserve(String inputValue,String typeSearch){
        
        Reserve reserve = new Reserve();
        
        System.out.println("Se va a Buscar un Proyecto");

        reserve = reserveDAO.searchReserve(inputValue, typeSearch);
      
       return reserve;       
    }
    
    public ArrayList<Object[]> listSearchReserve(String inputValue, String typeSearch){
    
         ArrayList <Object[]> reserves = new ArrayList <>();
         reserves = reserveDAO.listSearchReserve(inputValue, typeSearch);
         
         return reserves;      
    }
    
    public Reserve getInfoReserve(String code){
        Reserve reserve = new Reserve();
        
        reserve = reserveDAO.getInfoReserve(code);
                
        return reserve;
        
    }
}
