/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author APCL
 */
public class DataConnectionTemplate {
    
    private String schema = "my_bkash_db";
    private String pass = "azmol";
    private String driver = "com.mysql.jdbc.Driver";
    private Connection connection;
    private PreparedStatement pstm;
    private ResultSet res;
    
    public void connectedDriver(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Message : " + ex.getMessage());
        }
    }
    
    public void doConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + schema, "root", pass);
        } catch (SQLException ex) {
            System.out.println("SQL Status : " + ex.getSQLState());
            System.out.println("Message : " + ex.getMessage());
        }
    }
    
    public ResultSet showData(String stm){
        try {
            pstm = connection.prepareStatement(stm);
            res = pstm.executeQuery();
        } catch (SQLException ex) {
            System.out.println("SQL Status : " + ex.getSQLState());
            System.out.println("Message : " + ex.getMessage());
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Please insert required fields !!");
        }
        return res;
    }
    
    public int modifyData(String stm){
        int num = 0;
        try {
            pstm = connection.prepareStatement(stm);
            num = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQL Status : " + ex.getSQLState());
            System.out.println("Message : " + ex.getMessage());
        }
        return num;
    }
    
    public void closeConnection(){
        try {
            res.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("SQL Status : " + ex.getSQLState());
            System.out.println("Message : " + ex.getMessage());
        }
    }
    
}
