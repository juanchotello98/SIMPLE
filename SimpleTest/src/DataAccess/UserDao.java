/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Logic.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class UserDAO {
    
    Conection conection;
    
    public  UserDAO(){
        
        conection = new Conection();
    }
    
    
    public User verifyLogin(String userIdentificacion){
        
        User user = new User();
        String sql_search;

        sql_search="SELECT * FROM member WHERE identification ='"+userIdentificacion+"'";
        
        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
            
        while(tabla.next()){
                
            user.setCode(tabla.getString(1));
            user.setIdentification(tabla.getString(2));
            user.setPassword(tabla.getString(3));
            user.setFirstName(tabla.getString(4));
            user.setLastName(tabla.getString(5));
            user.setEmail(tabla.getString(6));     
            user.setCharge(tabla.getString(7));
            user.setTypeID(tabla.getString(8));
            user.setPhone(tabla.getString(9));
              
            System.out.println("ok");
            
        }
        return user;
      }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }   
        return user;
    }   
    
    public int saveUser(User user){
        
        String sql_save;
        int numFilas=0;

        sql_save="insert into member (identification, password, firstName, lastName, email, charge, typeID, phone, state)"
                + "VALUES ('" +user.getIdentification()+  "', '" +user.getPassword()+ "', '" +user.getFirstName()+ "', "
                + "'" +user.getLastName()+ "', '" +user.getEmail()+ "', '" +user.getCharge()+ "', "
                + "'" +user.getTypeID()+ "', '" +user.getPhone()+ "','Activo')";
        try{
            Connection conn = conection.connect();
            Statement sentencia = conn.createStatement();

            numFilas = sentencia.executeUpdate(sql_save);            
            System.out.println("up " + numFilas);
            return numFilas;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }//fin guardar    
    
    public ArrayList <Object[]> listUser(){
            
        ArrayList <Object[]> users = new ArrayList <>();
        String sql_search;
        sql_search="SELECT code, identification, firstName, lastName, email, charge, typeID, phone, state from member";


        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);

            while(tabla.next()){

               Object[] objectRow = new Object[9];
               
               for(int i=0; i<9; i++){
                   
                   objectRow[i]=tabla.getObject(i+1);  
               }
               
               users.add(objectRow);
            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return users;
   }
    
    public User searchUser(String inputValue, String typeSearch){
        User user = new User();
        String sql_search;
        
        sql_search="SELECT code FROM member WHERE "+typeSearch+" ilike '" +inputValue+  "%'";
        
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
            
            
            while(tabla.next()){
                
               user.setCode(tabla.getString(1));

               System.out.println("ok");
            }         
            return user;
         }//fin Buscar
         
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return null;
    }
    
    public ArrayList <Object[]> listSearchUser(String inputValue, String typeSearch){
            
        ArrayList <Object[]> users = new ArrayList <>();
        String sql_search;
        sql_search="SELECT code, identification, firstName, lastName, email, charge, typeID, phone, state from member WHERE "+typeSearch+" ilike '" +inputValue+  "%'";


        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);

            while(tabla.next()){

               Object[] objectRow = new Object[9];
               
               for(int i=0; i<9; i++){
                   
                   objectRow[i]=tabla.getObject(i+1);  
               }
               
               users.add(objectRow);
            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return users;
   }
    
    public int updateUser(User user){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE member Set identification='"+user.getIdentification()+"', firstName='"+user.getFirstName()+"', lastName='"+user.getLastName()+"',"
                + " email='"+user.getEmail()+"', charge='"+user.getCharge()+"', typeID='"+user.getTypeID()+"', phone='"+user.getPhone()+"', state='"+user.getState()+"'WHERE code='"+user.getCode()+"'";
        
        try{
            Connection conn = conection.connect();
            Statement sentencia = conn.createStatement();

            numFilas = sentencia.executeUpdate(sql_update);            
            System.out.println("up " + numFilas);
            return numFilas;            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }//fin guardar
    
}
