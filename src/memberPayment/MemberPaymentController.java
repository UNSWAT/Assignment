/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberPayment;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Database.Database;
import static Database.Database.con;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import memberLogin2.LoginController;
import memberType.MemberBothController;
import memberType.MemberDriverController;


/**
 * FXML Controller class
 *
 * @author Yu Bernice
 */
public class MemberPaymentController implements Initializable {
    ObservableList<String> month = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");
    ObservableList<String> year = FXCollections.observableArrayList("17","18","19","20","21","22","23","24");
    @FXML
    private Label amounttopay;
    @FXML
    private Label username;
    @FXML
    private Label paymentStatus;
    @FXML
    private RadioButton card2;
    @FXML
    private RadioButton card3;
    @FXML
    private RadioButton card1;
    @FXML
    private TextField ccNo;
    @FXML
    private TextField Fname;
    @FXML
    private TextField Lname;
    @FXML
    private TextField emailaddress;
    @FXML
    private ComboBox ccExpMonth;
    @FXML
    private ComboBox ccExpYear;
    @FXML
    private TextField ccv;
    @FXML
    private Label errorCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ccExpMonth.setValue("06");
        ccExpMonth.setItems(month);
        ccExpYear.setValue("17");
        ccExpYear.setItems(year);
            
    }  
    
    public void getUser(String user){
        username.setText(user);
    }

    @FXML
    private void confirmPayment(ActionEvent event) {
            boolean check = false;
            while (check == false) {
                 if (ccNo.getText().equals("")){
                 errorCode.setText("Please enter a credit card number");
                 check =true;
              }    
              else if (Fname.getText().equals("")){
                 errorCode.setText("Please enter your first name");
                 check =true;
             }
                 else if (Lname.getText().equals("")){
                     errorCode.setText("Please enter your last name");
                     check =true;
                 }
                 else if (ccv.getText().equals("")){
                     errorCode.setText("Please enter your CCV");
                     check =true;
                 }
                 else if (!ccv.getText().equals("")&&!ccNo.getText().equals("")){
                     try{                               
                        Pane root;

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberLogin2/Login.fxml"));

                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene((Pane)loader.load()));

                       LoginController controller = loader.<LoginController>getController();
                        controller.setLabel("Registration and Payment Successful");
                        stage.show(); 
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                 }
                        
        }
           
            
            
    }
        
    

    @FXML
    private void goBack(ActionEvent event) {
        try {
            PreparedStatement ps;
            Database.openConnection();
            String user = username.getText();
            ps= con.prepareStatement("DELETE FROM MEMBERS WHERE MEMBER_USERNAME = ?");
            ps.setString(1,user);
            ps.executeUpdate();         
            Parent root = FXMLLoader.load(getClass().getResource("/signup/RegisterPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MemberPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MemberPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Database.closeConnection();
    }

    @FXML
    private void calculate(ActionEvent event) {
        try {
            PreparedStatement ps;
            Database.openConnection();
            String consult = null;
            String user = username.getText();
            ps= con.prepareStatement("SELECT CORPORATE_MEMBER FROM MEMBERS WHERE MEMBER_USERNAME = ?");
            ps.setString(1, user);
            ResultSet result = ps.executeQuery();
            if (result.next()){
                consult = result.getString(1);
                if (consult.toUpperCase().equals("YES")){
                amounttopay.setText("$400 for a one year subscription with consultancy");
            }            
            }
            else {
                amounttopay.setText("$200 for a one year subscription.");
            }
            
            Database.closeConnection();
                
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
