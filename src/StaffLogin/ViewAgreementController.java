/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffLogin;

import AgreementRider.Agreement;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import memberLogin2.User;
import memberLogin2.memberLogin;
import Database.Database;
import static Database.Database.con;

/**
 * FXML Controller class
 *
 * @author hp1
 */
public class ViewAgreementController implements Initializable {

     @FXML 
    private TableView<Agreement> agreements;
    @FXML
    private TableColumn<Agreement, String> CarType;
    @FXML
    private TableColumn<Agreement, String> PickupTime;
    @FXML
    private TableColumn<Agreement, String> MemberDriver;
    @FXML
    private TableColumn<Agreement, Integer> AgreementId;
    @FXML
    private TableColumn<Agreement, Integer> Offerid;
    @FXML
    private TableColumn<Agreement, Integer> Postcodefrom;
    @FXML
    private TableColumn<Agreement, Date>AgreementDate;
    
       
    private ObservableList<Agreement> data;
    private PreparedStatement getAgreements;
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
    
    @FXML
    private void Back(ActionEvent event)throws IOException{
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/ClickSuberSystem.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(ViewAgreementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(User.getUsername());
        String user = username.getText();
        try{
            Database.openConnection();
            data=FXCollections.observableArrayList();
            getAgreements = con.prepareStatement("SELECT a.AGREEMENT_ID, a.OFFER_ID,a.MEMBER_USERNAME,a.AGREEMENTDATE,b.POSTCODE_FROM,b.CARTYPE,b.TIME_FROM from AGREEMENT a INNER JOIN OFFER b ON a.OFFER_ID = b.OFFER_ID");
            getAgreements.setString(1, user);
            getAgreements.executeQuery();
           
            ResultSet rs = getAgreements.executeQuery();
            
            while(rs.next()){
                data.add(new Agreement(rs.getString("CARTYPE"),rs.getString("TIME_FROM"),rs.getString("MEMBER_USERNAME"),rs.getInt("AGREEMENT_ID"),rs.getInt("OFFER_ID"),rs.getInt("POSTCODE_FROM"),rs.getDate("AGREEMENTDATE")));
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
           
           
           
           CarType.setCellValueFactory(new PropertyValueFactory<>("carType"));
           PickupTime.setCellValueFactory(new PropertyValueFactory<>("pickupTime"));
           MemberDriver.setCellValueFactory(new PropertyValueFactory<>("memberDriver")); 
           AgreementId.setCellValueFactory(new PropertyValueFactory<>("agreementId")); 
           Offerid.setCellValueFactory(new PropertyValueFactory<>("offerid")); 
           Postcodefrom.setCellValueFactory(new PropertyValueFactory<>("postcodefrom")); 
           AgreementDate.setCellValueFactory(new PropertyValueFactory<>("agreementDate")); 
              
           
            
            agreements.setItems(null);
            agreements.setItems(data);
            
                    
            
        }catch(SQLException se){
            System.out.println(se);
        }
        Database.closeConnection();
    }  

    @FXML
    private void Home(ActionEvent event) {
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/PageAfterStaffLoginFXML.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(ViewAgreementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logOut(ActionEvent event) {
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/StaffLoginFXML.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(ViewAgreementController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }     
    
}