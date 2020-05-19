/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.MSSQLConnection;
import static classes.AppInit.*;
import frames.TableSelectFrame;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.DbInfo;

/**
 *
 * @author jsarnowski
 */
public class MySQLTransactions {

    
    public MySQLTransactions() {

    }
    //pobranie listy tabel dla podanej bazy
    public ResultSet GetTableListForDb(String dbName){ 
        try{
            statusCode = appInit.mysqlConnection.CheckConnectionStatus();
            if(statusCode == 1) {
                Statement stmt = appInit.mysqlConnection.connection.createStatement();
                Statement stmt2 = appInit.mysqlConnection.connection.createStatement();
                   ResultSet rs1=stmt.executeQuery("use "+dbName+";");
                ResultSet res = stmt.executeQuery("show tables");
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
       //listowanie baz danych 
    public ResultSet GetDBList(){
        try{
            statusCode = appInit.mysqlConnection.CheckConnectionStatus();
            if(statusCode == 1) {
                Statement stmt = appInit.mysqlConnection.connection.createStatement();
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
    //pobranie wszystkich rekordow dla danej tabeli
        public ResultSet SelectAll(String dbName,String tableName){
        try{
            statusCode = appInit.mysqlConnection.CheckConnectionStatus();
            if(statusCode == 1) {
                try{
                Statement stmt = appInit.mysqlConnection.connection.createStatement();
                //konieczne zaznaczenie, którą bazę wykorzystujemuy
                ResultSet dbSelection = stmt.executeQuery("use " + dbName + ";");
                ResultSet res = stmt.executeQuery("select * from " + tableName+ ";");
                
                return res;

                }catch (Exception ex){
                    System.out.println(ex);
                    ex.printStackTrace();
                }
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
        
        
      //usuwanie z bazy
        public ResultSet Delete(String dbName,String tableName,String columnName,String conditionValue){
                try{
            statusCode = appInit.mysqlConnection.CheckConnectionStatus();
            if(statusCode == 1) {
                Statement stmt = appInit.mysqlConnection.connection.createStatement();
                ResultSet dbSelection = stmt.executeQuery("use " + dbName + ";");
                ResultSet res = stmt.executeQuery("delete from "+tableName+" where "+columnName+"="+conditionValue);
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
