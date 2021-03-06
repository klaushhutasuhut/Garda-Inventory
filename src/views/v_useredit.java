/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import helper.List_user;
import helper.Tbl_user;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import models.M_user;

/**
 *
 * @author Klaus
 */
public class v_useredit extends javax.swing.JDialog {
    List<List_user> data = new ArrayList<>();
    Tbl_user tbl_model = new Tbl_user(data);
    M_user model = new M_user();
    JTable tbl;
    private String id_user, nama, pendidikan, posisi = "", passus = "", emailus = "";
    private Date tggl_lahir;
    /**
     * Creates new form v_edituser
     * @param tbl_user
     * @param id_useradm
     * @param namaadm
     * @param posisiadm
     * @param tggllahir
     * @param pendidikanadm
     * @param email
     * @param pass
     */
    public v_useredit(JTable tbl_user, String id_useradm, String namaadm, String posisiadm, Date tggllahir, String pendidikanadm, String email, String pass) {
        initComponents();
        this.loadcombo();
        this.awal();
        this.OptionsF();
        tbl = tbl_user;
        id_user = id_useradm;
        nama = namaadm;
        posisi = posisiadm;
        tggl_lahir = tggllahir;
        pendidikan = pendidikanadm;
        emailus = email;
        passus = pass;
        this.setTable();
    }
    
    
    private void OptionsF(){
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0,0,0,0));
        this.tgl.setText(model.tanggalnow);
    }
    
    private void setTable(){
        tid.setText(id_user);
        tnm.setText(nama);
        cbjabat.setSelectedItem(posisi);
        tgllahir.setDate(tggl_lahir);
        cbpendidikan.setSelectedItem(pendidikan);
    }
    
    private void awal(){
        this.tid.setEnabled(false);
    }
    
    private void loadcombo(){
        model.LoadCombo(this.cbpendidikan);
    }
    
    private void loadtable(){
        data = model.LoadTable("");
        tbl_model = new Tbl_user(data);
        tbl.setModel(tbl_model);
    }
    
    private void proses(){
        model.setIdUser(String.valueOf(this.tid.getText()));
        model.setNamaUser(String.valueOf(this.tnm.getText()));
        model.setPosisi(String.valueOf(this.cbjabat.getSelectedItem()));
        model.setTanggalLahir(this.tgllahir.getDate());
        model.setPendidikan(String.valueOf(this.cbpendidikan.getSelectedItem()));
        model.setEmail(emailus);
        model.setPassword(passus);
    }
    
    private void Update(){
        model.Updatesup();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_save = new javax.swing.JButton();
        tnm = new javax.swing.JTextField();
        tid = new javax.swing.JTextField();
        cbjabat = new javax.swing.JComboBox<>();
        cbpendidikan = new javax.swing.JComboBox<>();
        tgllahir = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_save.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_save.setText("Edit");
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveMouseClicked(evt);
            }
        });
        jPanel2.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 130, 40));

        tnm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(tnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 290, 40));

        tid.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 290, 40));

        cbjabat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbjabat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Admin", "Kasir", "Supplier" }));
        jPanel2.add(cbjabat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 290, 40));

        cbpendidikan.setEditable(true);
        cbpendidikan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(cbpendidikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 290, 40));

        tgllahir.setMaxSelectableDate(new java.util.Date(1009821689000L));
        tgllahir.setMinSelectableDate(new java.util.Date(-62135791111000L));
        jPanel2.add(tgllahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 290, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Id Anggota");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Nama");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Jabatan");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Tanggal Lahir");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Pendidikan Terakhir");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 150, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 480, 390));

        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/close_32px.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 30, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Edit Data User");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 20));

        tgl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 150, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        if(this.tid.getText().equals("")
            || this.tnm.getText().equals("")
            || this.cbjabat.getSelectedItem().equals("--Pilih--")
            || this.cbpendidikan.getSelectedItem().equals("")
            || this.tgllahir.getDate() == null){
                model.msg.validasidata();
        }else{
            this.proses();
            this.Update();
            this.loadtable();
            this.awal();
            this.dispose();
        }
    }//GEN-LAST:event_btn_saveMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("icon/exitred_32px.png"));
        close.setIcon(A);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        ImageIcon A = new ImageIcon(getClass().getResource("icon/close_32px.png"));
        close.setIcon(A);
    }//GEN-LAST:event_closeMouseExited

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cbjabat;
    private javax.swing.JComboBox<String> cbpendidikan;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel tgl;
    private com.toedter.calendar.JDateChooser tgllahir;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tnm;
    // End of variables declaration//GEN-END:variables
}
