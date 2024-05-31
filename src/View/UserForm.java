/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.UserDao;
import Model.Users;
import com.mysql.jdbc.log.Log;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SHEMA 01
 */
public class UserForm extends javax.swing.JFrame {

    /**
     * Creates new form UserForm
     */
    public UserForm() {
        initComponents();
        displayData();
    }
public void displayData(){
    
    UserDao dao = new UserDao();
    
    List<Users> users= dao.display();
    DefaultTableModel dtModel = (DefaultTableModel) jTable1.getModel();
    dtModel.setRowCount(0);
    
    if(users!=null){
    for(Users i: users){
        
    String[] getData = {
    String.valueOf(i.getId()),  
    i.getFull_name(),
    i.getEmail(),
    i.getPassword(),
    i.getRole()
};
            dtModel.addRow(getData);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No data found");
        }
    
    }
 public void refleshTable(){
        DefaultTableModel dfm = (DefaultTableModel) jTable1.getModel();
        dfm.setRowCount(0);
        displayData();
    }
    public void resetField(){
         fullnametxt.setText("");
        emailTxt.setText("");
        passwordTxt.setText("");

        searchKeyTxt.requestFocus();
    }
    private boolean isValidEmail(String email) {
    // Regular expression for email validation
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    return email.matches(emailRegex);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fullnametxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        Add = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        SearchBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchKeyTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        SearchBtn1 = new javax.swing.JButton();
        SearchBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setText("SIGN UP");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Full name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel4.setText("Password:");

        Add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        EditBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Full name", "Email", "Password", "Role"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel5.setText("User Id:");

        jPanel2.setBackground(new java.awt.Color(102, 51, 0));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("AGRICULTURE HAVEST MANAGMENT SYSTEM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(jLabel6)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel6)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        SearchBtn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SearchBtn1.setText("Logout");
        SearchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn1ActionPerformed(evt);
            }
        });

        SearchBtn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SearchBtn2.setText("Stock");
        SearchBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditBtn)
                        .addGap(4, 4, 4)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(searchKeyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(fullnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailTxt)
                                    .addComponent(passwordTxt))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(SearchBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SearchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SearchBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(SearchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(fullnametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchKeyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
         if(
                fullnametxt.getText().trim().isEmpty()
                ||emailTxt.getText().trim().isEmpty()
                ||passwordTxt.getText().trim().isEmpty()
                 ){
            JOptionPane.showMessageDialog(this, "fill this filled");
            
        }else{
             String email = emailTxt.getText().trim();
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format", "Invalid Email", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if email is invalid
        }
         Users user = new Users();
        UserDao dao = new UserDao();
        
        user.setFull_name(fullnametxt.getText());
        user.setEmail(emailTxt.getText());
        user.setPassword(passwordTxt.getText());
//        user.setRole(role);

        String feedback = dao.recordUser(user);
        JOptionPane.showMessageDialog(null, feedback);  
           fullnametxt.setText("");
        emailTxt.setText("");
        passwordTxt.setText("");
         }
    }//GEN-LAST:event_AddActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // TODO add your handling code here:
         if (fullnametxt.getText().trim().isEmpty() || emailTxt.getText().trim().isEmpty() || passwordTxt.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please fill in all fields.");
} else {
    Users user = new Users();
    UserDao dao = new UserDao();
    
     String searchText = searchKeyTxt.getText();
    int userId = Integer.parseInt(searchText);
    user.setId(userId);
    user.setFull_name(fullnametxt.getText());
    user.setEmail(emailTxt.getText());
    user.setPassword(passwordTxt.getText());

    String feedback = dao.updateUser(user);
    JOptionPane.showMessageDialog(null, feedback);
    refleshTable();
    fullnametxt.setText("");
    emailTxt.setText("");
    passwordTxt.setText("");
}
    }//GEN-LAST:event_EditBtnActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
  if(searchKeyTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Search ID required", "Enter ID", HEIGHT);
        }else{
            Users users = new Users();
           String searchText = searchKeyTxt.getText();

           int userId = Integer.parseInt(searchText);
           users.setId(userId);
           UserDao dao = new UserDao();
            Users theUsers =dao.searchUser(users);
           
            if(theUsers != null){
            
                fullnametxt.setText(theUsers.getFull_name());
                emailTxt.setText(theUsers.getEmail());
                passwordTxt.setText(theUsers.getPassword());
                
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
        Users users = new Users();
         UserDao dao = new UserDao();
        
         String input = searchKeyTxt.getText();
         int id = Integer.parseInt(input);
         users.setId(id);
         String feedback = dao.deleteUser(users);
         JOptionPane.showMessageDialog(null, feedback); 
         refleshTable();;
            fullnametxt.setText("");
        emailTxt.setText("");
        passwordTxt.setText("");
         }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void SearchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn1ActionPerformed
       LoginForm log = new LoginForm();
       log.show();
       this.hide();
    }//GEN-LAST:event_SearchBtn1ActionPerformed

    private void SearchBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn2ActionPerformed
        // TODO add your handling code here:
        StockForm stock = new StockForm();
        stock.show();
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
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserForm().setVisible(true);
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
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField fullnametxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField searchKeyTxt;
    // End of variables declaration//GEN-END:variables
}
