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
import java.util.ArrayList;
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

        sql_save="INSERT INTO equipment (name, serialNumber, description, state) "
                + "VALUES ('" + equipment.getNameEquipment()+  "', '" +
                equipment.getSerieEquipment() + "', '" + equipment.getDescriptionEquipment() + "', 'Activo')";
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
        
        public Equipment searchEquipment(String inputValue, String typeSearch){
        Equipment equipment = new Equipment();
        String sql_search;
        
        sql_search="SELECT code, name, serialNumber, description, state FROM equipment WHERE "+typeSearch+" ilike '" +inputValue+  "%'";
        
         try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);
            
            
            while(tabla.next()){
                
               equipment.setNumberEquipment(tabla.getString(1));
               equipment.setNameEquipment(tabla.getString(2));
               equipment.setSerieEquipment(tabla.getString(3));     
               equipment.setDescriptionEquipment(tabla.getString(4));
               equipment.setStateEquipment(tabla.getString(5));
              
              System.out.println("ok");
            }         
            return equipment;
         }//fin Buscar
         
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return null;
    }
        
        public ArrayList <Object[]> listEquipment(){
            
        ArrayList <Object[]> inventory = new ArrayList <>();
        String sql_search;
        sql_search="SELECT * from equipment";


        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);

            while(tabla.next()){

               Object[] objectRow = new Object[5];
               
               for(int i=0; i<5; i++){
                   
                   objectRow[i]=tabla.getObject(i+1);  
               }
               
               inventory.add(objectRow);
            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return inventory;
   }
        
        public int updateEquipment(Equipment equipment){
        String sql_update;
        int numFilas=0;

        sql_update="UPDATE equipment Set name='"+equipment.getNameEquipment()+"', serialNumber='"+equipment.getSerieEquipment()+"', description='"+equipment.getDescriptionEquipment()+"',"
                + " state='"+equipment.getStateEquipment()+"'WHERE code='"+equipment.getNumberEquipment()+"'";
        
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
        
        public ArrayList <Object[]> listSearchEquipment(String inputValue, String typeSearch){
            
        ArrayList <Object[]> inventory = new ArrayList <>();
        String sql_search;
        sql_search="SELECT code, name, serialNumber, description, state FROM equipment WHERE "+typeSearch+" ilike '" +inputValue+ "%'";


        try{
            Connection conn= conection.connect();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_search);

            while(tabla.next()){

               Object[] objectRow = new Object[5];
               
               for(int i=0; i<5; i++){
                   
                   objectRow[i]=tabla.getObject(i+1);  
               }
               
               inventory.add(objectRow);
            }

         }
         catch(SQLException e){ 
                         System.out.println(e); 
                         }
         catch(Exception e){
                          System.out.println(e); 
                          }
        return inventory;
   }
} 
