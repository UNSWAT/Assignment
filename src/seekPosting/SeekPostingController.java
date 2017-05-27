/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seekPosting;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Database.Database;
import static Database.Database.con;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import memberType.MemberBothController;

/**
 * FXML Controller class
 *
 * @author Preet
 */
public class SeekPostingController implements Initializable {

    @FXML
    private TextField startPC;

    @FXML
    private ComboBox timeFrom;

    @FXML
    private ComboBox timeto;

    @FXML
    private TextField endPC;

    @FXML
    private ComboBox quota;

    private Label errorMessage;

    ObservableList<String> time = FXCollections.observableArrayList("00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30");
    ObservableList<String> noOfPassenger = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeFrom.setValue("00:00");
        timeFrom.setItems(time);
        timeto.setValue("00:00");
        timeto.setItems(time);
        quota.setValue("1");
        quota.setItems(noOfPassenger);

    }

    @FXML
    private Label userlabel;

    public void getUser(String user) {
        userlabel.setText(user);
    }

    @FXML
    private void createPost(ActionEvent event) throws SQLException {
        try {
            boolean check = false;
            PreparedStatement insertSeek = null;
            Database.openConnection();

            String MEMBERUSERNAME = userlabel.getText();

            String TIMETO = timeto.getSelectionModel().getSelectedItem().toString();

            String TIMEFROM = timeFrom.getSelectionModel().getSelectedItem().toString();

            String POSTCODE = startPC.getText();

            String POSTCODEDESTINATION = endPC.getText();

            String QUOTA = quota.getSelectionModel().getSelectedItem().toString();

            while (check == false) {
                if (timeto.equals("")) {
                    errorMessage.setText("Please enter a starting time");
                    check = true;
                } else if (timeFrom.equals("")) {
                    errorMessage.setText("Please enter a ending time");
                    check = true;
                } else if (startPC.equals("")) {
                    errorMessage.setText("Please enter your starting location postcode");
                    check = true;
                } else if (endPC.equals("")) {
                    errorMessage.setText("Please enter your denstination postcode");
                    check = true;
                } else if (quota.equals("")) {
                    errorMessage.setText("Please enter a valid password");
                    check = true;

                } else {
                    insertSeek = con.prepareStatement("INSERT INTO SEEK VALUES MEMBER_USERNAME = ?,TIME_TO = ?, TIME_FROM = ?, POSTCODE =? , POSTCODE_DESTINATION=?, QUOTA =?  ");
                    insertSeek.setString(1, MEMBERUSERNAME);
                    insertSeek.setString(2, TIMETO);
                    insertSeek.setString(3, TIMEFROM);
                    insertSeek.setString(4, POSTCODE);
                    insertSeek.setString(5, POSTCODEDESTINATION);
                    insertSeek.setString(6, QUOTA);

                    check = true;
                    Database.closeConnection();
                    try {
                        Parent root;
                        root = FXMLLoader.load(getClass().getResource("/memberType/riderForBoth.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException ex) {
                        Logger.getLogger(MemberBothController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeekPostingController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL error");
        }
    }

    @FXML
    private void clickMyProfile(ActionEvent event) {
    }

    @FXML
    private void clickMyAgreements(ActionEvent event) {
    }

    @FXML
    private void clickLogout(ActionEvent event) {
    }
}
