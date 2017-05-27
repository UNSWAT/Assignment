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
/**
 * FXML Controller class
 *
 * @author sunyifei
 */
public class StaffListController implements Initializable {
    
    @FXML
    TableView personTable;
    @FXML
    private TableColumn firstNameColumn;
    @FXML
    private TableColumn lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    
    private static Statement stmt;
    private ObservableList<StaffData> data;
    
    public void initialize(URL url, ResourceBundle rb) {
        try{
        PreparedStatement ps;
                Database.openConnection();
                data=FXCollections.observableArrayList();
        ps = con.prepareStatement("SELECT First_name,last_name from STAFF WHERE FIRST_NAME = ? and LAST_NAME =?");
        ResultSet result = ps.executeQuery();        

        while (result.next()){
            data.add(new StaffData(result.getString("first_name"),result.getString("Last_name")));
           
        }
        firstNameColumn.setCellValueFactory(new PropertyValueFactory("First_Name"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory("Last_Name"));

        personTable.setItems(null);
        personTable.setItems(data);
        
        
        }catch(SQLException se){
            System.out.println("Error connecting to database !");
        }

	Database.closeConnection();
        }   
    
    public static class StaffData {
        private StringProperty firstNameColumn;
        private StringProperty lastNameColumn;

        private StaffData(String first_name, String last_name) {
            this.firstNameColumn=new SimpleStringProperty(first_name);
            this.lastNameColumn=new SimpleStringProperty(last_name);
            
        }
        public StringProperty fist_nameProperty(){
            return firstNameColumn;
        }
        public StringProperty last_nameProperty(){
            return lastNameColumn;
        }
    }
    

    @FXML
    private void clickBackToWorkDesk(ActionEvent event)throws IOException{
        
        System.out.println("going to Staff");
        Parent root = FXMLLoader.load(getClass().getResource("ClickStaff.fxml"));
        Scene scene = new Scene(root);
        Stage stage = StaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };
    
    @FXML
    private void clickNewinStaffList(ActionEvent event)throws IOException{
        
        System.out.println("going to Create a Staff");
        Parent root = FXMLLoader.load(getClass().getResource("AddStaffAccount.fxml"));
        Scene scene = new Scene(root);
        Stage stage = StaffLogin.getStage(); 
        stage.setScene(scene);
        stage.show();
        };

    @FXML
    private void clickBackToWorkDesk(MouseEvent event) {
    }

    @FXML
    private void clickNewinStaffList(MouseEvent event) {
    }
    
}
