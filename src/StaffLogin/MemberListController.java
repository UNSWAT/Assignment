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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import memberLogin2.User;
import memberProfile.Member;
import Database.Database;
import static Database.Database.con;

/**
 * FXML Controller class
 *
 * @author sunyifei
 */
public class MemberListController implements Initializable {

    @FXML
    private TableView<Member> members;
    @FXML
    private TableColumn<Member, String> memberusername;
    @FXML
    private TableColumn<Member, String> password;
    @FXML
    private TableColumn<Member, String> fname;
    @FXML
    private TableColumn<Member, String> lname;
    @FXML
    private TableColumn<Member, String> email;
    @FXML
    private TableColumn<Member, String> mobile;
    @FXML
    private TableColumn<Member, String> haddress;
    @FXML
    private TableColumn<Member, String> hsuburb;
    @FXML
    private TableColumn<Member, String> hpostcode;
    @FXML
    private TableColumn<Member, String> hstate;
    @FXML
    private TableColumn<Member, String> waddress;
    @FXML
    private TableColumn<Member, String> wsuburb;
    @FXML
    private TableColumn<Member, String> wpostcode;
    @FXML
    private TableColumn<Member, String> wstate;
    @FXML
    private TableColumn<Member, String> ccnumber;
    @FXML
    private TableColumn<Member, String> ccexpirymonth;
    @FXML
    private TableColumn<Member, String> ccexpiryyear;
    @FXML
    private TableColumn<Member, String> corporatemember;
    @FXML
    private TableColumn<Member, String> companyname;
    @FXML
    private TableColumn<Member, String> membertype;
    
    private ObservableList<Member> data;
    private PreparedStatement getMembers;
    @FXML
    private Label username;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            Database.openConnection();
            data=FXCollections.observableArrayList();
            getMembers = con.prepareStatement("select MEMBER_USERNAME,MEMBER_PASSWORD, "
                    + "FIRST_NAME, LAST_NAME, EMAIL_ADDRESS,MOBILE_NO, HOME_ADDRESS, HOME_SUBURB, "
                    + "HOME_POSTCODE, HOME_STATE, WORK_ADDRESS, WORK_SUBURB,WORK_POSTCODE,WORK_STATE,"
                    + "CC_NUMBER,CCEXPRIRY_MONTH, CCEXPIRY_YEAR, CORPORATE_MEMBER, "
                    + "COMPANY_NAME,MEMBER_TYPE from MEMBERS ");
           
            ResultSet rs = getMembers.executeQuery();
            
            while(rs.next()){
//                data.add(new Member(rs.getString("MEMBER_USERNAME"),rs.getString("MEMBER_PASSWORD"),
//                        rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"),rs.getString("EMAIL_ADDRESS"),
//                        rs.getString("MOBILE_NO"),rs.getString("HOME_ADDRESS"),rs.getString("HOME_SUBURB"),
//                        rs.getString("HOME_POSTCODE"),rs.getString("HOME_STATE"),rs.getString("WORK_ADDRESS"),rs.getString("WORK_SUBURB"),
//                rs.getString("WORK_POSTCODE"),rs.getString("WORK_STATE"),rs.getString("CC_NUMBER"),rs.getString("CCEXPRIRY_MONTH"),
//                rs.getString("CCEXPIRY_YEAR"),rs.getString("CORPORATE_MEMBER"),rs.getString("COMPANY_NAME"),rs.getString("MEMBER_TYPE")));
            }

            memberusername.setCellValueFactory(new PropertyValueFactory<>("MEMBER_USERNAME"));
            password.setCellValueFactory(new PropertyValueFactory<>("MEMBER_PASSWORD"));
            fname.setCellValueFactory(new PropertyValueFactory<>("FIRST_NAME"));
            lname.setCellValueFactory(new PropertyValueFactory<>("LAST_NAME"));
            email.setCellValueFactory(new PropertyValueFactory<>("EMAIL_ADDRESS"));
            mobile.setCellValueFactory(new PropertyValueFactory<>("MOBILE_NO"));
            haddress.setCellValueFactory(new PropertyValueFactory<>("HOME_ADDRESS"));
            hsuburb.setCellValueFactory(new PropertyValueFactory<>("HOME_SUBURB"));
            hpostcode.setCellValueFactory(new PropertyValueFactory<>("HOME_POSTCODE"));
            hstate.setCellValueFactory(new PropertyValueFactory<>("HOME_STATE"));
            waddress.setCellValueFactory(new PropertyValueFactory<>("WORK_ADDRESS"));
            wsuburb.setCellValueFactory(new PropertyValueFactory<>("WORK_SUBURB"));
            wpostcode.setCellValueFactory(new PropertyValueFactory<>("WORK_POSTCODE"));
            wstate.setCellValueFactory(new PropertyValueFactory<>("WORK_STATE"));
            ccnumber.setCellValueFactory(new PropertyValueFactory<>("CC_NUMBER"));
            ccexpirymonth.setCellValueFactory(new PropertyValueFactory<>("CCEXPRIRY_MONTH"));
            ccexpiryyear.setCellValueFactory(new PropertyValueFactory<>("CCEXPIRY_YEAR"));
            corporatemember.setCellValueFactory(new PropertyValueFactory<>("CORPORATE_MEMBER"));
            companyname.setCellValueFactory(new PropertyValueFactory<>("COMPANY_NAME"));
            membertype.setCellValueFactory(new PropertyValueFactory<>("MEMBER_TYPE"));
            
            
            members.setItems(null);
            members.setItems(data);
                  
        }catch(SQLException se){
            System.out.println(se);
        }
        Database.closeConnection();
    }  
    
    @FXML
    private void Back(ActionEvent event)throws IOException{
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/ClickIndividualCustomer.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MemberListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clickNewinMemberList(ActionEvent event)throws IOException{
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/AddMemberAccount.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MemberListController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(MemberListController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MemberListController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }       

    @FXML
    private void clickNewinMemberList(MouseEvent event) {
    }

    @FXML
    private void Back(MouseEvent event) {
    }
    
}
