/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import controllers.Barang;
import helper.List_barang2;
import helper.Tbl_barang2;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JLabel;
import models.M_barang;
import models.M_kasir;
/**
 *
 * @author Klaus
 */
public class v_pilihbarang2 extends javax.swing.JDialog {
    M_barang brg = new M_barang();
    M_kasir model = new M_kasir();
    List<List_barang2> data = new ArrayList<>();
    Tbl_barang2 tbl_model = new Tbl_barang2(data);
    JTable tblka;
    JLabel Grandto;
    double sb;
    String harga = "";
    /**
     * Creates new form v_inputbarang
     * @param tblkas
     * @param Grandtotal
     */
    public v_pilihbarang2(JTable tblkas, JLabel Grandtotal) {
        initComponents();
        this.table();
        this.tanggal();
        this.awal();
        this.OptionsF();
        tblka = tblkas;
        Grandto = Grandtotal;        
    }
    
    private void OptionsF(){
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0,0,0,0));
        this.t_kd.setVisible(false);
        this.t_nm.setVisible(false);
        this.t_kon.setVisible(false);
        this.t_sat.setVisible(false);
        this.t_harga.setVisible(false);
        this.tharga.setVisible(false);
        this.t_stok.setVisible(false);
        this.t_kur.setVisible(false);
    }
    
    private void awal(){
        this.lbl35.setEnabled(false);
        this.jumbel.setEnabled(false);
        this.jButton1.setEnabled(false);
        this.jumbel.setText("");
    }
    
    private void tanggal(){
        tgl.setText(brg.tanggalnow);
    }
    
    private void table(){
        data = brg.Load2("");
        tbl_model = new Tbl_barang2(data);
        tbl_barang.setModel(tbl_model);
    }
    
    private void cari(){
        brg.Cari2(cari, tbl_barang);
    }
    
    private void settable(){
        int i = tbl_barang.getSelectedRow();
        String kd_brg = tbl_barang.getValueAt(i, 0).toString();
        Barang d = brg.pilihdata1(kd_brg);
        t_kd.setText(d.getKodeBrg());
        t_nm.setText(d.getNamaBrg());
        t_stok.setText(Integer.toString(d.getStokBrg()));
        t_sat.setText(d.getSatuanBrg());
        t_kon.setText(d.getKondisiBrg());
        tharga.setText(d.getHargajual());
        harga = (d.getHarga());
        this.jButton1.setEnabled(true);
    }
    
    private void proses(){
        model.setKodeBrg(String.valueOf(this.t_kd.getText()));
        model.setNamaBrg(String.valueOf(this.t_nm.getText()));
        model.setSatuanBrg(String.valueOf(this.t_sat.getText()));
        model.setJumlahBeli(String.valueOf(this.jumbel.getText()));
        model.setHarga(String.valueOf(this.tharga.getText()));
        model.setSubtotal(String.valueOf(this.t_harga.getText()));
        brg.setKodeBrg(String.valueOf(this.t_kd.getText()));
        brg.setNamaBrg(String.valueOf(this.t_nm.getText()));
        brg.setHargajual(String.valueOf(this.tharga.getText()));
        brg.setHarga(String.valueOf(harga));
        brg.setSatuanBrg(String.valueOf(this.t_sat.getText()));
        brg.setKondisiBrg(String.valueOf(this.t_kon.getText()));
        brg.setStokBrg(Integer.valueOf(this.t_kur.getText()));
    }
    
    private void pilih(){
        this.jumbel.setEnabled(true);
        this.jButton1.setEnabled(true);
        this.jumbel.requestFocus();
        this.settable();
    }
    
    private void Tableconfig(){
        model.tablerow(this.tblka);
        model.hitung(tblka, Grandto);
    }
    
    private void hitung(){
        int y = Integer.parseInt(t_stok.getText());
        int x = Integer.parseInt(jumbel.getText());
        double sub = Double.parseDouble(tharga.getText());
        int baru = y - x;
        sb = x*sub;
        this.t_harga.setText(Double.toString(sb));
        if(baru <= 0){
            int coba = 0;
            t_kur.setText(Integer.toString(coba));
        }else{
            t_kur.setText(Integer.toString(baru));
        }
    }
    
    private void Seleksistok(){
        int y = Integer.parseInt(t_stok.getText());
        int x = Integer.parseInt(jumbel.getText());
        if(t_stok.getText().equals("0")){
            brg.msg.seleksi();
            this.awal();
        }else if(x > y){
            brg.msg.lebih();
            this.awal();
        }else{
            this.hitung();
            this.proses();
            this.Tableconfig();
            this.update();
            this.jumbel.setText("");
            this.awal();
            this.table();
        }
    }
    
    private void update(){
        brg.Updatesup();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_barang = new javax.swing.JTable();
        lbl = new javax.swing.JLabel();
        jumbel = new javax.swing.JTextField();
        lbl35 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        t_kd = new javax.swing.JTextField();
        t_nm = new javax.swing.JTextField();
        t_sat = new javax.swing.JTextField();
        t_harga = new javax.swing.JTextField();
        t_stok = new javax.swing.JTextField();
        t_kur = new javax.swing.JTextField();
        t_kon = new javax.swing.JTextField();
        tharga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        close = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_barang);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 460, 270));

        lbl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl.setText("Jumlah Beli");
        jPanel2.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 80, 30));

        jumbel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jumbel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jumbelKeyPressed(evt);
            }
        });
        jPanel2.add(jumbel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 170, 30));

        lbl35.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl35.setText("Enter");
        jPanel2.add(lbl35, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 40, 30));

        cari.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariKeyTyped(evt);
            }
        });
        jPanel2.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 170, 30));

        lbl1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl1.setText("Cari Nama Barang");
        jPanel2.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 120, 30));
        jPanel2.add(t_kd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 80, 30));
        jPanel2.add(t_nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 80, 30));
        jPanel2.add(t_sat, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 60, 30));
        jPanel2.add(t_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 70, -1));
        jPanel2.add(t_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 40, -1));
        jPanel2.add(t_kur, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 70, -1));
        jPanel2.add(t_kon, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 50, -1));
        jPanel2.add(tharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 140, -1));

        jButton1.setText("Batal");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 460, 400));

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
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 30, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pilih Barang");
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

    private void tbl_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_barangMouseClicked
        this.pilih();
    }//GEN-LAST:event_tbl_barangMouseClicked

    private void jumbelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumbelKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(jumbel.getText().equals("")
                    || jumbel.getText().equals("0")){
                brg.msg.validasidata();
            }else if(tharga.getText().equals("0")){
                brg.msg.hargams();         
            }else{
                this.Seleksistok();
            }
        }
    }//GEN-LAST:event_jumbelKeyPressed

    private void cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyTyped
        this.cari();
    }//GEN-LAST:event_cariKeyTyped

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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.awal();
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JLabel close;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumbel;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl35;
    private javax.swing.JTextField t_harga;
    private javax.swing.JTextField t_kd;
    private javax.swing.JTextField t_kon;
    private javax.swing.JTextField t_kur;
    private javax.swing.JTextField t_nm;
    private javax.swing.JTextField t_sat;
    private javax.swing.JTextField t_stok;
    private javax.swing.JTable tbl_barang;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField tharga;
    // End of variables declaration//GEN-END:variables
}
