/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import emotionsserver.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aleksandra
 */
public class DataBaseMethods {
   
    public void addNewUser(String username, String password, Connection conn){
        
        
        //SQL query; ? is a placeholder
        String sql = "INSERT INTO users (username, password) VALUES (?,?)";
        PreparedStatement ps;
        
        try{
            
            ps = conn.prepareStatement(sql);
           
            //setting values for placeholders
            ps.setString(1, username);
            ps.setString(2, password);
            //executing the query
             int rowsAffected = ps.executeUpdate();
             
             //checking if insertion was successful
             if (rowsAffected > 0) {
                System.out.println("A new row has been inserted successfully.");
            } else {
                System.out.println("Failed to insert a new row.");
             }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void listAllTheRows(String tableName, Connection c){
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Create statement
            statement = c.createStatement();

            // Execute query to select all rows from the table
            String sqlQuery = "SELECT * FROM " + tableName;
            resultSet = statement.executeQuery(sqlQuery);

            // Iterate over the result set and print each row
            while (resultSet.next()) {
                // Assuming the table has two columns: column1 and column2
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");

                // You can customize this part to fit your needs
                System.out.println("ID: " + id + ", Username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int deleteUser(int UserID, Connection c) throws SQLException{
        
        // sql query for deleting the row
        String sql = "DELETE FROM users WHERE id = ?";
        
        try (PreparedStatement statement = c.prepareStatement(sql)) {
            // Set the username parameter
            statement.setInt(1, UserID);

            // Execute the deletion query
            int rowsDeleted = statement.executeUpdate();

            // Check if any rows were affected
            if (rowsDeleted > 0) {
                System.out.println("User with ID '" + UserID + "' has been deleted successfully.");
            } else {
                System.out.println("No user found with ID '" + UserID + "'.");
            }
        }
        return UserID;
    } 
    
    public boolean doesUsernameExists(String username, Connection conn) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing the query");
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean doesUserIdExists(String username, String password, Connection conn) {
        String sql = "SELECT id FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                // Check if there's at least one result
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception occurred while checking user ID.");
            e.printStackTrace();
        }
        return false;
    } 
    
    public Connection connectToDatabase(){
        Connection conn = null;
        
         try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Connection details
            String url = "jdbc:mysql://localhost:3306/emotions_db";
            String user = "emotions_db_user";
            String password = "emotions_db_user";
            
            //establish the connection
            conn = DriverManager.getConnection(url, user, password);
             System.out.println("Connected to the database.\n");         
        } catch (Exception e) {
            e.printStackTrace();   
        }
         return conn;
    }

    public void addNewFeeling(String date, String emotion, Connection conn){
        String sql = "INSERT INTO emotions (date, emotion) VALUES (?,?)";
        PreparedStatement ps;
        
        try{
            
            ps = conn.prepareStatement(sql);
           
            //setting values for placeholders
            ps.setString(1, date);
            ps.setString(2, emotion);
            //executing the query
             int rowsAffected = ps.executeUpdate();
             
             //checking if insertion was successful
             if (rowsAffected > 0) {
                System.out.println("A new row has been inserted successfully.");
            } else {
                System.out.println("Failed to insert a new row.");
             }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}

    
    
