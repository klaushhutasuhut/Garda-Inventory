/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import config.database;
import helper.List_user;
import helper.Message;
import helper.Tbl_user;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import views.v_admdatapenjualan;
import views.v_admdatapersediaan;
import views.v_admkasir;
import views.v_admsupplier;
import views.v_barang;
import views.v_gantipass;
import views.v_login;
import views.v_userbaru;
import views.v_useredit;
/**
 *
 * @author Klaus
 */
public class User extends database{
    java.util.Date tgls = new java.util.Date();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault());   
    public String tanggalnow = sdf.format(tgls);
    public Message msg = new Message();
    private String id_user, nama, pendidikan, posisi, email, pass;
    private Integer kolom,RecordCount;
    private Date tggl_lahir;
    
    public String getIdUser(){
        return id_user;
    }

    public void setIdUser(String id_user){
        this.id_user = id_user;
    }
    
    public String getNamaUser(){
        return nama;
    }

    public void setNamaUser(String nama){
        this.nama = nama;
    }
    
    public Date getTanggalLahir(){
        return tggl_lahir;
    }

    public void setTanggalLahir(Date tggl_lahir){
        this.tggl_lahir = tggl_lahir;
    }
    
    public String getPendidikan(){
        return pendidikan;
    }

    public void setPendidikan(String pendidikan){
        this.pendidikan = pendidikan;
    }
    
    public String getPosisi(){
        return posisi;
    }

    public void setPosisi(String posisi){
        this.posisi = posisi;
    }
    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return pass;
    }

    public void setPassword(String pass){
        this.pass = pass;
    }
    
    public Integer getRecordCount(){
        return RecordCount;
    }

    public void setRecordCount(Integer RecordCount){
        this.RecordCount = RecordCount;
    }
      
    public void loaddatacb(String Queryload, String IdxField, JComboBox Cb){
        try{
            koneksi();
            rs = st.executeQuery(Queryload);
            int i = 0;
            
            while(rs.next()){
                Cb.addItem(rs.getString(IdxField));
                i++;
            }
            this.setRecordCount(i);
        }catch(SQLException ex){
            msg.notloadcombo(ex);
        }
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
            msg.teredit();
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
        List<List_user> data = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                List_user mm = new List_user();
                mm.setIdUser(rs.getString("id_user"));
                mm.setNamaUser(rs.getString("namaus"));
                mm.setPosisi(rs.getString("posisi"));
                mm.setTanggalLahir(rs.getString("tanggal_lahir"));
                mm.setPendidikan(rs.getString("pendidikan"));
                data.add(mm);
            }
            Tbl_user tblcari = new Tbl_user(data);
            tbl.setModel(tblcari);
        } catch (SQLException ex) {
            msg.notload(ex);
        }
    }
    
    public void InputUser(JTable tbl_user){
        v_userbaru baruuser = new v_userbaru(tbl_user);
        baruuser.setVisible(true);
    }
    
    public void KeFormPersediaan(String id_u, String namaus, String pos){
        v_admdatapersediaan barang = new v_admdatapersediaan(id_u, namaus, pos);
        barang.setVisible(true);
    }
    
    public void EditUser(JTable tbl_user, String id_useradm, String namaadm, String posisiadm, Date tggllahir, String pendidikanadm, String emailus, String passus){
        v_useredit edituser = new v_useredit(tbl_user, id_useradm, namaadm, posisiadm, tggllahir, pendidikanadm, emailus, passus);
        edituser.setVisible(true);
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
    
    public void KeFormDataP(String id_u, String namaus, String pos){
        v_admdatapenjualan barang = new v_admdatapenjualan(id_u, namaus, pos);
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
    
    public void Confirm(String QueryLoad, JTextField passlama, JTextField passbaru, JTextField samaulang){
        try{
            koneksi();            
            rs = st.executeQuery(QueryLoad);
            if(rs.next()){
                passlama.setEnabled(false);
                passbaru.setEnabled(true);
                samaulang.setEnabled(true);
            }else{
                msg.Salah();
            }           
        }catch(SQLException e){
            msg.Salaherror(e);
        }
    }
    
    public void okpass(String QueryLoad){
        try{
            st.executeUpdate(QueryLoad);
            msg.passok();
        }catch(SQLException e){
            msg.passerror(e);
        }
    }
}


