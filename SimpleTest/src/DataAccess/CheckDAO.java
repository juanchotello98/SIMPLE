/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Logic.Loan;
import Logic.Project;
import Logic.Reserve;
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
public class CheckDAO {
    Conection conection;
    LoanDAO loanDAO;
    
    public CheckDAO(){
        conection = new Conection();
        loanDAO = new LoanDAO();
    }
    
    public ArrayList getLoans(){
        ArrayList <Loan> loans = new ArrayList <>();
       String sql_select;
        sql_select="SELECT * FROM loan WHERE state = 'Activo' and ticket = 'false'";

        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               Loan loan = new Loan();
               loan.setCode(tabla.getString(1));
               loan.setUserCode(tabla.getString(2));
               loan.setEquipmentCode(tabla.getString(3));
               loan.setState(tabla.getString(4));
               loan.setStartDate(tabla.getDate(5));
               loan.setFinalDate(tabla.getDate(6));
               loan.setReturnEquipment(tabla.getDate(7));
               loan.setRenew(tabla.getInt(8));
               loan.setTicket(tabla.getBoolean(9));

               loans.add(loan);

            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return loans;
    }
    
    public void makeTicket(Loan loan){
        Calendar actualDate = Calendar.getInstance();
        actualDate.setTime(new Date());
        
        String sql_guardar;
        int numFilas=0;

        sql_guardar="INSERT INTO ticket(userCode, serialNumber, ticketDate, state, tipoMulta, description, costoMulta) VALUES ('"+loan.getUserCode()+"','"+loan.getEquipmentCode()+"','"+loanDAO.getCurrentLoanDate()+"','Activa','Atraso','No entrego el equipo a tiempo.',2000);";

        try{
            Connection conn = conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);                  
          }
            catch(SQLException e){
                System.out.println(e); 
                }
            catch(Exception e){ 
                System.out.println(e);
            }
    }
       
    public ArrayList getAvailablesReserves(){
        ArrayList <Reserve> reserves = new ArrayList <>();
       String sql_select;
        sql_select="SELECT * FROM reserve WHERE state = 'Disponible' AND ticket = 'false'";

        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               Reserve reserve = new Reserve();
               reserve.setCode(tabla.getString(1));
               reserve.setUserCode(tabla.getString(2));
               reserve.setSerialNumber(tabla.getString(3));
               reserve.setStartDate(tabla.getDate(4));
               reserve.setFinalDate(tabla.getDate(5));
               reserve.setLoanDate(tabla.getDate(6));
               reserve.setState(tabla.getString(7));
               reserve.setTicket(tabla.getBoolean(8));

               reserves.add(reserve);

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
    
    public void makeTicketReserve(Reserve reserve){
        Calendar actualDate = Calendar.getInstance();
        actualDate.setTime(new Date());
        
        String sql_guardar;
        int numFilas=0;

        sql_guardar="INSERT INTO ticket(userCode, serialNumber, ticketDate, state, tipoMulta, description, costoMulta) VALUES ('"+reserve.getUserCode()+"','"+reserve.getSerialNumber()+"','"+loanDAO.getCurrentLoanDate()+"','Activa','Incumplir reserva','Hizo una reserva y no la termino o cancelo.',1000);";

        try{
            Connection conn = conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);                  
          }
            catch(SQLException e){
                System.out.println(e); 
                }
            catch(Exception e){ 
                System.out.println(e);
            }
         if(loanDAO.verifyEquipmentStatus(reserve.getSerialNumber()).equals("Ocupado")){
            loanDAO.changeStateEquipment(reserve.getSerialNumber(), "loca");
        } else {
             loanDAO.changeStateEquipment(reserve.getSerialNumber(), loanDAO.verifyEquipmentStatus(reserve.getSerialNumber()));
         }
        
    }
    
    public void changeTicketLoan(Loan loan){
        String sql_select;
        sql_select="UPDATE loan SET ticket ='true' WHERE code='"+loan.getCode()+"';";
        try{
        Connection conn = conection.connect();
        System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    }
    
    public void changeTicketReserve(Reserve reserve){
        String sql_select;
        sql_select="UPDATE reserve SET ticket ='true' WHERE code='"+reserve.getCode()+"';";
        try{
        Connection conn = conection.connect();
        System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
    }
}

