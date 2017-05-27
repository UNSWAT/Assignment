/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberProfile;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Yu Bernice
 */
public class Member {
     private SimpleStringProperty memberusername,password,fname,lname,email,mobile,
             haddress,hsuburb,hpostcode,hstate,waddress,wsuburb,wpostcode,wstate,
             ccnumber,ccexpirymonth,ccexpiryyear,corporatemember,companyname,
             membertype;
    //private SimpleIntegerProperty postcodefrom, postcodeto,Quota, Offerid;
    
    
    
    
    public Member(String memberusername, String password, String fname, String lname, String email, String mobile,
            String haddress, String hsuburb,String hpostcode,String hstate,String waddress,String wsuburb,
            String wpostcode,String wstate,String ccnumber ,String ccexpirymonth,String ccexpiryyear,String corporatemember,
             String companyname, String membertype) {
        this.memberusername = new SimpleStringProperty(memberusername);
        this.password = new SimpleStringProperty(password);
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.email = new SimpleStringProperty(email);
        this.mobile = new SimpleStringProperty(mobile);
        this.haddress = new SimpleStringProperty(haddress);
        this.hsuburb = new SimpleStringProperty(hsuburb);
        this.hpostcode = new SimpleStringProperty(hpostcode);
        this.hstate = new SimpleStringProperty(hstate);
        this.waddress = new SimpleStringProperty(waddress);
        this.wsuburb = new SimpleStringProperty(wsuburb);
        this.wpostcode = new SimpleStringProperty(wpostcode);
        this.wstate = new SimpleStringProperty(wstate);
        this.ccnumber = new SimpleStringProperty(ccnumber);
        this.ccexpirymonth = new SimpleStringProperty(ccexpirymonth);
        this.ccexpiryyear = new SimpleStringProperty(ccexpiryyear); 
        this.corporatemember = new SimpleStringProperty(corporatemember);
        this.companyname = new SimpleStringProperty(companyname);
        this.membertype = new SimpleStringProperty(membertype);
        
        
        
    }

    public SimpleStringProperty getMemberusername() {
        return memberusername;
    }

    public void setMemberusername(SimpleStringProperty memberusername) {
        this.memberusername = memberusername;
    }

    public SimpleStringProperty getPassword() {
        return password;
    }

    public void setPassword(SimpleStringProperty password) {
        this.password = password;
    }

    public SimpleStringProperty getFname() {
        return fname;
    }

    public void setFname(SimpleStringProperty fname) {
        this.fname = fname;
    }

    public SimpleStringProperty getLname() {
        return lname;
    }

    public void setLname(SimpleStringProperty lname) {
        this.lname = lname;
    }

    public SimpleStringProperty getEmail() {
        return email;
    }

    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }

    public SimpleStringProperty getMobile() {
        return mobile;
    }

    public void setMobile(SimpleStringProperty mobile) {
        this.mobile = mobile;
    }

    public SimpleStringProperty getHaddress() {
        return haddress;
    }

    public void setHaddress(SimpleStringProperty haddress) {
        this.haddress = haddress;
    }

    public SimpleStringProperty getHsuburb() {
        return hsuburb;
    }

    public void setHsuburb(SimpleStringProperty hsuburb) {
        this.hsuburb = hsuburb;
    }

    public SimpleStringProperty getHpostcode() {
        return hpostcode;
    }

    public void setHpostcode(SimpleStringProperty hpostcode) {
        this.hpostcode = hpostcode;
    }

    public SimpleStringProperty getHstate() {
        return hstate;
    }

    public void setHstate(SimpleStringProperty hstate) {
        this.hstate = hstate;
    }

    public SimpleStringProperty getWaddress() {
        return waddress;
    }

    public void setWaddress(SimpleStringProperty waddress) {
        this.waddress = waddress;
    }

    public SimpleStringProperty getWsuburb() {
        return wsuburb;
    }

    public void setWsuburb(SimpleStringProperty wsuburb) {
        this.wsuburb = wsuburb;
    }

    public SimpleStringProperty getWpostcode() {
        return wpostcode;
    }

    public void setWpostcode(SimpleStringProperty wpostcode) {
        this.wpostcode = wpostcode;
    }

    public SimpleStringProperty getWstate() {
        return wstate;
    }

    public void setWstate(SimpleStringProperty wstate) {
        this.wstate = wstate;
    }

    public SimpleStringProperty getCcnumber() {
        return ccnumber;
    }

    public void setCcnumber(SimpleStringProperty ccnumber) {
        this.ccnumber = ccnumber;
    }

    public SimpleStringProperty getCcexpirymonth() {
        return ccexpirymonth;
    }

    public void setCcexpirymonth(SimpleStringProperty ccexpirymonth) {
        this.ccexpirymonth = ccexpirymonth;
    }

    public SimpleStringProperty getCcexpiryyear() {
        return ccexpiryyear;
    }

    public void setCcexpiryyear(SimpleStringProperty ccexpiryyear) {
        this.ccexpiryyear = ccexpiryyear;
    }

    public SimpleStringProperty getCorporatemember() {
        return corporatemember;
    }

    public void setCorporatemember(SimpleStringProperty corporatemember) {
        this.corporatemember = corporatemember;
    }

    public SimpleStringProperty getCompanyname() {
        return companyname;
    }

    public void setCompanyname(SimpleStringProperty companyname) {
        this.companyname = companyname;
    }

    public SimpleStringProperty getMembertype() {
        return membertype;
    }

    public void setMembertype(SimpleStringProperty membertype) {
        this.membertype = membertype;
    }
    
}
