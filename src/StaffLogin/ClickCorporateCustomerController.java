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
import memberLogin2.memberLogin;

/**
 * FXML Controller class
 *
 * @author sunyifei
 */
public class ClickCorporateCustomerController implements Initializable {

    @FXML
    private void clickBackToWorkDesk(ActionEvent event)throws IOException{
        
        System.out.println("going to Work Desk");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/PageAfterStaffLoginFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickCorporateMemberList(ActionEvent event)throws IOException{
        
        System.out.println("going to CorporateMember List");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/CorporateMemberList.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickPCorporateMemberList(ActionEvent event)throws IOException{
        
        System.out.println("going to Pentential CorporateMember List");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/PCorporateMemberList.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberLogin.getStage(); 
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
