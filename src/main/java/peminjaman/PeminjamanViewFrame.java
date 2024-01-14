/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package peminjaman;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author mbemd
 */
public class PeminjamanViewFrame extends javax.swing.JFrame {

    /**
     * Creates new form PeminjamanViewForm
     */
    public PeminjamanViewFrame() {
        initComponents();
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
        cariTextField = new javax.swing.JTextField();
        cariButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        tambahButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        tutupButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Daftar Peminjam");

        jLabel2.setText("Cari Data");

        cariButton.setText("Cari");
        cariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariButtonActionPerformed(evt);
            }
        });

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Tanggal Pinjam", "Tanggal Kembali", "Nama Petugas", "Nama Peminjam"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(viewTable);
        if (viewTable.getColumnModel().getColumnCount() > 0) {
            viewTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            viewTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        tambahButton.setText("Tambah");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        tutupButton.setText("Tutup");
        tutupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(196, 196, 196))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cariTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cariButton)
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(tutupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tambahButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cariTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(tambahButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hapusButton)
                    .addComponent(resetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tutupButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariButtonActionPerformed
        try {
            String kataKunci = cariTextField.getText();
            Connection koneksi = Database.getConnection();
            String selectSQL = "SELECT PM.id, PM.tanggal_pinjam, PM.tenggat_pengembalian, PT.nama, A.nama"
            + " FROM peminjaman PM LEFT JOIN petugas PT ON PM.petugas_id=PT.id"
            + " LEFT JOIN anggota A ON PM.anggota_id=A.id WHERE tanggal_pinjam LIKE '%"+kataKunci+"%' ";
            Statement statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            Object[] row = new Object[5];
            DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
            model.setRowCount(0);

            while(resultSet.next()) {
                row[0] = resultSet.getInt("PM.id");
                row[1] = resultSet.getString("PM.tanggal_pinjam");
                row[2] = resultSet.getString("PM.tenggat_pengembalian");
                row[3] = resultSet.getString("PT.nama");
                row[4] = resultSet.getString("A.nama");
                model.addRow(row);
            }
            koneksi.close();
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_cariButtonActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        PeminjamanAddFrame f = new PeminjamanAddFrame();
        f.setVisible(true);
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int barisTerpilih = viewTable.getSelectedRow();
        if(barisTerpilih >= 0) {
            TableModel model = viewTable.getModel();
            int id = (int) model.getValueAt(barisTerpilih, 0);
            PeminjamanAddFrame f = new PeminjamanAddFrame(id);
            f.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data");
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        formWindowActivated(null);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        int barisTerpilih = viewTable.getSelectedRow();
        if(barisTerpilih >= 0) {
            int pilihan = JOptionPane.showConfirmDialog(null,
                "Yakin hapus?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
            if(pilihan == 0) {
                try {
                    TableModel model = viewTable.getModel();
                    int id = (int) model.getValueAt(barisTerpilih, 0);
                    Connection koneksi = Database.getConnection();
                    String deleteSQL = "DELETE FROM peminjaman WHERE id ="+id;
                    Statement statement = koneksi.createStatement();
                    statement.executeUpdate(deleteSQL);
                    koneksi.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data");
        }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void tutupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutupButtonActionPerformed
        dispose();
    }//GEN-LAST:event_tutupButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setLocationRelativeTo(null);
        try{
            Connection koneksi = Database.getConnection();
            String selectSQL = "SELECT PM.id, PM.tanggal_pinjam, PM.tenggat_pengembalian, PT.nama, A.nama"
                                + " FROM peminjaman PM LEFT JOIN petugas PT ON PM.petugas_id=PT.id"
                                + " LEFT JOIN anggota A ON PM.anggota_id=A.id";
            Statement statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);
            
            Object[] row = new Object[8];
            DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
            model.setRowCount(0);
            
            while(resultSet.next()) {
                row[0] = resultSet.getInt("PM.id");
                row[1] = resultSet.getString("PM.tanggal_pinjam");
                row[2] = resultSet.getString("PM.tenggat_pengembalian");
                row[3] = resultSet.getString("PT.nama");
                row[4] = resultSet.getString("A.nama");
                model.addRow(row);
            }
            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(PeminjamanViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeminjamanViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeminjamanViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeminjamanViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeminjamanViewFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariButton;
    private javax.swing.JTextField cariTextField;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton tambahButton;
    private javax.swing.JButton tutupButton;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}
