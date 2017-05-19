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
public class Corporate {
    
    private String id;
    private String companyName;
    private String companyAddr;
    private long companyPhoneNum;
    private long companyPCode;
    private int customerType;

    public Corporate(String id, String companyName, String companyAddr, 
            long companyPhoneNum, long companyPCode, int customerType) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddr = companyAddr;
        this.companyPhoneNum = companyPhoneNum;
        this.companyPCode = companyPCode;
        this.customerType = customerType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public long getCompanyPhoneNum() {
        return companyPhoneNum;
    }

    public void setCompanyPhoneNum(long companyPhoneNum) {
        this.companyPhoneNum = companyPhoneNum;
    }

    public long getCompanyPCode() {
        return companyPCode;
    }

    public void setCompanyPCode(long companyPCode) {
        this.companyPCode = companyPCode;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }
    
    
    
    
}
