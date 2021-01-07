/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import controllers.Barang;
import helper.List_barang;
import helper.Tbl_barang;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import models.M_barang;
/**
 *
 * @author Klaus
 */
public class v_barang extends javax.swing.JFrame {
    M_barang model = new M_barang();
    List<List_barang> data = new ArrayList<>();
    Tbl_barang tbl_model = new Tbl_barang(data);
    private String kd_barang, nm_brg, kds_brg, satuan, hargajual, hargabeli;
    private String id, pos, nm;
    private int stok_brg;
    /**
     * Creates new form v_barang
     * @param id_user
     * @param nama
     * @param posisi
     */
    public v_barang(String id_user, String nama, String posisi) {
        initComponents();
        this.awal();
        this.OptionsFrame();
        this.loadtable();
        id = id_user;
        nm = nama;
        pos = posisi;
        this.setprofile();
    }
    
    private void OptionsFrame(){
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0,0,0,0));
        this.tid.setVisible(false);
        this.tgl.setText(model.tanggalnow);
    }
    
    private void awal(){
        this.btn_hapus.setEnabled(false);
        this.btn_edit.setEnabled(false);
        this.btl.setEnabled(false);
    }
    
    private void loadtable(){
        data = model.Load1("");
        tbl_model = new Tbl_barang(data);
        tbl_barang.setModel(tbl_model);
    }
    
    private void setprofile(){
        tid.setText(id);
        tnm.setText(nm);
        tpos.setText(pos);
    }
    
    private void profile(){
        id = tid.getText();
        nm = tnm.getText();
        pos = tpos.getText();
    }
    
    private void settable(){
        int i = tbl_barang.getSelectedRow();
        String kd_brg = tbl_barang.getValueAt(i, 0).toString();
        Barang d = model.pilihdata1(kd_brg);
        kd_barang = (d.getKodeBrg());
        nm_brg = (d.getNamaBrg());
        stok_brg = (d.getStokBrg());
        satuan = (d.getSatuanBrg());
        kds_brg = (d.getKondisiBrg());
        hargabeli = (d.getHarga());
        hargajual = (d.getHargajual());
    }
    
    private void proses(){
        model.setKodeBrg(String.valueOf(kd_barang));
        model.setNamaBrg(String.valueOf(nm_brg));
        model.setHarga(hargabeli);
        model.setHargajual(hargajual);
        model.setSatuanBrg(String.valueOf(satuan));
        model.setKondisiBrg(String.valueOf(kds_brg));
        model.setStokBrg(stok_brg);
    }
    
    private void ieditb(){
        ImageIcon A = new ImageIcon(getClass().getResource("icon/edit_red_32px.png"));
        btn_edit.setIcon(A);
    }
    
    private void itrash(){
        ImageIcon A = new ImageIcon(getClass().getResource("icon/wastered_32px.png"));
        btn_hapus.setIcon(A);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        user = new javax.swing.JPanel();
        mn_user = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        mn_logout = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        profile = new javax.swing.JPanel();
        mn_profile = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tnm = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        supply = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        mn_supply = new javax.swing.JLabel();
        trans = new javax.swing.JPanel();
        mn_sells = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        item = new javax.swing.JPanel();
        mn_lap2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pers = new javax.swing.JPanel();
        mn_persediaan = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        trx = new javax.swing.JPanel();
        mn_dt = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tpos = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_close = new javax.swing.JLabel();
        btn_edit = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JLabel();
        tid = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        btl = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_barang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepane.setBackground(new java.awt.Color(54, 33, 89));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(85, 55, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Master Barang");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 11, 172, 39));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/product_32px.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -1, 42, 50));

        sidepane.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 230, 50));

        user.setBackground(new java.awt.Color(64, 43, 100));
        user.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mn_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mn_userMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mn_userMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mn_userMouseExited(evt);
            }
        });
        user.add(mn_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Master User");
        user.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 11, 172, 39));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/home_32px.png"))); // NOI18N
        user.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -1, 40, 50));

        sidepane.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        logout.setBackground(new java.awt.Color(64, 43, 100));
        logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mn_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mn_logoutMouseExited(evt);
            }
        });
        logout.add(mn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/exit_32px.png"))); // NOI18N
        logout.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 42, 50));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Logout");
        logout.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 11, 172, 39));

        sidepane.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, -1, -1));

        profile.setBackground(new java.awt.Color(54, 33, 89));
        profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mn_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mn_profileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mn_profileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mn_profileMouseExited(evt);
            }
        });
        profile.add(mn_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/gender_neutral_user_32px.png"))); // NOI18N
        profile.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 42, 50));

        tnm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tnm.setForeground(new java.awt.Color(255, 255, 255));
        tnm.setText("Klaus");
        profile.add(tnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 11, 170, 39));

        sidepane.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, -1));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        sidepane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 10));

        supply.setBackground(new java.awt.Color(64, 43, 100));
        supply.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/truck_32px.png"))); // NOI18N
        supply.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 42, 50));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Persediaan Barang");
        supply.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 11, 172, 39));

        mn_supply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mn_supplyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mn_supplyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mn_supplyMouseExited(evt);
            }
        });
        supply.add(mn_supply, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        sidepane.add(supply, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        trans.setBackground(new java.awt.Color(64, 43, 100));
        trans.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mn_sells.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mn_sellsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mn_sellsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mn_sellsMouseExited(evt);
            }
        });
        trans.add(mn_sells, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/shopping_cart_32px.png"))); // NOI18N
        trans.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 42, 50));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Penjualan Barang");
        trans.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 11, 172, 39));

        sidepane.add(trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, 50));

        item.setBackground(new java.awt.Color(64, 43, 100));
        item.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mn_lap2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mn_lap2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mn_lap2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mn_lap2MouseExited(evt);
            }
        });
        item.add(mn_lap2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/pdf_32px.png"))); // NOI18N
        item.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 42, 50));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Laporan Barang");
        item.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 0, 172, 50));

        sidepane.add(item, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, 50));

        pers.setBackground(new java.awt.Color(64, 43, 100));
        pers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mn_persediaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mn_persediaanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mn_persediaanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mn_persediaanMouseExited(evt);
            }
        });
        pers.add(mn_persediaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/box_32px.png"))); // NOI18N
        pers.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 42, 50));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Data Persediaan Barang");
        pers.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 11, 172, 39));

        sidepane.add(pers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));

        trx.setBackground(new java.awt.Color(64, 43, 100));
        trx.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mn_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mn_dtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mn_dtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mn_dtMouseExited(evt);
            }
        });
        trx.add(mn_dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/banknotes_32px.png"))); // NOI18N
        trx.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 42, 50));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Data Penjualan Barang");
        trx.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 11, 172, 39));

        sidepane.add(trx, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, 50));

        bg.add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 590));

        jPanel1.setBackground(new java.awt.Color(122, 72, 221));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Master Barang");

        tpos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tpos.setForeground(new java.awt.Color(255, 255, 255));
        tpos.setText("Admin");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/LOGO.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(tpos, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addGap(463, 463, 463)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(tpos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(90, Short.MAX_VALUE)))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 680, 150));

        btn_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/close_window_32px.png"))); // NOI18N
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_closeMouseExited(evt);
            }
        });
        bg.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 30, 30));

        btn_edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/edit_property_32px.png"))); // NOI18N
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_editMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_editMouseReleased(evt);
            }
        });
        bg.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 30, 30));

        btn_hapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/waste_32px.png"))); // NOI18N
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_hapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_hapusMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_hapusMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_hapusMouseReleased(evt);
            }
        });
        bg.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 30, 30));
        bg.add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 70, 30));

        tgl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tgl.setText("tgl");
        bg.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 220, 30));

        btl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btl.setText("Batal");
        btl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlActionPerformed(evt);
            }
        });
        bg.add(btl, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, -1, 30));

        tcari.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tcariKeyTyped(evt);
            }
        });
        bg.add(tcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 240, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Cari Nama");
        bg.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 80, 30));

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
        jScrollPane2.setViewportView(tbl_barang);

        bg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 680, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mn_userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_userMouseEntered
        this.user.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_userMouseEntered

    private void mn_userMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_userMouseExited
        this.user.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_mn_userMouseExited

    private void mn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_logoutMouseEntered
        this.logout.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_logoutMouseEntered

    private void mn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_logoutMouseExited
        this.logout.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_mn_logoutMouseExited

    private void mn_profileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_profileMouseEntered
        this.profile.setBackground(new Color(85,55,118));
    }//GEN-LAST:event_mn_profileMouseEntered

    private void mn_profileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_profileMouseExited
        this.profile.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_profileMouseExited

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        model.msg.keluar();
    }//GEN-LAST:event_btn_closeMouseClicked

    private void btn_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("icon/exitred_32px.png"));
        btn_close.setIcon(A);
    }//GEN-LAST:event_btn_closeMouseEntered

    private void btn_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseExited
        ImageIcon A = new ImageIcon(getClass().getResource("icon/close_window_32px.png"));
        btn_close.setIcon(A);
    }//GEN-LAST:event_btn_closeMouseExited

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        this.proses();
        model.EditBarang(kd_barang, nm_brg, kds_brg, satuan, stok_brg, hargabeli, hargajual, this.tbl_barang);
        this.awal();
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("icon/edit_red_32px.png"));
        btn_edit.setIcon(A);
    }//GEN-LAST:event_btn_editMouseEntered

    private void btn_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseExited
        ImageIcon A = new ImageIcon(getClass().getResource("icon/edit_property_32px.png"));
        btn_edit.setIcon(A);
    }//GEN-LAST:event_btn_editMouseExited

    private void btn_editMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMousePressed
        ImageIcon A = new ImageIcon(getClass().getResource("icon/edit_green_32px.png"));
        btn_edit.setIcon(A);
    }//GEN-LAST:event_btn_editMousePressed

    private void btn_editMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseReleased
        this.ieditb();
    }//GEN-LAST:event_btn_editMouseReleased

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        this.proses();
        model.Delete();
        this.awal();
        this.loadtable();
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_hapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("icon/wastered_32px.png"));
        btn_hapus.setIcon(A);
    }//GEN-LAST:event_btn_hapusMouseEntered

    private void btn_hapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseExited
        ImageIcon A = new ImageIcon(getClass().getResource("icon/waste_32px.png"));
        btn_hapus.setIcon(A);
    }//GEN-LAST:event_btn_hapusMouseExited

    private void btn_hapusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMousePressed
        ImageIcon A = new ImageIcon(getClass().getResource("icon/wastegreen_32px.png"));
        btn_hapus.setIcon(A);
    }//GEN-LAST:event_btn_hapusMousePressed

    private void btn_hapusMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseReleased
        this.itrash();
    }//GEN-LAST:event_btn_hapusMouseReleased

    private void btlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlActionPerformed
        this.awal();
    }//GEN-LAST:event_btlActionPerformed

    private void tbl_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_barangMouseClicked
        this.settable();
        this.btn_hapus.setEnabled(true);
        this.btn_edit.setEnabled(true);
        this.btl.setEnabled(true);
    }//GEN-LAST:event_tbl_barangMouseClicked

    private void tcariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyTyped
        model.Cari(tcari, tbl_barang);
    }//GEN-LAST:event_tcariKeyTyped

    private void mn_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_userMouseClicked
        this.profile();
        model.KeFormUser(id, nm, pos);
        this.dispose();
    }//GEN-LAST:event_mn_userMouseClicked

    private void mn_supplyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_supplyMouseClicked
        this.profile();
        model.KeFormSupplier(id, nm, pos);
        this.dispose();
    }//GEN-LAST:event_mn_supplyMouseClicked

    private void mn_supplyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_supplyMouseEntered
        this.supply.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_supplyMouseEntered

    private void mn_supplyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_supplyMouseExited
        this.supply.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_mn_supplyMouseExited

    private void mn_sellsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_sellsMouseClicked
        this.profile();
        model.KeFormKasir(id, nm, pos);
        this.dispose();
    }//GEN-LAST:event_mn_sellsMouseClicked

    private void mn_sellsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_sellsMouseEntered
        this.trans.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_sellsMouseEntered

    private void mn_sellsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_sellsMouseExited
        this.trans.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_mn_sellsMouseExited

    private void mn_lap2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_lap2MouseEntered
        this.item.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_lap2MouseEntered

    private void mn_lap2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_lap2MouseExited
        this.item.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_mn_lap2MouseExited

    private void mn_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_profileMouseClicked
        this.profile();
        this.model.KeGantiPass(tid);
    }//GEN-LAST:event_mn_profileMouseClicked

    private void mn_lap2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_lap2MouseClicked
        model.laporan();
    }//GEN-LAST:event_mn_lap2MouseClicked

    private void mn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_logoutMouseClicked
        model.Logout();
        this.dispose();
    }//GEN-LAST:event_mn_logoutMouseClicked

    private void mn_persediaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_persediaanMouseClicked
        this.profile();
        model.KeFormPersediaan(id, nm, pos);
        this.dispose();
    }//GEN-LAST:event_mn_persediaanMouseClicked

    private void mn_persediaanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_persediaanMouseEntered
        this.pers.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_persediaanMouseEntered

    private void mn_persediaanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_persediaanMouseExited
        this.pers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_mn_persediaanMouseExited

    private void mn_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_dtMouseClicked
        this.profile();
        model.KeFormDataP(id, nm, pos);
        this.dispose();
    }//GEN-LAST:event_mn_dtMouseClicked

    private void mn_dtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_dtMouseEntered
        this.trx.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_dtMouseEntered

    private void mn_dtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_dtMouseExited
        this.trx.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_mn_dtMouseExited

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btl;
    private javax.swing.JLabel btn_close;
    private javax.swing.JLabel btn_edit;
    private javax.swing.JLabel btn_hapus;
    private javax.swing.JPanel item;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel logout;
    private javax.swing.JLabel mn_dt;
    private javax.swing.JLabel mn_lap2;
    private javax.swing.JLabel mn_logout;
    private javax.swing.JLabel mn_persediaan;
    private javax.swing.JLabel mn_profile;
    private javax.swing.JLabel mn_sells;
    private javax.swing.JLabel mn_supply;
    private javax.swing.JLabel mn_user;
    private javax.swing.JPanel pers;
    private javax.swing.JPanel profile;
    private javax.swing.JPanel sidepane;
    private javax.swing.JPanel supply;
    private javax.swing.JTable tbl_barang;
    private javax.swing.JTextField tcari;
    private javax.swing.JLabel tgl;
    private javax.swing.JLabel tid;
    private javax.swing.JLabel tnm;
    private javax.swing.JLabel tpos;
    private javax.swing.JPanel trans;
    private javax.swing.JPanel trx;
    private javax.swing.JPanel user;
    // End of variables declaration//GEN-END:variables
}
