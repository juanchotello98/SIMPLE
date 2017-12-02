/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import java.util.ArrayList.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Logic.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author SJ
 */
public class UserDao {
	
    //Attributes
    FachadaBD conexion;
    public UserDao(){
        conexion = new FachadaBD();
    }
	
    //Methods
    
   
   // METODOS PENSADOS DE OTRA MANERA PARTE 1
   
   public User viewProfile(String userCode){
       
       User user = new User(userCode);
        String sql_select;
        int numberRows=0;

        sql_select="SELECT userCode, name, email, charge, cedula, phone, password FROM member WHERE userCode='"+user.getUserCode()+"';";

        try{
            Connection conn= conexion.conectar();
            //System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               user.setUserCode(tabla.getString(1));
               user.setName(tabla.getString(2));
               user.setEmail(tabla.getString(3));
               user.setCharge(tabla.getString(4));
               user.setCedula(tabla.getString(5));
               user.setPhone(tabla.getString(6));
               user.setPassword(tabla.getString(7));

              System.out.println("ok");
            }


         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        
        return user;
   }
   
   public Equipment viewEquipment(String equipmentCode){
       
       Equipment equipment = new Equipment();
        String sql_select;
        int numberRows=0;

        sql_select="SELECT equipmentCode, name, serialNumber, equipmentDescription, equipmentState FROM equipment WHERE equipmentCode='"+equipmentCode+"';";

        try{
            Connection conn= conexion.conectar();
            //System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               equipment.setEquipmentCode(tabla.getString(1));
               equipment.setName(tabla.getString(2));
               equipment.setSerialNumber(tabla.getString(3));
               equipment.setDescription(tabla.getString(4));
               equipment.setState(tabla.getString(5));
               
              System.out.println("ok");
            }


         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        
        return equipment;
   }
   
   public void changePassword(String userCode, String newPassword){
       String sql_select;
        sql_select="UPDATE member SET password = '"+newPassword+"' WHERE userCode = '"+userCode+"';";
        try{
        Connection conn= conexion.conectar();
        //System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
   }
   
   public void editProfile(String userCode, String phone){
       String sql_select;
        sql_select="UPDATE member SET phone ='" + phone +"' WHERE userCode='"+userCode+"';";
        try{
        Connection conn= conexion.conectar();
        System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
   }
   
   public ArrayList listMyProject(String userCode){
       ArrayList <Project> myProjects = new ArrayList <>();
       String sql_select;
        sql_select="SELECT projectCode, name, projectDescription, projectManager FROM project NATURAL JOIN user_project WHERE userCode='"+userCode+"';";

        try{
            Connection conn= conexion.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               Project project = new Project();
               project.setProjectCode(tabla.getString(1));
               project.setName(tabla.getString(2));
               project.setDescription(tabla.getString(3));
               project.setProjectManager(tabla.getString(4));

               myProjects.add(project);

            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return myProjects;
   }
   
   public ArrayList listEquipment(){
       ArrayList <Equipment> inventory = new ArrayList <>();
       String sql_select;
        sql_select="SELECT * FROM equipment;";

        try{
            Connection conn= conexion.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               Equipment equipment = new Equipment();
               equipment.setEquipmentCode(tabla.getString(1));
               equipment.setName(tabla.getString(2));
               equipment.setSerialNumber(tabla.getString(3));
               equipment.setDescription(tabla.getString(4));
               equipment.setState(tabla.getString(5));

               inventory.add(equipment);

            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return inventory;
   }
   
   public ArrayList listProject(){
       ArrayList <Project> projects = new ArrayList <>();
       String sql_select;
        sql_select="SELECT * FROM project;";

        try{
            Connection conn= conexion.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               Project project = new Project();
               project.setProjectCode(tabla.getString(1));
               project.setName(tabla.getString(2));
               project.setDescription(tabla.getString(3));
               project.setProjectManager(tabla.getString(4));

               projects.add(project);

            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return projects;
   }
   
   public ArrayList listMyLoans(String userCode){
       ArrayList <Loan> loans = new ArrayList <>();
       String sql_select;
        sql_select="SELECT * FROM loan WHERE userCode = '"+userCode+"';";

        try{
            Connection conn= conexion.conectar();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){

               Loan loan = new Loan();
               loan.setUserCode(tabla.getString(1));
               loan.setEquipmentCode(tabla.getString(2));
               loan.setStartDate(tabla.getDate(3));
               loan.setFinalDate(tabla.getDate(4));
               loan.setState(tabla.getBoolean(5));
               loan.setReturnEquipment(tabla.getDate(6));

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
   
   public void takeOutEquipment(String userCode, String equipmentCode){
       String sql_guardar;
        int numFilas=0;
        
        String sql_search;
        
        sql_guardar="INSERT INTO loan(userCode,equipmentCode, loanstartDate, loanfinalDate, loanstate) VALUES ('"+userCode+"','"+equipmentCode+"','"+getCurrentLoanDate()+"','"+getFinalLoanDate()+"', 'true')";
        
        try{
            Connection conn= conexion.conectar();
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
        changeStateEquipment(equipmentCode, verifyEquipmentStatus(equipmentCode));
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
   
   public int verifyEquipmentStatus(String equipmentCode){
        String sql_select;
        String state = null;
        int output;
        sql_select="SELECT equipmentstate FROM equipment WHERE equipmentCode = '"+equipmentCode+"';";

        try{
            Connection conn= conexion.conectar();
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
        switch (state){
            case "0":
                output = 0;
                break;
            case "1":
                output = 1;
                break;
            case "2":
                output = 2;
            default:
                output = 2;
                break;                          
        }
        return output;
   }
   
   public void changeStateEquipment(String equipmentCode, int state){
   
       switch(state){
           case 0:
               state = 1;
           case 1:
               state = 0;
           case 2:
               state = 1;
       }
       String sql_select;
        sql_select="UPDATE equipment SET equipmentstate ='"+state+"' WHERE equipmentCode = '"+equipmentCode+"';";
        try{
        Connection conn= conexion.conectar();
        System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
   }
   
   
   public void returnEquipment(Loan loan){
       
       String sql_select;
        sql_select="UPDATE loan SET equipmentreturndate ='"+getCurrentLoanDate()+"', loanstate = 'false' WHERE userCode='"+loan.getUserCode()+"' AND equipmentCode = '"+loan.getEquipmentCode()+"' AND loanstartdate = '"+loan.getStartDate()+"';";
        try{
        Connection conn= conexion.conectar();
        System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        changeStateEquipment(loan.getEquipmentCode(), verifyEquipmentStatus(loan.getEquipmentCode()));
   }
   
   public void reserveEquipment(String userCode, Loan loan){
       if((verifyEquipmentStatus(loan.getEquipmentCode()) == 1) && (checkAvailabilityReservation(loan))){
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

            sql_guardar="INSERT INTO reserve(userCode,equipmentCode, reservestartdate, reservefinalDate, reservestate) VALUES ('"+userCode+"','"+loan.getEquipmentCode()+"','"+getCurrentLoanDate()+"','"+finalDate+"', 'true')";

            try{
                Connection conn= conexion.conectar();
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
            changeStateEquipment(loan.getEquipmentCode(), verifyEquipmentStatus(loan.getEquipmentCode()));          
           }else{
           System.out.println("No se pudo rservar papu");
       }
   } // incompleta
   
   public boolean checkAvailabilityReservation(Loan loan){
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
   
   
   }


