/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberProfile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yu Bernice
 */
public class Member {

    private SimpleStringProperty memberusername, password, fname, lname, email, mobile,
            haddress, hsuburb, hstate, waddress, wsuburb, wstate, membertype;
    private SimpleIntegerProperty hpostcode, wpostcode ;

    public Member(String memberusername, String password, String fname, String lname, String email, String mobile,
            String haddress, String hsuburb, int hpostcode, String hstate, String waddress, String wsuburb, int wpostcode, String wstate) {
        this.memberusername = new SimpleStringProperty(memberusername);
        this.password = new SimpleStringProperty(password);
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.email = new SimpleStringProperty(email);
        this.mobile = new SimpleStringProperty(mobile);
        this.haddress = new SimpleStringProperty(haddress);
        this.hsuburb = new SimpleStringProperty(hsuburb);
        this.hpostcode = new SimpleIntegerProperty(hpostcode);
        this.hstate = new SimpleStringProperty(hstate);
        this.waddress = new SimpleStringProperty(waddress);
        this.wsuburb = new SimpleStringProperty(wsuburb);
        this.wpostcode = new SimpleIntegerProperty(wpostcode);
        this.wstate = new SimpleStringProperty(wstate);

    }
    public Member(String fname, String lname, String email, String mobile,
            String haddress, String hsuburb,int hpostcode,String hstate, String membertype) {
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.email = new SimpleStringProperty(email);
        this.mobile = new SimpleStringProperty(mobile);
        this.haddress = new SimpleStringProperty(haddress);
        this.hsuburb = new SimpleStringProperty(hsuburb);
        this.hpostcode = new SimpleIntegerProperty(hpostcode);
        this.hstate = new SimpleStringProperty(hstate);
        this.membertype = new SimpleStringProperty(membertype);
        
    }
    
    public String getMembertype(){
        return membertype.get();
    }
    
    public void setMembertype(String value){
        membertype.setValue(value);
    }
    
    public int getHpostcode() {
        return hpostcode.get();
    }
    
    public int getWpostcode() {
        return wpostcode.get();
    }
    
    public String getMemberusername() {
        return memberusername.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getFname() {
        return fname.get();
    }

    public String getLname() {
        return lname.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getMobile() {
        return mobile.get();
    }

    public String getHaddress() {
        return haddress.get();
    }

    public String getHsuburb() {
        return hsuburb.get();
    }

    public String getHstate() {
        return hstate.get();
    }

    public String getWaddress() {
        return waddress.get();
    }

    public String getWsuburb() {
        return wsuburb.get();
    }

    public String getWstate() {
        return wstate.get();
    }

    public void setWPostcode(int value) {
        wpostcode.set(value);
    }
    
    public void setHPostcode(int value) {
        hpostcode.set(value);
    }
    
    public void setMemberusername(String value) {
        memberusername.set(value);
    }

    public void setPassword(String value) {
        password.set(value);
    }

    public void setFname(String value) {
        fname.set(value);
    }

    public void setLname(String value) {
        lname.set(value);
    }

    public void setEmail(String value) {
        email.set(value);
    }

    public void setMobile(String value) {
        mobile.set(value);
    }

    public void setHaddress(String value) {
        haddress.set(value);
    }

    public void setHsuburb(String value) {
        hsuburb.set(value);
    }

    public void setHstate(String value) {
        hstate.set(value);
    }

    public void setWaddress(String value) {
        waddress.set(value);
    }

    public void setWsuburb(String value) {
        wsuburb.set(value);
    }

    public void setWstate(String value) {
        wstate.set(value);
    }

    public StringProperty memberusername() {
        return memberusername;
    }

    public StringProperty password() {
        return password;
    }

    public StringProperty fname() {
        return fname;
    }

    public StringProperty lname() {
        return lname;
    }

    public StringProperty email() {
        return email;
    }

    public StringProperty mobile() {
        return mobile;
    }

    public StringProperty haddress() {
        return haddress;
    }

    public StringProperty hsuburb() {
        return hsuburb;
    }

    public StringProperty hstate() {
        return hstate;
    }

    public StringProperty waddress() {
        return waddress;
    }

    public StringProperty wsuburb() {
        return wsuburb;
    }

    public StringProperty wstate() {
        return wstate;
    }
    
    public IntegerProperty wpostcode() {
        return wpostcode;
    }
    
    public IntegerProperty hpostcode() {
        return hpostcode;
    }
    
    public StringProperty membertype(){
        return membertype;
    }

}
