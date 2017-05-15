/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageAfterStaffLogin;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sunyifei
 */
public class PageAfterStaffLogin extends Application {
    
    private static Stage stage;
    
    static Stage getStage(){
        return stage;
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        this.stage = primaryStage;  
        Parent root = FXMLLoader.load(getClass().getResource("PageAfterStaffLoginFXML.fxml"));
        
        Scene scene = new Scene(root, 1280, 768);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        primaryStage.setTitle("Suber");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
