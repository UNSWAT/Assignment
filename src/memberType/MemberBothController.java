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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
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
        
         Pane root;
                                                    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/riderForBoth.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene((Pane)loader.load()));


        riderForBothController controller = loader.<riderForBothController>getController();
        controller.getUser(userlabel.getText());
        stage.show(); 
    }
    
        @FXML
        private void clickDriver(ActionEvent event)throws IOException{
        
         Pane root;
                                                    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/driverForBoth.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene((Pane)loader.load()));


        driverForBothController controller = loader.<driverForBothController>getController();
        controller.getUser(userlabel.getText());
        stage.show(); 
    }
        
        public void getUser(String user){
        userlabel.setText(user);
    }

    @FXML
    private void myprofile(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }
    
}
