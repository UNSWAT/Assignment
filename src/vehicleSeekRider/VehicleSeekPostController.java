/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicleSeekRider;

import seekPosting.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Database.Database;
import static Database.Database.con;
import Database.OtherStaticVariables;
import SeekTableView.SeekTableView;
import SeekTableView.SeekTableViewController;
import static java.lang.Integer.parseInt;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import memberPayment.MemberPaymentController;
import memberType.MemberBothController;
import memberType.riderForBothController;
import signup.RegisterPageController;
import memberLogin2.User;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class VehicleSeekPostController implements Initializable {

    ObservableList<String> vehicle = FXCollections.observableArrayList("Sedan","Coupe","Convertible","Minivan","Truck","SUV","Motorcycle");
    
    @FXML
    private Label username;
    @FXML
    private ComboBox vehicleType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        vehicleType.setValue("Sedan");
        vehicleType.setItems(vehicle);
        username.setText(User.getUsername());

    }
    

   

    @FXML
    private void back(ActionEvent event) {
        try {
                Pane root;

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/memberRider.fxml"));

                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(new Scene((Pane)loader.load()));

                stage.show(); 

                } catch (IOException ex) {
                    Logger.getLogger(RegisterPageController.class.getName()).log(Level.SEVERE, null, ex);
                }

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
            Logger.getLogger(VehicleSeekPostController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(VehicleSeekPostController.class.getName()).log(Level.SEVERE, null, ex);
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
            
            
        /*   rider doesn't need offers 
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
*/
            
            @FXML
            private void seekVehicle(ActionEvent event) {
                    String vehicle = vehicleType.getSelectionModel().getSelectedItem().toString();
                    OtherStaticVariables.setVehicle(vehicle);
//                    Database.openConnection();
//                    PreparedStatement ps;
//                    
                    
                    //push to new vehicle page.
                    try {
                        Pane root;

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/VehicleSeekTable/VehicleSeekTable.fxml"));

                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene((Pane)loader.load()));
                      
                        stage.show(); 

                        } catch (IOException ex) {
                            Logger.getLogger(RegisterPageController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    
                
            }
        }  
