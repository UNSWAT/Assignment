/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memberType;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import memberLogin2.User;

/**
 * FXML Controller class
 *
 * @author MI-PC
 */
public class MemberDriverController implements Initializable {

    @FXML
    private Label username;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       username.setText(User.getUsername());
    }   
    

   

    @FXML
    private void Home(ActionEvent event) {
        try {
            Pane root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/memberDriver.fxml"));
            
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
            Logger.getLogger(MemberBothController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Page Error");
        }
    }

    @FXML
    private void myOffers(ActionEvent event) {
    }
    
    
}
