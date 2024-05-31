
package Model;

public class Supply {
    private int id;
    private String product_name;
    private String pro_id;
    private String supplyer_name;
    private int quantity;
    private float unity_price;
    private float sell_price;
    private String date;

    public Supply() {
    }

    public Supply(int id, String product_name, String pro_id, String supplyer_name, int quantity, float unity_price, float sell_price, String date) {
        this.id = id;
        this.product_name = product_name;
        this.pro_id = pro_id;
        this.supplyer_name = supplyer_name;
        this.quantity = quantity;
        this.unity_price = unity_price;
        this.sell_price = sell_price;
        this.date = date;
    }

    public Supply(String productname, String pro_id, String supplyerName, int convertQuantity, float convertPirce, float convert_total_Pirce, String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public String getSupplyer_name() {
        return supplyer_name;
    }

    public void setSupplyer_name(String supplyer_name) {
        this.supplyer_name = supplyer_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnity_price() {
        return unity_price;
    }

    public void setUnity_price(float unity_price) {
        this.unity_price = unity_price;
    }

    public float getSell_price() {
        return sell_price;
    }

    public void setSell_price(float sell_price) {
        this.sell_price = sell_price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
}
