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

/**
 *
 * @author jsarnowski
 */
public class Transactions {
    public List<String> tables = Arrays.asList();
    
    public Transactions() {

    }
    
    public void GetTables() {
        try {
            statusCode = main.databaseConnection.CheckConnectionStatus();
            if(statusCode == 1) {
                DatabaseMetaData md = main.databaseConnection.connection.getMetaData();
                ResultSet rs = md.getTables(null, null, "%", null);
                while (rs.next()) {
                    System.out.println(rs.getString(3));
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
    
    public ResultSet GetDBList(){
                
        try{
             statusCode = main.databaseConnection.CheckConnectionStatus();
            if(statusCode == 1) {
              Statement stmt = main.databaseConnection.connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT name, database_id FROM sys.databases;  ");
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
       public ResultSet GetTableListForDb(String dbName){
                
        try{
             statusCode = main.databaseConnection.CheckConnectionStatus();
            if(statusCode == 1) {
              Statement stmt = main.databaseConnection.connection.createStatement();
        ResultSet res = stmt.executeQuery("use "+dbName+" SELECT TABLE_NAME FROM information_schema.tables;");
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
