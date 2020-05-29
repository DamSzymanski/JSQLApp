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
public class AppInit extends Application {
    
    public static AppInit appInit;
    
    public AppInit() {
        appInit = this;
    }
    
    @Override
    public void start(Stage primaryStage) {
        loginFrame = new LoginFrame();
        loginFrame.setSize(600,500);
        loginFrame.setVisible(true);
        
        mssqlConnection = new MSSQLConnection();
        mysqlConnection = new MySQLConnection();
        mssqlTransactions = new MSSQLTransactions();
        mysqlTransactions = new MySQLTransactions();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public MSSQLConnection getDatabaseConnection() {
        return mssqlConnection;
    }
        
    public MySQLConnection getMysqlDatabaseConnection() {
        return mysqlConnection;
    }
    public LoginFrame loginFrame;
    public TableOverviewFrame tableOverviewFrame;
    public AboutFrame aboutFrame;
    public TableSelectFrame tableSelectFrame;
    public MSSQLConnection mssqlConnection;
    public MSSQLTransactions mssqlTransactions;
    public String engine;
    public MySQLConnection mysqlConnection;
    public MySQLTransactions mysqlTransactions;
}
