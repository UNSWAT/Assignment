/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberProfile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Database.Database;
import static Database.Database.con;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import memberLogin2.User;

/**
 * FXML Controller class
 *
 * @author MI-PC
 */
public class memberProfileController implements Initializable {

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
    private TableColumn<Member, Integer> hpostcode;
    @FXML
    private TableColumn<Member, String> hstate;
    @FXML
    private TableColumn<Member, String> waddress;
    @FXML
    private TableColumn<Member, String> wsuburb;
    @FXML
    private TableColumn<Member, Integer> wpostcode;
    @FXML
    private TableColumn<Member, String> wstate;

    private ObservableList<Member> data;
    private PreparedStatement getMembers;
    @FXML
    private Label username;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(User.getUsername());
        String user = username.getText();
        try {
            Database.openConnection();
            data = FXCollections.observableArrayList();
            getMembers = con.prepareStatement("SELECT MEMBER_USERNAME,MEMBER_PASSWORD, "
                    + "FIRST_NAME, LAST_NAME, EMAIL_ADDRESS,MOBILE_NO, HOME_ADDRESS, HOME_SUBURB, "
                    + "HOME_POSTCODE, HOME_STATE, WORK_ADDRESS, WORK_SUBURB,WORK_POSTCODE,WORK_STATE FROM MEMBERS WHERE MEMBER_USERNAME = ?; ");
            getMembers.setString(1, user);
            getMembers.executeQuery();
//            getOffers.setInt(1,OtherStaticVariables.getQuota() );
//            getOffers.setString(2, username.getText());
//            getOffers.setInt(3, OtherStaticVariables.getPostcodefrom());
//            getOffers.setString(4, OtherStaticVariables.getTimefrom());

            ResultSet rs = getMembers.executeQuery();

            while (rs.next()) {
                data.add(new Member(rs.getString("MEMBER_USERNAME"), rs.getString("MEMBER_PASSWORD"),
                        rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL_ADDRESS"),
                        rs.getString("MOBILE_NO"), rs.getString("HOME_ADDRESS"), rs.getString("HOME_SUBURB"), 
                        rs.getInt("HOME_POSTCODE"),rs.getString("HOME_STATE"), rs.getString("WORK_ADDRESS"), 
                        rs.getString("WORK_SUBURB"), rs.getInt("WORK_POSTCODE"), rs.getString("WORK_STATE")));
            }

//            ResultSet result = getOffers.executeQuery();
//            while(result.next()){
//                String userName = result.getString("MEMBER_USERNAME");
//                String timeFrom = result.getString("TIME_FROM");
//                String timeTo = result.getString("TIME_TO");
//                String carType = result.getString("Cartype");
//                int postcodeFrom = result.getInt("POSTCODE_FROM");
//                int postcodeTo =result.getInt("POSTCODE_TO");
//                int Quota = result.getInt("QUOTA");
//                Offer offer = new Offer(userName, timeFrom, timeTo,carType,postcodeFrom,postcodeTo,Quota);
//                System.out.println(offer.getMemberUsername());
//                System.out.println(offer.getTimefrom());
//                data.add(offer);
            //}
            memberusername.setCellValueFactory(new PropertyValueFactory<>("memberusername"));
            password.setCellValueFactory(new PropertyValueFactory<>("password"));
            fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
            lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
            haddress.setCellValueFactory(new PropertyValueFactory<>("haddress"));
            hsuburb.setCellValueFactory(new PropertyValueFactory<>("hsuburb"));
            hpostcode.setCellValueFactory(new PropertyValueFactory<>("hpostcode"));
            hstate.setCellValueFactory(new PropertyValueFactory<>("hstate"));
            waddress.setCellValueFactory(new PropertyValueFactory<>("waddress"));
            wsuburb.setCellValueFactory(new PropertyValueFactory<>("wsuburb"));
            wpostcode.setCellValueFactory(new PropertyValueFactory<>("wpostcode"));
            wstate.setCellValueFactory(new PropertyValueFactory<>("wstate"));

            members.setItems(null);
            members.setItems(data);

        } catch (SQLException se) {
            System.out.println(se);
        }
        Database.closeConnection();
    }

    @FXML
    private void Home(ActionEvent event) {
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberType/memberBoth.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(memberProfileController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Page Error");
        }
    }

    @FXML
    private void logOut(ActionEvent event) {
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/memberLogin2/Login.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(memberProfileController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Page Error");
        }
    }
}

/*@FXML
    private void edit(ActionEvent event) {        
            Offer currentOffer = (Offer)members.getSelectionModel().getSelectedItem();
            int offerID = currentOffer.getOfferid();
            PreparedStatement ps;
            Database.openConnection();
        try {
             ps=con.prepareStatement("UPDATE OFFER SET STATUS = 'Accepted' WHERE OFFER_ID = ?;");
             ps.setInt(offerID, 1);
             
            
            
            
            
            
            
            
            Database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(memberProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
