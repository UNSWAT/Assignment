/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Preet
 */
public class Database {
    
    public static Connection con;
    public static String database = "jdbc:h2:./INFS2605db;create=true";
    
    public static void setDatabase(String database){
        Database.database = database;
    }
    
    public static void openConnection(){
        try{
            con = DriverManager.getConnection(database);
            System.out.println("Connected to Database " + database);
        }
        catch (SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void closeConnection(){
        try{
            if(con != null){
                con.close();
           }
            System.out.println("Disconnected from Database " + database);
        } catch (SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE,null,ex);    
        }
            
           
        }
    
    
    
    
    }
    


