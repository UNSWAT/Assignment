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
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import memberLogin2.User;
import memberType.MemberBothController;
import vehicleSeekRider.VehicleSeekPostController;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class AgreementRiderController implements Initializable {

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
    
   
  

     
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(User.getUsername());
        String user = username.getText();
        try{
            Database.openConnection();
            data=FXCollections.observableArrayList();
            getAgreements = con.prepareStatement("SELECT a.AGREEMENT_ID, a.OFFER_ID,a.MEMBER_USERNAME,a.AGREEMENTDATE,b.POSTCODE_FROM,b.CARTYPE,b.TIME_FROM from AGREEMENT a INNER JOIN OFFER b ON a.OFFER_ID = b.OFFER_ID WHERE b.MEMBER_USERNAME = ?");
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
            Database.openConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("SELECT MEMBER_TYPE FROM MEMBERS WHERE MEMBER_USERNAME = ?");
            ps.setString(1, User.getUsername());
            ResultSet member =ps.executeQuery();
            if (member.next()){
                String membertype = member.getString(1);
                if (membertype.toUpperCase().equals("RIDER")){
                    try {
                            
                                                    
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/memberRider.fxml"));

                            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            stage.setScene(new Scene((Pane)loader.load()));



                            stage.show(); 
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }   
                }
                
                else if (membertype.toUpperCase().equals("SHARER")){
                  try{

                           

                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/memberDriver.fxml"));

                            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            stage.setScene(new Scene((Pane)loader.load()));



                            stage.show(); 
                        } catch (IOException ex) {
                            System.out.println(ex);
                            }  
                }
                
                else if (membertype.toUpperCase().equals("BOTH")){
                    try {
                                Parent root = FXMLLoader.load(getClass().getResource("/memberType/memberBoth.fxml"));
                                Scene scene = new Scene(root);
                                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                stage.setScene(scene);
                                stage.show();
                            } catch (IOException ex) {
                                System.out.println("Page Error");
                               
                            }

                }
                
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgreementRiderController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }

    @FXML
    private void myProfile(ActionEvent event) {
                   try {
                Pane root;
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberProfile/memberProfile.fxml"));
                
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(new Scene((Pane)loader.load()));
                
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AgreementRiderController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Page Error");
            } 
        
    }

    @FXML
    private void MyAgreements(ActionEvent event) {
                    try {
                Pane root;
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/AgreementRider/AgreementRider.fxml"));
                
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(new Scene((Pane)loader.load()));
                
                
                
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MemberBothController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Page Error");
            }
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
                Logger.getLogger(MemberBothController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Page Error");
            }
    }

    /* NO LONGER NEEDED
    @FXML
    private void myOffers(ActionEvent event) {
    }
   */

    
    
    
}
