/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;

/**
 *
 * @author Preet
 */
public class DatabaseDemo {
    public static void main (String[] args) throws SQLException{
         Database.openConnection();
         Database.closeConnection();
    }
    
    
}
