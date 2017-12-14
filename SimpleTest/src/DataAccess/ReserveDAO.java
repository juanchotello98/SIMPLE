/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Logic.Reserve;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SJ
 */
public class ReserveDAO {
    Conection conection;
    LoanDAO loanDAO;
    
    public ReserveDAO(){
        conection = new Conection();
        loanDAO = new LoanDAO();
    }
    
    public ArrayList listReserve(){
       ArrayList <Object[]> reserves = new ArrayList <>();
            String sql_search;
            sql_search="SELECT reserve.code, member.firstname||' '||member.lastName, equipment.name, reserve.startDate, reserve.finalDate, reserve.loanDate, reserve.state\n" +
                   "FROM reserve, equipment, member\n" +
                   "WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode = member.identification";    


            try{
                Connection conn= conection.connect();
                System.out.println("consultando en la bd10");
                Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql_search);

                while(tabla.next()){

                   Object[] objectRow = new Object[7];

                   for(int i=0; i<7; i++){

                       objectRow[i]=tabla.getObject(i+1);  
                   }

                   reserves.add(objectRow);
                }

             }
             catch(SQLException e){ 
                             System.out.println(e); 
                             }
             catch(Exception e){
                              System.out.println(e); 
                              }
        //---------------------------------------------------------------
       
