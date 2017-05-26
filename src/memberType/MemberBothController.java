/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MI-PC
 */
public class MemberBothController implements Initializable {

    @FXML
    private Label userlabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void clickRider(ActionEvent event)throws IOException{
        
        System.out.println("Member Type: Rider");
        Parent root = FXMLLoader.load(getClass().getResource("/memberType/riderForBoth.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberBoth.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
        @FXML
        private void clickDriver(ActionEvent event)throws IOException{
        
        System.out.println("Member Type: Driver");
        Parent root = FXMLLoader.load(getClass().getResource("/memberType/driverForBoth.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberBoth.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
        
        public void getUser(String user){
        userlabel.setText(user);
    }
    
}
