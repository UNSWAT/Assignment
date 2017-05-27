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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import memberLogin2.memberLogin;

/**
 * FXML Controller class
 *
 * @author sunyifei
 */
public class CorporateMemberListController implements Initializable {

    @FXML
    private TableView<?> personTable;
    @FXML
    private TableColumn<?, ?> firstNameColumn;
    @FXML
    private TableColumn<?, ?> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label emailAddressLabel;
    @FXML
    private Label mobileNumberLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label postCodeLabel;
    @FXML
    private Label suburbLabel;
    @FXML
    private Label stateLabel;
    @FXML
    private Label companyNameLabel;
    @FXML
    private Label companyMobileNumberLabel;
    @FXML
    private Label companyAddressLabel;
    @FXML
    private Label companyPostCodeLabel;
    @FXML
    private Label companySuburbLabel;
    @FXML
    private Label companyStateLabel;

    
    @FXML
    private void Back(ActionEvent event)throws IOException{
        
        System.out.println("going to Corporate Member");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/ClickCorporateCustomer.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickNewCorporateMember(ActionEvent event)throws IOException{
        
        System.out.println("going to Create a CorporateMember");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/CreateCorporateMemberFXML.fxml"));
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

    @FXML
    private void Home(ActionEvent event) {
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/PageAfterStaffLoginFXML.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AddStaffAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logOut(ActionEvent event) {
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/StaffLoginFXML.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AddStaffAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
