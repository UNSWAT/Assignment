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
public class CorporateMember extends Corporate{

    public CorporateMember(String id, String companyName, String companyAddr, 
            long companyPhoneNum, long companyPCode, int customerType) {
        super(id, companyName, companyAddr, companyPhoneNum, companyPCode, customerType);
    }
    
     
}
