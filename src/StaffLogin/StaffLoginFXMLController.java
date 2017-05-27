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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import memberLogin2.LoginController;

/**
 * FXML Controller class
 *
 * @author sunyifei
 */
public class StaffLoginFXMLController implements Initializable {

    @FXML 
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label setLabel;
    @FXML
    private Button SignIn;
    @FXML
    private Hyperlink MemberLogin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     
    @FXML
    private void clickSignIn(ActionEvent event)throws IOException{
        
        PreparedStatement ps;
       Database.openConnection();
       
        try {
            String user = username.getText();
            System.out.println(user);            
            String pass = password.getText();
            System.out.println(pass);
            
            ps = con.prepareStatement("SELECT USERNAME,PASSWORD from PUBLIC.STAFF WHERE USERNAME = ? and PASSWORD = ?;");
            
            ps.setString(1,user);
            
            ps.setString(2,pass);
            
            ResultSet result = ps.executeQuery();
            if(result.next()){
                setLabel.setText("Login Successfully");
                try {
                            Parent root;
                            root = FXMLLoader.load(getClass().getResource("PageAfterStaffLoginFXML.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(StaffLoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
            }
            else {
                 setLabel.setText("Invalid Username or Password");
            }
            } catch (SQLException ex) {
                 System.out.println(ex);
            }

           Database.closeConnection();
        }
    
    @FXML
    private void clickMemberLogin(ActionEvent event){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/memberLogin2/Login.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Page Error");
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickSignIn(MouseEvent event) {
    }

    
    
}
