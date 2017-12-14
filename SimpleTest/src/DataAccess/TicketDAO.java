/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import Logic.Ticket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author SJ
 */
public class TicketDAO {
    Conection conection;
    
    public TicketDAO(){
        conection = new Conection();
    }
    
    public ArrayList listTickets(){
       ArrayList <Object[]> tickets = new ArrayList <>();
            String sql_search;
            sql_search="SELECT ticket.code, member.firstname, member.lastname, equipment.name, tipoMulta, ticket.state, costoMulta, ticketDate FROM ticket, member, equipment WHERE ticket.userCode = member.identification and ticket.serialNumber=equipment.serialNumber";


            try{
                Connection conn= conection.connect();
                System.out.println("consultando en la bd10");
                Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql_search);

                while(tabla.next()){

                   Object[] objectRow = new Object[8];

                   for(int i=0; i<8; i++){

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
        //---------------------------------------------------------------
       
        return tickets;
   }
    
    public ArrayList listProfileTickets(String userCode){
       ArrayList <Object[]> myTickets = new ArrayList <>();
            String sql_search;
            sql_search="SELECT ticket.code, equipment.name, ticket.state, tipoMulta, costoMulta, ticketDate "
                    +  "FROM ticket, equipment "
                    +  "WHERE ticket.serialNumber=equipment.serialNumber and userCode='"+userCode+"'";


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

                   myTickets.add(objectRow);
                }

             }
             catch(SQLException e){ 
                             System.out.println(e); 
                             }
             catch(Exception e){
                              System.out.println(e); 
                              }
        //---------------------------------------------------------------
       
        return myTickets;
   }
    
    public String verifyTicketStatus(String code){
        String sql_select;
        String state = null;
        sql_select="SELECT state FROM ticket WHERE code = '"+code+"';";

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
    
    public void payTicket(String code){
        String sql_select;
        sql_select="UPDATE ticket SET state ='Pagada' WHERE code = '"+code+"';";
        try{
        Connection conn= conection.connect();
        System.out.println("Update in the bd3");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    }
    
    public void cancelTicket(String code){
        String sql_select;
        sql_select="UPDATE ticket SET state ='Cancelada' WHERE code = '"+code+"';";
        try{
        Connection conn= conection.connect();
        System.out.println("Update in the bd3");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    }
    
    public Ticket searchProfileTicket(String inputValue, String typeSearch, String userIdentification){
        Ticket ticket = new Ticket();
        String sql_search;
        
        if(typeSearch.equals("name")){
        sql_search="SELECT ticket.code FROM ticket, equipment WHERE ticket.serialNumber=equipment.serialNumber and userCode='"+userIdentification+"' and equipment.name ilike '%"+inputValue+"%'";
        }
        else{ sql_search="SELECT ticket.code FROM ticket, equipment WHERE ticket.serialNumber=equipment.serialNumber and userCode='"+userIdentification+"' and ticket."+typeSearch+" ilike '%"+inputValue+"%'";}
        
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
         
            
            while(tabla.next()){
                
               ticket.setCode(tabla.getString(1));
              
              System.out.println("ok");
            }  
             System.out.println(ticket.getCode());
            return ticket;
         }
         //fin Buscar
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return null;
    }
    
    public ArrayList <Object[]> listSearchProfileTicket(String inputValue, String typeSearch, String userIdentification){
        
        ArrayList <Object[]> tickets = new ArrayList <>();
        String sql_search;
        
        if(typeSearch.equals("name")){
        sql_search="SELECT ticket.code, equipment.name, ticket.state, tipoMulta, costoMulta, ticketDate  FROM ticket, equipment WHERE ticket.serialNumber=equipment.serialNumber and userCode='"+userIdentification+"' and equipment.name ilike '%"+inputValue+"%'";
        }
        else{ sql_search="SELECT ticket.code, equipment.name, ticket.state, tipoMulta, costoMulta, ticketDate  FROM ticket, equipment WHERE ticket.serialNumber=equipment.serialNumber and userCode='"+userIdentification+"' and ticket."+typeSearch+" ilike '%"+inputValue+"%'";}
        
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
    
    public Ticket searchTicket(String inputValue, String typeSearch){
        Ticket ticket = new Ticket();
        String sql_search;
        
        if(typeSearch.equals("firstName") || typeSearch.equals("lastName")){
        sql_search="SELECT ticket.code\n" +
                   "FROM ticket, equipment, member\n" +
                   "WHERE ticket.serialNumber=equipment.serialNumber and ticket.userCode = member.identification and member."+typeSearch+" ilike '%"+inputValue+"%'";    
        }
        else{sql_search="SELECT ticket.code\n" +
                   "FROM ticket, equipment, member\n" +
                   "WHERE ticket.serialNumber=equipment.serialNumber and ticket.userCode = member.identification and ticket."+typeSearch+" ilike '%"+inputValue+"%'";
        }
          
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
         
            
            while(tabla.next()){
                
               ticket.setCode(tabla.getString(1));
              
              System.out.println("ok");
            }  
             System.out.println(ticket.getCode());
            return ticket;
         }
         //fin Buscar
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return null;
    }

    public ArrayList <Object[]> listSearchTicket(String inputValue, String typeSearch){
        
        ArrayList <Object[]> tickets = new ArrayList <>();
        String sql_search;
        if(typeSearch.equals("firstName") || typeSearch.equals("lastName")){
        sql_search="SELECT ticket.code, member.firstname, member.lastname, equipment.name, tipoMulta, ticket.state, costoMulta, ticketDate\n" +
                   "FROM ticket, equipment, member\n" +
                   "WHERE ticket.serialNumber=equipment.serialNumber and ticket.userCode = member.identification and member."+typeSearch+" ilike '%"+inputValue+"%'";    
        }
        else{sql_search="SELECT ticket.code, member.firstname, member.lastname, equipment.name, tipoMulta, ticket.state, costoMulta, ticketDate\n" +
                   "FROM ticket, equipment, member\n" +
                   "WHERE ticket.serialNumber=equipment.serialNumber and ticket.userCode = member.identification and ticket."+typeSearch+" ilike '%"+inputValue+"%'";
        }
        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);

            while(tabla.next()){

               Object[] objectRow = new Object[8];
               
               for(int i=0; i<8; i++){
                   
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
    
    public Ticket getInfoTicket(String code){
        Ticket ticket = new Ticket();
        String sql_select;
        sql_select="select ticket.code, member.identification, equipment.serialNumber, ticket.state, ticket.costoMulta, ticket.ticketDate\n" +
                   "from equipment,ticket, member\n"+
                   "Where ticket.serialNumber=equipment.serialNumber and ticket.userCode=member.identification and ticket.code='"+code+"'";
       
        try{
            Connection conn = conection.connect();
            System.out.println("consultando en la bd4");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                
               ticket.setCode(tabla.getString(1));
               ticket.setUserCode(tabla.getString(2));
               ticket.setSerialNumber(tabla.getString(3));
               ticket.setState(tabla.getString(4));
               ticket.setCostoMulta(tabla.getInt(5));
               ticket.setTicketDate(tabla.getDate(6));
            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return ticket;
        
    }

}
