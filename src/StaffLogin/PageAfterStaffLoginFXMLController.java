/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import memberLogin2.memberLogin;


/**
 * FXML Controller class
 *
 * @author sunyifei
 */
public class PageAfterStaffLoginFXMLController implements Initializable {

    @FXML
    private void clickCorporateCustomer(ActionEvent event){
        
        try {
            System.out.println("going to Corporate Customer");
            Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/ClickCorporateCustomer.fxml"));
            Scene scene = new Scene(root);
            Stage stage = memberLogin.getStage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PageAfterStaffLoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        };
    
    @FXML
    private void clickIndividualCustomer(ActionEvent event)throws IOException{
        
        System.out.println("going to Individual Customer");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/ClickIndividualCustomer.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickSuberSystem(ActionEvent event)throws IOException{
        
        System.out.println("going to sUber System");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/ClickSuberSystem.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickStaff(ActionEvent event)throws IOException{
        
        System.out.println("going to Staff");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/ClickStaff.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
