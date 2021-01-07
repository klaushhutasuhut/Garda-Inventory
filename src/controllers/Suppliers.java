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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
import views.v_barangbaru;
import views.v_datapersediaan;
import views.v_gantipass;
import views.v_login;
import views.v_pilihbarang1;
import views.v_supplier;
/**
 *
 * @author Klaus
 */
public class Suppliers extends database{
    JasperDesign jasperdesign;
    JasperReport jasperreport;
    JasperPrint jasperprint;
    public Message msg = new Message();
    public java.util.Date tgls = new java.util.Date();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());   
    public String tanggalnow = sdf.format(tgls);
    String kd_brg, no_persed, nm_brg, kondisi, satuan, id_user, tbkd, total, stok, hargabeli, sbttl, mbel;
    int stokttl, mstok;
    Date tanggal;
    double mtotal;
    
    
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
    
    public String getStokBrg(){
        return stok;
    }

    public void setStokBrg(String stok){
        this.stok = stok;
    }
    
    public String getHargabeli(){
        return hargabeli;
    }

    public void setHargabeli(String hargabeli){
        this.hargabeli = hargabeli;
    }
    
    public String getTotal(){
        return total;
    }

    public void setTotal(String  total){
        this.total = total;
    }
    
    public String getKondisiBrg(){
        return kondisi;
    }

    public void setKondisiBrg(String kondisi){
        this.kondisi = kondisi;
    }
    
    public String getSatuanBrg(){
        return satuan;
    }

    public void setSatuanBrg(String satuan){
        this.satuan = satuan;
    }
    
    /* --- Batas Pengiriman Data --- */
    
    public String getNopersed(){
        return no_persed;
    }

    public void setNopersed(String no_persed){
        this.no_persed = no_persed;
    }
    
    public Date getTanggal(){
        return tanggal;
    }

    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    
    public int getStoktotal(){
        return stokttl;
    }

    public void setStoktotal(int stokttl){
        this.stokttl = stokttl;
    }
    
    public String getSubtotal(){
        return sbttl;
    }

    public void setSubtotal(String sbttl){
        this.sbttl = sbttl;
    }
    
    public String getId(){
        return id_user;
    }

    public void setId(String id_user){
        this.id_user = id_user;
    }
    
     /* --- Batas Pengiriman Data --- */
    
    public void SimpanDetail(String QuerySave){
        try{
            koneksi();
            st.executeUpdate(QuerySave);
            msg.simpan();
        }catch(SQLException e){
            msg.notsimpan(e);
        }
    }
    
    public void SimpanData(String QuerySave, JTable tsub){
        try{
            this.koneksi();
            int rows=tsub.getRowCount();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(QuerySave);
            for(int row = 0; row<rows; row++){
                tbkd  = (String)tsub.getValueAt(row, 0);
                mstok  = Integer.parseInt((String)tsub.getValueAt(row, 4));
                mbel  = ((String)tsub.getValueAt(row, 5));
                mtotal  = Double.parseDouble((String)tsub.getValueAt(row, 6));
                pstmt.setString(1, getNopersed());
                pstmt.setInt(2, mstok);
                pstmt.setString(3, mbel);
                pstmt.setDouble(4, mtotal);
                pstmt.setString(5, getId());
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
        list.add(getKondisiBrg());
        list.add(getStokBrg());
        list.add(getHargabeli());
        list.add(getTotal());
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
    
    public void pilihrow(JTable tablesup){
        DefaultTableModel datatable = (DefaultTableModel) tablesup.getModel();
        int row =tablesup.getSelectedRow();
        if(row>=0){
            datatable.removeRow(row);
        }
    }
    
    public void hitung(JTable tablesup, JLabel stoktotal,JLabel subtotal){
        int stk = 0;
        double ttl = 0;
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        for(int a=0;a<tablesup.getRowCount();a++){
            int sub = Integer.parseInt((String)tablesup.getValueAt(a, 4));
            double pu = Double.parseDouble((String)tablesup.getValueAt(a, 6));
            stk+=sub;
            ttl+=pu;
        }       
        String x = kursIndonesia.format(ttl);
        stoktotal.setText(Integer.toString(stk));
        subtotal.setText(x);
    }
    
    public void tambahke(JTable tbl_sup, JLabel subtotal, JLabel stoktotal){
        v_pilihbarang1 vb = new v_pilihbarang1(tbl_sup, subtotal, stoktotal);
        vb.setVisible(true);
    }
    
    public void barubarang(JTable tbl_bar){
        v_barangbaru dt = new v_barangbaru(tbl_bar);
        dt.setVisible(true);
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
    
    public void KeFormKasir(String id_u, String namaus, String pos){
        v_admkasir barang = new v_admkasir(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void KeFormSupplier(String id_u, String namaus, String pos){
        v_admsupplier barang = new v_admsupplier(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void KSupplier(String id_u, String namaus, String pos){
        v_supplier barang = new v_supplier(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void KeFormPersediaan(String id_u, String namaus, String pos){
        v_admdatapersediaan barang = new v_admdatapersediaan(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void KePersediaan(String id_u, String namaus, String pos){
        v_datapersediaan barang = new v_datapersediaan(id_u, namaus, pos);
        barang.setVisible(true);
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
    
    public void KeFormDataP(String id_u, String namaus, String pos){
        v_admdatapenjualan barang = new v_admdatapenjualan(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void Cetak(Date jdc1, Date jdc2){
        String tgl1 = new SimpleDateFormat("dd/MM/yyyy").format(jdc1);
        String tgl2 = new SimpleDateFormat("dd/MM/yyyy").format(jdc2);
        try{
            File file = new File("src/ireport/LaporanPersediaan.jrxml");
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
