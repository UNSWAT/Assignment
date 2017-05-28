package StaffLogin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import Database.Database;
import static Database.Database.con;
import Suber.Models.Staff;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import memberLogin2.memberLogin;
/**
 * FXML Controller class
 *
 * @author sunyifei
 */
public class StaffListController implements Initializable {
    
   @FXML
    private TableView<Staff> staff;
    @FXML
    private TableColumn<Staff,String> FirstName;
    @FXML
    private TableColumn<Staff,String> LastName;
    @FXML
    private TableColumn<Staff,String> username;
    @FXML
    private TableColumn<Staff,String> password;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    
    private ObservableList<Staff> data;
    private PreparedStatement getStaff;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            Database.openConnection();
            data=FXCollections.observableArrayList();
            getStaff = con.prepareStatement("select FIRST_NAME,LAST_NAME,USERNAME,PASSWORD from STAFF" );
            ResultSet rs = getStaff.executeQuery();
            while(rs.next()){
                data.add(new Staff(rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"),rs.getString("USERNAME"),rs.getString("PASSWORD")));
            }
            FirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            username.setCellValueFactory(new PropertyValueFactory<>("username"));
            password.setCellValueFactory(new PropertyValueFactory<>("password"));
            
            staff.setItems(null);
            staff.setItems(data);
        }catch(SQLException se){
            System.out.println(se);
        }
        Database.closeConnection();
    }
    

    @FXML
    private void Back(ActionEvent event){
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/ClickStaff.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(StaffListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clickNewinStaffList(ActionEvent event){
        try {
            Pane root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StaffLogin/AddStaffAccount.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene((Pane) loader.load()));

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(StaffListController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StaffListController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StaffListController.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
    
}
