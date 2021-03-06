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
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import memberType.MemberBothController;
import memberType.MemberDriverController;
import memberType.MemberRiderController;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class LoginController implements Initializable {

   
    
    @FXML
    private Button signin;
    @FXML
    private Button register;
    @FXML
    private Label setLabel;
    @FXML
    private TextField username;
    @FXML
    private PasswordField passWord;
    @FXML
    private Button register1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setLabel(String message){
        setLabel.setText(message);
    }

    @FXML
    private void clickLogin(ActionEvent event) {
       PreparedStatement ps;
       Database.openConnection();
       
        try {
            
            
            String user = username.getText();
            
            String pass = passWord.getText();
            User userlogin = new User(user);
            System.out.println(userlogin.getUsername());
            
            ps = con.prepareStatement("SELECT MEMBER_USERNAME,MEMBER_PASSWORD from PUBLIC.MEMBERS WHERE MEMBER_USERNAME = ? and MEMBER_PASSWORD = ?;");
            
            ps.setString(1,user);
            
            ps.setString(2,pass);
            
            ResultSet result = ps.executeQuery();
            if(result.next()){
                User.setUsername(user);
                setLabel.setText("Login Successfully");  
                
                String membertype =null;
                
                ps = con.prepareStatement("SELECT MEMBER_TYPE FROM MEMBERS WHERE MEMBER_USERNAME = ? ");
                
                ps.setString(1,user);    
                
                ResultSet member = ps.executeQuery();
                
                if (member.next()){
                    membertype = member.getString(1); 
                    System.out.println(membertype);
                        if (membertype.toUpperCase().equals("RIDER")){
                            //load Rider page here                            
                        try {
                            Pane root;
                                                    
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/memberRider.fxml"));
                                
                                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                stage.setScene(new Scene((Pane)loader.load()));
                                        
                                                              
                                
                                stage.show(); 
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }                         
               
                        }
                        else if (membertype.toUpperCase().equals("SHARER")){
                            //load driver page here
                            try{
                               
                                Pane root;
                                                    
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/memberDriver.fxml"));
                                
                                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                stage.setScene(new Scene((Pane)loader.load()));
                                        
                                     
                                
                                stage.show(); 
                            } catch (IOException ex) {
                                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                            } 
                        }
                        else if (membertype.toUpperCase().equals("BOTH")){
                            //load both page here.
                            try {
                                    Parent root = FXMLLoader.load(getClass().getResource("/memberType/memberBoth.fxml"));
                                    Scene scene = new Scene(root);
                                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                    stage.setScene(scene);
                                    stage.show();
                                } catch (IOException ex) {
                                    System.out.println("Page Error");
                                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                }
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
    private void staffLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/StaffLoginFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Page Error");
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
