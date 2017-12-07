/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Logic.Project;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class ProjectDAO {
    Conection conection;
    
    
    public ProjectDAO(){
        conection = new Conection();
    }
    
    public ArrayList <Object[]> listProject(){
            
        ArrayList <Object[]> projects = new ArrayList <>();
        String sql_search;
        sql_search="select project.code, projectID, name, projectDescription, member.firstname||' '||member.lastName, project.state from project inner join member on projectManager=member.identification;";


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
               
               projects.add(objectRow);
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
    
    public Project searchProject(String inputValue, String typeSearch){
        Project project = new Project();
        String sql_search;
        
        if(typeSearch.equals("namemanager")){
        sql_search="select project.code, projectID, name, projectDescription, member.firstname||' '||member.lastName as nameManager, project.state from project inner join member on projectManager=member.identification WHERE member.firstname||' '||member.lastName ilike '%"+inputValue+"%'";
        }
        else{sql_search="select project.code, projectID, name, projectDescription, member.firstname||' '||member.lastName as nameManager, project.state from project inner join member on projectManager=member.identification WHERE project."+typeSearch+" ilike '%"+inputValue+"%'";
        }
        
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
            
            
            while(tabla.next()){
                
               project.setCode(tabla.getString(1));
              
              System.out.println("ok");
            }         
            return project;
         }//fin Buscar
         
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return null;
    }
    
    public ArrayList <Object[]> listSearchProject(String inputValue, String typeSearch){
            
        ArrayList <Object[]> projects = new ArrayList <>();
        String sql_search;
        
        if(typeSearch.equals("namemanager")){
        sql_search="select project.code, projectID, name, projectDescription, member.firstname||' '||member.lastName as nameManager, project.state from project inner join member on projectManager=member.identification WHERE member.firstname||' '||member.lastName ilike '%"+inputValue+"%'";
        }
        else{sql_search="select project.code, projectID, name, projectDescription, member.firstname||' '||member.lastName as nameManager, project.state from project inner join member on projectManager=member.identification WHERE project."+typeSearch+" ilike '%"+inputValue+"%'";
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
               
               projects.add(objectRow);
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
    
    public ArrayList <String> loadManager(){
            
        ArrayList <String> managers = new ArrayList <String>();
        String sql_search;
        sql_search="select firstname||' '||lastName as managername from member Where charge='Lider de Proyecto'";


        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);

            while(tabla.next()){
       
            managers.add(tabla.getString("managername"));
            }
         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return managers;
   }
    
    public String getManagerID(String managerName){
        
        String managerCode="";
        String sql_search;
        
        sql_search="select identification from member WHERE member.firstname||' '||member.lastName = '"+managerName+"'";
        
        
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
 
            while(tabla.next()){
                
               managerCode=(tabla.getString(1));
              
              System.out.println("ok");
            }         
         }
         
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         
         return managerCode;
    }     
    
    public int saveProject(Project project){
        String sql_save;
        int numFilas=0;

        sql_save="INSERT INTO project (projectID, name, projectDescription, projectManager, state) "
                + "VALUES ('" + project.getProjectID()+  "', '" +
                project.getName()+ "', '" + project.getDescription()+ "', '" + project.getProjectManager()+ "','Activo')";
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
    
    public int updateProject(Project project){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE project Set projectID='"+project.getProjectID()+"', name='"+project.getName()+"', projectDescription='"+project.getDescription()+"',"
                + " projectManager='"+project.getProjectManager()+"', state='"+project.getState()+"'WHERE code='"+project.getProjectCode()+"'";
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

