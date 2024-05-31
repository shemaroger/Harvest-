/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.StockDao;
import Dao.SupplyDao;
import Model.Stock;
import Model.Supply;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SHEMA 01
 */
public class SupplyForm extends javax.swing.JFrame {
    int store_qty;
    String pro_id;
    
Date dates = new Date();
    java.sql.Date toDayDate = new java.sql.Date(dates.getTime());

    /**
     * Creates new form SupplyForm
     */
    public SupplyForm() {
        initComponents();
        displayData();
        addQuantityChangeListener();
        refleshTable();
    }

    private void addQuantityChangeListener() {
    quantityTxt.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateTotalPrice();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateTotalPrice();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateTotalPrice();
        }

       private void updateTotalPrice() {
    String quantityText = quantityTxt.getText().trim();
    if (!quantityText.isEmpty()) {
        try {
            Stock theStock = new Stock();
            float quantity = Float.parseFloat(quantityText);
            float initialPrice = Float.parseFloat(unityPriceTxt.getText());

            // Check if theStock is not null and initialized
            if (theStock != null && quantity <= store_qty) {
                float totalPrice = quantity * initialPrice;
                String totalPriceText = String.valueOf(totalPrice);
                totalAmountTxt.setText(totalPriceText);
                
            } else {
                
                JOptionPane.showMessageDialog(SupplyForm.this, "Quantity exceeds available stock", "Error", JOptionPane.ERROR_MESSAGE);
                quantityTxt.setText(""); // Clear quantity field
                totalAmountTxt.setText(""); // Clear total amount field
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(SupplyForm.this, "Invalid input for quantity or price", "Error", JOptionPane.ERROR_MESSAGE);
            totalAmountTxt.setText(""); // Clear total amount if invalid input
        }
    } else {
        totalAmountTxt.setText(""); // Clear total amount if quantity is empty
    }
}

    });
}

public void displayData(){
    
     SupplyDao dao = new SupplyDao();
     List<Supply> theSupply = dao.display();
    
    DefaultTableModel dtModel = (DefaultTableModel) jTable2.getModel();
    dtModel.setRowCount(0);
    
    if(theSupply != null){
    for(Supply i: theSupply){
        
    Object[] getData = {
//    String.valueOf(i.getId()),
    i.getSupplyer_name(),
    i.getProduct_name(),
    i.getQuantity(),  
    i.getUnity_price(),
    i.getSell_price(),
    i.getDate()
    
};
            dtModel.addRow(getData);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No data found");
    }
    }
    
    public void refleshTable(){
        DefaultTableModel dfm = (DefaultTableModel) jTable2.getModel();
        dfm.setRowCount(0);
        displayData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        SearchBtn = new javax.swing.JButton();
        searchKeyTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        unityPriceTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        totalAmountTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        supplyNameTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        SearchBtn1 = new javax.swing.JButton();
        SearchBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("SUPPLY");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Product name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setText("Quantinty:");

        Add.setBackground(new java.awt.Color(255, 255, 255));
        Add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Add.setText("Supply");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        SearchBtn.setBackground(new java.awt.Color(0, 153, 204));
        SearchBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SearchBtn.setText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel6.setText("Unity price:");

        unityPriceTxt.setEditable(false);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplyer name", "Product name", "Quantity", "Unity price", "Total amount", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel4.setText("Total amount:");

        totalAmountTxt.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel5.setText("Supply name:");

        jPanel2.setBackground(new java.awt.Color(102, 51, 0));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("AGRICULTURE HAVEST MANAGMENT SYSTEM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(203, 203, 203))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel8)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        SearchBtn1.setBackground(new java.awt.Color(0, 153, 204));
        SearchBtn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SearchBtn1.setText("Daily Report");
        SearchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn1ActionPerformed(evt);
            }
        });

        SearchBtn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SearchBtn2.setText("Logout");
        SearchBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(supplyNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unityPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(searchKeyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(SearchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(805, 805, 805)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(SearchBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(SearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(496, 496, 496)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchBtn1)
                    .addComponent(SearchBtn2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(unityPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplyNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(searchKeyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        if(
            unityPriceTxt.getText().trim().isEmpty()
            ||quantityTxt.getText().trim().isEmpty()
            ||searchKeyTxt.getText().trim().isEmpty()
            ||unityPriceTxt.getText().trim().isEmpty()
            ||supplyNameTxt.getText().trim().isEmpty()

        ){
            JOptionPane.showMessageDialog(this, "fill all filled");

        }else{
            String QtTxt = quantityTxt.getText();
            int quantity = Integer.parseInt(QtTxt);
            int reduce_quantity = store_qty-quantity;
            Stock stocks = new Stock();
            StockDao stockdao = new StockDao();
            
            stocks.setQuantity(reduce_quantity);
            stocks.setId(pro_id);
            stockdao.updateQuantity(stocks);
            
            Supply supply = new Supply();
            SupplyDao dao = new SupplyDao();

            supply.setPro_id(pro_id);
            supply.setSupplyer_name(supplyNameTxt.getText());
            supply.setProduct_name(searchKeyTxt.getText());
            supply.setQuantity(quantity);
            
            float priceTxt =Float.parseFloat( unityPriceTxt.getText());
            supply.setUnity_price(priceTxt);            
            String total_price = totalAmountTxt.getText();
            float totalPrice = Float.parseFloat(total_price);
            supply.setSell_price(totalPrice);
            supply.setDate(toDayDate.toString());

            String feedback = dao.recordSupply(supply);
            JOptionPane.showMessageDialog(null, feedback);

            totalAmountTxt.setText("");
            quantityTxt.setText("");
            searchKeyTxt.setText("");
            unityPriceTxt.setText("");
            refleshTable();
        }
    }//GEN-LAST:event_AddActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        if(searchKeyTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Search ID required", "Enter ID", HEIGHT);
        }else{
            
            Stock stocks = new Stock();
            stocks.setProduct_name(searchKeyTxt.getText());
            StockDao dao = new StockDao();
            Stock theStock =dao.searchProduct(stocks);

            if(theStock != null){
                pro_id = theStock.getId();
                store_qty = theStock.getQuantity();
                float initialPrice = theStock.getInitial_price();
                String priceText = String.valueOf(initialPrice);
                unityPriceTxt.setText(priceText);

            }else{
                JOptionPane.showConfirmDialog(this, "No data found");

            }
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void SearchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn1ActionPerformed
      DailyReportForm report = new DailyReportForm();
      report.show();
      this.hide();
    }//GEN-LAST:event_SearchBtn1ActionPerformed

    private void SearchBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn2ActionPerformed
        LoginForm log = new LoginForm();
        log.show();
        this.hide();
    }//GEN-LAST:event_SearchBtn2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SupplyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplyForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JButton SearchBtn1;
    private javax.swing.JButton SearchBtn2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JTextField searchKeyTxt;
    private javax.swing.JTextField supplyNameTxt;
    private javax.swing.JTextField totalAmountTxt;
    private javax.swing.JTextField unityPriceTxt;
    // End of variables declaration//GEN-END:variables
}
