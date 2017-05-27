/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgreementRider;

import java.time.LocalDate;
import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Preet
 */
public class Agreement {


    private SimpleStringProperty carType,pickupTime,memberDriver;
    private SimpleIntegerProperty agreementId,offerid,postcodefrom;
    private Date agreementDate;
    
   public Agreement(String carType, String pickupTime, String memberDriver, int agreementId, int offerid, int postcodefrom, Date agreementDate ){
       this.carType = new SimpleStringProperty(carType);
       this.pickupTime = new SimpleStringProperty(pickupTime);
       this.memberDriver = new SimpleStringProperty(memberDriver);
       this.agreementId = new SimpleIntegerProperty(agreementId);
       this.offerid = new SimpleIntegerProperty(offerid);
       this.postcodefrom = new SimpleIntegerProperty(postcodefrom);
       this.agreementDate = agreementDate;
       
   }

    public Date getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(Date agreementDate) {
        this.agreementDate = agreementDate;
    }
   
   public String getCarType(){
       return carType.get();
   }
   
   public String getPickupTime(){
       return pickupTime.get();
   }
   
   public String getMemberDriver(){
       return memberDriver.get();
   }
   
   public int getAgreementID(){
       return agreementId.get();
   }
   
   public int getOfferId(){
       return offerid.get();
   }
   
   public int getPostCodeTo(){
       return postcodefrom.get();
   }
   
   public void setCarType(String value){
       carType.set(value);
   }
   
   public void setPickupTime(String value){
       pickupTime.set(value);
   }
   
   public void setMemberDriver(String value){
       memberDriver.set(value);
   }
   
   public void setAgreementId(int value){
       agreementId.set(value);
   }
   
   public void setOfferId(int value){
       offerid.set(value);
   }
   
   public void setPostCodeTo(int value){
       postcodefrom.set(value);
   }
   
   public StringProperty carTypeProperty(){
       return carType;
   }
   
   public StringProperty pickupTimeProperty(){
       return pickupTime;
   }
   
   public StringProperty memberDriverProperty(){
       return memberDriver;
   }
   
   public IntegerProperty agreementIdProperty(){
       return agreementId;
   }
   
   public IntegerProperty offeridProperty(){
       return offerid;
   } 
   
    public IntegerProperty postcodeto(){
        return postcodefrom;
    }
    
    
   
    
   
    
    
    
}
