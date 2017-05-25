/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Database.Database;
import static Database.Database.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class RegisterPageController implements Initializable {

   ObservableList<String> states = FXCollections.observableArrayList("NSW","QLD","SA","WA","NT","VIC","ACT");
   ObservableList<String> CompanyConsultancy = FXCollections.observableArrayList("Yes","No");
   ObservableList<String> ExpiryMonth = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");
   ObservableList<String> ExpiryYear = FXCollections.observableArrayList("17","18","19","20","21","22","23","24");
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
    private TextField creditNo;
    @FXML
    private Button createAccount;
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
    private TextField ccCCV;
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
    private Button goBack;
    @FXML
    private ComboBox ccMonth;
    @FXML
    private ComboBox ccYear;
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
        workState.setItems(states);
        ccMonth.setValue("01");
        ccYear.setValue("17");
        ccMonth.setItems(ExpiryMonth);
        ccYear.setItems(ExpiryYear);
        memberType.setValue("Rider");
        memberType.setItems(memType);
        
        
    }    

    @FXML
    private void createAccount(ActionEvent event) throws SQLException, IOException {
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
            String creditNumber = creditNo.getText();
            
            String password1 = password.getText();
            String passwordConfirm = password2.getText();
            String homeAdd = homeAddress.getText();
            String homeSub = homeSuburb.getText();
            String homePC = homePostCode.getText();
            String homestate = homeState.getSelectionModel().getSelectedItem().toString();
            String CreditCardback = ccCCV.getText();
            String workAdd = workAddress.getText();
            String workSub = workSuburb.getText();
            String workPC = workPostcode.getText();
            String consult = consultancy.getSelectionModel().getSelectedItem().toString();
            String expiryMon = ccMonth.getSelectionModel().getSelectedItem().toString();
            String expiryYr = ccYear.getSelectionModel().getSelectedItem().toString();
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
             else if (passwordConfirm.equals("")){
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

              else if (creditNumber.equals("")){
                 errorMessage.setText("Please enter a valid credit card number");
                 check =true;
             }
              else if (CreditCardback.equals("")){
                  errorMessage.setText("Please enter a CCV number");
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
                  }
                  
                  else {              
                      insertMember = con.prepareStatement("INSERT INTO PUBLIC.MEMBERS(MEMBER_USERNAME,MEMBER_PASSWORD,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,MOBILE_NO,HOME_ADDRESS,HOME_SUBURB,HOME_POSTCODE,HOME_STATE,WORK_ADDRESS,WORK_SUBURB,WORK_POSTCODE,WORK_STATE,CC_NUMBER,CC_EXPIRY_MONTH,CC_EXPIRY_YEAR,CORPORATE_MEMBER,COMPANY_NAME,MEMBER_TYPE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                            int expMon = Integer.parseInt(expiryMon);
                            long ccNo = Long.parseLong(creditNumber);
                            int expYr = Integer.parseInt(expiryYr);
                            int homepostcode = Integer.parseInt(homePC);
                            int workpostcode = Integer.parseInt(workPC);
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
                            insertMember.setLong(15,ccNo);
                            insertMember.setInt(16,expMon);
                            insertMember.setInt(17,expYr);
                            insertMember.setString(18,consult);
                            insertMember.setString(19, companyN);
                            insertMember.setString(20,membType);   
                            insertMember.execute();
                            insertMember.close(); 
                            check =true;  
                            //change back to page login page.
                            Parent root = FXMLLoader.load(getClass().getResource("/memberLogin2/Login.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                            memberLogin2.LoginController.setLabel.setText("Registration Successful");
               
                          }
                      
                    
              }
                 
             }
        
     
       } catch (SQLException ex) {
           Logger.getLogger(RegisterPageController.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("SQL error");
       } 
        
        Database.closeConnection();
        
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/memberLogin2/Login.fxml"));
         Scene scene = new Scene(root);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         stage.setScene(scene);
         stage.show();
               
}
}


    

    

