/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seekPosting;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import Database.Database;
import static Database.Database.con;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class SeekPostingController implements Initializable {
     ObservableList<String> time = FXCollections.observableArrayList("00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30", "14:00","14:30","15:00", "15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30");
     
     @FXML
    private TextField startPC;
    @FXML
    private ComboBox timeFrom;
    @FXML
    private ComboBox timeto;
    @FXML
    private TextField endPC;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeFrom.setValue("00:00");
        timeFrom.setItems(time);
        timeto.setValue("00:00");
        timeto.setItems(time);
    }    

    @FXML
    private void createPost(ActionEvent event) {
        Database.openConnection();
        PreparedStatement ps;
         try {
             ps = con.prepareStatement("INSERT INTO SEEK VALUES MEMBER_USERNAME = ?,TIME_TO = ?, TIME_FROM = ?, POSTCODE =? , POSTCODEDESTINATION=?, QUOTA =?  ");
                     
                     } catch (SQLException ex) {
             System.out.println(ex);
         }
    
    }
    
}
