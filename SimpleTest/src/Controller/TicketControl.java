/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccess.TicketDAO;
import Logic.Ticket;
import java.util.ArrayList;

/**
 *
 * @author SJ
 */
public class TicketControl {
    TicketDAO ticketDAO;
    
    public TicketControl(){
        ticketDAO = new TicketDAO();
    }
    
    public ArrayList<Object[]> listTickets(){
       ArrayList <Object[]> tickets = new ArrayList <>();
         tickets = ticketDAO.listTickets();
        
        return tickets;
    }
    
    public ArrayList<Object[]> listProfileTickets(String userIdentification){
       ArrayList <Object[]> myTickets = new ArrayList <>();
        myTickets = ticketDAO.listProfileTickets(userIdentification); // Poner userCode member
        
        return myTickets;
    }
    
    public int verifyTicket(String code){
        if(ticketDAO.verifyTicketStatus(code).equals("Activa")){
            return 0;
        } else {
            if(ticketDAO.verifyTicketStatus(code).equals("Pagada")){
                return 1;
            } else {
                return 2;
            }
            
        }
    }
    
    public void payTicket(String code){
        ticketDAO.payTicket(code);
    }
    
    public void cancelTicket(String code){
        ticketDAO.cancelTicket(code);
    }
    
    public Ticket searchProfileTicket(String inputValue,String typeSearch, String userIdentification){
        
        Ticket ticket = new Ticket();
        
        System.out.println("Se va a Buscar un Proyecto");

        ticket = ticketDAO.searchProfileTicket(inputValue, typeSearch, userIdentification);
      
       return ticket;       
    }
    
    public ArrayList<Object[]> listSearchProfileTicket(String inputValue, String typeSearch, String userIdentification){
    
         ArrayList <Object[]> tickets = new ArrayList <>();
         tickets = ticketDAO.listSearchProfileTicket(inputValue, typeSearch, userIdentification);
         
         return tickets;      
    }
    
    public Ticket searchTicket(String inputValue,String typeSearch){
        
        Ticket ticket = new Ticket();
        
        System.out.println("Se va a Buscar un Proyecto");

        ticket = ticketDAO.searchTicket(inputValue, typeSearch);
      
       return ticket;       
    }

    public ArrayList<Object[]> listSearchTicket(String inputValue, String typeSearch){
    
         ArrayList <Object[]> tickets = new ArrayList <>();
         tickets = ticketDAO.listSearchTicket(inputValue, typeSearch);
         
         return tickets;      
    }
    
    public Ticket getInfoTicket(String code){
        Ticket ticket = new Ticket();
        
        ticket = ticketDAO.getInfoTicket(code);
                
        return ticket;
        
    }

}

