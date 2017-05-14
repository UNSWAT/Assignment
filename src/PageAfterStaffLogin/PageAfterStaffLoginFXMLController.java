/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageAfterStaffLogin;

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
public class PageAfterStaffLoginFXMLController implements Initializable {

    @FXML
    private void clickCorporateCustomer(ActionEvent event)throws IOException{
        
        System.out.println("going to Corporate Customer");
        Parent root = FXMLLoader.load(getClass().getResource("ClickCorporateCustomer.fxml"));
        Scene scene = new Scene(root);
        Stage stage = PageAfterStaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickIndividualCustomer(ActionEvent event)throws IOException{
        
        System.out.println("going to Individual Customer");
        Parent root = FXMLLoader.load(getClass().getResource("ClickIndividualCustomer.fxml"));
        Scene scene = new Scene(root);
        Stage stage = PageAfterStaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickSuberSystem(ActionEvent event)throws IOException{
        
        System.out.println("going to sUber System");
        Parent root = FXMLLoader.load(getClass().getResource("ClickSuberSystem.fxml"));
        Scene scene = new Scene(root);
        Stage stage = PageAfterStaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickStaff(ActionEvent event)throws IOException{
        
        System.out.println("going to Staff");
        Parent root = FXMLLoader.load(getClass().getResource("ClickStaff.fxml"));
        Scene scene = new Scene(root);
        Stage stage = PageAfterStaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
