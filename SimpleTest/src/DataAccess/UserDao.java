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
    public void refreshProfile(User user){ // No deberia tener entrada
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
        refreshProject(user);

    }
    
    public void updatePassword(User user){
        String sql_select;
        sql_select="UPDATE member SET password = '"+user.getPassword()+"' WHERE userCode = '"+user.getUserCode()+"';";
        try{
        Connection conn= conexion.conectar();
        //System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        refreshProfile(user);
    }

    // METODO VER PERFIL LISTO


    public void editProfile(User user, String phone){
        String sql_select;
        sql_select="UPDATE member SET phone ='" + phone +"' WHERE userCode='"+user.getUserCode()+"';";
        try{
        Connection conn= conexion.conectar();
        System.out.println("Update in the bd");
        Statement sentencia = conn.createStatement();
        sentencia.executeUpdate(sql_select);

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        refreshProfile(user);
    }

    // Metodo listo 

    public void refreshProject(User user){//ENTRADA ARRAY LIST
        // NO OLVIDAR AGREGAR CONDICION DE CONTAR SI EL USUARIO YA TIENE PROYECTOS, SI ES ASI ELIMINARLOS 
        // Y DE JAR ARRAYLIST EN CEROS, SI NO CORRER NORMAL
        if(user.getProject().size()!=0){
            while(user.getProject().size()!=0){
                int aux = 0;
                user.deleteProject(aux);
            }
        }
        String sql_select;
        sql_select="SELECT projectCode, name, projectDescription, projectManager FROM project NATURAL JOIN user_project WHERE userCode='"+user.getUserCode()+"';";

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

               user.updateProjects(project);

            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
    }
    
    public String changePassword(User user, String currentPassword, String newPassword, String newPassword1){
        String finalMessage;
        if(currentPassword.equals(user.getPassword())){
            if(newPassword.equals(newPassword1)){
                user.setPassword(newPassword);
                System.out.println("Debio cambiar: "+user.getPassword());
                updatePassword(user);
                finalMessage = "Cambio de Contraseña exitoso";
            } else {
                finalMessage = "No coincide las nuevas contraseñas, vuelva a intentarlo";
            }
        } else {
            finalMessage = "Error, esta no es su contraseña actual.";
        }
        
        return finalMessage;
    }

}
