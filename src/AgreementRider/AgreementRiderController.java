/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgreementRider;

import SeekTableView.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import offerPosting.Offer;
import Database.Database;
import static Database.Database.con;
import Database.OtherStaticVariables;
import static java.lang.Integer.parseInt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import memberLogin2.User;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class AgreementRiderController implements Initializable {

    @FXML
    private TableView<Offer> offers;
    private TableColumn<Offer, String> memberUsername;
    private TableColumn<Offer, String> TimeFrom;
    private TableColumn<Offer, String> TimeTo;
    private TableColumn<Offer, Integer> PostcodeFrom;
    @FXML
    private TableColumn<Offer, Integer> PostcodeTo;
    @FXML
    private TableColumn<Offer, String> CarType;
    @FXML
    private TableColumn<Offer, Integer> Quota;
    
    @FXML
    private TableColumn<Offer, Integer> OfferId;
    
    
    

    /**
     * Initializes the controller class.
     */
    
   
    private ObservableList<Offer> data;
    private PreparedStatement getOffers;
    @FXML
    private Label username;

    
    @FXML
    private Label timeto;
    @FXML
    private Label postcodefrom;
    @FXML
    private Label postcodeto;
    @FXML
    private Label quota;
    private Label message;
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(User.getUsername());
        try{
            Database.openConnection();
            data=FXCollections.observableArrayList();
            getOffers = con.prepareStatement("select MEMBER_USERNAME,POSTCODE_FROM,POSTCODE_TO, TIME_FROM, TIME_TO, QUOTA, CARTYPE, OFFER_ID from OFFER WHERE STATUS = 'Pending' ");
//            getOffers.setInt(1,OtherStaticVariables.getQuota() );
//            getOffers.setString(2, username.getText());
//            getOffers.setInt(3, OtherStaticVariables.getPostcodefrom());
//            getOffers.setString(4, OtherStaticVariables.getTimefrom());
           
            ResultSet rs = getOffers.executeQuery();
            
            while(rs.next()){
                data.add(new Offer(rs.getString("MEMBER_USERNAME"),rs.getString("TIME_FROM"),rs.getString("TIME_TO"),rs.getString("CARTYPE"),rs.getInt("POSTCODE_FROM"),rs.getInt("POSTCODE_TO"),rs.getInt("QUOTA"),rs.getInt("OFFER_ID")));
            }
            
//            ResultSet result = getOffers.executeQuery();
//            while(result.next()){
//                String userName = result.getString("MEMBER_USERNAME");
//                String timeFrom = result.getString("TIME_FROM");
//                String timeTo = result.getString("TIME_TO");
//                String carType = result.getString("Cartype");
//                int postcodeFrom = result.getInt("POSTCODE_FROM");
//                int postcodeTo =result.getInt("POSTCODE_TO");
//                int Quota = result.getInt("QUOTA");
//                Offer offer = new Offer(userName, timeFrom, timeTo,carType,postcodeFrom,postcodeTo,Quota);
//                System.out.println(offer.getMemberUsername());
//                System.out.println(offer.getTimefrom());
//                data.add(offer);
           //}
           
            memberUsername.setCellValueFactory(new PropertyValueFactory<>("memberUsername"));
            TimeFrom.setCellValueFactory(new PropertyValueFactory<>("timefrom"));
            TimeTo.setCellValueFactory(new PropertyValueFactory<>("timeto"));
            PostcodeFrom.setCellValueFactory(new PropertyValueFactory<>("postcodefrom"));
            PostcodeTo.setCellValueFactory(new PropertyValueFactory<>("postcodeto"));
            CarType.setCellValueFactory(new PropertyValueFactory<>("cartype"));
            Quota.setCellValueFactory(new PropertyValueFactory<>("quota"));
            OfferId.setCellValueFactory(new PropertyValueFactory<>("Offerid"));
            
            offers.setItems(null);
            offers.setItems(data);
            
                    
            
        }catch(SQLException se){
            System.out.println(se);
        }
        Database.closeConnection();
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
    }

    @FXML
    private void myOffers(ActionEvent event) {
    }

    private void Accept(ActionEvent event) {        
            Offer currentOffer = (Offer)offers.getSelectionModel().getSelectedItem();
            int offerID = currentOffer.getOfferid();
            String memberName = currentOffer.getmemberUsername();
            System.out.println(offerID);
            PreparedStatement ps;
            Database.openConnection();
        try {
             ps=con.prepareStatement("UPDATE OFFER SET STATUS = 'Accepted' WHERE OFFER_ID = ?;");
             ps.setInt(1, offerID);
             ps.execute();
             message.setText("Successfully Accepted. Please click on 'My Agreements' to see your agreements.");
             java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime()); 
             ps = con.prepareStatement("INSERT INTO AGREEMENT(OFFER_ID, MEMBER_USERNAME, AGREEMENTDATE)VALUES (?,?,?);");
             ps.setInt(1, offerID);
             ps.setString(2,memberName);
             ps.setTimestamp(3, date);
             ps.execute();
             ps = con.prepareStatement("INSERT INTO AGREEMENT2(OFFER_ID,MEMBER_USERNAME,AGREEMENTDATE) VALUES(?,?,?);");
             ps.setInt(1, offerID);
             ps.setString(2, User.getUsername());
             ps.setTimestamp(3, date);
             ps.execute();            
            
            
            Database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AgreementRiderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
