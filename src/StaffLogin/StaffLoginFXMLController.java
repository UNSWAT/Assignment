/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffLogin;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Database.Database;
import static Database.Database.con;

/**
 * FXML Controller class
 *
 * @author z5039190
 */
public class StaffLoginFXMLController implements Initializable {

    @FXML
    private Label label;
    
    @FXML
    private TextField email;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Button signinbtn;
    
    @FXML
    private Label setLabel;
    
    @FXML
    void signin(ActionEvent event) {
        String userEmail = email.getText();
        String userPass = password.getText();
        System.out.println(userEmail + userPass);
        if (userEmail.equals("123@gmail.com") && userPass.equals("pass"))
        {
            label.setText("Welcome");
        }
        else {
                label.setText("Username or Password invalid");
        }
        }
    
     @FXML
    private void emailAddress(ActionEvent event) {
    }

    @FXML
    private void enterPassword(ActionEvent event) {
    }

    @FXML
    private void clickLogin(ActionEvent event) throws SQLException {
       PreparedStatement ps;
       Database.openConnection();
       ps = con.prepareStatement("SELECT USERNAME,PASSWORD from PUBLIC.STAFF WHERE USERNAME = ? and PASSWORD = ?;");
       ps.setString(1,email.getText());
       ps.setString(2,password.getText());
       ResultSet result = ps.executeQuery();
       if(result.next()){
           setLabel.setText("Login Successfully");
       }
       else {
           setLabel.setText("Invalid Username or Password");
       }
       Database.closeConnection();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
