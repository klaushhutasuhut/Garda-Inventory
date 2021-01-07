/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import config.database;
import helper.List_barang;
import helper.List_barang2;
import helper.Tbl_barang;
import helper.Message;
import helper.Tbl_barang2;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import views.v_admdatapenjualan;
import views.v_admdatapersediaan;
import views.v_admin;
import views.v_admkasir;
import views.v_admsupplier;
import views.v_barangedit;
import views.v_gantipass;
import views.v_login;
/**
 *
 * @author Klaus
 */
public class Barang extends database{
    public Message msg = new Message();
    String kd_brg, nm_brg, kds_brg, satuan, hrg, hargajual;
    int stok_brg;
    java.util.Date tgls = new java.util.Date();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault());   
    public String tanggalnow = sdf.format(tgls);
    
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
    
    public int getStokBrg(){
        return stok_brg;
    }

    public void setStokBrg(int stok_brg){
        this.stok_brg = stok_brg;
    }
    
    public String getHarga(){
        return hrg;
    }

    public void setHarga(String hrg){
        this.hrg = hrg;
    }
    
    public String getHargajual(){
        return hargajual;
    }

    public void setHargajual(String hargajual){
        this.hargajual = hargajual;
    }
    
    public String getKondisiBrg(){
        return kds_brg;
    }

    public void setKondisiBrg(String kds_brg){
        this.kds_brg = kds_brg;
    }
    
    public String getSatuanBrg(){
        return satuan;
    }

    public void setSatuanBrg(String satuan){
        this.satuan = satuan;
    }
    
    public void SimpanData(String QuerySave){
        try{
            koneksi();
            st.executeUpdate(QuerySave);
            msg.simpan();
        }catch(SQLException e){
            msg.notsimpan(e);
        }
    }
    
    public void UpdateData(String QueryEdit){
        try{
            koneksi();
            st.executeUpdate(QueryEdit);
        }catch (SQLException e) {
            msg.notteredit(e);
        }
    }
    
    public void DeleteData(String QueryHapus){
        try{
            koneksi();
            st.executeUpdate(QueryHapus);
            msg.terhapus();
        }catch (SQLException e) {
            msg.notterhapus(e);
        }
    }
    
    public void cariBrg(String QueryLoad ,JTable tbl){
        List<List_barang> data = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                List_barang mm = new List_barang();
                mm.setKodeBrg(rs.getString("kd_barang"));
                mm.setNamaBrg(rs.getString("nama"));
                mm.setKondisiBrg(rs.getString("kondisi"));
                mm.setSatuanBrg(rs.getString("satuan"));
                mm.setStok(rs.getInt("stok"));
                mm.setHargaBeli(rs.getString("hargabeli"));
                mm.setHargaJual(rs.getString("hargajual"));
                data.add(mm);
            }
            Tbl_barang tblcari = new Tbl_barang(data);
            tbl.setModel(tblcari);
        } catch (SQLException ex) {
            msg.notload(ex);
        }
    }
    
    public void cariBrg2(String QueryLoad ,JTable tbl){
        List<List_barang2> data = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                List_barang2 mm = new List_barang2();
                mm.setKodeBrg(rs.getString("kd_barang"));
                mm.setNamaBrg(rs.getString("nama"));
                mm.setKondisiBrg(rs.getString("kondisi"));
                mm.setSatuanBrg(rs.getString("satuan"));
                mm.setStok(rs.getInt("stok"));
                mm.setHargajual(rs.getString("hargajual"));
                data.add(mm);
            }
            Tbl_barang2 tblcari = new Tbl_barang2(data);
            tbl.setModel(tblcari);
        } catch (SQLException ex) {
            msg.notload(ex);
        }
    }
    
    public void Showinput(JDialog input){
        input.setVisible(true);
    }
    
    public void Showedit(JDialog Edit){
        Edit.setVisible(true);
    }
    
    public void KeFormPersediaan(String id_u, String namaus, String pos){
        v_admdatapersediaan barang = new v_admdatapersediaan(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void EditBarang(String kd_barang, String nama, String kondisi, String satuan, int stok, String hargab, String hargaj, JTable tbl_brg){
        v_barangedit edituser = new v_barangedit(kd_barang, nama, kondisi, satuan, stok, hargab, hargaj, tbl_brg);
        edituser.setVisible(true);
    }
    
    public void KeFormUser(String id_u, String namaus, String pos){
        v_admin barang = new v_admin(id_u, namaus, pos);
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
    
    public void laporan(){
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

