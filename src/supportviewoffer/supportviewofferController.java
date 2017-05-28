/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportviewoffer;

import myOffersDriverTable.*;
import VehicleSeekTable.*;
import SeekTableView.*;
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
import java.io.IOException;
import static java.lang.Integer.parseInt;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import memberLogin2.User;
import memberType.MemberBothController;
import vehicleSeekRider.VehicleSeekPostController;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class supportviewofferController implements Initializable {

    @FXML
    private TableView<Offer2> offers;
    @FXML
    private TableColumn<Offer2, String> memberUsername;
    @FXML
    private TableColumn<Offer2, String> TimeFrom;
    @FXML
    private TableColumn<Offer2, String> TimeTo;
    @FXML
    private TableColumn<Offer2, Integer> PostcodeFrom;
    @FXML
    private TableColumn<Offer2, Integer> PostcodeTo;
    @FXML
    private TableColumn<Offer2, String> CarType;
    @FXML
    private TableColumn<Offer2, Integer> Quota;
    
    @FXML
    private TableColumn<Offer2, Integer> OfferId;
    
    @FXML
    private TableColumn<Offer2, String> Status;
    
    
    
    

    /**
     * Initializes the controller class.
     */
    
   
    private ObservableList<Offer2> data;
    private PreparedStatement getOffers;
    @FXML
    private Label username;


    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(User.getUsername());
        try{
            Database.openConnection();
            data=FXCollections.observableArrayList();
            getOffers = con.prepareStatement("select MEMBER_USERNAME,POSTCODE_FROM,POSTCODE_TO, TIME_FROM, TIME_TO, QUOTA, CARTYPE, OFFER_ID, STATUS from OFFER ORDER BY STATUS");           
           
            ResultSet rs = getOffers.executeQuery();            
            while(rs.next()){
                data.add(new Offer2(rs.getString("MEMBER_USERNAME"),rs.getString("TIME_FROM"),rs.getString("TIME_TO"),rs.getString("CARTYPE"),rs.getInt("POSTCODE_FROM"),rs.getInt("POSTCODE_TO"),rs.getInt("QUOTA"),rs.getInt("OFFER_ID"), rs.getString("STATUS")));
            }
            
//           
           
            memberUsername.setCellValueFactory(new PropertyValueFactory<>("memberUsername"));
            TimeFrom.setCellValueFactory(new PropertyValueFactory<>("timefrom"));
            TimeTo.setCellValueFactory(new PropertyValueFactory<>("timeto"));
            PostcodeFrom.setCellValueFactory(new PropertyValueFactory<>("postcodefrom"));
            PostcodeTo.setCellValueFactory(new PropertyValueFactory<>("postcodeto"));
            CarType.setCellValueFactory(new PropertyValueFactory<>("cartype"));
            Quota.setCellValueFactory(new PropertyValueFactory<>("quota"));
            OfferId.setCellValueFactory(new PropertyValueFactory<>("Offerid"));
            Status.setCellValueFactory(new PropertyValueFactory<>("status"));
            
            offers.setItems(null);
            offers.setItems(data);
            
                    
            
        }catch(SQLException se){
            System.out.println(se);
        }
        Database.closeConnection();
    }  

    @FXML
    private void Home(ActionEvent event) {
          try {
                Pane root;
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/PageAfterStaffLoginFXML.fxml"));
                
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(new Scene((Pane)loader.load()));
                
                
                
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MemberBothController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Page Error");
            }        
    }

    

    

    @FXML
    private void logOut(ActionEvent event) {
     try {
                Pane root;
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/StaffLoginFXML.fxml"));
                
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(new Scene((Pane)loader.load()));
                
                
                
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MemberBothController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Page Error");
            }        
    }

   
  

    
    
    
}
