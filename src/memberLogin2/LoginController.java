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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class LoginController implements Initializable {

   
    private TextField password;
    @FXML
    private Button signin;
    @FXML
    private Button register;
    @FXML
    private Label setLabel;
    @FXML
    private TextField username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickLogin(ActionEvent event) {
       PreparedStatement ps;
       Database.openConnection();
       
        try {
            String user = username.getText();
            ps = con.prepareStatement("SELECT MEMBER_USERNAME,MEMBER_PASSWORD from PUBLIC.MEMBERS WHERE MEMBER_USERNAME = ? and MEMBER_PASSWORD = ?;");
            ps.setString(1,username.getText());
            ps.setString(2,password.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                setLabel.setText("Login Successfully");
                ps = con.prepareStatement("SELECT MEMBER_TYPE FROM MEMBERS WHERE MEMBER_USERNAME = ? ");
                ps.setString(1,user);
                String membertype =null;
                ResultSet member = ps.executeQuery();
                if (member.next()){
                    membertype = member.getString(1);
                        if (membertype.toUpperCase().equals("RIDER")){
                            //load Rider page here
                        }
                        else if (membertype.toUpperCase().equals("DRIVER")){
                            //load driver page here
                        }
                        else if (membertype.toUpperCase().equals("BOTH")){
                            //load both page here.
                        }
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
    private void clickRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/signup/RegisterPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
               
    }

    @FXML
    private void username(ActionEvent event) {
    }

    @FXML
    private void clickRegister(MouseEvent event) {
    }
    
}
