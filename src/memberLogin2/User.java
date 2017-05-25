/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberLogin2;

/**
 *
 * @author Preet
 */
public class User {
    public static String username;
    
    public User(String userName){
        this.username = userName;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }
    
    
    
}
