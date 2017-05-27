/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offerPosting;

import seekPosting.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import Database.Database;
import static Database.Database.con;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import memberPayment.MemberPaymentController;
import signup.RegisterPageController;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class memberOfferController implements Initializable {
     ObservableList<String> time = FXCollections.observableArrayList("00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30", "14:00","14:30","15:00", "15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30");
     ObservableList<String> vehicle = FXCollections.observableArrayList("Sedan","Coupe","Convertible","Minivan","Truck","SUV","Motorcycle");
     ObservableList<String> passengers = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
     
     @FXML
    private TextField startPC;
    @FXML
    private ComboBox timeFrom;
    @FXML
    private ComboBox timeto;
    @FXML
    private TextField endPC;
    
    @FXML
    private ComboBox vehicleType;
    @FXML
    private Label username;
    @FXML
    private Label setMessage;
    @FXML
    private ComboBox noPassenger;
    @FXML
    private Label offerComplete;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeFrom.setValue("00:00");
        timeFrom.setItems(time);
        timeto.setValue("00:00");
        timeto.setItems(time);
        vehicleType.setValue("Sedan");
        vehicleType.setItems(vehicle);
        noPassenger.setValue("1");
        noPassenger.setItems(passengers);
    }    
    
    public void setUser(String user){
        username.setText(user);
    }

    

    @FXML
    private void createOffer(ActionEvent event) {
        Database.openConnection();
        PreparedStatement insertOffer;
        PreparedStatement insertCar;
        
        try{
            boolean check = false;
            while (check == false){
                if (startPC.getText().equals("")){
                    setMessage.setText("Please enter the Postcode you are travelling from");
                    check = true;
                }
                
                else if (endPC.getText().equals("")){
                    setMessage.setText("Please enter your destination postcode");
                    check = true;
                }
                
                else if (!startPC.getText().equals("")&&!endPC.getText().equals("")){
                    int startpc = Integer.parseInt(startPC.getText());
                    int endpc = Integer.parseInt(endPC.getText());
                    int quota = Integer.parseInt(noPassenger.getSelectionModel().getSelectedItem().toString());
                    java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime()); 
                    insertOffer=con.prepareStatement("INSERT INTO OFFER(MEMBER_USERNAME,POSTCODE_FROM,POSTCODE_TO,TIME_FROM,TIME_TO,QUOTA,CARTYPE,DATE_OFFER,STATUS) VALUES (?,?,?,?,?,?,?,?,?)");
                    insertOffer.setString(1,username.getText());
                    insertOffer.setInt(2,startpc);
                    insertOffer.setInt(3,endpc);
                    insertOffer.setString(4,timeFrom.getSelectionModel().getSelectedItem().toString());
                    insertOffer.setString(5,timeto.getSelectionModel().getSelectedItem().toString());
                    insertOffer.setInt(6,quota);   
                    insertOffer.setString(7,vehicleType.getSelectionModel().getSelectedItem().toString());
                    insertOffer.setTimestamp(8, date);
                    insertOffer.setString(9,"Pending");
                    insertOffer.execute();
                    insertOffer.close();

                    insertCar= con.prepareStatement("INSERT INTO CARS(CAR_TYPE, MEMBER_USERNAME) VALUES (?,?)");
                    insertCar.setString(1,vehicleType.getSelectionModel().getSelectedItem().toString());
                    insertCar.setString(2,username.getText());
                    insertCar.execute();
                    insertCar.close();
                    check=true;
                    offerComplete.setText("Your offer has been successfully entered. Please click on my offers to see your current offers.");
            
                }
            }
            
        Database.closeConnection();    
            
        } catch (SQLException ex) { 
             Logger.getLogger(memberOfferController.class.getName()).log(Level.SEVERE, null, ex);
             offerComplete.setText("Please make sure you have entered details correctly");
         } 
    }

    @FXML
    private void Home(ActionEvent event) {
    }

    @FXML
    private void myProfile(ActionEvent event) {
    }

    @FXML
    private void MyAgreements(ActionEvent event) {
        
    }

    @FXML
    private void logOut(ActionEvent event) {
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberLogin2/Login.fxml"));

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane)loader.load()));
          
            stage.show(); 

        } catch (IOException ex) {
            Logger.getLogger(RegisterPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void myOffers(ActionEvent event) {
    }
    
    
    
}
