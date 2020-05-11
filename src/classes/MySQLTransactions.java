/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.DatabaseConnection;
import static classes.Main.*;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import models.DbInfo;

/**
 *
 * @author jsarnowski
 */
public class MySQLTransactions {

    
    public MySQLTransactions() {

    }
    
  
    
    public void GetDatabases() {
        try {            
            statusCode = main.databaseConnection.CheckConnectionStatus();
            if(statusCode == 1) {
                String query = "SELECT name, create_date FROM sys.databases";
                Statement statement = main.databaseConnection.connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while(rs.next()) {
                    DbInfo database = new DbInfo(rs.getString("name"), rs.getString("create_date"));
                    //databases.add(database);
                }
            }
            else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    
    public ResultSet GetTableListForDb(String dbName){ 
        try{
            statusCode = main.databaseConnection.CheckConnectionStatus();
            if(statusCode == 1) {
                Statement stmt = main.databaseConnection.connection.createStatement();
                ResultSet res = stmt.executeQuery("use "+dbName+"; show tables");
                return res;
            }
            else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        }
        catch(Exception ex){
         System.out.println("Connection exception  " + ex.toString());
         ex.printStackTrace();
        }
        return null;
    }
       
    public ResultSet GetDBList(){
        try{
            statusCode = main.databaseConnection.CheckConnectionStatus();
            if(statusCode == 1) {
                Statement stmt = main.databaseConnection.connection.createStatement();
                ResultSet res = stmt.executeQuery("SHOW DATABASES;");
                return res;
            }
            else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        }
        catch(Exception ex){
            System.out.println("Connection exception  " + ex.toString());
            ex.printStackTrace();
        }
        return null;
    }
        
    private int statusCode;
}
