/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author SHEMA 01
 */
public class Stock {
    private String id;
    private String product_name;
    private int quantity;
    private float initial_price;
    private String date;

    public Stock() {
    }

    public Stock(String id, String product_name, int quantity, float initial_price, String date) {
        this.id = id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.initial_price = initial_price;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getInitial_price() {
        return initial_price;
    }

    public void setInitial_price(float initial_price) {
        this.initial_price = initial_price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  
}
