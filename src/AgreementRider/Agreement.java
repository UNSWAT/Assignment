/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgreementRider;

import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Preet
 */
public class Agreement {


    private SimpleStringProperty carType,pickupTime,memberDriver;
    private SimpleIntegerProperty agreementId,offerid,postcodeto;
    private LocalDate agreementDate;
    
   public Agreement(String carType, String pickupTime, String memberDriver, int agreementId, int offerid, int postcodeto, LocalDate agreementDate ){
       
   }
    
    
    
}
