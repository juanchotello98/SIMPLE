/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import DataAccess.*;

/**
 *
 * @author SJ
 */
public class EquipmentCoordinatorDao extends UserDao{
    
    
    public EquipmentCoordinatorDao (){
        conexion = new FachadaBD();
    }
    
    //Inserte metodos de EquipmentCoordinator y asi deberian ser los demas daos .'v aunque  el root deberia extender de los 2 ultimos (ignoren lo ultimo)
}
