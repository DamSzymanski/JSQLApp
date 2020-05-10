/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import frames.AboutFrame;
import frames.TableSelectFrame;
import frames.LoginFrame;
import frames.TableOverviewFrame;
import frames.TableOverviewFrame;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jsarnowski
 */
public class Main extends Application {
    
    public static Main main;
    
    public Main() {
        main = this;
    }
    
    @Override
    public void start(Stage primaryStage) {
        loginFrame = new LoginFrame();
        loginFrame.setSize(600,500);
        loginFrame.setVisible(true);
        
        databaseConnection = new DatabaseConnection();
        transactions = new Transactions();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }
    
    public LoginFrame loginFrame;
    public TableOverviewFrame tableOverviewFrame;
    public AboutFrame aboutFrame;
    public TableSelectFrame tableSelectFrame;
    public DatabaseConnection databaseConnection;
    public Transactions transactions;
}
