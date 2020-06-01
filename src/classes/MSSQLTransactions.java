/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.MSSQLConnection;
import static classes.AppInit.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jsarnowski
 */
public class MSSQLTransactions {

    public List<String> tables = Arrays.asList();
    public List<String> databases = Arrays.asList();

    public MSSQLTransactions() {

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
            statusCode = appInit.mssqlConnection.CheckConnectionStatus();
            if (statusCode == 1) {
                String query = "SELECT name, create_date FROM sys.databases";
                Statement statement = appInit.mssqlConnection.connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    Database database = new Database(rs.getString("name"), rs.getString("create_date"));
                    //databases.add(database);
                }
            } else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void GetTables(String database) {
        try {
            statusCode = appInit.mssqlConnection.CheckConnectionStatus();
            if (statusCode == 1) {
                String query = "SELECT TABLE_NAME, TABLE_CATALOG, TABLE_TYPE FROM INFORMATION_SCHEMA.TABLES where TABLE_CATALOG = '" + database + "'";
                Statement statement = appInit.mssqlConnection.connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    Table table = new Table(rs.getString("TABLE_CATALOG"), rs.getString("TABLE_NAME"), rs.getString("TABLE_TYPE"));
                    //tables.add(table);
                }
            } else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public ResultSet GetTableListForDb(String dbName) {
        try {
            statusCode = appInit.mssqlConnection.CheckConnectionStatus();
            if (statusCode == 1) {
                Statement stmt = appInit.mssqlConnection.connection.createStatement();
                ResultSet res = stmt.executeQuery("use " + dbName + " SELECT TABLE_NAME FROM information_schema.tables;");
                return res;
            } else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        } catch (Exception ex) {
            System.out.println("Connection exception  " + ex.toString());
            ex.printStackTrace();
        }
        return null;
    }

    public ResultSet GetDBList() {
        try {
            statusCode = appInit.mssqlConnection.CheckConnectionStatus();
            if (statusCode == 1) {
                Statement stmt = appInit.mssqlConnection.connection.createStatement();
                ResultSet res = stmt.executeQuery("SELECT name, database_id FROM sys.databases;  ");
                return res;
            } else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        } catch (Exception ex) {
            System.out.println("Connection exception  " + ex.toString());
            ex.printStackTrace();
        }
        return null;
    }

    public ResultSet SelectAll(String dbName, String tableName) {
        try {
            statusCode = appInit.mssqlConnection.CheckConnectionStatus();
            if (statusCode == 1) {
                try {
                    Statement stmt = appInit.mssqlConnection.connection.createStatement();
                    //konieczne zaznaczenie, którą bazę wykorzystujemuy
                    ResultSet res = stmt.executeQuery("use " + dbName + "; select * from " + tableName + ";");

                    return res;

                } catch (Exception ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        } catch (Exception ex) {
            System.out.println("Connection exception  " + ex.toString());
            ex.printStackTrace();
        }
        return null;
    }

    //usuwanie z bazy
    public int Delete(String dbName, String tableName, String columnName, String conditionValue) {
        try {
            statusCode = appInit.mssqlConnection.CheckConnectionStatus();
            if (statusCode == 1) {
                Statement stmt = appInit.mssqlConnection.connection.createStatement();
                int res = stmt.executeUpdate("delete from " + tableName + " where " + columnName + "=" + conditionValue);
                return res;
            } else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        } catch (Exception ex) {
            System.out.println("Connection exception  " + ex.toString());
            ex.printStackTrace();
        }
        return 0;
    }
    //update

    public int Update(String updateString, String tableName, String columnName, String conditionValue) {
        try {
            statusCode = appInit.mssqlConnection.CheckConnectionStatus();
            if (statusCode == 1) {
                Statement stmt = appInit.mssqlConnection.connection.createStatement();
                String cellKindString = "";
                try {
                    Integer.parseInt(conditionValue);
                    cellKindString = "=" + conditionValue;
                } catch (NumberFormatException e) {
                    cellKindString = "='" + conditionValue + "'";
                }

                System.out.println("update " + tableName + " set " + updateString + "where " + columnName + cellKindString);

                int res = stmt.executeUpdate("update " + tableName + " set " + updateString + "where " + columnName + cellKindString);
                return res;
            } else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        } catch (Exception ex) {
            System.out.println("Connection exception  " + ex.toString());
            ex.printStackTrace();
        }
        return 0;
    }

    //insert
    public int Insert(String tableName, ArrayList<String> values) {
        try {
            statusCode = appInit.mssqlConnection.CheckConnectionStatus();
            if (statusCode == 1) {
                Statement stmt = appInit.mssqlConnection.connection.createStatement();
                String query = "insert into " + tableName + " values (";
                for(int i = 0; i < values.size(); i++) {
                    try {
                        Integer.parseInt(values.get(i));
                        if(i < values.size() - 1) {
                            query += values.get(i) + ",";
                        }
                        else {
                            query += values.get(i) + ")";  
                        }
                    } catch(NumberFormatException ex) {
                        if(i < values.size() - 1) {
                            query += "'" + values.get(i) + "',";    
                        }
                        else {
                            query += "'" + values.get(i) + "')";
                        }
                    }
                }
                int res = stmt.executeUpdate(query);
                return res;
            } else {
                System.out.println("Connection not established - return code " + statusCode);
            }
        } catch (Exception ex) {
            System.out.println("Connection exception  " + ex.toString());
            ex.printStackTrace();
        }
        return 0;
    }
    private int statusCode;
}
