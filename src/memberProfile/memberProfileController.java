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
import offerPosting.Offer;
import Database.Database;
import static Database.Database.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Member> members2;
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
    
    @FXML
    private Label memberPassword;
    
    @FXML
    private Label fName;
    @FXML
    private Label lName;
    @FXML
    private Label emailAddress;
    @FXML
    private Label mobileNo;
    @FXML
    private Label homeAddress;
    @FXML
    private Label homeSuburb;
    @FXML
    private Label homePostcode;
    @FXML
    private Label homeState;
    @FXML
    private Label workSddress;
    @FXML
    private Label workSuburb;
    @FXML
    private Label workPostcode;
    @FXML
    private Label workState;
    @FXML
    private Label ccNumber;
    @FXML
    private Label ccExpiryMonth;
    @FXML
    private Label ccExpiryYear;
    @FXML
    private Label corporateMember;
    @FXML
    private Label companyName;
    @FXML
    private Label memberType;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(User.getUsername());
        try{
            Database.openConnection();
            data=FXCollections.observableArrayList();
            getMembers = con.prepareStatement("select MEMBER_USERNAME,MEMBER_PASSWORD, "
                    + "FISRST_NAME, LAST_NAME, EMAIL_ADDRESS,MOBILE_NO, HOME_ADDRESS, HOME_SUBURB, "
                    + "HOME_POSTCODE, HOME_STATE, WORK_ADDRESS, WORK_SUBURB,WORKPOSTCODE,WORKSTATE,"
                    + "CCNUMBER,CCEXPRIRY_MONTH, CCEXPIRY_YEAR, CORPORATE_MEMBER, "
                    + "COMPANY_NAME,MEMBER_TYPE from MEMBERS ");
//            getOffers.setInt(1,OtherStaticVariables.getQuota() );
//            getOffers.setString(2, username.getText());
//            getOffers.setInt(3, OtherStaticVariables.getPostcodefrom());
//            getOffers.setString(4, OtherStaticVariables.getTimefrom());
           
            ResultSet rs = getMembers.executeQuery();
            
            while(rs.next()){
                data.add(new Member(rs.getString("MEMBER_USERNAME"),rs.getString("MEMBER_PASSWORD"),
                        rs.getString("FISRST_NAME"),rs.getString("LAST_NAME"),rs.getString("EMAIL_ADDRESS"),
                        rs.getString("MOBILE_NO"),rs.getString("HOME_ADDRESS"),rs.getString("HOME_SUBURB"),
                        rs.getString("HOME_POSTCODE"),rs.getString("HOME_STATE"),rs.getString("WORK_ADDRESS"),rs.getString("WORK_SUBURB"),
                rs.getString("WORKPOSTCODE"),rs.getString("WORKSTATE"),rs.getString("CCNUMBER"),rs.getString("CCEXPRIRY_MONTH"),
                rs.getString("CCEXPIRY_YEAR"),rs.getString("CORPORATE_MEMBER"),rs.getString("COMPANY_NAME"),rs.getString("MEMBER_TYPE")));
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

            memberusername.setCellValueFactory(new PropertyValueFactory<>("MEMBER_USERNAME"));
            password.setCellValueFactory(new PropertyValueFactory<>("MEMBER_PASSWORD"));
            fname.setCellValueFactory(new PropertyValueFactory<>("FISRST_NAME"));
            lname.setCellValueFactory(new PropertyValueFactory<>("LAST_NAME"));
            email.setCellValueFactory(new PropertyValueFactory<>("EMAIL_ADDRESS"));
            mobile.setCellValueFactory(new PropertyValueFactory<>("MOBILE_NO"));
            haddress.setCellValueFactory(new PropertyValueFactory<>("HOME_ADDRESS"));
            hsuburb.setCellValueFactory(new PropertyValueFactory<>("HOME_SUBURB"));
            hpostcode.setCellValueFactory(new PropertyValueFactory<>("HOME_POSTCODE"));
            hstate.setCellValueFactory(new PropertyValueFactory<>("HOME_STATE"));
            waddress.setCellValueFactory(new PropertyValueFactory<>("WORK_ADDRESS"));
            wsuburb.setCellValueFactory(new PropertyValueFactory<>("WORK_SUBURB"));
            wpostcode.setCellValueFactory(new PropertyValueFactory<>("WORKPOSTCODE"));
            wstate.setCellValueFactory(new PropertyValueFactory<>("WORKSTATE"));
            ccnumber.setCellValueFactory(new PropertyValueFactory<>("CCNUMBER"));
            ccexpirymonth.setCellValueFactory(new PropertyValueFactory<>("CCEXPRIRY_MONTH"));
            ccexpiryyear.setCellValueFactory(new PropertyValueFactory<>("CCEXPIRY_YEAR"));
            corporatemember.setCellValueFactory(new PropertyValueFactory<>("CORPORATE_MEMBER"));
            companyname.setCellValueFactory(new PropertyValueFactory<>("COMPANY_NAME"));
            membertype.setCellValueFactory(new PropertyValueFactory<>("MEMBER_TYPE"));
            
            
            members.setItems(null);
            members.setItems(data);
            
            members.setItems(null);
            members2.setItems(data);
            
                    
            
        }catch(SQLException se){
            System.out.println(se);
        }
        Database.closeConnection();
    }  
  

    @FXML
    private void Home(ActionEvent event) {
    }

    private void MyAgreements(ActionEvent event) {
    }

    @FXML
    private void logOut(ActionEvent event) {
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
    
    
}
