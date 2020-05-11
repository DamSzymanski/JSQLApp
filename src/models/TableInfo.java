/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Damian
 */
public class TableInfo {
        public String table_catalog;
        public String table_type;
        public String table_name;
        
        public TableInfo(String table_catalog, String table_type, String table_name) {
            this.table_catalog = table_catalog;
            this.table_type = table_type;
            this.table_name = table_name;
        }
        
        public TableInfo() {
            
        }
}
