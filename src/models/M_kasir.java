/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import controllers.Kasir;
import helper.List_penjualan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
/**
 *
 * @author Klaus
 */
public class M_kasir extends Kasir{
    private String QuerySave,QueryEdit,QueryHapus;

    public void setQuerySave(String QuerySave){
        this.QuerySave = QuerySave;
    }

    public void setQueryHapus(String QueryHapus){
        this.QueryHapus = QueryHapus;
    }
    
     public void Simpan(JTable tkas){
        this.setQuerySave("INSERT INTO dt_penjualan(no_faktur,jumlah,hargajual,subtotal,id_user,kd_barang) values(?,?,?,?,?,?)");              
        this.SimpanData(QuerySave, tkas);
    }
     
    public void Simpandet(){
        Timestamp tanggalkeluar = new Timestamp(getTanggal().getTime());
        this.setQuerySave ("INSERT INTO penjualan(no_faktur,tanggal,grandtotal,bayar,kembali) values"
                + "('" + getNoFaktur()+ "',"
                + "'" + tanggalkeluar + "'" + ","
                + "'" + getGrandTotal()+ "'" + ","        
                + "'" + getPembayaran()+ "'" + ","      
                + "'" + getKembali()+ "')");
        this.SimpanDetail(QuerySave);
    }
     
    public void KeGantiPass(JLabel id){
        String QueryLoad = "Select * from user where id_user='" + id.getText() + "'";
        GantiPass(QueryLoad);
    }
    
    public List<List_penjualan> Load1(String where){
        String QueryLoad = "SELECT penjualan.tanggal, penjualan.no_faktur, barang.kd_barang, barang.stok, barang.hargajual, barang.satuan, barang.nama, dt_penjualan.jumlah, dt_penjualan.hargajual, dt_penjualan.subtotal\n" +
"FROM [user] INNER JOIN (penjualan INNER JOIN (barang INNER JOIN dt_penjualan ON barang.kd_barang = dt_penjualan.kd_barang) ON penjualan.no_faktur = dt_penjualan.no_faktur) ON user.id_user = dt_penjualan.id_user\n" +
"ORDER BY penjualan.no_faktur;" + where;
        List<List_penjualan> data = new ArrayList<>();
        try {
            koneksi();
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                List_penjualan mm = new List_penjualan();
                mm.setTanggal(rs.getDate("tanggal"));
                mm.setNoFaktur(rs.getString("no_faktur"));
                mm.setKode(rs.getString("kd_barang"));
                mm.setNamaBrg(rs.getString("nama"));
                mm.setSatuanBrg(rs.getString("satuan"));
                mm.setJumlah(rs.getInt("jumlah"));
                mm.setHargajual(rs.getString("hargajual"));
                mm.setSubtotal(rs.getString("subtotal"));
                mm.setHargajual(rs.getString("hargajual"));
                mm.setStok(rs.getInt("stok"));
                data.add(mm);
            }
        } catch (SQLException ex) {
            msg.notload(ex);
        }
        return data;
    }
}
