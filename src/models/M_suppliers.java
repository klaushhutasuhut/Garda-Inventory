/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import controllers.Suppliers;
import helper.List_persediaan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
/**
 *
 * @author Klaus
 */
public class M_suppliers extends Suppliers{
    private String QuerySave,QueryEdit,QueryHapus;

    public void setQuerySave(String QuerySave){
        this.QuerySave = QuerySave;
    }
    
     public void Simpan(JTable tsub){
        this.setQuerySave("INSERT INTO dt_persediaan(no_persediaan,jumlahbeli,hargabeli,subtotal,id_user,kd_barang) values(?,?,?,?,?,?)");              
        this.SimpanData(QuerySave, tsub);
    }
     
    public void Simpandet(){
        Timestamp tanggalmasuk = new Timestamp(getTanggal().getTime());
        this.setQuerySave ("INSERT INTO persediaan(no_persediaan,tgl,totalbeli,grandtotal) values"
                + "('" + getNopersed()+ "',"
                + "'" + tanggalmasuk+ "'" + ","
                + "'" + getStoktotal()+ "'" + ","      
                + "'" + getSubtotal()+ "')");
        this.SimpanDetail(QuerySave);
    }
     
    public void KeGantiPass(JLabel id){
        String QueryLoad = "Select * from user where id_user='" + id.getText() + "'";
        GantiPass(QueryLoad);
    }
    
    public List<List_persediaan> Load1(String where){
        String QueryLoad = "SELECT persediaan.tgl, dt_persediaan.no_persediaan, "
                + "dt_persediaan.kd_barang, barang.nama, barang.satuan, "
                + "barang.hargajual, dt_persediaan.hargabeli, dt_persediaan.jumlahbeli, "
                + "dt_persediaan.subtotal, barang.stok\n" 
                + "FROM persediaan INNER JOIN (barang INNER JOIN dt_persediaan ON barang.kd_barang = dt_persediaan.kd_barang) "
                + "ON persediaan.no_persediaan = dt_persediaan.no_persediaan;" + where;
        List<List_persediaan> data = new ArrayList<>();
        try {
            koneksi();
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                List_persediaan mm = new List_persediaan();
                mm.setTanggal(rs.getDate("tgl"));
                mm.setNoPersediaan(rs.getString("no_persediaan"));
                mm.setKode(rs.getString("kd_barang"));
                mm.setNamaBrg(rs.getString("nama"));
                mm.setSatuanBrg(rs.getString("satuan"));
                mm.setJumlah(rs.getInt("jumlahbeli"));
                mm.setHargabeli(rs.getString("hargabeli"));
                mm.setSubtotal(rs.getString("subtotal"));
                mm.setStok(rs.getInt("stok"));
                mm.setHargajual(rs.getString("hargajual"));
                data.add(mm);
            }
        } catch (SQLException ex) {
            msg.notload(ex);
        }
        return data;
    }
}
