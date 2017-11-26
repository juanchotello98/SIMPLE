/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.project;
import Logic.*;
import DataAccess.*;
/**
 *
 * @author SJ
 */
public class SIMPLEPROJECT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        User user = new User("1632645");
        UserDao objDao = new UserDao();
        
        objDao.refreshProfile(user);
        System.out.println("Se logea usuario con codigo 1632645");
        System.out.println("Se muestra informacion del usuario");
        System.out.println("CODIGO = "+user.getUserCode()+", NOMBRE = "+user.getName()+" TELEFONO = "+user.getPhone());
        
        objDao.listProject(user);
        
        System.out.println("CODIGO PROYECTO -   NOMBRE  -   DESCRIPCION -   DIR PROYECTO");
        for(int i=0; i<user.projectSize();i++){
            System.out.println(user.viewProject(i).getProjectCode()+"       "+user.viewProject(i).getName()+"   "+user.viewProject(i).getDescription()+"    "+user.viewProject(i).getProjectManager());
        }
    }
    
}
