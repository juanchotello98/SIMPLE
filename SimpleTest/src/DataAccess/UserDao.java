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

/**
 *
 * @author Diego
 */
public class UserDAO {
    
    Conection conection;
    
    public  UserDAO(){
        
        conection = new Conection();
    }
    
    
    public User verifyLogin(String userCode){
        
        User user = new User();
        String sql_search;

        sql_search="SELECT * FROM member WHERE usercode ='"+userCode+"'";
        
        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
            
        while(tabla.next()){
                
            user.setUserID(tabla.getString(1));
            user.setUserCode(tabla.getString(2));
            user.setPassword(tabla.getString(3));
            user.setName(tabla.getString(4));
            user.setEmail(tabla.getString(5));     
            user.setCharge(tabla.getString(6));
            user.setCedula(tabla.getString(7));
            user.setPhone(tabla.getString(8));
              
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
}
