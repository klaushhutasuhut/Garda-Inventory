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
public class v_userbaru extends javax.swing.JDialog {
    List<List_user> data = new ArrayList<>();
    Tbl_user tbl_model = new Tbl_user(data);
    M_user model = new M_user();
    JTable tbl;
    /**
     * Creates new form v_userbaru
     * @param tbl_user
     */
    public v_userbaru(JTable tbl_user) {
        initComponents();
        this.loadcombo();
        this.OptionsFrame();
        this.awal();
        tbl = tbl_user;
    }
    
    private void OptionsFrame(){
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0,0,0,0));
        this.tsama.setVisible(false);
    }
    
    private void awal(){
        this.tnm.setText("");
        this.cbjabat.setSelectedItem("--Pilih--");
        this.tgllahir.setDate(new Date(31, 12, 1998));
        this.cbjabat.setSelectedItem("");
        this.t_email.setText("");
        this.tpass.setText("");
        this.tketik.setText("");
        this.btn_save.setEnabled(false);
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
        model.setIdUser(String.valueOf(model.Userkode(cbjabat.getSelectedItem().toString())));
        model.setNamaUser(String.valueOf(this.tnm.getText()));
        model.setPosisi(String.valueOf(this.cbjabat.getSelectedItem()));
        model.setTanggalLahir(this.tgllahir.getDate());
        model.setPendidikan(String.valueOf(this.cbpendidikan.getSelectedItem()));
        model.setEmail(String.valueOf(this.t_email.getText()));
        model.setPassword(String.valueOf(this.tpass.getText()));
    }
    
    private void simpan(){
        model.Simpan();
    }
    
    private void password(){
        String password = this.tpass.getText();
        if(this.tketik.getText().equals(password)){
            this.btn_save.setEnabled(true);
            this.tsama.setVisible(false);
        }else{
            this.tsama.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_batal = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        t_email = new javax.swing.JTextField();
        tnm = new javax.swing.JTextField();
        cbjabat = new javax.swing.JComboBox<>();
        cbpendidikan = new javax.swing.JComboBox<>();
        tgllahir = new com.toedter.calendar.JDateChooser();
        tketik = new javax.swing.JPasswordField();
        tpass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tsama = new javax.swing.JLabel();
        show2 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_batal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_batalMouseClicked(evt);
            }
        });
        jPanel2.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 80, 40));

        btn_save.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_save.setText("Simpan");
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveMouseClicked(evt);
            }
        });
        jPanel2.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 80, 40));

        t_email.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 290, 40));

        tnm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(tnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 290, 40));

        cbjabat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbjabat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Admin", "Kasir", "Supplier" }));
        jPanel2.add(cbjabat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 290, 40));

        cbpendidikan.setEditable(true);
        cbpendidikan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(cbpendidikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 290, 40));

        tgllahir.setMaxSelectableDate(new java.util.Date(1009821689000L));
        tgllahir.setMinSelectableDate(new java.util.Date(-62135791111000L));
        jPanel2.add(tgllahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 290, 40));

        tketik.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tketik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tketikKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tketikKeyTyped(evt);
            }
        });
        jPanel2.add(tketik, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 250, 40));

        tpass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(tpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 250, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Ketik Ulang Password");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 150, 40));

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/visible_32px.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 40, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Nama");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Jabatan");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Tanggal Lahir");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Pendidikan Terakhir");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 150, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Email");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 150, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Password");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 150, 40));

        tsama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tsama.setForeground(new java.awt.Color(255, 0, 0));
        tsama.setText("Password Tidak Samai");
        jPanel2.add(tsama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 250, 30));

        show2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/visiblegreen_32px.png"))); // NOI18N
        show2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show2MouseClicked(evt);
            }
        });
        jPanel2.add(show2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 40, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 480, 540));

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
        jLabel7.setText("Input Data User");
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

    private void btn_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseClicked
        this.awal();
    }//GEN-LAST:event_btn_batalMouseClicked

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        if(this.tnm.getText().equals("")
            || this.cbjabat.getSelectedItem().equals("--Pilih--")
            || this.t_email.getText().equals("")
            || this.cbpendidikan.getSelectedItem().equals("")
            || this.t_email.getText().equals("")
            || this.tgllahir.getDate() == null
            || this.tpass.getText().equals(false)){
                model.msg.validasidata();
        }else{   
            this.proses();
            this.simpan();
            this.loadtable();
            this.awal();
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

    private void tketikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tketikKeyTyped
        this.password();
    }//GEN-LAST:event_tketikKeyTyped

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        this.tpass.setEchoChar((char)0);
        this.tketik.setEchoChar((char)0);
        this.show.setVisible(false);
        this.show2.setVisible(true);
    }//GEN-LAST:event_showMouseClicked

    private void show2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show2MouseClicked
        this.tpass.setEchoChar('*');
        this.tketik.setEchoChar('*');
        this.show.setVisible(true);
        this.show2.setVisible(false);
    }//GEN-LAST:event_show2MouseClicked

    private void tketikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tketikKeyPressed
        this.password();
    }//GEN-LAST:event_tketikKeyPressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cbjabat;
    private javax.swing.JComboBox<String> cbpendidikan;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel show;
    private javax.swing.JLabel show2;
    private javax.swing.JTextField t_email;
    private javax.swing.JLabel tgl;
    private com.toedter.calendar.JDateChooser tgllahir;
    private javax.swing.JPasswordField tketik;
    private javax.swing.JTextField tnm;
    private javax.swing.JPasswordField tpass;
    private javax.swing.JLabel tsama;
    // End of variables declaration//GEN-END:variables
}
