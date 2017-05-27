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
import seekPosting.SeekPostingController;

/**
 * FXML Controller class
 *
 * @author MI-PC
 */
public class riderForBothController implements Initializable {
    
    @FXML
    private Label userlabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createSeek(ActionEvent event) {
        
        try {
            Pane root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/seekPosting/seekPosting.fxml"));
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane)loader.load()));
            
            
            SeekPostingController controller = loader.<SeekPostingController>getController();
            controller.getUser(userlabel.getText());
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(riderForBothController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getUser(String user){
        userlabel.setText(user);
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            Pane root;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/memberBoth.fxml"));
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane)loader.load()));
            
            
            MemberBothController controller = loader.<MemberBothController>getController();
            controller.getUser(userlabel.getText()); 
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(riderForBothController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickMyProfile(ActionEvent event) {
    }

    @FXML
    private void clickMyAgreements(ActionEvent event) {
    }
    
}
