/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Logic.Equipment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class EquipmentDAO {
    
    Conection conection;
    
    public  EquipmentDAO(){
        
        conection = new Conection();
    }
    
    
        public int saveEquipment(Equipment equipment){
        String sql_save;
        int numFilas=0;

        sql_save="INSERT INTO equipos (Nombre, CodigoBarras, NumeroSerie, Descripcion, Estado) "
                + "VALUES ('" + equipment.getNameEquipment()+  "', '" +
                equipment.getBarcodeEquipment() + "', '" + equipment.getSerieEquipment() + "', '" +
                equipment.getDescriptionEquipment() + "', 'Activo')";
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
        
        
        public Equipment searchEquipment(String numberEquipment){
        Equipment equipment = new Equipment();
        String sql_search;
        
        sql_search="SELECT codigo, nombre, codigoBarras, numeroSerie, descripcion, estado FROM  equipos WHERE codigo='" +numberEquipment+  "'";
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
            
            
            while(tabla.next()){
                
               equipment.setNumberEquipment(tabla.getString(1));
               equipment.setNameEquipment(tabla.getString(2));
               equipment.setBarcodeEquipment(tabla.getString(3));
               equipment.setSerieEquipment(tabla.getString(4));     
               equipment.setDescriptionEquipment(tabla.getString(5));
               equipment.setStateEquipment(tabla.getString(6));
              
              System.out.println("ok");
            }         
            return equipment;
         }//fin Buscar
         
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return null;
    }
        
        
        public int updateEquipment(Equipment equipment){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE equipos Set Nombre='"+equipment.getNameEquipment()+"', CodigoBarras='"+equipment.getBarcodeEquipment()+"', "
                + "NumeroSerie='"+equipment.getSerieEquipment()+"', Descripcion='"+equipment.getDescriptionEquipment()+"',"
                + " Estado='"+equipment.getStateEquipment()+"'WHERE codigo='"+equipment.getNumberEquipment()+"'";
        
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
