/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffLogin;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Database.Database;
import static Database.Database.con;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.Label;
import memberLogin2.memberLogin;


/**
 * FXML Controller class
 *
 * @author sunyifei
 */
public class AddStaffAccountController implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;
    @FXML
    private Label errorMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void createAccount(ActionEvent event) throws SQLException {
        try {     
            boolean check = false;
            PreparedStatement insertMember = null;
            PreparedStatement usernameCheck= null;
            Database.openConnection();
            
            String fname = firstName.getText(); 
            
            String lname = lastName.getText();
            
            String userName = username.getText();
            
            String password1 = password.getText();
            
            String passwordConfirm = password2.getText();
            
            
            
            while (check == false) {
                 if (userName.equals("")){
                 errorMessage.setText("Please enter a username");
                 check =true;
            }             
             else if (fname.equals("")){
                 errorMessage.setText("Please enter your first name");
                 check =true;
            }
             else if (lname.equals("")){
                 errorMessage.setText("Please enter your last name");
                 check =true;
            }
            else if (password1.equals("")){
                 errorMessage.setText("Please enter a valid password");
                 check =true;
            }
             else if (passwordConfirm.equals("")){
                 errorMessage.setText("Please confirm your password");
                 check =true;
            }
            else if (!password1.equals(passwordConfirm)){
                  errorMessage.setText("Your passwords are not identical. Please try again.");
                  check =true;
              }              
              else if (password1.equals(passwordConfirm)){
                  usernameCheck =con.prepareStatement("SELECT USERNAME FROM PUBLIC.STAFF WHERE USERNAME = ?");
                  usernameCheck.setString(1,userName);
                  ResultSet allUsername = usernameCheck.executeQuery();
                  if (allUsername.next()){
                      errorMessage.setText("That username has already been taken. Please choose another one");
                      check = true;
                  }
                  
                  else {              
                      insertMember = con.prepareStatement("INSERT INTO PUBLIC.STAFF(USERNAME,PASSWORD,FIRST_NAME,LAST_NAME) VALUES(?,?,?,?)");
                            insertMember.setString(1, userName);
                            insertMember.setString(2, password1);
                            insertMember.setString(3,fname);
                            insertMember.setString(4, lname); 
                            insertMember.execute();
                            insertMember.close(); 
                            check =true;
                            
                            Database.closeConnection();
                            try {
                                Parent root;
                                root = FXMLLoader.load(getClass().getResource("/StaffLogin/StaffList.fxml"));
                                Scene scene = new Scene(root);
                                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                stage.setScene(scene);
                                stage.show();

                            } catch (IOException ex) {
                                Logger.getLogger(AddStaffAccountController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }     
              }        
        }
     
            } catch (SQLException ex) {
               Logger.getLogger(AddStaffAccountController.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("SQL error");
           }  
    }
            
    
    @FXML
    private void CancelCreateStaff(ActionEvent event)throws IOException{
        
        System.out.println("Cancel Create a Staff");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/StaffList.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
    }
}
