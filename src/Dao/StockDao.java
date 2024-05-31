
package Dao;

import Model.Stock;
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
public class StockDao {
      String dbUrl = "jdbc:mysql://localhost:3306/agrisc";
    String username = "root";
    String password = "";
    String sql;
    int rowAffected;
     
    public String recordStock(Stock stockObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);
         sql = "INSERT INTO stock (id,product_name,quantity,product_price,date)VALUES(?,?,?,?,?)";
         PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1, stockObj.getId());
          pst.setString(2, stockObj.getProduct_name());
          pst.setInt(3, stockObj.getQuantity());
          pst.setFloat(4, stockObj.getInitial_price());
          pst.setString(5, stockObj.getDate());
         
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
    public List<Stock> display(){
        List<Stock> stocks = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);
            sql = "SELECT *FROM stock";
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                String productId = result.getString("id");
                String productname = result.getString("product_name");
                String quantity = result.getString("quantity");
                int convertQuantity = Integer.parseInt(quantity);
                String price = result.getString("product_price");
                float convertPirce = Float.parseFloat(price);
                String date = result.getString("date");
                
                stocks.add(new Stock(productId,productname,convertQuantity,convertPirce,date));
            }
        } catch (Exception e) {
                e.printStackTrace();
                
        }
        return stocks;
    }
    public String updateStock(Stock stockObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);
            sql = "UPDATE stock SET product_name=?,quantity=?,product_price=? WHERE id = ? ";
           PreparedStatement pst = con.prepareStatement(sql);
     
        pst.setString(1, stockObj.getProduct_name());
        pst.setInt(2, stockObj.getQuantity());
        pst.setFloat(3, stockObj.getInitial_price());
        pst.setString(4, stockObj.getId());
        
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
     public String updateQuantity(Stock stockObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);;
            sql = "UPDATE stock SET quantity=? WHERE id = ? ";
           PreparedStatement pst = con.prepareStatement(sql);
     
        
        pst.setInt(1, stockObj.getQuantity());
        pst.setString(2, stockObj.getId());
        
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
    public String deleteStock(Stock stockObj){
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);
            sql = "DELETE FROM stock Where id=?";
         PreparedStatement pst = con.prepareStatement(sql);
     
        pst.setString(1, stockObj.getId());
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
    public Stock searchStock(Stock StockObj){
        try {
             Connection con = DriverManager.getConnection(dbUrl,username,password);
               sql = "SELECT *FROM stock WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, StockObj.getId());
            
            ResultSet result= pst.executeQuery();
            Stock stocks = new Stock();
            boolean flag = false;
            while(result.next()){
          stocks.setId(result.getString("id"));
          stocks.setProduct_name(result.getString("product_name"));
          stocks.setQuantity(result.getInt("quantity"));
          stocks.setInitial_price(result.getFloat("product_price"));
   
          flag = true;
      }
      con.close();
      if(flag){
          return stocks;
      }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Stock searchProduct(Stock StockObj){
        try {
             Connection con = DriverManager.getConnection(dbUrl,username,password);
               sql = "SELECT *FROM stock WHERE product_name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, StockObj.getProduct_name());
            
            ResultSet result= pst.executeQuery();
            Stock stocks = new Stock();
            boolean flag = false;
            while(result.next()){
          stocks.setId(result.getString("id"));
          stocks.setProduct_name(result.getString("product_name"));
          stocks.setQuantity(result.getInt("quantity"));
          stocks.setInitial_price(result.getFloat("product_price"));
   
          flag = true;
      }
      con.close();
      if(flag){
          return stocks;
      }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
