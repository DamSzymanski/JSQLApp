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
    public List<String> databases = Arrays.asList();
    
    public Transactions() {

    }
    
     public class Database {
        public String name;
        public String create_date;
        
        public Database(String name, String create_date) {
            this.name = name;
            this.create_date = create_date;
        }
        
        public Database() {
            
        }
    }
    
    public class Table {
        public String table_catalog;
        public String table_type;
        public String table_name;
        
        public Table(String table_catalog, String table_type, String table_name) {
            this.table_catalog = table_catalog;
            this.table_type = table_type;
            this.table_name = table_name;
        }
        
        public Table() {
            
        }
    }
    
    public void GetDatabases() {
        try {            
            statusCode = main.databaseConnection.CheckConnectionStatus();
            if(statusCode == 1) {
                String query = "SELECT name, create_date FROM sys.databases";
                Statement statement = main.databaseConnection.connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while(rs.next()) {
                    Database database = new Database(rs.getString("name"), rs.getString("create_date"));
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
    
    public void GetTables(String database) {
        try {            
            statusCode = main.databaseConnection.CheckConnectionStatus();
            if(statusCode == 1) {
                String query = "SELECT TABLE_NAME, TABLE_CATALOG, TABLE_TYPE FROM INFORMATION_SCHEMA.TABLES where TABLE_CATALOG = '" + database + "'";
                Statement statement = main.databaseConnection.connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while(rs.next()) {
                    Table table = new Table(rs.getString("TABLE_CATALOG"), rs.getString("TABLE_NAME"), rs.getString("TABLE_TYPE"));
                    //tables.add(table);
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
        
    private int statusCode;
}
