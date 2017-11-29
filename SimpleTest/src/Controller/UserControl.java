/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccess.RootDAO;
import DataAccess.UserDAO;
import Logic.User;

/**
 *
 * @author Diego
 */
public class UserControl {
    
    UserDAO userDAO;
    
    
    public UserControl(){
        userDAO = new UserDAO();
    }
    
    
    public User verifyLogin(String userCode){

        User user = new User();
        
        System.out.println("Se va a Buscar un Usuario");

        user = userDAO.verifyLogin(userCode);
      
        System.out.println("pasò a login");
        
       return user;       
    }
}
