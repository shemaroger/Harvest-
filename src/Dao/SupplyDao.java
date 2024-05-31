
package Dao;

import Model.Supply;
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
public class SupplyDao {
      String dbUrl = "jdbc:mysql://localhost:3306/agrisc";
    String supplyname = "root";
    String password = "";
    String sql;
    int rowAffected;
     
    public String recordSupply(Supply supplyObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,supplyname,password);
         sql = "INSERT INTO supply (product_name,product_id,supplyer_name,quantity,price_unit,total_price,date)VALUES(?,?,?,?,?,?,?)";
         PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1, supplyObj.getProduct_name());
          pst.setString(2, supplyObj.getPro_id());
          pst.setString(3, supplyObj.getSupplyer_name());
          pst.setInt(4, supplyObj.getQuantity());
          pst.setFloat(5, supplyObj.getUnity_price());
          pst.setFloat(6, supplyObj.getSell_price());
          pst.setString(7, supplyObj.getDate());
         
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
    public List<Supply> display(){
        List<Supply> supplies = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbUrl,supplyname,password);
            sql = "SELECT *FROM supply";
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                String supply_Id = result.getString("id");
                String pro_id = result.getString("product_id");
                int id = Integer.parseInt(supply_Id);
                String productname = result.getString("product_name");
                String supplyerName = result.getString("supplyer_name");
                String quantity = result.getString("quantity");
                int convertQuantity = Integer.parseInt(quantity);
                String price = result.getString("price_unit");
                float convertPirce = Float.parseFloat(price);
                String total_price = result.getString("total_price");
                float convert_total_Pirce = Float.parseFloat(price);
                String date = result.getString("date");
                
                supplies.add(new Supply(id,productname,pro_id,supplyerName,convertQuantity,convertPirce,convert_total_Pirce,date));
            }
        } catch (Exception e) {
                e.printStackTrace();
                
        }
        return supplies;
    }
    public String updateSupply(Supply supplyObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,supplyname,password);
            sql = "UPDATE supply SET product_name=?,quantity=? WHERE id = ? ";
           PreparedStatement pst = con.prepareStatement(sql);
     
        pst.setString(1, supplyObj.getProduct_name());
        pst.setInt(2, supplyObj.getQuantity());
        pst.setInt(4, supplyObj.getId());
        
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
    public String deleteSupply(Supply supplyObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,supplyname,password);
            sql = "DELETE FROM supply Where id=?";
         PreparedStatement pst = con.prepareStatement(sql);
     
        pst.setInt(1, supplyObj.getId());
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
    public Supply searchSupply(Supply SupplyObj){
        try {
             Connection con = DriverManager.getConnection(dbUrl,supplyname,password);
               sql = "SELECT *FROM supply WHERE product_name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, SupplyObj.getProduct_name());
            
            ResultSet result= pst.executeQuery();
            Supply supplies = new Supply();
            boolean flag = false;
            while(result.next()){
          supplies.setId(result.getInt("id"));
          supplies.setPro_id(result.getString("product_id"));
          supplies.setProduct_name(result.getString("product_name"));
          supplies.setQuantity(result.getInt("quantity"));
          supplies.setUnity_price(result.getFloat("price_unit"));
          supplies.setSell_price(result.getFloat("total_price"));
   
          flag = true;
      }
      con.close();
      if(flag){
          return supplies;
      }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
    
     public List<Supply> report(Supply SupplyObj){
         List<Supply> supplies = new ArrayList<>();
        try {
             Connection con = DriverManager.getConnection(dbUrl,supplyname,password);
             sql =   "SELECT id,product_id, product_name, price_unit, SUM(quantity) AS TotalQuantity, SUM(total_price) AS TotalAmount " +
                           "FROM supply " +
                           "WHERE date = ? " +
                           "GROUP BY product_id";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, SupplyObj.getDate());
            
            ResultSet result= pst.executeQuery();
            
          while(result.next()){
                Supply thesuplly = new Supply();
                thesuplly.setId(result.getInt("id"));
                thesuplly.setPro_id(result.getString("product_id"));
                thesuplly.setProduct_name(result.getString("product_name"));                 
                thesuplly.setQuantity(result.getInt("TotalQuantity"));                  
                thesuplly.setUnity_price(result.getFloat("price_unit"));                   
                thesuplly.setSell_price(result.getFloat("TotalAmount"));
                
                supplies.add(thesuplly);
                
            }
         con.close();
         return  supplies;
        } catch (Exception e) {
                e.printStackTrace();
                
        }
        return supplies;
    } 
    
public Supply searchSupplyDate(Supply SupplyObj){
        try {
             Connection con = DriverManager.getConnection(dbUrl,supplyname,password);
               sql = "SELECT *FROM supply WHERE date = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, SupplyObj.getDate());
            
            ResultSet result= pst.executeQuery();
            Supply supplies = new Supply();
            boolean flag = false;
            while(result.next()){
          supplies.setId(result.getInt("id"));
          supplies.setPro_id(result.getString("product_id"));
          supplies.setProduct_name(result.getString("product_name"));
          supplies.setQuantity(result.getInt("quantity"));
          supplies.setUnity_price(result.getFloat("price_unit"));
          supplies.setSell_price(result.getFloat("total_price"));
   
          flag = true;
      }
      con.close();
      if(flag){
          return supplies;
      }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}
