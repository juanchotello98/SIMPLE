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
        System.out.println("Iniciando cambio de contraseña, contraseña actual: "+user.getPassword());
        System.out.println("Cambiemole por 'aloha'");
        System.out.println(objDao.changePassword(user, "aloha", "sifunciona", "sifunciona"));
        System.out.println("Su contraseña actual es: "+user.getPassword());
    }
    
}
