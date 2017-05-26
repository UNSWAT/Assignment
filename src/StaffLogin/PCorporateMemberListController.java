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
public class PCorporateMemberListController implements Initializable {

    
    @FXML
    private void clickBackToWorkDesk(ActionEvent event)throws IOException{
        
        System.out.println("going to Corporate Member");
        Parent root = FXMLLoader.load(getClass().getResource("ClickCorporateCustomer.fxml"));
        Scene scene = new Scene(root);
        Stage stage = StaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickNewinPcorporateMemberList(ActionEvent event)throws IOException{
        
        System.out.println("going to Create a PCorporate Member");
        Parent root = FXMLLoader.load(getClass().getResource("CreatePCorporateCustomer.fxml"));
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
