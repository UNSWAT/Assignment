/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffLogin;

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
            ResultSet rs = con.createStatement().executeQuery("select FIRST_NAME,LAST_NAME from STAFF" );
            while(rs.next()){
                data.add(new Staff(rs.getString("FIRST_NAME"),rs.getString("LAST_NAME")));
            }
            FirstName.setCellValueFactory(new PropertyValueFactory<>("FIRST_NAME"));
            LastName.setCellValueFactory(new PropertyValueFactory<>("LAST_NAME"));
            
            staff.setItems(null);
            staff.setItems(data);
        }catch(SQLException se){
            System.out.println(se);
        }
        Database.closeConnection();
    }
    

    @FXML
    private void Back(ActionEvent event)throws IOException{
        
        System.out.println("going to Staff");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/ClickStaff.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickNewinStaffList(ActionEvent event)throws IOException{
        
        System.out.println("going to Create a Staff");
        Parent root = FXMLLoader.load(getClass().getResource("/StaffLogin/AddStaffAccount.fxml"));
        Scene scene = new Scene(root);
        Stage stage = memberLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };

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