        return reserves;
   }
    
    public ArrayList listProfileReserves(String userCode){
       ArrayList <Object[]> myReserves = new ArrayList <>();
            String sql_search;
         
            sql_search="SELECT reserve.code, equipment.name, startDate, finalDate, loanDate, reserve.state FROM reserve, equipment WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode='"+userCode+"'";
            
            try{
                Connection conn= conection.connect();
                System.out.println("consultando en la bd");
                Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql_search);

                while(tabla.next()){

                   Object[] objectRow = new Object[6];

                   for(int i=0; i<6; i++){

                       objectRow[i]=tabla.getObject(i+1);  
                   }

                   myReserves.add(objectRow);
                }

             }
             catch(SQLException e){ 
                             System.out.println(e); 
                             }
             catch(Exception e){
                              System.out.println(e); 
                              }
        return myReserves;
   }
    
    public String verifyReserveStatus(String code){
        String sql_select;
        String state = null;
        sql_select="SELECT state FROM reserve WHERE code = '"+code+"';";

        try{
            Connection conn = conection.connect();
            //System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               state = tabla.getString(1);               
            }
         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        
        return state;
   }
    
    public void makeLoan(String userCode, String serialNumber){
        loanDAO.takeOutEquipment(userCode, serialNumber);
    }
    
    public void cancelReserve(String code){
        String sql_select;
        sql_select="UPDATE reserve SET state ='Cancelada' WHERE code = '"+code+"';";
        try{
        Connection conn= conection.connect();
        System.out.println("Update in the bd3");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    }
    
    public void loanDate(String code){
        String sql_select;
        sql_select="UPDATE reserve SET loandate ='"+loanDAO.getCurrentLoanDate()+"' WHERE code = '"+code+"';";
        try{
        Connection conn= conection.connect();
        System.out.println("Update in the bd3");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    }
    
    public Reserve searchProfileReserve(String inputValue, String typeSearch, String userIdentification){
        Reserve reserve = new Reserve();
        String sql_search;
        
       if(typeSearch.equals("name")){
           
        sql_search="SELECT reserve.code FROM reserve, equipment WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode='"+userIdentification+"' and equipment.name ilike '%"+inputValue+"%'";
       } 
        
       else{sql_search="SELECT reserve.code FROM reserve, equipment WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode='"+userIdentification+"' and reserve."+typeSearch+" ilike '%"+inputValue+"%'";
           }
          
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
         
            
            while(tabla.next()){
                
               reserve.setCode(tabla.getString(1));
              
              System.out.println("ok");
            }  
             System.out.println(reserve.getCode());
             return reserve;
         }
         //fin Buscar
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return null;
    }
    
    public ArrayList <Object[]> listSearchProfileReserve(String inputValue, String typeSearch, String userIdentification){
        
        ArrayList <Object[]> reserves = new ArrayList <>();
        String sql_search;
        
       if(typeSearch.equals("name")){
           
           sql_search="SELECT reserve.code, equipment.name, startDate, finalDate, loanDate, reserve.state FROM reserve, equipment WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode='"+userIdentification+"' and equipment.name ilike '%"+inputValue+"%'";
       } 
        
       else{sql_search="SELECT reserve.code, equipment.name, startDate, finalDate, loanDate, reserve.state FROM reserve, equipment WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode='"+userIdentification+"' and reserve."+typeSearch+" ilike '%"+inputValue+"%'";
           }
        
        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);

            while(tabla.next()){

               Object[] objectRow = new Object[6];
               
               for(int i=0; i<6; i++){
                   
                   objectRow[i]=tabla.getObject(i+1);  
               }
               reserves.add(objectRow);
            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return reserves;
   }
    
    public Reserve searchReserve(String inputValue, String typeSearch){
        Reserve reserve = new Reserve();
        String sql_search;
        
        if(typeSearch.equals("member.name")){
        sql_search="SELECT reserve.code\n" +
                   "FROM reserve, equipment, member\n" +
                   "WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode = member.identification and member.firstname||' '||member.lastName ilike '%"+inputValue+"%'";    
        }
        else if(typeSearch.equals("equipment.name")){
        sql_search="SELECT reserve.code\n" +
                   "FROM reserve, equipment, member\n" +
                   "WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode = member.identification and "+typeSearch+" ilike '%"+inputValue+"%'";    
        }
        else{sql_search="SELECT reserve.code\n" +
                   "FROM reserve, equipment, member\n" +
                   "WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode = member.identification and reserve."+typeSearch+" ilike '%"+inputValue+"%'";
        }
          
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
         
            
            while(tabla.next()){
                
               reserve.setCode(tabla.getString(1));
              
              System.out.println("ok");
            }  
             System.out.println(reserve.getCode());
            return reserve;
         }
         //fin Buscar
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return null;
    }
    
    public ArrayList <Object[]> listSearchReserve(String inputValue, String typeSearch){
        
        ArrayList <Object[]> tickets = new ArrayList <>();
        String sql_search;
       if(typeSearch.equals("member.name")){
        sql_search="SELECT reserve.code, member.firstname||' '||member.lastName, equipment.name, reserve.startDate, reserve.finalDate, reserve.loanDate, reserve.state\n" +
                   "FROM reserve, equipment, member\n" +
                   "WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode = member.identification and member.firstname||' '||member.lastName ilike '%"+inputValue+"%'";    
        }
        else if(typeSearch.equals("equipment.name")){
        sql_search="SELECT reserve.code, member.firstname||' '||member.lastName, equipment.name, reserve.startDate, reserve.finalDate, reserve.loanDate, reserve.state\n" +
                   "FROM reserve, equipment, member\n" +
                   "WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode = member.identification and "+typeSearch+" ilike '%"+inputValue+"%'";    
        }
        else{sql_search="SELECT reserve.code, member.firstname||' '||member.lastName, equipment.name, reserve.startDate, reserve.finalDate, reserve.loanDate, reserve.state\n" +
                   "FROM reserve, equipment, member\n" +
                   "WHERE reserve.serialNumber=equipment.serialNumber and reserve.userCode = member.identification and reserve."+typeSearch+" ilike '%"+inputValue+"%'";
        }
        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);

            while(tabla.next()){

               Object[] objectRow = new Object[7];
               
               for(int i=0; i<7; i++){
                   
                   objectRow[i]=tabla.getObject(i+1);  
               }
               tickets.add(objectRow);
            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return tickets;
   }
    
    public Reserve getInfoReserve(String code){
        Reserve reserve = new Reserve();
        String sql_select;
        sql_select="select reserve.code, member.identification, equipment.serialNumber, reserve.startDate, reserve.finalDate, reserve.loanDate, reserve.state\n" +
                   "from equipment,reserve, member\n"+
                   "Where reserve.serialNumber=equipment.serialNumber and reserve.userCode=member.identification and reserve.code='"+code+"'";
       
        try{
            Connection conn = conection.connect();
            System.out.println("consultando en la bd4");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                
               reserve.setCode(tabla.getString(1));
               reserve.setUserCode(tabla.getString(2));
               reserve.setSerialNumber(tabla.getString(3));
               reserve.setStartDate(tabla.getDate(4));
               reserve.setFinalDate(tabla.getDate(5));
               reserve.setLoanDate(tabla.getDate(6));
               reserve.setState(tabla.getString(7));
               
            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return reserve;
        
    }
 
}
