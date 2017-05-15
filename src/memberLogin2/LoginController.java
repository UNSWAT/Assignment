/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberLogin2;



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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Database.Database;
import static Database.Database.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button signin;
    @FXML
    private Button register;
    @FXML
    private Label setLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
       ps = con.prepareStatement("SELECT USERNAME,PASSWORD from PUBLIC.USER WHERE USERNAME = ? and PASSWORD = ?;");
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

    @FXML
    private void clickRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/signup/RegisterPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
               
    }
    
}
