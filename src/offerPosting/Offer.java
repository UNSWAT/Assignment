/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offerPosting;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Preet
 */
public class Offer {

    
    private SimpleStringProperty memberUsername, timefrom,timeto,cartype;
    private SimpleIntegerProperty postcodefrom, postcodeto,Quota, Offerid;
    
    
    public Offer(String memberUsername, String timefrom, String timeto, String cartype, int postcodefrom, int postcodeto, int Quota, int Offerid) {
        this.memberUsername = new SimpleStringProperty(memberUsername);
        this.timefrom = new SimpleStringProperty(timefrom);
        this.timeto = new SimpleStringProperty(timeto);
        this.cartype = new SimpleStringProperty(cartype);
        this.postcodefrom = new SimpleIntegerProperty(postcodefrom);
        this.postcodeto = new SimpleIntegerProperty(postcodeto);
        this.Quota = new SimpleIntegerProperty(Quota);
        this.Offerid = new SimpleIntegerProperty(Offerid);
        
    }
    
    public int getOfferid(){
        return Offerid.get();
    }
    
    public void setOfferid(int value){
        Offerid.set(value);
    }
    
    public String getmemberUsername(){
        return memberUsername.get();
    }
    
    public String gettimefrom(){
        return timefrom.get();
    }
    
    public String gettimeto(){
        return timeto.get();
    }
    
    public String getcartype(){
        return cartype.get();
    }
    
    public int getpostcodefrom(){
        return postcodefrom.get();
    }
    
    public int getpostcodeto(){
        return postcodeto.get();
    }
    
    public int getQuota(){
        return Quota.get();
    }
    
    public void setmemberUsername(String value){
        memberUsername.set(value);
    }
    
    public void settimefrom(String value){
        timefrom.set(value);
    }
    
    public void settimeto(String value){
        timeto.set(value);
    }
    
    public void setcartype(String value){
        cartype.set(value);
    }
    
    public void setpostcodefrom(int value){
        postcodefrom.set(value);
    }
    
    public void setpostcodeto(int value){
        postcodeto.set(value);
    }
    
    public void setQuota(int value){
        Quota.set(value);
    }
    
    public StringProperty memberUsernameProperty(){
        return memberUsername;
    }
    
    public StringProperty timefromProperty(){
        return timefrom;
    }
    
    public StringProperty timetoProperty(){
        return timeto;
    }
    
    public StringProperty cartypeProperty(){
        return cartype;
    }
    
    public IntegerProperty postcodefromProperty(){
        return postcodefrom;
    }
    
    public IntegerProperty postcodetoProperty(){
        return postcodeto;
    }
    
    public IntegerProperty QuotaProperty(){
        return Quota;
    }

    public IntegerProperty OfferidProperty(){
        return Offerid;
    }
    


   
    
}
