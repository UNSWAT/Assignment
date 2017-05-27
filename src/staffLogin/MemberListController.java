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
public class MemberListController implements Initializable {

    @FXML
    private void clickBackToWorkDesk(ActionEvent event)throws IOException{
        
        System.out.println("going to Individual Member");
        Parent root = FXMLLoader.load(getClass().getResource("ClickIndividualCustomer.fxml"));
        Scene scene = new Scene(root);
        Stage stage = StaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickNewinMemberList(ActionEvent event)throws IOException{
        
        System.out.println("going to Create a Individual Member");
        Parent root = FXMLLoader.load(getClass().getResource("AddMemberAccount.fxml"));
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
