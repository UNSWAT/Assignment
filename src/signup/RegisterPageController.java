/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class RegisterPageController implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField email;
    @FXML
    private TextField lastName;
    @FXML
    private TextField address;
    @FXML
    private TextField mobileNo;
    @FXML
    private TextField Suburb;
    @FXML
    private TextField postCode;
    @FXML
    private ComboBox<?> state;
    @FXML
    private TextField creditNo;
    @FXML
    private ComboBox<?> expiryMonth;
    @FXML
    private TextField CCV;
    @FXML
    private ComboBox<?> expiryYear;
    @FXML
    private Button createAccount;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;
    @FXML
    private Hyperlink makePayment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createAccount(ActionEvent event) {
    }

    @FXML
    private void makePayment(ActionEvent event) {
    }
    
}
