/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHEMA 01
 */
public class UserDao {
    String dbUrl = "jdbc:mysql://localhost:3306/agrisc";
    String username = "root";
    String password = "";
    String sql;
    int rowAffected;
     
    public String recordUser(Users userObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);
         sql = "INSERT INTO users (full_name,email,password,role) VALUES(?,?,?,?)";
         PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1, userObj.getFull_name());
          pst.setString(2, userObj.getEmail());
          pst.setString(3, userObj.getPassword());
          pst.setString(4, "seller");
         
         rowAffected = pst.executeUpdate();
         if(rowAffected>=1){
             return "Data saved";
         }else{
             return "Data not saved";
         }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   return null;
    }
    public List<Users> display(){
        List<Users> users = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);
            sql = "SELECT *FROM users";
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                String id = result.getString("id");
                int convertedId = Integer.parseInt(id);
                String name = result.getString("full_name");
                String email = result.getString("email");
                String password = result.getString("password");
                String role = result.getString("role");
                
                users.add(new Users(convertedId,name,email,password,role));
            }
        } catch (Exception e) {
                e.printStackTrace();
                
        }
        return users;
    }
    public String updateUser(Users userObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);
            sql = "UPDATE users SET full_name=?,email=?,password=? WHERE id = ? ";
           PreparedStatement pst = con.prepareStatement(sql);
     
        pst.setString(1, userObj.getFull_name());
        pst.setString(2, userObj.getEmail());
        pst.setString(3, userObj.getPassword());
        pst.setInt(4, userObj.getId());
        
        rowAffected = pst.executeUpdate();
        if(rowAffected>=1)
            return "Data updated successifully!!";
        else
            return "Data not updated ";
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String deleteUser(Users userObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);
            sql = "DELETE FROM users Where id=?";
         PreparedStatement pst = con.prepareStatement(sql);
     
        pst.setInt(1, userObj.getId());
        rowAffected = pst.executeUpdate();
        if(rowAffected>=1)
            return "Data deleted successifully!!";
        else
            return "Data not deleted ";
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Users searchUser(Users UserObj){
        try {
             Connection con = DriverManager.getConnection(dbUrl,username,password);
               sql = "SELECT *FROM users WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, UserObj.getId());
            
            ResultSet result= pst.executeQuery();
            Users users = new Users();
            boolean flag = false;
            while(result.next()){
          users.setId(result.getInt("id"));
          users.setFull_name(result.getString("full_name"));
          users.setEmail(result.getString("email"));
          users.setPassword(result.getString("password"));
          users.setRole(result.getString("role"));

          
          flag = true;
      }
      con.close();
      if(flag){
          return users;
      }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public Users loginUser(Users UserObj){
        try {
             Connection con = DriverManager.getConnection(dbUrl,username,password);
               sql = "SELECT *FROM users WHERE email = ? and password = ? and role = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, UserObj.getEmail());
            pst.setString(2, UserObj.getPassword());
            pst.setString(3, UserObj.getRole());
            
            ResultSet result= pst.executeQuery();
            Users users = new Users();
            boolean flag = false;
            while(result.next()){
          users.setEmail(result.getString("email"));
          users.setPassword(result.getString("password"));
          users.setRole(result.getString("role"));
          flag = true;
      }
      con.close();
      if(flag){
          return users;
      }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
