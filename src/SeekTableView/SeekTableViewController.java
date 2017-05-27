/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeekTableView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import offerPosting.Offer;
import Database.Database;
import static Database.Database.con;
import Database.OtherStaticVariables;
import static java.lang.Integer.parseInt;
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
 * @author Preet
 */
public class SeekTableViewController implements Initializable {

    @FXML
    private TableView<Offer> offers;
    @FXML
    private TableColumn<Offer, String> memberUsername;
    @FXML
    private TableColumn<Offer, String> TimeFrom;
    @FXML
    private TableColumn<Offer, String> TimeTo;
    @FXML
    private TableColumn<Offer, Integer> PostcodeFrom;
    @FXML
    private TableColumn<Offer, Integer> PostcodeTo;
    @FXML
    private TableColumn<Offer, String> CarType;
    @FXML
    private TableColumn<Offer, Integer> Quota;
    
    
    

    /**
     * Initializes the controller class.
     */
    
   
    private ObservableList<Offer> data;
    private PreparedStatement getOffers;
    @FXML
    private Label username;

    
    @FXML
    private Label timefrom;
    @FXML
    private Label timeto;
    @FXML
    private Label postcodefrom;
    @FXML
    private Label postcodeto;
    @FXML
    private Label quota;
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(User.getUsername());
        try{
            Database.openConnection();
            data=FXCollections.observableArrayList();
            getOffers = con.prepareStatement("select MEMBER_USERNAME,POSTCODE_FROM,POSTCODE_TO, TIME_FROM, TIME_TO, QUOTA, CARTYPE from OFFER WHERE QUOTA <= ? AND STATUS = 'Pending' AND MEMBER_USERNAME != ?");
            System.out.println(OtherStaticVariables.getQuota());
            getOffers.setInt(1,OtherStaticVariables.getQuota() );
            getOffers.setString(2, username.getText());
            //getOffers.setInt(2, OtherStaticVariables.getPostcodefrom());
            //getOffers.setString(3, OtherStaticVariables.getTimefrom() );
            ResultSet rs = getOffers.executeQuery();
            while(rs.next()){
                data.add(new Offer(rs.getString("MEMBER_USERNAME"),rs.getString("TIME_FROM"),rs.getString("TIME_TO"),rs.getString("CARTYPE"),rs.getInt("POSTCODE_FROM"),rs.getInt("POSTCODE_TO"),rs.getInt("QUOTA")));
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
           
            memberUsername.setCellValueFactory(new PropertyValueFactory<>("memberUsername"));
            TimeFrom.setCellValueFactory(new PropertyValueFactory<>("timefrom"));
            TimeTo.setCellValueFactory(new PropertyValueFactory<>("timeto"));
            PostcodeFrom.setCellValueFactory(new PropertyValueFactory<>("postcodefrom"));
            PostcodeTo.setCellValueFactory(new PropertyValueFactory<>("postcodeto"));
            CarType.setCellValueFactory(new PropertyValueFactory<>("cartype"));
            Quota.setCellValueFactory(new PropertyValueFactory<>("quota"));
            
            offers.setItems(null);
            offers.setItems(data);
            
                    
            
        }catch(SQLException se){
            System.out.println(se);
        }
        Database.closeConnection();
    }  
  

    @FXML
    private void Home(ActionEvent event) {
    }

    @FXML
    private void myProfile(ActionEvent event) {
    }

    @FXML
    private void MyAgreements(ActionEvent event) {
    }

    @FXML
    private void logOut(ActionEvent event) {
    }

    @FXML
    private void myOffers(ActionEvent event) {
    }
    
    
}
