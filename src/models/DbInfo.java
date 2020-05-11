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
public class DbInfo {
        public String name;
        public String creation_date ;
           public DbInfo(String name, String create_date) {
            this.name = name;
            this.creation_date = create_date;
        }
        
        public DbInfo() {
            
        }
        
}
