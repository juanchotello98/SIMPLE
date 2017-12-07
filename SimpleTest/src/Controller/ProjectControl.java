/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccess.ProjectDAO;
import Logic.Project;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class ProjectControl {
    
    ProjectDAO projectDAO;
    
     public ProjectControl(){
        projectDAO = new ProjectDAO();
    }   
     
    public ArrayList<Object[]> listProject(){
    
         ArrayList <Object[]> projects = new ArrayList <>();
         projects = projectDAO.listProject();
         
         return projects;      
    }   
     
    public Project searchProject(String inputValue,String typeSearch){
        
        Project project = new Project();
        
        System.out.println("Se va a Buscar un Proyecto");

        project = projectDAO.searchProject(inputValue, typeSearch);
      
       return project;       
    }
    
    public ArrayList<Object[]> listSearchProject(String inputValue, String typeSearch){
    
         ArrayList <Object[]> projects = new ArrayList <>();
         projects = projectDAO.listSearchProject(inputValue, typeSearch);
         
         return projects;      
    }
     
    public ArrayList<String> loadManager(){
    
         ArrayList <String> managers = new ArrayList<String>();
         managers = projectDAO.loadManager();
         
         return managers;      
    }  
    
    public String getManagerID(String managerName){
        
        String managerID = projectDAO.getManagerID(managerName);
        
        return managerID;
    }
    
    public int insertProject(String identification, String name, String description, String managerID){
            
        Project project = new Project();        

        project.setProjectID(identification);
        project.setName(name);
        project.setDescription(description);
        project.setManagerID(managerID);
        //Se llama al dao para guardar
        System.out.println("Se insertarà un Proyecto");
        
        int result = projectDAO.saveProject(project);

        System.out.println("Se insertò un Proyecto");
        
        return result;

    }
    
    public int updateProject(String code, String identification, String name, String description, String managerID, String state){
            
        Project project = new Project();        

        project.setCode(code);
        project.setProjectID(identification);
        project.setName(name);
        project.setDescription(description);
        project.setManagerID(managerID);
        project.setState(state);
        //Se llama al dao para guardar
        System.out.println("Se insertarà un Proyecto");
        
        int result = projectDAO.updateProject(project);

        System.out.println("Se insertò un Proyecto");
        
        return result;

    }
}
