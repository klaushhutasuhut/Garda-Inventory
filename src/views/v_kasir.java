/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import javax.swing.ImageIcon;
import models.M_kasir;
/**
 *
 * @author Klaus
 */
public class v_kasir extends javax.swing.JFrame {
    M_kasir model = new M_kasir();
    private String id, pos, nm;
    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    /**
     * Creates new form v_kasir
     * @param id_user
     * @param nama
     * @param posisi
     */
    public v_kasir(String id_user, String nama, String posisi) {
        initComponents();
        this.OptionsFrame();
        this.tanggal();
        this.awal();
        this.jam();
        model.koneksi();
        id = id_user;
        nm = nama;
        pos = posisi;
        this.setprofile();
    }
    
    private void OptionsFrame(){
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0,0,0,0));
        this.tjam.setVisible(false);
        this.tno.setEnabled(false);
        this.tid.setVisible(false);
        this.tjam.setVisible(false);
    }
    
    private void awal(){
        this.btn_no.setEnabled(true);
        this.tno.setText("");
        this.btn_tambah.setEnabled(false);
        this.t_bayar.setEnabled(false);
        this.btn_cetak.setEnabled(false);
        this.jButton1.setEnabled(false);
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
    
    private void jam(){
        model.setJam(this.tjam);
    }
    
    private void tanggal(){
        tgl.setText(model.tanggalnow);
    }
    
    private void hapustable(){
        model.hapusrow(this.tbl_kass);
        this.grandtotal.setText("0");
        this.t_bayar.setText("");
        this.t_kem.setText("0");
    }
    
    private void iplusb(){
        ImageIcon A = new ImageIcon(getClass().getResource("icon/plusred_32px.png"));
        btn_tambah.setIcon(A);
    }
    
    private void printimg(){
        ImageIcon A = new ImageIcon(getClass().getResource("icon/printred_32px.png"));
        btn_cetak.setIcon(A);
    }
    
    private void cetakno(){
        String x = "FK" + "-" + this.tgl.getText() + this.tjam.getText();
        this.tno.setText(x);
        this.btn_tambah.setEnabled(true);
        this.t_bayar.setEnabled(true);
        this.btn_no.setEnabled(false);
        this.jButton1.setEnabled(true);
    }
    
    private void hitungkembalian(){
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        try {
            Number number = kursIndonesia.parse(grandtotal.getText());
            double a = number.doubleValue();
            double b = Double.parseDouble(t_bayar.getText());
            double c = b - a;
            String tb = kursIndonesia.format(c);
            this.t_kem.setText(tb);
        }catch(ParseException ex){
                
        }
        this.t_kem.setEnabled(false);
        this.btn_cetak.setEnabled(true);
    }
    
    private void tambah(){
        model.tambahke(this.tbl_kass, this.grandtotal);
    }
    
    private void proses(){
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        double b = Double.parseDouble(t_bayar.getText());
        String tbyar = kursIndonesia.format(b);
        model.setNoFaktur(String.valueOf(this.tno.getText()));
        model.setTanggal(this.jdc.getDate());
        model.setGrandTotal(String.valueOf(grandtotal.getText()));
        model.setPembayaran(String.valueOf(tbyar));
        model.setKembali(String.valueOf(t_kem.getText()));
        model.setID(String.valueOf(this.tid.getText()));
    }
    
    private void seleksi(){
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        try {
            Number number = kursIndonesia.parse(grandtotal.getText());
            double a = number.doubleValue();
            double b = Double.parseDouble(t_bayar.getText());
            if(b < a){
                model.msg.seleksitotal();
            }else{
                this.hitungkembalian();
            }
        }catch(ParseException ex){
            System.out.println("Kesalahan Parsing");
        }
        
    }
    
    private void Simpan(){
        this.proses();
        this.model.Simpan(this.tbl_kass);
        this.model.Simpandet();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg2 = new javax.swing.JPanel();
        sidepane2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        profile = new javax.swing.JPanel();
        mn_profile = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tnm = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        item = new javax.swing.JPanel();
        mn_lap2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        mn_logout = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        trx = new javax.swing.JPanel();
        mn_dt = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tpos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kass = new javax.swing.JTable();
        btn_close = new javax.swing.JLabel();
        btn_cetak = new javax.swing.JLabel();
        btn_no = new javax.swing.JButton();
        t_bayar = new javax.swing.JTextField();
        t_kem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        grandtotal = new javax.swing.JLabel();
        tno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tjam = new javax.swing.JLabel();
        tid = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        grandtotal1 = new javax.swing.JLabel();
        jdc = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kasir");
        setUndecorated(true);

        bg2.setBackground(new java.awt.Color(255, 255, 255));
        bg2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepane2.setBackground(new java.awt.Color(54, 33, 89));
        sidepane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(85, 55, 118));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/shopping_cart_32px.png"))); // NOI18N
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 42, 50));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Penjualan Barang");
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 0, 172, 50));

        sidepane2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 230, 50));

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
        profile.add(tnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 0, 162, 50));

        sidepane2.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, -1));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        sidepane2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 10));

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

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/pdf_32px.png"))); // NOI18N
        item.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 42, 50));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Laporan Barang");
        item.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 0, 172, 50));

        sidepane2.add(item, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, 50));

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

        sidepane2.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, -1, -1));

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

        sidepane2.add(trx, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 50));

        bg2.add(sidepane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 740));

        jPanel1.setBackground(new java.awt.Color(122, 72, 221));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Penjualan Barang");

        tpos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tpos.setForeground(new java.awt.Color(255, 255, 255));
        tpos.setText("Admin");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/LOGO.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(tpos, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addGap(463, 463, 463)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(tpos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(90, Short.MAX_VALUE)))
        );

        bg2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 690, 150));

        tbl_kass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbl_kass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Satuan", "Jumlah Beli", "Harga", "Subtotal"
            }
        ));
        tbl_kass.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_kass.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbl_kass);

        bg2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 690, 280));

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
        bg2.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 30, 30));

        btn_cetak.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_cetak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/print_32px.png"))); // NOI18N
        btn_cetak.setText("Simpan");
        btn_cetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cetakMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cetakMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cetakMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cetakMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_cetakMouseReleased(evt);
            }
        });
        bg2.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 690, 90, 40));

        btn_no.setText("Cetak No Faktur");
        btn_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_noActionPerformed(evt);
            }
        });
        bg2.add(btn_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 120, 30));

        t_bayar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        t_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_bayarKeyPressed(evt);
            }
        });
        bg2.add(t_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 610, 190, 30));

        t_kem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        t_kem.setText("0");
        bg2.add(t_kem, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 650, 210, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Pembayaran :");
        bg2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 110, 30));

        btn_tambah.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_tambah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icon/plus_32px.png"))); // NOI18N
        btn_tambah.setText("Tambah Barang");
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tambahMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_tambahMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_tambahMouseReleased(evt);
            }
        });
        bg2.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 140, 30));

        tgl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tgl.setText("tgl");
        bg2.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 220, 30));

        grandtotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        grandtotal.setText("0");
        bg2.add(grandtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 560, 210, 40));

        tno.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bg2.add(tno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 190, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Total   :");
        bg2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 560, 60, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Kembali :");
        bg2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 650, 90, 40));
        bg2.add(tjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 130, 30));
        bg2.add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 100, 20));

        jButton1.setText("Batal");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        bg2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, -1, -1));

        grandtotal1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        grandtotal1.setText("Rp.");
        bg2.add(grandtotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 610, 30, 30));
        bg2.add(jdc, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg2, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mn_profileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_profileMouseEntered
        this.profile.setBackground(new Color(85,55,118));
    }//GEN-LAST:event_mn_profileMouseEntered

    private void mn_profileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_profileMouseExited
        this.profile.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_profileMouseExited

    private void btn_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseExited
        ImageIcon A = new ImageIcon(getClass().getResource("icon/close_window_32px.png"));
        btn_close.setIcon(A);
    }//GEN-LAST:event_btn_closeMouseExited

    private void btn_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseEntered
        ImageIcon A = new ImageIcon(getClass().getResource("icon/exitred_32px.png"));
        btn_close.setIcon(A);
    }//GEN-LAST:event_btn_closeMouseEntered

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        model.msg.keluar();
    }//GEN-LAST:event_btn_closeMouseClicked

    private void btn_cetakMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cetakMouseReleased
        this.printimg();
    }//GEN-LAST:event_btn_cetakMouseReleased

    private void btn_cetakMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cetakMousePressed
        ImageIcon A = new ImageIcon(getClass().getResource("icon/print_green32px.png"));
        btn_cetak.setIcon(A);
    }//GEN-LAST:event_btn_cetakMousePressed

    private void btn_cetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cetakMouseExited
        ImageIcon A = new ImageIcon(getClass().getResource("icon/print_32px.png"));
        btn_cetak.setIcon(A);
    }//GEN-LAST:event_btn_cetakMouseExited

    private void btn_cetakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cetakMouseEntered
        this.printimg();
    }//GEN-LAST:event_btn_cetakMouseEntered

    private void btn_cetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cetakMouseClicked
        this.Simpan();
        model.msg.cetstruk(tno.getText());
        this.awal();
        this.hapustable();
    }//GEN-LAST:event_btn_cetakMouseClicked

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        this.tambah();
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void btn_tambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseEntered
        this.iplusb();
    }//GEN-LAST:event_btn_tambahMouseEntered

    private void btn_tambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseExited
        ImageIcon A = new ImageIcon(getClass().getResource("icon/plus_32px.png"));
        btn_tambah.setIcon(A);
    }//GEN-LAST:event_btn_tambahMouseExited

    private void btn_tambahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMousePressed
        ImageIcon A = new ImageIcon(getClass().getResource("icon/plus_green32px.png"));
        btn_tambah.setIcon(A);
    }//GEN-LAST:event_btn_tambahMousePressed

    private void btn_tambahMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseReleased
        this.iplusb();
    }//GEN-LAST:event_btn_tambahMouseReleased

    private void mn_lap2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_lap2MouseEntered
        this.item.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_lap2MouseEntered

    private void mn_lap2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_lap2MouseExited
        this.item.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_mn_lap2MouseExited

    private void btn_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_noActionPerformed
        this.cetakno();
    }//GEN-LAST:event_btn_noActionPerformed

    private void t_bayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_bayarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(t_bayar.getText().equals("")){
                model.msg.validasidata();
            }else{
                this.seleksi();
            }
        }
    }//GEN-LAST:event_t_bayarKeyPressed

    private void mn_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_profileMouseClicked
        this.profile();
        this.model.KeGantiPass(tid);
    }//GEN-LAST:event_mn_profileMouseClicked

    private void mn_lap2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_lap2MouseClicked
        model.laporan11();
    }//GEN-LAST:event_mn_lap2MouseClicked

    private void mn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_logoutMouseClicked
        model.Logout();
        this.dispose();
    }//GEN-LAST:event_mn_logoutMouseClicked

    private void mn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_logoutMouseEntered
        this.logout.setBackground(new Color(54,33,89));
    }//GEN-LAST:event_mn_logoutMouseEntered

    private void mn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_logoutMouseExited
        this.logout.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_mn_logoutMouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.awal();
        this.hapustable();
    }//GEN-LAST:event_jButton1MouseClicked

    private void mn_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mn_dtMouseClicked
        this.profile();
        model.KeKasir(id, nm, pos);
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
    private javax.swing.JPanel bg2;
    private javax.swing.JLabel btn_cetak;
    private javax.swing.JLabel btn_close;
    private javax.swing.JButton btn_no;
    private javax.swing.JLabel btn_tambah;
    private javax.swing.JLabel grandtotal;
    private javax.swing.JLabel grandtotal1;
    private javax.swing.JPanel item;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdc;
    private javax.swing.JPanel logout;
    private javax.swing.JLabel mn_dt;
    private javax.swing.JLabel mn_lap2;
    private javax.swing.JLabel mn_logout;
    private javax.swing.JLabel mn_profile;
    private javax.swing.JPanel profile;
    private javax.swing.JPanel sidepane2;
    private javax.swing.JTextField t_bayar;
    private javax.swing.JLabel t_kem;
    private javax.swing.JTable tbl_kass;
    private javax.swing.JLabel tgl;
    private javax.swing.JLabel tid;
    private javax.swing.JLabel tjam;
    private javax.swing.JLabel tnm;
    private javax.swing.JTextField tno;
    private javax.swing.JLabel tpos;
    private javax.swing.JPanel trx;
    // End of variables declaration//GEN-END:variables
}
