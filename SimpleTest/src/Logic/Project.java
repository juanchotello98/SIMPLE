/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Diego
 */
public class Project {
    
    private String code;
    private String projectID;
    private String name;
    private String description;
    private String managerID;
    private String state;
    
    
    public Project(){}
    
    //Methods

    public String getProjectCode(){
        return code;
    }
    
    public String getProjectID(){
        return projectID;
    }

    public String getName(){
            return name;
    }

    public String getDescription(){
            return description;
    }

    public String getProjectManager(){
            return managerID;
    }
    
    public String getState(){
            return state;
    }

    public void setCode(String code){
            this.code=code;
    }
    
    public void setProjectID(String projectID){
            this.projectID=projectID;
    }

    public void setName(String name){
            this.name=name;
    }

    public void setDescription(String description){
            this.description=description;
    }

    public void setManagerID(String managerID){
            this.managerID=managerID;
    }
    
    public void setState(String state){
            this.state=state;
    }
}
