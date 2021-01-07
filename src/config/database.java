/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Klaus
 */
public class database {
    public Connection conn;
    public Statement st;
    public PreparedStatement pstmt;
    public ResultSet rs;
    public ResultSetMetaData m; 
       
    public Connection koneksi(){
        String URL = "jdbc:ucanaccess://db_gas.accdb";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn = DriverManager.getConnection(URL);
            st = conn.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            
        }
    return conn;
    }
}
