/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suber.Models;

/**
 *
 * @author sunyifei
 */
public class PCustomer extends User{
    

    public PCustomer(String ID, String Name, int userType, String gender, 
            int age, String homeAddr, String compAddr, long homepCode, 
            long homeNum, long hpNum, String email, String vehicle) {
        super(ID, Name, userType, gender, age, homeAddr, compAddr, 
                homepCode, homeNum, hpNum, email, vehicle);
    }
    
    
}
