/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberType;

import static Database.Database.con;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import memberLogin2.User;
import seekPosting.SeekPostingController;
import vehicleSeekRider.VehicleSeekPostController;

/**
 * FXML Controller class
 *
 * @author MI-PC
 */
public class riderForBothController implements Initializable {
    
    
    @FXML
    private Label seekSuccess;
    @FXML
    private Label username;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        username.setText(User.getUsername());
    } 
    
    public void setLabel(String success){
        seekSuccess.setText(success);
    }

    @FXML
    private void createSeek(ActionEvent event) {
        
        try {
            Pane root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/seekPosting/seekPosting.fxml"));
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane)loader.load()));
            
            
            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(riderForBothController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    private void back(ActionEvent event) {
        try {
            Pane root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/memberBoth.fxml"));
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane)loader.load()));
           
            
            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(riderForBothController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Home(ActionEvent event) {
        try {
            Database.Database.openConnection();
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
            Logger.getLogger(riderForBothController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(riderForBothController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void vehicleSeek(ActionEvent event) {
        try {
            Pane root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vehicleSeekRider/VehicleSeekPost.fxml"));
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane)loader.load()));
            
            
             
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MemberBothController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Page Error");
        }
    }
    
}
