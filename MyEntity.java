package com.example.application.views.addcoursereview;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;


public class MyEntity {
   private String firstName;
   private String lastName;
   private String subject;
   private String courseLevel;
   private String university;
   private String rating;
   private boolean wouldTakeAgain;
   private String description;


   // Getters and setters for the fields


   public String getFirstName() {
       return firstName;
   }


   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }


   public String getLastName() {
       return lastName;
   }


   public void setLastName(String lastName) {
       this.lastName = lastName;
   }


   public String getSubject() {
       return subject;
   }


   public void setSubject(String subject) {
       this.subject = subject;
   }


   public String getCourseLevel() {
       return courseLevel;
   }


   public void setCourseLevel(String courseLevel) {
       this.courseLevel = courseLevel;
   }


   public String getUniversity() {
       return university;
   }


   public void setUniversity(String university) {
       this.university = university;
   }


   public String getRating() {
       return rating;
   }


   public void setRating(String rating) {
       this.rating = rating;
   }


   public boolean isWouldTakeAgain() {
       return wouldTakeAgain;
   }


   public void setWouldTakeAgain(boolean wouldTakeAgain) {
       this.wouldTakeAgain = wouldTakeAgain;
   }

   public String getDescription(){
        return description;
   }

   public void setDescription(String description){
        this.description = description;
   }


   // Method to save the entity to the MySQL database
   public void saveToDatabase() {
       // JDBC connection parameters
       String url = "jdbc:mysql://localhost:3306/courses";
       String user = "root";
       String password = "korea123";
       String sql = "INSERT INTO course_info (first_name, last_name, subject, course_level, university, rating, would_take_again, description) " +
       "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection(url, user, password);
           System.out.println("Connection is Successful.");
           PreparedStatement statement = conn.prepareStatement(sql); 
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, subject);
            statement.setString(4, courseLevel);
            statement.setString(5, university);
            statement.setString(6, rating);
            statement.setBoolean(7, wouldTakeAgain);
            statement.setString(8, description);

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


