/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;



import Logic.Loan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author SJ
 */
public class LoanDAO {
    
    Conection conection;
    
    public LoanDAO(){
        conection = new Conection();
    }
    
    public ArrayList listLoan(){
       ArrayList <Object[]> loans = new ArrayList <>();
            String sql_search;
            sql_search="select loan.code, member.firstname||' '||member.lastName, equipment.name, loan.state, loan.loanStartDate, loan.loanFinalDate, loan.loanDeliveryDate\n" +
                       "from equipment,loan, member\n"+
                       "Where loan.serialNumber=equipment.serialNumber and loan.userCode=member.identification";


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

                   loans.add(objectRow);
                }

             }
             catch(SQLException e){ 
                             System.out.println(e); 
                             }
             catch(Exception e){
                              System.out.println(e); 
                              }
        //---------------------------------------------------------------
       
        return loans;
   }
   
    public ArrayList listMyLoans(String userCode){
       ArrayList <Object[]> myLoans = new ArrayList <>();
            String sql_search;
            sql_search="select loan.code, equipment.name, loan.loanStartDate, loan.loanFinalDate, loan.loanDeliveryDate, loan.state\n" +
                       "from loan, equipment, member\n" +
                       "Where loan.userCode=member.identification and equipment.serialNumber=loan.serialNumber and member.identification='"+userCode+"'";


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

                   myLoans.add(objectRow);
                }

             }
             catch(SQLException e){ 
                             System.out.println(e); 
                             }
             catch(Exception e){
                              System.out.println(e); 
                              }
        //---------------------------------------------------------------
       
        return myLoans;
   }
   
    public void takeOutEquipment(String userCode, String serialNumber){
       String sql_guardar;
        int numFilas=0;
        
        String sql_search;
        
        sql_guardar="INSERT INTO loan(userCode,serialNumber, state, loanstartDate, loanfinalDate, renovaciones, ticket) VALUES ('"+userCode+"','"+serialNumber+"','Activo', '"+getCurrentLoanDate()+"','"+getFinalLoanDate()+"', '0', 'false')";
        
        try{
            Connection conn = conection.connect();
            System.out.println("consultando en la bd2");
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);                  
      }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        changeStateEquipment(serialNumber, verifyEquipmentStatus(serialNumber));
        System.out.println(getFinalLoanDate());
   }
   
    public String getCurrentLoanDate(){
       String output="";
       Calendar currentDate = Calendar.getInstance();
       currentDate.setTime(new Date());
       int month;
       month = currentDate.get(Calendar.MONTH)+1;
       output = currentDate.get(Calendar.DAY_OF_MONTH)+"/"+month+"/"+currentDate.get(Calendar.YEAR);
       return output;
   }
   
    public String getFinalLoanDate(){
       String output="";
       Calendar currentDate = Calendar.getInstance();
       currentDate.setTime(new Date());
       currentDate.add(Calendar.DAY_OF_YEAR,7);
       int month;
       month = currentDate.get(Calendar.MONTH)+1;
       output = currentDate.get(Calendar.DAY_OF_MONTH)+"/"+month+"/"+currentDate.get(Calendar.YEAR);
       return output;
   }
   
    public String getFinalLoanDate(Date date){
       String output="";
       Calendar currentDate = Calendar.getInstance();
       currentDate.setTime(date);
       currentDate.add(Calendar.DAY_OF_YEAR,7);
       int month;
       month = currentDate.get(Calendar.MONTH)+1;
       output = currentDate.get(Calendar.DAY_OF_MONTH)+"/"+month+"/"+currentDate.get(Calendar.YEAR);
       return output;
   }
   
    public String verifyEquipmentStatus(String serialNumber){
        String sql_select;
        String state = null;
        sql_select="SELECT state FROM equipment WHERE serialNumber = '"+serialNumber+"';";

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
   
    public void changeStateEquipment(String serialNumber, String state){
   
       if(state.equals("Libre")){
           state = "Ocupado";
       } else {
           if(state.equals("Ocupado")){
               state = "Reservado";
           } else{
               if(state.equals("Reservado")){
                   state = "Ocupado";
               }
                 else{
                 if(state.equals("Validado")){
                   state = "Libre";
               }
               else{
                   state = "Libre";
               }
             }
           }
       }
       
       String sql_select;
        sql_select="UPDATE equipment SET state ='"+state+"' WHERE serialNumber = '"+serialNumber+"';";
        try{
        Connection conn= conection.connect();
        System.out.println("Update in the bd3");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
   }
   
    public Loan searchLoan(String loanCode){
       
       Loan loan = new Loan();
       String sql_select;
       sql_select="SELECT code, userCode, serialNumber, state, loanStartDate, loanfinaldate, loandeliverydate FROM loan WHERE code = '"+loanCode+"'";

        try{
            Connection conn = conection.connect();
            System.out.println("consultando en la bd4");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                
               loan.setCode(tabla.getString(1));
               loan.setUserCode(tabla.getString(2));
               loan.setEquipmentCode(tabla.getString(3));
               loan.setState(tabla.getString(4));
               loan.setStartDate(tabla.getDate(5));
               loan.setFinalDate(tabla.getDate(6));
               loan.setReturnEquipment(tabla.getDate(7));

            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return loan;
   }
    
    public Loan searchLoanReserve(String serialNumber){
       
       Loan loan = new Loan();
       String sql_select;
        sql_select="SELECT userCode, serialNumber, state, loanstartdate, loanfinaldate, loandeliverydate FROM loan WHERE serialNumber = '"+serialNumber+"';";

        try{
            Connection conn = conection.connect();
            System.out.println("consultando en la bd4");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               loan.setUserCode(tabla.getString(1));
               loan.setEquipmentCode(tabla.getString(2));
               loan.setState(tabla.getString(3));
               loan.setStartDate(tabla.getDate(4));
               loan.setFinalDate(tabla.getDate(5));
               loan.setReturnEquipment(tabla.getDate(6));

            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return loan;
   }
   
    public boolean reserveEquipment(String userCode, Loan loan){
       System.out.println(loan.getFinalDate());
       if((verifyEquipmentStatus(loan.getEquipmentCode()).equals("Ocupado")) && (checkAvailabilityReservation(loan))){
           String sql_guardar;
            int numFilas=0;
            Calendar reserveFinalDate = Calendar.getInstance();
            reserveFinalDate.setTime(loan.getFinalDate());
            reserveFinalDate.add(Calendar.DAY_OF_YEAR, 1);
            String finalDate=null;
            int month;
            month = reserveFinalDate.get(Calendar.MONTH)+1;
            
            finalDate=reserveFinalDate.get(Calendar.DAY_OF_MONTH)+"/"+month+"/"+reserveFinalDate.get(Calendar.YEAR);
        
            String sql_search;
            System.out.println(getCurrentLoanDate());
            System.out.println(finalDate);

            sql_guardar="INSERT INTO reserve(userCode, serialNumber, reservefinalDate, reservestate, ticket) VALUES ('"+userCode+"','"+loan.getEquipmentCode()+"','"+getCurrentLoanDate()+"','"+finalDate+"', 'Ocupado', 'false')";

            try{
                Connection conn = conection.connect();
                System.out.println("consultando en la bdsdsadsadsadsadsad");
                Statement sentencia = conn.createStatement();
                numFilas = sentencia.executeUpdate(sql_guardar);                  
          }
            catch(SQLException e){
                System.out.println(e); 
                }
            catch(Exception e){ 
                System.out.println(e);
            }
            changeStateEquipment(loan.getEquipmentCode(), verifyEquipmentStatus(loan.getEquipmentCode()));  
            return true;
           }else{
           return false;
       }
   }
   
    public boolean checkAvailabilityReservation(Loan loan){
       System.out.println(loan.getFinalDate());
       Calendar actualDate = Calendar.getInstance();
       Calendar loanDate = Calendar.getInstance();
       Calendar loanDate3 = Calendar.getInstance();
       actualDate.setTime(new Date());
       loanDate.setTime(loan.getFinalDate());
       loanDate3.setTime(loan.getFinalDate());
       loanDate3.add(Calendar.DAY_OF_YEAR, -3);
       if(((actualDate.compareTo(loanDate))==0) || ((actualDate.compareTo(loanDate3)==1) && (actualDate.compareTo(loanDate)==-1))){
           System.out.println("Paso el chequeo");
           return true;
       } else {
           return false;
       }
   }
   
    public void returnEquipment(Loan loan){
       
       String sql_select;
        sql_select="UPDATE loan SET loandeliverydate ='"+getCurrentLoanDate()+"', state = 'Entregado' WHERE code='"+loan.getCode()+"'";
        try{
        Connection conn = conection.connect();
        System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        /*if(verifyEquipmentStatus(loan.getEquipmentCode()).equals("Ocupado")){
            changeStateEquipment(loan.getEquipmentCode(), "loca");
        } else {
            changeStateEquipment(loan.getEquipmentCode(), verifyEquipmentStatus(loan.getEquipmentCode()));
        }*/
        
   }
   
    public String verifyLoanStatus(String loanCode){
        String sql_select;
        String state = null;
        sql_select="SELECT state FROM loan WHERE code = '"+loanCode+"';";

        try{
            Connection conn = conection.connect();
            //System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               state=tabla.getString(1);               
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
   
    public int renewLoan(Loan loan){
       if(checkAvailabilityReservation(loan)){
       if(loan.getRenew()< 4){
           int renew = loan.getRenew() +1;
       String sql_select;
        sql_select="UPDATE loan SET loanfinaldate ='"+getFinalLoanDate(loan.getFinalDate())+"', renovaciones = "+renew+" WHERE userCode='"+loan.getUserCode()+"' AND serialnumber = '"+loan.getEquipmentCode()+"' AND loanstartdate = '"+loan.getStartDate()+"';";
        try{
        Connection conn = conection.connect();
        System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return 0;
        
       } else {
           return 1;
       }
       } else return 2;
   } 
   
    public void validateDelivery(Loan loan){
       String sql_select;
        sql_select="UPDATE loan SET state = 'Validado' WHERE userCode='"+loan.getUserCode()+"' AND serialnumber = '"+loan.getEquipmentCode()+"' AND loanstartdate = '"+loan.getStartDate()+"';";
        try{
        Connection conn = conection.connect();
        System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        if(verifyEquipmentStatus(loan.getEquipmentCode()).equals("Ocupado")){
            changeStateEquipment(loan.getEquipmentCode(), "loca");
        } else {
            if(verifyEquipmentStatus(loan.getEquipmentCode()).equals("Reservado")){
                changeStateReserve(loan.getEquipmentCode(),loan.getStartDate(),loan.returnEquipment());
                changeStateEquipment(loan.getEquipmentCode(), verifyEquipmentStatus(loan.getEquipmentCode()));
            }
            else changeStateEquipment(loan.getEquipmentCode(), verifyEquipmentStatus(loan.getEquipmentCode()));
        }
   }
    
    public Loan searchProfileLoan(String inputValue, String typeSearch, String userIdentification){
        Loan loan = new Loan();
        String sql_search;
        
        if(typeSearch.equals("serialNumber")){
        sql_search="select loan.code\n" +
                    "from equipment,loan, member\n" +
                    "Where loan.serialNumber=equipment.serialNumber and loan.userCode=member.identification and member.identification='"+userIdentification+"' and equipment.name ilike '%"+inputValue+"%'";
        }
        
        else{
        sql_search="select loan.code\n" +
                   "from equipment,loan, member\n" +
                   "Where loan.serialNumber=equipment.serialNumber and loan.userCode=member.identification and member.identification='"+userIdentification+"' and loan."+typeSearch+" ilike '%"+inputValue+"%'";
        } 
          
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
         
            
            while(tabla.next()){
                
               loan.setCode(tabla.getString(1));
              
              System.out.println("ok");
            }  
             System.out.println(loan.getCode());
            return loan;
         }
         //fin Buscar
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return null;
    }
    
    public ArrayList <Object[]> listSearchProfileLoan(String inputValue, String typeSearch, String userIdentification){
        
        ArrayList <Object[]> loans = new ArrayList <>();
        String sql_search;
        
        if(typeSearch.equals("serialNumber")){
            sql_search="select loan.code, equipment.name, loan.loanStartDate, loan.loanFinalDate, loan.loanDeliveryDate, loan.state\n" +
                       "from equipment,loan, member\n" +
                       "Where loan.serialNumber=equipment.serialNumber and loan.userCode=member.identification and member.identification='"+userIdentification+"' and equipment.name ilike '%"+inputValue+"%'";
        }
        
        else{
        sql_search="select loan.code, equipment.name, loan.loanStartDate, loan.loanFinalDate, loan.loanDeliveryDate, loan.state\n" +
                   "from equipment,loan, member\n" +
                   "Where loan.serialNumber=equipment.serialNumber and loan.userCode=member.identification and member.identification='"+userIdentification+"' and loan."+typeSearch+" ilike '%"+inputValue+"%'";
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
               loans.add(objectRow);
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
    
    public Loan searchLoan(String inputValue, String typeSearch){
        Loan loan = new Loan();
        String sql_search;
        
        if(typeSearch.equals("serialNumber")){
            sql_search="select loan.code\n" +
                       "from equipment,loan, member\n" +
                       "Where loan.serialNumber=equipment.serialNumber and loan.userCode=member.identification and equipment.name ilike '%"+inputValue+"%'";
        }
        
        else{
        sql_search="select loan.code\n" +
                   "from equipment,loan, member\n" +
                   "Where loan.serialNumber=equipment.serialNumber and loan.userCode=member.identification and loan."+typeSearch+" ilike '%"+inputValue+"%'";
        } 
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
         
            
            while(tabla.next()){
                
              loan.setCode(tabla.getString(1));
              
              System.out.println("ok");
            }  
             System.out.println(loan.getCode());
            return loan;
         }
         //fin Buscar
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return null;
    }
    
    public ArrayList <Object[]> listSearchLoan(String inputValue, String typeSearch){
        
        ArrayList <Object[]> loans = new ArrayList <>();
        String sql_search;
        
        if(typeSearch.equals("serialNumber")){
        sql_search="select loan.code, member.firstname||' '||member.lastName, equipment.name, loan.state, loan.loanStartDate, loan.loanFinalDate, loan.loanDeliveryDate\n" +
                       "from equipment,loan, member\n" +
                       "Where loan.serialNumber=equipment.serialNumber and loan.userCode=member.identification and equipment.name ilike '%"+inputValue+"%'";
        }
        else{
        sql_search="select loan.code, member.firstname||' '||member.lastName, equipment.name, loan.state, loan.loanStartDate, loan.loanFinalDate, loan.loanDeliveryDate\n" +
                   "from equipment,loan, member\n" +
                   "Where loan.serialNumber=equipment.serialNumber and loan.userCode=member.identification and loan."+typeSearch+" ilike '%"+inputValue+"%'";
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
               loans.add(objectRow);
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
    
    public Loan getInfoLoan(String code){
        Loan loan = new Loan();
        String sql_select;
        sql_select="select loan.code, member.identification, equipment.serialNumber, loan.state, loan.loanStartDate, loan.loanFinalDate, loan.loanDeliveryDate, loan.state, loan.renovaciones\n" +
                   "from equipment,loan, member\n"+
                   "Where loan.serialNumber=equipment.serialNumber and loan.userCode=member.identification and loan.code='"+code+"'";
       
        try{
            Connection conn = conection.connect();
            System.out.println("consultando en la bd4");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                
               loan.setCode(tabla.getString(1));
               loan.setUserCode(tabla.getString(2));
               loan.setEquipmentCode(tabla.getString(3));
               loan.setState(tabla.getString(4));
               loan.setStartDate(tabla.getDate(5));
               loan.setFinalDate(tabla.getDate(6));
               loan.setReturnEquipment(tabla.getDate(7));
               loan.setRenew(tabla.getInt(8));
            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return loan;
        
    }
    
    public void changeStateReserve(String serialNumber, Date StartLoanDate, Date finalDate){
       Calendar loanDateF = Calendar.getInstance();
        loanDateF.setTime(finalDate);
        loanDateF.add(Calendar.DAY_OF_YEAR, 1);
        String sql_select;
        sql_select="UPDATE reserve SET state = 'Disponible', finaldate = '"+getFinalLoanDate(loanDateF.getTime())+"' WHERE serialnumber = '"+serialNumber+"' AND startdate = '"+StartLoanDate+"';";
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
