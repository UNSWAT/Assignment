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
            getMembers = con.prepareStatement("select FIRST_NAME, LAST_NAME, EMAIL_ADDRESS,MOBILE_NO, HOME_ADDRESS, HOME_SUBURB,HOME_POSTCODE, HOME_STATE, WORK_ADDRESS, WORK_SUBURB,WORK_POSTCODE,WORK_STATE,MEMBER_TYPE from MEMBERS ");
           
            ResultSet rs = getMembers.executeQuery();
            
            while(rs.next()){
                data.add(new Member(
                        rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"),rs.getString("EMAIL_ADDRESS"),
                        rs.getString("MOBILE_NO"),rs.getString("HOME_ADDRESS"),rs.getString("HOME_SUBURB"),
                        rs.getInt("HOME_POSTCODE"),rs.getString("HOME_STATE")));
            }

            fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
            lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
            haddress.setCellValueFactory(new PropertyValueFactory<>("haddress"));
            hsuburb.setCellValueFactory(new PropertyValueFactory<>("hsuburb"));
            hpostcode.setCellValueFactory(new PropertyValueFactory<>("hpostcode"));
            hstate.setCellValueFactory(new PropertyValueFactory<>("hstate"));
            membertype.setCellValueFactory(new PropertyValueFactory<>("membertype")); 
            
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
