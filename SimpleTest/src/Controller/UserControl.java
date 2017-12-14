/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccess.UserDAO;
import Logic.User;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class UserControl {
    
    UserDAO userDAO;
    
    
    public UserControl(){
        userDAO = new UserDAO();
    }
    
    
    public User verifyLogin(String userIdentificacion){

        User user = new User();
        
        System.out.println("Se va a Buscar un Usuario");

        user = userDAO.verifyLogin(userIdentificacion);
              
       return user;       
    }
    
    public int insertUser(String identification, String password, String firstName, String lastName, String email, String charge, String typeID, String phone ){
            
        User user = new User();        

        user.setIdentification(identification);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setCharge(charge);
        user.setTypeID(typeID);
        user.setPhone(phone);
        // private String password;
        
        //Se llama al dao para guardar
        System.out.println("Se insertarà un Usuario");
        
        int result = userDAO.saveUser(user);

        System.out.println("Se insertò un Usuario");
        
        return result;

    }
    
    public String assingPassword(String firstName, String lastName, String identification){
        
        String password;
        firstName = firstName.toUpperCase();
        lastName = lastName.toUpperCase();
        char[] firstNameCadena = firstName.toCharArray();
        char[] lastNameCadena = lastName.toCharArray();
 
        password=firstNameCadena[0]+identification+lastNameCadena[0];
        
        return  password;
        
    }
    
    public ArrayList<Object[]> listUser(){
    
         ArrayList <Object[]> users = new ArrayList <>();
         users = userDAO.listUser();
         
         return users;      
    }
    
    public ArrayList<Object[]> listSearchUser(String inputValue, String typeSearch){
    
         ArrayList <Object[]> users = new ArrayList <>();
         users = userDAO.listSearchUser(inputValue, typeSearch);
         
         return users;      
    }
    
    public User searchUser(String inputValue,String typeSearch){
        //Vector v= new Vector();

        User user = new User();
        
        System.out.println("Se va a Buscar un Equipo");

        user = userDAO.searchUser(inputValue, typeSearch);
      
       return user;       
    }
    
    public int updateUser(String code, String identification, String firstName, String lastName, String email, String charge, String typeID, String phone, String state){
       
        User user = new User();        

        user.setCode(code);
        user.setIdentification(identification);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setCharge(charge);
        user.setTypeID(typeID);
        user.setPhone(phone);
        user.setState(state);

        //Se llama al dao para actualizar
        System.out.println("Se actualizarà un Equipo");
        
        int result = userDAO.updateUser(user);

        System.out.println("Se actualizò un Equipo");
        
        return result;

    }

    public int updateProfile(String phone, String codeUser){

        System.out.println("Se actualizarà un Perfil");
        
        int result = userDAO.updateProfile(phone, codeUser);

        System.out.println("Se actualizò un Equipo");
        
        return result;

    }
    
    public int updatePassword(String password, String codeUser){

        System.out.println("Se actualizarà un Perfil");
        
        int result = userDAO.updatePassword(password, codeUser);

        System.out.println("Se actualizò un Equipo");
        
        return result;

    }
    
    public ArrayList<Object[]> listUserLinkProject(String projectID, String userID){
    
         ArrayList <Object[]> users = new ArrayList <>();
         users = userDAO.listUserLinkProject(projectID,userID);
         
         return users;      
    }
    
    public ArrayList<Object[]> listUserProject(String projectID){
    
         ArrayList <Object[]> users = new ArrayList <>();
         users = userDAO.listUserProject(projectID);
         
         return users;      
    }
    
    public User searchLinkUser(String inputValue,String typeSearch, String projectID){
        //Vector v= new Vector();

        User user = new User();
        
        System.out.println("Se va a Buscar un usuario");

        user = userDAO.searchLinkUser(inputValue, typeSearch, projectID);
      
       return user;       
    }
    
    public ArrayList<Object[]> listSearchLinkUser(String inputValue, String typeSearch, String projectID){
    
         ArrayList <Object[]> users = new ArrayList <>();
         users = userDAO.listSearchLinkUser(inputValue, typeSearch, projectID);
         
         return users;      
    }

    public User searchProjecUser(String inputValue,String typeSearch, String projectID){
        //Vector v= new Vector();

        User user = new User();
        
        System.out.println("Se va a Buscar un usuario");

        user = userDAO.searchProjectUser(inputValue, typeSearch, projectID);
      
       return user;       
    }
    
    public ArrayList<Object[]> listSearchProjectUser(String inputValue, String typeSearch, String projectID){
    
         ArrayList <Object[]> users = new ArrayList <>();
         users = userDAO.listSearchProjectUser(inputValue, typeSearch, projectID);
         
         return users;      
    }

    public User getUserInfo(String identification){
        //Vector v= new Vector();

        User user = new User();
        
        System.out.println("Se va a Buscar un Equipo");

        user = userDAO.getUserInfo(identification);
      
       return user;       
    }
    
    public int dropUserProject(String identification, String projectID ){
            
        //Se llama al dao para guardar
        System.out.println("Se insertarà un Usuario");
        
        int result = userDAO.dropUserProject(identification,projectID);

        System.out.println("Se insertò un Usuario");
        
        return result;

    }

}

