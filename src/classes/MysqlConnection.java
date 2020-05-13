/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damian
 */
public class MysqlConnection {
        public Connection connection;
    public void DatabaseUserAuthentication(String username, String password, String server, int port,String dbName) {
        try {
            
         Class.forName("com.mysql.cj.jdbc.Driver");  
           /* connection = DriverManager.getConnection(
                "jdbc:mysql://" + server+":"+String.valueOf(port)+";",
                username, password
            );    */
           System.out.println("jdbc:mysql://"+server+":"+String.valueOf(port)+"/"+dbName+";");
           //nie działa ale skopiownay do managera działa
          // connection = DriverManager.getConnection("jdbc:mysql://"+server+""+String.valueOf(port)+"/"+dbName+"&autoReconnect=true&failOverReadOnly=false&maxReconnects=10",username, password);
          //działa ale not established
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/siemanko?zeroDateTimeBehavior=CONVERT_TO_NULL",username, password);

            System.out.println(connection+"Eee");
        }
        catch(Exception e) {
            System.out.println(e);
            System.out.println(username);
            System.out.println(password);
            System.out.println(server);            
        }
    }
        public void CloseDatabaseConnection() {
        try {
            if(connection.isClosed() == false) {
                connection.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int CheckConnectionStatus() {
        try {
            if(connection.isClosed() != true) {
                return 1;
            }
            else {
                return 0;
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        return 2;
    }
}
