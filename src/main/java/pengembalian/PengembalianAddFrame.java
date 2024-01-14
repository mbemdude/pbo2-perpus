/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pengembalian;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mbemd
 */
public class PengembalianAddFrame extends javax.swing.JFrame {
    
    HashMap<String, Integer> petugasMap = new HashMap<>();
    HashMap<String, Integer> peminjamanMap = new HashMap<>();
    
    public void PetugasComboBox() {
        try {
            Connection koneksi = Database.getConnection();

            String sqlPetugas = "SELECT nama, id FROM petugas";
            Statement stPetugas = koneksi.createStatement();
            ResultSet rsPetugas = stPetugas.executeQuery(sqlPetugas);

            while (rsPetugas.next()) {
                String namaPetugas = rsPetugas.getString("nama");
                int idPetugas = rsPetugas.getInt("id");

                petugasMap.put(namaPetugas, idPetugas);
                petugasComboBox.addItem(namaPetugas);
            }

            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void PeminjamanComboBox() {
        try {
            Connection koneksi = Database.getConnection();

            String sqlPeminjaman = "SELECT tanggal_pinjam, id FROM peminjaman";
            Statement stPeminjaman = koneksi.createStatement();
            ResultSet rsPeminjaman = stPeminjaman.executeQuery(sqlPeminjaman);

            while (rsPeminjaman.next()) {
                String tanggalPinjam = rsPeminjaman.getString("tanggal_pinjam");
                int idPinjam = rsPeminjaman.getInt("id");

                peminjamanMap.put(tanggalPinjam, idPinjam);
                tanggalPinjamComboBox.addItem(tanggalPinjam);
            }

            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
        
    public void FillComboBox() {
        petugasComboBox.removeAllItems();
        PetugasComboBox();
        
        tanggalPinjamComboBox.removeAllItems();
        PeminjamanComboBox();
    
        for (Map.Entry<String, Integer> entry : petugasMap.entrySet()) {
            String namaPengarang = entry.getKey();
            petugasComboBox.addItem(namaPengarang);
        }
    }
    
    
    public PengembalianAddFrame() {
        initComponents();
        
        petugasComboBox.removeAllItems();
        PetugasComboBox();
        
        tanggalPinjamComboBox.removeAllItems();
        PeminjamanComboBox();
    }
    
    public PengembalianAddFrame(int id) {
    initComponents();
    FillComboBox();
        try {
        Connection koneksi = Database.getConnection();
        String findSQL = "SELECT * FROM pengembalian WHERE id="+id;
        Statement statement = koneksi.createStatement();
        ResultSet resultSet = statement.executeQuery(findSQL);
        while(resultSet.next()){
            idTextField.setText(resultSet.getString("id"));
            tanggalPinjamDatePicker.setText(resultSet.getString("tanggal_pinjam"));
            dendaTextField.setText(resultSet.getString("denda"));
            
            String selectedPetugas = String.valueOf(resultSet.getInt("petugas_id"));
            String selectedTanggalPinjam = String.valueOf(resultSet.getInt("peminjaman_id"));
            
            petugasComboBox.setSelectedItem(selectedPetugas);
            petugasTextField.setText(resultSet.getString("petugas_id"));
            
            tanggalPinjamComboBox.setSelectedItem(selectedTanggalPinjam); 
            tanggalPinjamTextField.setText(resultSet.getString("peminjaman_id"));
        }
            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        batalButton = new javax.swing.JButton();
        simpanButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        petugasComboBox = new javax.swing.JComboBox<>();
        petugasTextField = new javax.swing.JTextField();
        tanggalPinjamComboBox = new javax.swing.JComboBox<>();
        tanggalPinjamTextField = new javax.swing.JTextField();
        tanggalPinjamDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        dendaTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Id");

        jLabel3.setText("Tanggal Kembali");

        jLabel5.setText("Denda");

        jLabel6.setText("Petugas Perpustakaan");

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

        jLabel8.setText("Tanggal Pinjam");

        petugasComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petugasComboBoxActionPerformed(evt);
            }
        });

        tanggalPinjamComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalPinjamComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Tambah Pengembalian");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(petugasComboBox, 0, 98, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(petugasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tanggalPinjamComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tanggalPinjamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tanggalPinjamDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dendaTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(batalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tanggalPinjamDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dendaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(petugasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(petugasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tanggalPinjamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggalPinjamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batalButton)
                    .addComponent(simpanButton))
                .addContainerGap(47, Short.MAX_VALUE))
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
                String insertSQL = "INSERT INTO pengembalian (tanggal_pengembalian, denda, petugas_id, peminjaman_id) VALUES ('"
                + tanggalPinjamDatePicker.getDate() + "', '"
                + dendaTextField.getText() + "', '"
                + petugasTextField.getText() + "', '"
                + tanggalPinjamTextField.getText() + "')";
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
                String updateSQL = "UPDATE peminjaman SET tanggal_pengembalian = '" +
                tanggalPinjamDatePicker.getDate() + "', denda = '"+
                dendaTextField.getText() + "', petugas_id = '"+
                petugasTextField.getText() + "', peminjaman_id = '"+
                tanggalPinjamTextField.getText() + "' WHERE id = " +
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

    private void petugasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petugasComboBoxActionPerformed
        String itemName = (String) petugasComboBox.getSelectedItem();
        petugasTextField.setText(String.valueOf(petugasMap.get(itemName)));
    }//GEN-LAST:event_petugasComboBoxActionPerformed

    private void tanggalPinjamComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalPinjamComboBoxActionPerformed
        String itemName = (String) tanggalPinjamComboBox.getSelectedItem();
        tanggalPinjamTextField.setText(String.valueOf(peminjamanMap.get(itemName)));
    }//GEN-LAST:event_tanggalPinjamComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(PengembalianAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PengembalianAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PengembalianAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PengembalianAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengembalianAddFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JTextField dendaTextField;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> petugasComboBox;
    private javax.swing.JTextField petugasTextField;
    private javax.swing.JButton simpanButton;
    private javax.swing.JComboBox<String> tanggalPinjamComboBox;
    private com.github.lgooddatepicker.components.DatePicker tanggalPinjamDatePicker;
    private javax.swing.JTextField tanggalPinjamTextField;
    // End of variables declaration//GEN-END:variables
}
