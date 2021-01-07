/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import config.database;
import helper.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import views.v_admdatapenjualan;
import views.v_admdatapersediaan;
import views.v_admin;
import views.v_admkasir;
import views.v_admsupplier;
import views.v_barang;
import views.v_datapenjualan;
import views.v_gantipass;
import views.v_kasir;
import views.v_login;
import views.v_pilihbarang2;
/**
 *
 * @author Klaus
 */
public class Kasir extends database{
    JasperDesign jasperdesign;
    JasperReport jasperreport;
    JasperPrint jasperprint;
    public Message msg = new Message();
    public java.util.Date tgls = new java.util.Date();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault());   
    public String tanggalnow = sdf.format(tgls);
    String kd_brg, no_faktur, nm_brg, kondisi, satuan, id_user, jumlah, subtotal, harga, grandtotal, kembali, pembayaran;
    String tbkd, tbharga;
    Date tanggal;
    int tbjum;
    double tbsub;
    
    /* untuk Table */
    
    public String getKodeBrg(){
        return kd_brg;
    }

    public void setKodeBrg(String kd_brg){
        this.kd_brg = kd_brg;
    }
    
    public String getNamaBrg(){
        return nm_brg;
    }

    public void setNamaBrg(String nm_brg){
        this.nm_brg = nm_brg;
    }
    
    public String getSatuanBrg(){
        return satuan;
    }

    public void setSatuanBrg(String satuan){
        this.satuan = satuan;
    }
    
    public String getJumlahBeli(){
        return jumlah;
    }

    public void setJumlahBeli(String jumlah){
        this.jumlah = jumlah;
    }
    
    public String getHarga(){
        return harga;
    }

    public void setHarga(String harga){
        this.harga = harga;
    }
    
    public String getSubtotal(){
        return subtotal;
    }

    public void setSubtotal(String subtotal){
        this.subtotal = subtotal;
    }    
    /* untuk Database */
    public String getNoFaktur(){
        return no_faktur;
    }
    
    public void setNoFaktur(String no_faktur){
        this.no_faktur = no_faktur;
    }
    
    public Date getTanggal(){
        return tanggal;
    }

    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    
    public String getGrandTotal(){
        return grandtotal;
    }

    public void setGrandTotal(String grandtotal){
        this.grandtotal = grandtotal;
    }
    
    public String getPembayaran(){
        return pembayaran;
    }

    public void setPembayaran(String pembayaran){
        this.pembayaran = pembayaran;
    }
    
    public String getKembali(){
        return kembali;
    }

    public void setKembali(String kembali){
        this.kembali = kembali;
    }
    
    public String getID(){
        return id_user;
    }
    
    public void setID(String id_user){
        this.id_user = id_user;
    }
    
     public void SimpanDetail(String QuerySave){
        try{
            koneksi();
            st.executeUpdate(QuerySave);
        }catch(SQLException e){
            msg.notsimpan(e);
        }
    }
     
     public void KeFormPersediaan(String id_u, String namaus, String pos){
        v_admdatapersediaan barang = new v_admdatapersediaan(id_u, namaus, pos);
        barang.setVisible(true);
    } 
    
    public void SimpanData(String QuerySave, JTable tkas){
        try{
            this.koneksi();
            int rows=tkas.getRowCount();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(QuerySave);
            for(int row = 0; row<rows; row++){
                tbkd  = (String)tkas.getValueAt(row, 0);
                tbjum  = Integer.parseInt((String)tkas.getValueAt(row, 3));
                tbharga  = (String)tkas.getValueAt(row, 4);
                tbsub  = Double.parseDouble((String) tkas.getValueAt(row, 5));
                pstmt.setString(1, getNoFaktur());
                pstmt.setInt(2, tbjum);
                pstmt.setString(3, tbharga);
                pstmt.setDouble(4, tbsub);
                pstmt.setString(5, getID());
                pstmt.setString(6, tbkd);
                
                pstmt.addBatch();
            }            
            pstmt.executeBatch();
            conn.commit();
        }catch(SQLException e){
            msg.notsimpan(e);
        }
    }
    
    public void tablerow(JTable tablesup){
        DefaultTableModel datatable = (DefaultTableModel) tablesup.getModel();
        List list = new ArrayList<>();
        tablesup.setAutoCreateColumnsFromModel(true);
        list.add(getKodeBrg());
        list.add(getNamaBrg());
        list.add(getSatuanBrg());
        list.add(getJumlahBeli());
        list.add(getHarga());
        list.add(getSubtotal());
        datatable.addRow(list.toArray());
    }
    
    public void hapusrow(JTable tablesup){
        DefaultTableModel datatable = (DefaultTableModel) tablesup.getModel();
        if(tablesup.getRowCount() > 0){
            for(int i = tablesup.getRowCount() - 1; i > -1; i--){
                datatable.removeRow(i);
            }
        }
    }
    
    public void pilihrow(JTable tablekas){
        DefaultTableModel datatable = (DefaultTableModel) tablekas.getModel();
        int row =tablekas.getSelectedRow();
        if(row>=0){
            datatable.removeRow(row);
        }
    }
    
    public void hitung(JTable tablesup, JLabel Grandtotal){
        double ttl = 0;
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        for(int a=0;a<tablesup.getRowCount();a++){
            double pu =Double.parseDouble((String)tablesup.getValueAt(a, 5));
            ttl+=pu;
        }
        String x = kursIndonesia.format(ttl);
        Grandtotal.setText(x);
    }
    
    public void tambahke(JTable tbl_kas, JLabel Grandtotal){
        v_pilihbarang2 vb = new v_pilihbarang2(tbl_kas, Grandtotal);
        vb.setVisible(true);
    }
    
    public final void setJam(JLabel lblwktu){
    ActionListener taskPerformer = (ActionEvent evt) -> {
        String nol_jam = "", nol_menit = "", nol_detik = "";
        java.util.Date dateTime = new java.util.Date();
        int nilai_jam = dateTime.getHours();
        int nilai_menit = dateTime.getMinutes();
        int nilai_detik = dateTime.getSeconds();
        if(nilai_jam <= 9) nol_jam= "0";
        if(nilai_menit <= 9) nol_menit= "0";
        if(nilai_detik <= 9) nol_detik= "0";
        String jam = nol_jam + Integer.toString(nilai_jam);
        String menit = nol_menit + Integer.toString(nilai_menit);
        String detik = nol_detik + Integer.toString(nilai_detik);
        lblwktu.setText(jam + menit + detik);
    };
    new Timer(1000, taskPerformer).start();
    }
    
    public void KeFormUser(String id_u, String namaus, String pos){
        v_admin barang = new v_admin(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void KeFormBarang(String id_u, String namaus, String pos){
        v_barang barang = new v_barang(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void KeFormSupplier(String id_u, String namaus, String pos){
        v_admsupplier barang = new v_admsupplier(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void KeFormKasir(String id_u, String namaus, String pos){
        v_admkasir barang = new v_admkasir(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void KeKasir(String id_u, String namaus, String pos){
        v_datapenjualan barang = new v_datapenjualan(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void KKasir(String id_u, String namaus, String pos){
        v_kasir barang = new v_kasir(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void Cetak(Date jdc1, Date jdc2){
        try{
            String tgl1 = new SimpleDateFormat("dd/MM/yyyy").format(jdc1);
            String tgl2 = new SimpleDateFormat("dd/MM/yyyy").format(jdc2);
            File file = new File("src/ireport/LaporanPenjualan.jrxml");
            jasperdesign = JRXmlLoader.load(file);
            Map param = new HashMap();
            param.put("tgl1", tgl1);
            param.put("tgl2", tgl2);
            jasperreport = JasperCompileManager.compileReport(jasperdesign);
            jasperprint = JasperFillManager.fillReport(jasperreport, param, koneksi());
            JasperViewer.viewReport(jasperprint, false);
        }catch(JRException E){
            
        }
    }
    
    public void GantiPass(String QueryLoad){
        try {
            koneksi();
            rs = st.executeQuery(QueryLoad);
            while (rs.next()) {
                String id_us = rs.getString("id_user");
                String nm = rs.getString("namaus");
                String pos = rs.getString("posisi");
                String emai = rs.getString("email");
                String tanggall = rs.getString("tanggal_lahir");
                String pendid = rs.getString("pendidikan");  
                v_gantipass barang = new v_gantipass(id_us, nm, pos, emai, tanggall, pendid);
                barang.setVisible(true);
            }
        }catch(SQLException E){
            msg.not(String.valueOf(E));
        }
    }
    
    public void Struk(String nofaktur){
        try{
            String file = "src/ireport/StrukPenjualan.jasper";
            HashMap param = new HashMap();
            param.put("notrans", nofaktur);
            JasperPrint jp = JasperFillManager.fillReport(file, param, koneksi());
            JasperViewer.viewReport(jp, false);
        }catch(JRException E){
            
        }
    }
    
    public void KeFormDataP(String id_u, String namaus, String pos){
        v_admdatapenjualan barang = new v_admdatapenjualan(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void laporan11(){
        try{
            JasperPrint jp = JasperFillManager.fillReport("src/ireport/LaporanBarang.jasper", null, koneksi());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }catch(JRException E){
            E.printStackTrace();
        }
    }
    
    public void Logout(){
        v_login log = new v_login();
        log.setVisible(true);
    }
}


