/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeekTableView;

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
public class SeekTableViewController implements Initializable {

    @FXML
    private TableView<Offer> offers;
    @FXML
    private TableColumn<Offer, String> memberUsername;
    @FXML
    private TableColumn<Offer, String> TimeFrom;
    @FXML
    private TableColumn<Offer, String> TimeTo;
    @FXML
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
    private Label timefrom;
    @FXML
    private Label timeto;
    @FXML
    private Label postcodefrom;
    @FXML
    private Label postcodeto;
    @FXML
    private Label quota;
    @FXML
    private Label message;
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(User.getUsername());
        try{
            Database.openConnection();
            data=FXCollections.observableArrayList();
            getOffers = con.prepareStatement("select MEMBER_USERNAME,POSTCODE_FROM,POSTCODE_TO, TIME_FROM, TIME_TO, QUOTA, CARTYPE, OFFER_ID from OFFER WHERE STATUS = 'Pending' AND MEMBER_USERNAME != ? AND POSTCODE = ? || TIME_FROM = ?;");
//            
            getOffers.setString(1,User.getUsername());
            getOffers.setInt(2,OtherStaticVariables.getPostcodefrom());
            getOffers.setString(3,OtherStaticVariables.getTimefrom());
           
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
            Logger.getLogger(SeekTableViewController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SeekTableViewController.class.getName()).log(Level.SEVERE, null, ex);
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

    @FXML
    private void myOffers(ActionEvent event) {
            try {
                Pane root;
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/ViewOffer.fxml"));
                
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(new Scene((Pane)loader.load()));
                
                
                
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MemberBothController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Page Error");
            }   
    }

    @FXML
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
            Logger.getLogger(SeekTableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
