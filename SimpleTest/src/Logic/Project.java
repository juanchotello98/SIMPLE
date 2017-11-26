/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author SJ
 */
public class Project {
    //Attributes
    String projectCode;
    String name;
    String description;
    String projectManager;
    ArrayList <User> members;


    //Builder
    public Project(){
        members = new ArrayList <> ();
    }
    
    public void getMembers(User user){
        members.add(user);
    }
    
    public int projectSize(){
        return members.size();
    }
    
    public User viewMember(int posicion){
        return members.get(posicion);
    }

    //Methods

    public String getProjectCode(){
            return projectCode;
    }

    public String getName(){
            return name;
    }

    public String getDescription(){
            return description;
    }

    public String getProjectManager(){
            return projectManager;
    }


    public void setProjectCode(String projectCode){
            this.projectCode=projectCode;
    }

    public void setName(String name){
            this.name=name;
    }

    public void setDescription(String description){
            this.description=description;
    }

    public void setProjectManager(String projectManager){
            this.projectManager=projectManager;
    }
}
