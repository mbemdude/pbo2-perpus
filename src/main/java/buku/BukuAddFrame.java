package buku;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

public class BukuAddFrame extends javax.swing.JFrame {
    
    HashMap<String, Integer> pengarangMap = new HashMap<>();
    HashMap<String, Integer> penerbitMap = new HashMap<>();
    HashMap<String, Integer> rakMap = new HashMap<>();
    
    public void PengarangComboBox() {
        try {
            Connection koneksi = Database.getConnection();

            String sqlPengarang = "SELECT nama, id FROM pengarang";
            Statement stPengarang = koneksi.createStatement();
            ResultSet rsPengarang = stPengarang.executeQuery(sqlPengarang);

            while (rsPengarang.next()) {
                String namaPengarang = rsPengarang.getString("nama");
                int idPengarang = rsPengarang.getInt("id");

                pengarangMap.put(namaPengarang, idPengarang);
                pengarangComboBox.addItem(namaPengarang);
            }

            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void PenerbitComboBox() {
        try {
            Connection koneksi = Database.getConnection();

            String sqlPenerbit = "SELECT nama, id FROM penerbit";
            Statement stPenerbit = koneksi.createStatement();
            ResultSet rsPenerbit = stPenerbit.executeQuery(sqlPenerbit);

            while (rsPenerbit.next()) {
                String namaPenerbit = rsPenerbit.getString("nama");
                int idPenerbit = rsPenerbit.getInt("id");

                penerbitMap.put(namaPenerbit, idPenerbit);
                penerbitComboBox.addItem(namaPenerbit);
            }

            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void RakComboBox() {
        try {
            Connection koneksi = Database.getConnection();

            String sqlRak = "SELECT kd_rak, id FROM rak"; // Sesuaikan nama kolom sesuai tabel Anda
            Statement stRak = koneksi.createStatement();
            ResultSet rsRak = stRak.executeQuery(sqlRak);

            while (rsRak.next()) {
                String kodeRak = rsRak.getString("kd_rak");
                int idRak = rsRak.getInt("id");

                rakMap.put(kodeRak, idRak);
                rakComboBox.addItem(kodeRak);
            }

            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
        
    public void FillComboBox() {
        pengarangComboBox.removeAllItems();
        PengarangComboBox();
        
        penerbitComboBox.removeAllItems();
        PenerbitComboBox();
        
        rakComboBox.removeAllItems();
        RakComboBox();
        
        for (Map.Entry<String, Integer> entry : pengarangMap.entrySet()) {
            String namaPengarang = entry.getKey();
            pengarangComboBox.addItem(namaPengarang);
        }
    }
    
        
    public BukuAddFrame() {
        initComponents();
        pengarangComboBox.removeAllItems();
        PengarangComboBox();
        
        penerbitComboBox.removeAllItems();
        PenerbitComboBox();
        
        rakComboBox.removeAllItems();
        RakComboBox();
    }
    
    
    public BukuAddFrame(int id) {
    initComponents();
    FillComboBox();
        try {
        Connection koneksi = Database.getConnection();
        String findSQL = "SELECT * FROM buku WHERE id="+id;
        Statement statement = koneksi.createStatement();
        ResultSet resultSet = statement.executeQuery(findSQL);
        while(resultSet.next()){
            idTextField.setText(resultSet.getString("id"));
            judulTextField.setText(resultSet.getString("judul"));
            tahunTerbit.setText(resultSet.getString("tahun_terbit"));
            jumlahTextField.setText(resultSet.getString("jumlah"));
            idbnTextField.setText(resultSet.getString("idbn"));
            
            String selectedPengarang = String.valueOf(resultSet.getInt("pengarang_id"));
            String selectedPenerbit = resultSet.getString("penerbit_id");
            String selectedRak = resultSet.getString("rak_id");
            
            pengarangComboBox.setSelectedItem(selectedPengarang);
            pengarangTextField.setText(resultSet.getString("pengarang_id"));
            
            penerbitComboBox.setSelectedItem(selectedPenerbit); 
            penerbitTextField.setText(resultSet.getString("penerbit_id"));
            
            rakComboBox.setSelectedItem(selectedRak);
            rakTextField.setText(resultSet.getString("rak_id"));
            
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        judulTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        batalButton = new javax.swing.JButton();
        simpanButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jumlahTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rakTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idbnTextField = new javax.swing.JTextField();
        pengarangComboBox = new javax.swing.JComboBox<>();
        pengarangTextField = new javax.swing.JTextField();
        penerbitComboBox = new javax.swing.JComboBox<>();
        penerbitTextField = new javax.swing.JTextField();
        rakComboBox = new javax.swing.JComboBox<>();
        tahunTerbit = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tambah Buku");

        jLabel2.setText("Id");

        jLabel3.setText("Judul Buku");

        jLabel5.setText("Tahun Terbit");

        jLabel6.setText("Pengarang");

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

        jLabel7.setText("Jumlah Buku");

        jLabel8.setText("Penerbit");

        jLabel9.setText("Rak");

        jLabel10.setText("IDBN");

        pengarangComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengarangComboBoxActionPerformed(evt);
            }
        });

        penerbitComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penerbitComboBoxActionPerformed(evt);
            }
        });

        rakComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rakComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(judulTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(batalButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(simpanButton))
                            .addComponent(jumlahTextField)
                            .addComponent(idbnTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pengarangComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pengarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(penerbitComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rakComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rakTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(penerbitTextField, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(tahunTerbit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(12, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(judulTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jumlahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(idbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pengarangComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pengarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(penerbitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(penerbitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rakTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rakComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                String insertSQL = "INSERT INTO buku (judul, tahun_terbit, jumlah, idbn, pengarang_id, penerbit_id, rak_id) VALUES ('"
                + judulTextField.getText() + "', '"
                + tahunTerbit.getDate() + "', '"
                + jumlahTextField.getText() + "', '"
                + idbnTextField.getText() + "', '"
                + pengarangTextField.getText() + "', '"
                + penerbitTextField.getText() + "', '"
                + rakTextField.getText() + "')";
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
                String updateSQL = "UPDATE buku SET judul = '" +
                judulTextField.getText() + "', tahun_terbit = '"+
                tahunTerbit.getDate() + "', jumlah = '"+
                jumlahTextField.getText() + "', idbn = '"+
                idbnTextField.getText() + "', pengarang_id = '"+
                pengarangTextField.getText() + "', penerbit_id = '"+
                penerbitTextField.getText() + "', rak_id = '"+
                rakTextField.getText() + "' WHERE id = " +
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

    private void pengarangComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengarangComboBoxActionPerformed
        String itemName = (String) pengarangComboBox.getSelectedItem();
        pengarangTextField.setText(String.valueOf(pengarangMap.get(itemName)));
    }//GEN-LAST:event_pengarangComboBoxActionPerformed

    private void penerbitComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penerbitComboBoxActionPerformed
        String itemName = (String) penerbitComboBox.getSelectedItem();
        penerbitTextField.setText(String.valueOf(penerbitMap.get(itemName)));
    }//GEN-LAST:event_penerbitComboBoxActionPerformed

    private void rakComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rakComboBoxActionPerformed
        String itemName = (String) rakComboBox.getSelectedItem();
        rakTextField.setText(String.valueOf(rakMap.get(itemName)));
    }//GEN-LAST:event_rakComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(BukuAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BukuAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BukuAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BukuAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BukuAddFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JTextField idbnTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField judulTextField;
    private javax.swing.JTextField jumlahTextField;
    private javax.swing.JComboBox<String> penerbitComboBox;
    private javax.swing.JTextField penerbitTextField;
    private javax.swing.JComboBox<String> pengarangComboBox;
    private javax.swing.JTextField pengarangTextField;
    private javax.swing.JComboBox<String> rakComboBox;
    private javax.swing.JTextField rakTextField;
    private javax.swing.JButton simpanButton;
    private com.github.lgooddatepicker.components.DatePicker tahunTerbit;
    // End of variables declaration//GEN-END:variables
}
