/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sunyifei
 */
public class ClickStaffController implements Initializable {

    @FXML
    private void clickBackToWorkDesk(ActionEvent event)throws IOException{
        
        System.out.println("going to Work Desk");
        Parent root = FXMLLoader.load(getClass().getResource("PageAfterStaffLoginFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = StaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickViewStaffList(ActionEvent event)throws IOException{
        
        System.out.println("going to Staff List");
        Parent root = FXMLLoader.load(getClass().getResource("StaffList.fxml"));
        Scene scene = new Scene(root);
        Stage stage = StaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickPCorporateMemberList(ActionEvent event)throws IOException{
        
        System.out.println("going to Create a New Staff");
        Parent root = FXMLLoader.load(getClass().getResource("AddStaffAccount.fxml"));
        Scene scene = new Scene(root);
        Stage stage = StaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
