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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sunyifei
 */
public class AddStaffAccountController implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    @FXML
    private void CancelCreateStaff(ActionEvent event)throws IOException{
        
        System.out.println("Cancel Create a Staff");
        Parent root = FXMLLoader.load(getClass().getResource("StaffList.fxml"));
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

    @FXML
    private void CancelCreateStaff(MouseEvent event) {
    }
    
}
