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
    
    private String code;
    private String identification;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String charge;
    private String typeID;
    private String phone;
    private String state;
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
    
    public String getCode(){
        return code;
    } 
    
    public String getIdentification(){
        return identification;
    }

    public String getFirstName(){
            return firstName;
    }
    
    public String getLastName(){
            return lastName;
    }

    public String getEmail(){
            return email;
    }

    public String getCharge(){
            return charge;
    }

    public String getTypeID(){
            return typeID;
    }

    public String getPhone(){
            return phone;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getState(){
        return state;
    }
    
    public void setCode(String code){
        this.code=code;
    }
    
    public void setPassword(String password){
        this.password=password;
    }

    public void setIdentification(String identification){
        this.identification=identification;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public void setEmail(String email){
            this.email=email;
    }

    public void setCharge(String charge){
            this.charge=charge;
    }

    public void setTypeID(String typeID){
            this.typeID=typeID;
    }

    public void setPhone(String phone){
            this.phone=phone;
    }
    
    public void setState(String state){
            this.state=state;
    }
}

