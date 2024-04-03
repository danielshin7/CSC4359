package com.example.application.views.createaccount;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;


public class MyUser {
   private String email;
   private String userName;
   private String password;
   private String educationLevel;

   // Getters and setters for the fields


   public String getEmail() {
       return email;
   }


   public void setEmail(String email) {
       this.email = email;
   }


   public String getUserName() {
       return userName;
   }


   public void setUserName(String userName) {
       this.userName = userName;
   }


   public String getPassword() {
       return password;
   }


   public void setPassword(String password) {
       this.password = password;
   }


   public String getEducationLevel() {
       return educationLevel;
   }


   public void setEducationLevel(String educationLevel) {
       this.educationLevel = educationLevel;
   }

   public void saveToDatabase() {
    // JDBC connection parameters
    String url = "jdbc:mysql://localhost:3306/courses";
    String user = "root";
    String password = "korea123";
    String sql = "INSERT INTO users (email, username, password, education_level) " +
    "VALUES (?, ?, ?, ?)";
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connection is Successful.");
        PreparedStatement statement = conn.prepareStatement(sql); 
         statement.setString(1, userName);
         statement.setString(2, password);
         statement.setString(3, email);
         statement.setString(4, educationLevel);

         int rowsInserted = statement.executeUpdate();
         if (rowsInserted > 0) {
             System.out.println("Data inserted successfully.");
         }
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    catch (SQLException e) {
         throw new RuntimeException(e);
    }
}
}
