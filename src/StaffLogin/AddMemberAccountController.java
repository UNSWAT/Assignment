package StaffLogin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Database.Database;
import static Database.Database.con;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hp1
 */
public class AddMemberAccountController implements Initializable {

   ObservableList<String> states = FXCollections.observableArrayList("NSW","QLD","SA","WA","NT","VIC","ACT");
   ObservableList<String> CompanyConsultancy = FXCollections.observableArrayList("Yes","No");
      ObservableList<String> memType = FXCollections.observableArrayList("Rider","Sharer","Both");
    
    @FXML
    private TextField firstName;
    @FXML
    private TextField email;
    @FXML
    private TextField lastName;
    @FXML
    private TextField mobileNo;
    
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;
    @FXML
    private TextField homeAddress;
    @FXML
    private TextField homeSuburb;
    @FXML
    private TextField homePostCode;
    @FXML
    private ComboBox homeState;
    
    @FXML
    private TextField workAddress;
    @FXML
    private TextField workSuburb;
    @FXML
    private TextField workPostcode;
    @FXML
    private ComboBox consultancy;
    @FXML
    private TextField username;
    @FXML
    private TextField companyName;
    @FXML
    private ComboBox workState;
    
    @FXML
    private Label errorMessage;
    @FXML
    private ComboBox memberType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        homeState.setValue("NSW");
        homeState.setItems(states);
        consultancy.setValue("Yes");
        consultancy.setItems(CompanyConsultancy);
        workState.setValue("");
        workState.setItems(states);
        memberType.setValue("Rider");
        memberType.setItems(memType);
        
        
    }    

    

    
    @FXML
    private void CancelCreateIndividualMember(ActionEvent event){
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/MemberList.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AddMemberAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       

   

    @FXML
    private void CreateMember(ActionEvent event) {
        try {     
            boolean check = false;
            PreparedStatement insertMember = null;
            PreparedStatement usernameCheck= null;
            Database.openConnection();
            
            String fname = firstName.getText(); 
            
            String lname = lastName.getText();
            
            String userName = username.getText();
            
            String emailAddress = email.getText();
            
            String mobileNumber = mobileNo.getText();
            
            String password1 = password.getText();
            
            String passwordConfirm = password2.getText();
            
            String homeAdd = homeAddress.getText();
            
            String homeSub = homeSuburb.getText();
            
            String homePC = homePostCode.getText();
            
            String homestate = homeState.getSelectionModel().getSelectedItem().toString();
       
            String workAdd = workAddress.getText();
            
            String workSub = workSuburb.getText();
            
            String workPC = workPostcode.getText();
            
            String consult = consultancy.getSelectionModel().getSelectedItem().toString();
            
              
            String companyN = companyName.getText();
            
            String workSte = workState.getSelectionModel().getSelectedItem().toString();  
            
            
            String membType = memberType.getSelectionModel().getSelectedItem().toString(); 
            
                             
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
             else if (emailAddress.equals("")){
                 errorMessage.setText("Please enter your email address");
                 check =true;
              }             
             else if (password1.equals("")){
                 errorMessage.setText("Please enter a valid password");
                 check =true;
             }
             else if (password2.equals("")){
                 errorMessage.setText("Please confirm your password");
                 check =true;
             }
             else if (mobileNumber.equals("")){
                 errorMessage.setText("Please enter your mobile number");
                 check =true;
             }      
             else if (homeAdd.equals("")){
                 errorMessage.setText("Please enter your home address");
                 check =true;
             }
             else if (homeSub.equals("")){
                 errorMessage.setText("Please enter your home suburb");
                 check =true;
             }
             else if (homePC.equals("")){
                 errorMessage.setText("Please enter your postcode");
                 check =true;
             }          
              
              else if (!password1.equals(passwordConfirm)){
                  errorMessage.setText("Your passwords are not identical. Please try again.");
                  check =true;
              }              
              else if (password1.equals(passwordConfirm)){
                  usernameCheck =con.prepareStatement("SELECT MEMBER_USERNAME FROM PUBLIC.MEMBERS WHERE MEMBER_USERNAME = ?");
                  usernameCheck.setString(1,userName);
                  ResultSet allUsername = usernameCheck.executeQuery();
                  if (allUsername.next()){
                      errorMessage.setText("That username has already been taken. Please choose another one");
                      check = true;
                  }
                  
                  else {              
                      insertMember = con.prepareStatement("INSERT INTO PUBLIC.MEMBERS(MEMBER_USERNAME,MEMBER_PASSWORD,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,MOBILE_NO,HOME_ADDRESS,HOME_SUBURB,HOME_POSTCODE,HOME_STATE,WORK_ADDRESS,WORK_SUBURB,WORK_POSTCODE,WORK_STATE,CORPORATE_MEMBER,COMPANY_NAME,MEMBER_TYPE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                            int homepostcode = Integer.parseInt(homePC);
                            int workpostcode;
                            if (workPC.equals("")){
                                workpostcode = 0;
                            }
                            else {
                                workpostcode = Integer.parseInt(workPC);
                            }                            
                            insertMember.setString(1, userName);
                            insertMember.setString(2, password1);
                            insertMember.setString(3,fname);
                            insertMember.setString(4, lname);
                            insertMember.setString(5,emailAddress);
                            insertMember.setString(6,mobileNumber);
                            insertMember.setString(7,homeAdd);
                            insertMember.setString(8,homeSub);
                            insertMember.setInt(9,homepostcode);
                            insertMember.setString(10,homestate);
                            insertMember.setString(11,workAdd);
                            insertMember.setString(12,workSub);
                            insertMember.setInt(13,workpostcode);
                            insertMember.setString(14,workSte);                            
                            insertMember.setString(15,consult);
                            insertMember.setString(16, companyN);
                            insertMember.setString(17,membType);   
                            insertMember.execute();
                            insertMember.close(); 
                            check =true;
                            Database.closeConnection();
                            try {
                                    Parent root;
                                    root = FXMLLoader.load(getClass().getResource("/StaffLogin/MemberList.fxml"));
                                    Scene scene = new Scene(root);
                                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                    stage.setScene(scene);
                                    stage.show();

                            } catch (IOException ex) {
                                Logger.getLogger(AddMemberAccountController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                          }     
              }       
         }     
       } catch (SQLException ex) {
           Logger.getLogger(AddMemberAccountController.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("SQL error");
       } 
    }
}
