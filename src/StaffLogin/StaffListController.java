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
    private TableView<StaffData> personTable;
    @FXML
    private TableColumn<StaffData,String> firstNameColumn;
    @FXML
    private TableColumn<StaffData,String> lastNameColumn;
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
    
    public void initialize(URL url, ResourceBundle rb){
        try{
        PreparedStatement ps;
                Database.openConnection();
                data=FXCollections.observableArrayList();
        ps = con.prepareStatement("SELECT FIRST_NAME,LAST_NAME FROM PUBLIC.STAFF;");
        ResultSet result = ps.executeQuery();        
        
        while (result.next()){
            //System.out.println(result.getString("FIRST_NAME"));
            //firstNameLabel.setText(result.getString("FIRST_NAME"));
            data.add(new StaffData(result.getString("FIRST_NAME"),result.getString("LAST_NAME")));
            System.out.println("sth3");
        }
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<StaffData,String>("FIRST_NAME"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<StaffData,String>("LAST_NAME"));
            System.out.println("sth4");
        personTable.setItems(null);
            System.out.println("sth5");
        personTable.setItems(data);
            System.out.println("sth6");
        
            //personTable.getColumns().addAll(firstNameColumn, lastNameColumn);
            result.close();
            ps.close();
        }catch(SQLException se){
            System.out.println(se.getMessage());
            System.out.println(se.getErrorCode());
            System.out.println("Error connecting to database !");
        }

	Database.closeConnection();
        }   
    
    public static class StaffData {
        private SimpleStringProperty firstNameColumn;
        private SimpleStringProperty lastNameColumn;

        private StaffData(String first_name, String last_name) {
            this.firstNameColumn=new SimpleStringProperty(first_name);
            this.lastNameColumn=new SimpleStringProperty(last_name);
            
        }
        public StringProperty getFirst_nameProperty(){
            return firstNameColumn;
        }
        public StringProperty getlast_nameProperty(){
            return lastNameColumn;
        }
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
