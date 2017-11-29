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
public class User {
    
    private String userID;
    private String userCode;
    private String password;
    private String name;
    private String email;
    private String charge;
    private String cedula;
    private String phone;
   // private ArrayList < Project > myProjects;
    //private ArrayList < Equipment > my

    // AGREGAR ATRIBUTOS PROYECTO ARRAYLIST


    //Builder
    public User(){
        //this.userCode=userCode;
        //myProjects = new ArrayList <>();
    }

    //Methods
    
   /* public ArrayList getProject(){
        return myProjects;
    }
    
    public void deleteProjects(){
        myProjects.removeAll(myProjects);
    }
    
    public int projectSize(){
        return myProjects.size();
    }
    
    public void updateProjects(Project project){
        myProjects.add(project);
    }
    
    public Project viewProject(int posicion){
        return myProjects.get(posicion);
    }*/
    
    public String getUserID(){
        return userID;
    } 
    
    public String getUserCode(){
        return userCode;
    }

    public String getName(){
            return name;
    }

    public String getEmail(){
            return email;
    }

    public String getCharge(){
            return charge;
    }

    public String getCedula(){
            return cedula;
    }

    public String getPhone(){
            return phone;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setUserID(String userID){
        this.userID=userID;
    }
    
    public void setPassword(String password){
        this.password=password;
    }

    public void setUserCode(String userCode){
            this.userCode=userCode;
    }

    public void setName(String name){
            this.name=name;
    }

    public void setEmail(String email){
            this.email=email;
    }

    public void setCharge(String charge){
            this.charge=charge;
    }

    public void setCedula(String cedula){
            this.cedula=cedula;
    }

    public void setPhone(String phone){
            this.phone=phone;
    }
}

