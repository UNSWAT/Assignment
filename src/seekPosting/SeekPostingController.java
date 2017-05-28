/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seekPosting;

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
public class SeekPostingController implements Initializable {

    private TextField startPC;

    private ComboBox timeFrom;

    private ComboBox timeto;

    private TextField endPC;

    private ComboBox quota;

    private Label errorMessage;

    ObservableList<String> time = FXCollections.observableArrayList("00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30");
    ObservableList<String> noOfPassenger = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    @FXML
    private Label username;
    @FXML
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeFrom.setValue("00:00");
        timeFrom.setItems(time);
        timeto.setValue("00:00");
        timeto.setItems(time);
        quota.setValue("1");
        quota.setItems(noOfPassenger);
        username.setText(User.getUsername());

    }

    

    private void createPost(ActionEvent event) throws SQLException {
        try {
            boolean check = false;
            PreparedStatement insertSeek = null;
            Database.openConnection();

            String MEMBERUSERNAME = username.getText();

            String TIMETO = timeto.getSelectionModel().getSelectedItem().toString();

            String TIMEFROM = timeFrom.getSelectionModel().getSelectedItem().toString();

            String POSTCODE = startPC.getText();

            String POSTCODEDESTINATION = endPC.getText();

            String QUOTA = quota.getSelectionModel().getSelectedItem().toString();

            while (check == false) {
                if (POSTCODE.equals("")) {
                    errorMessage.setText("Please enter your starting location postcode");
                    check = true;
                } else if (POSTCODEDESTINATION.equals("")) {
                    errorMessage.setText("Please enter your denstination postcode");
                    check = true;
                } else if (!POSTCODE.equals("")&&!POSTCODEDESTINATION.equals("")){
                    int pcstart = parseInt(POSTCODE);
                    int pcend = parseInt(POSTCODEDESTINATION);
                    int quoTa = parseInt(QUOTA);
                    OtherStaticVariables.setQuota(quoTa);
                    OtherStaticVariables.setPostcodefrom(pcstart);
                    OtherStaticVariables.setTimefrom(TIMEFROM);
                    java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());                    
                    insertSeek = con.prepareStatement("INSERT INTO SEEK(MEMBER_USERNAME,TIME_TO,TIME_FROM,POSTCODE,POSTCODE_DESTINATION,QUOTA,DATESEEK) VALUES(?,?,?,?,?,?,?)");
                    insertSeek.setString(1, MEMBERUSERNAME);
                    insertSeek.setString(2, TIMETO);
                    insertSeek.setString(3, TIMEFROM);
                    insertSeek.setInt(4, pcstart);
                    insertSeek.setInt(5, pcend);
                    insertSeek.setInt(6, quoTa);
                    insertSeek.setTimestamp(7, date);
                    insertSeek.execute();
                    insertSeek.close();
                    check = true;
                    Database.closeConnection();
                    try {
                        Pane root;

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SeekTableView/SeekTableView.fxml"));

                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene((Pane)loader.load()));
                      
                        stage.show(); 

                        } catch (IOException ex) {
                            Logger.getLogger(RegisterPageController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                } 
                    
                } 
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(SeekPostingController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL error");
        }
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
            Pane root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/memberRider.fxml"));
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane)loader.load()));
            
            
             
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MemberBothController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Page Error");
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
            Logger.getLogger(SeekPostingController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void seekVehicle(ActionEvent event) {
    }
}
