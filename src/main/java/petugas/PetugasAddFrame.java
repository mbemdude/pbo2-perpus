/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package petugas;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mbemd
 */
public class PetugasAddFrame extends javax.swing.JFrame {

    /** Creates new form PetugasAddFrame */
    public PetugasAddFrame() {
        initComponents();
    }
    
    public PetugasAddFrame(int id) {
        initComponents();
        try {
            Connection koneksi = Database.getConnection();
            String findSQL = "SELECT * FROM petugas WHERE id="+id;
            Statement statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(findSQL);
            while(resultSet.next()){
                idTextField.setText(resultSet.getString("id"));
                namaTextField.setText(resultSet.getString("nama"));
                jenisKelaminComboBox.setSelectedItem(resultSet.getObject("jenis_kelamin"));
                noTelpTextField.setText(resultSet.getString("telp"));
                alamatTextField.setText(resultSet.getString("alamat"));
            }
            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        namaTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        noTelpTextField = new javax.swing.JTextField();
        alamatTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        batalButton = new javax.swing.JButton();
        simpanButton = new javax.swing.JButton();
        jenisKelaminComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tambah Petugas");

        jLabel2.setText("Id");

        jLabel3.setText("Nama");

        jLabel4.setText("Jenis Kelamin");

        jLabel5.setText("No Telpon");

        jLabel6.setText("Alamat");

        batalButton.setText("Batal");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        jenisKelaminComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alamatTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(noTelpTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(idTextField)
                    .addComponent(namaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(batalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simpanButton))
                    .addComponent(jenisKelaminComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jenisKelaminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(noTelpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(alamatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batalButton)
                    .addComponent(simpanButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        dispose();
    }//GEN-LAST:event_batalButtonActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        if(idTextField.getText().equals("")) {
            try{
                Connection koneksi = Database.getConnection();
                String insertSQL = "INSERT INTO petugas (nama, jenis_kelamin, telp, alamat) VALUES ('" 
                            + namaTextField.getText() + "', '"
                            + jenisKelaminComboBox.getSelectedItem() + "', '"
                            + noTelpTextField.getText() + "', '"
                            + alamatTextField.getText() + "')";
                Statement statement = koneksi.createStatement();
                statement.executeUpdate(insertSQL);
                koneksi.close();
                dispose();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                Connection koneksi = Database.getConnection();
                String updateSQL = "UPDATE petugas SET nama = '" +
                        namaTextField.getText() + "', jenis_kelamin = '"+
                        jenisKelaminComboBox.getSelectedItem() + "', telp = '"+
                        noTelpTextField.getText() + "', alamat = '"+
                        alamatTextField.getText() + "' WHERE id = " +
                        idTextField.getText();
                Statement statement = koneksi.createStatement();
                statement.executeUpdate(updateSQL);
                koneksi.close();
                dispose();
            } catch(SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_simpanButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PetugasAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PetugasAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PetugasAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PetugasAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PetugasAddFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatTextField;
    private javax.swing.JButton batalButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jenisKelaminComboBox;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JTextField noTelpTextField;
    private javax.swing.JButton simpanButton;
    // End of variables declaration//GEN-END:variables

}
