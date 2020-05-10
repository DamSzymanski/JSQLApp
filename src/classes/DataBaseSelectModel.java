/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Damian
 */
public class DataBaseSelectModel {
    public String dbName;
    public int dbId;
     
    public DataBaseSelectModel(String dbName,int dbId){
        this.dbName = dbName;
        this.dbId = dbId;
    }
     
}
