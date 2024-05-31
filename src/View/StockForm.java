
package View;

import Dao.StockDao;
import Dao.UserDao;
import Model.Stock;
import Model.Users;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class StockForm extends javax.swing.JFrame {
Date dates = new Date();
java.sql.Date toDayDate = new java.sql.Date(dates.getTime());
    /**
     * Creates new form StockForm
     */
    public StockForm() {
        initComponents();
        displayData();
    }
    
   

   public void displayData(){
    
     StockDao dao = new StockDao();
     List<Stock> theStock = dao.display();
    
    DefaultTableModel dtModel = (DefaultTableModel) jTable2.getModel();
    dtModel.setRowCount(0);
    
    if(theStock!=null){
    for(Stock i: theStock){
        
    String[] getData = {
    i.getId(),
    i.getProduct_name(),
    String.valueOf(i.getQuantity()),  
    String.valueOf(i.getInitial_price()),
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
        productIdTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        SearchBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        searchKeyTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        productNameTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        unityPriceTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        SearchBtn2 = new javax.swing.JButton();
        SearchBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("STOCK");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Product name:");

        productIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdTxtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setText("Quantinty:");

        Add.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        EditBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        SearchBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SearchBtn.setText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel5.setText("Product Id:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel6.setText("Unity price:");

        unityPriceTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unityPriceTxtActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product name", "Quantity", "Unity price", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel7.setText("Product Id:");

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
                .addGap(231, 231, 231))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel8)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        SearchBtn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SearchBtn2.setText("Logout");
        SearchBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn2ActionPerformed(evt);
            }
        });

        SearchBtn1.setBackground(new java.awt.Color(0, 153, 204));
        SearchBtn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SearchBtn1.setText("Daily Report");
        SearchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(productIdTxt))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(unityPriceTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SearchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(415, 415, 415)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(383, 383, 383)
                        .addComponent(SearchBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(searchKeyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn2)
                    .addComponent(SearchBtn1))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(productIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(productNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(unityPriceTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6))
                    .addComponent(quantityTxt))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchKeyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        if(
            productIdTxt.getText().trim().isEmpty()
            ||quantityTxt.getText().trim().isEmpty()
            ||productNameTxt.getText().trim().isEmpty()
            ||unityPriceTxt.getText().trim().isEmpty()
            
        ){
            JOptionPane.showMessageDialog(this, "fill all filled");

        }else{
            Stock stocks = new Stock();
            StockDao dao = new StockDao();

           stocks.setId(productIdTxt.getText());
           stocks.setProduct_name(productNameTxt.getText());
           String QtTxt = quantityTxt.getText();
           int quantity = Integer.parseInt(QtTxt);
           stocks.setQuantity(quantity);
            String price = unityPriceTxt.getText();
            float priceTxt = Float.parseFloat(price);
           stocks.setInitial_price(priceTxt);
           stocks.setDate(toDayDate.toString());

            String feedback = dao.recordStock(stocks);
            JOptionPane.showMessageDialog(null, feedback);
         
            productIdTxt.setText("");
            quantityTxt.setText("");
            productNameTxt.setText("");
            unityPriceTxt.setText("");
            refleshTable();
        }
    }//GEN-LAST:event_AddActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // TODO add your handling code here:
        if (productIdTxt.getText().trim().isEmpty()
                || quantityTxt.getText().trim().isEmpty() 
                || productNameTxt.getText().trim().isEmpty()
                 || unityPriceTxt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        } else {
            Stock stocks  = new Stock();
            StockDao dao = new StockDao();

            
           stocks.setId(productIdTxt.getText());
           stocks.setProduct_name(productNameTxt.getText());
           String QtTxt = quantityTxt.getText();
           int quantity = Integer.parseInt(QtTxt);
           stocks.setQuantity(quantity);
            String price = unityPriceTxt.getText();
            float priceTxt = Float.parseFloat(price);
           stocks.setInitial_price(priceTxt);
           stocks.setDate(toDayDate.toString());

            String feedback = dao.updateStock(stocks);
            JOptionPane.showMessageDialog(null, feedback);
         
            productIdTxt.setText("");
            quantityTxt.setText("");
            productNameTxt.setText("");
            //unityPriceTxt.setText("");
            refleshTable();
        }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        if(searchKeyTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Search ID required", "Enter ID", HEIGHT);
        }else{
            Stock stocks = new Stock();
            stocks.setId(searchKeyTxt.getText());
            StockDao dao = new StockDao();
            Stock theStock =dao.searchStock(stocks);

            if(theStock != null){

                productIdTxt.setText(theStock.getId());
                productNameTxt.setText(theStock.getProduct_name());
                int quantity = theStock.getQuantity();
                String quantityText = String.valueOf(quantity);
                quantityTxt.setText(quantityText);
                float initialPrice = theStock.getInitial_price();
                String priceText = String.valueOf(initialPrice);
                unityPriceTxt.setText(priceText);

            }else{
                JOptionPane.showConfirmDialog(this, "No data found");

            }
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(null, "Do you really want to delete seleted record", "Confirm", JOptionPane.YES_NO_OPTION);
        if(searchKeyTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Search ID required", "Enter ID", HEIGHT);
        }else
        if(response==JOptionPane.YES_OPTION){
            Stock stocks = new Stock();
            StockDao dao = new StockDao();

            stocks.setId(searchKeyTxt.getText());
            String feedback = dao.deleteStock(stocks);
            JOptionPane.showMessageDialog(null, feedback);
           
            productIdTxt.setText("");
            productIdTxt.setText("");
            quantityTxt.setText("");
            productNameTxt.setText("");
            //unityPriceTxt.setText("");
            refleshTable();
            
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void productIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdTxtActionPerformed

    private void unityPriceTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unityPriceTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unityPriceTxtActionPerformed

    private void SearchBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn2ActionPerformed
        LoginForm log = new LoginForm();
        log.show();
        this.hide();
    }//GEN-LAST:event_SearchBtn2ActionPerformed

    private void SearchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn1ActionPerformed
        DailyReportForm report = new DailyReportForm();
        report.show();
        this.hide();
    }//GEN-LAST:event_SearchBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(StockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton EditBtn;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JButton SearchBtn1;
    private javax.swing.JButton SearchBtn2;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField productIdTxt;
    private javax.swing.JTextField productNameTxt;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JTextField searchKeyTxt;
    private javax.swing.JTextField unityPriceTxt;
    // End of variables declaration//GEN-END:variables
}
