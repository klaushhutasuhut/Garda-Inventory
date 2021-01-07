/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import controllers.Barang;
import helper.List_barang;
import helper.List_barang2;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author Klaus
 */
public class M_barang extends Barang{
    private String QuerySave,QueryEdit,QueryHapus;

    public void setQuerySave(String QuerySave){
        this.QuerySave = QuerySave;
    }
     
    public void setQueryEdit(String QueryEdit){
        this.QueryEdit = QueryEdit;
    }

    public String getQueryHapus(){
        return QueryHapus;
    }

    public void setQueryHapus(String QueryHapus){
        this.QueryHapus = QueryHapus;
    }
    
    public List<List_barang> Load1(String where){
        String QueryLoad = "SELECT * FROM barang" + where;
        List<List_barang> data = new ArrayList<>();
        try {
            koneksi();
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while(rs.next()) {
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
        } catch (SQLException ex) {
            msg.notload(ex);
        }
        return data;
    }
    
    public List<List_barang2> Load2(String where){
        String QueryLoad = "SELECT * FROM barang" + where;
        List<List_barang2> data = new ArrayList<>();
        try {
            koneksi();
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                List_barang2 mm = new List_barang2();
                mm.setKodeBrg(rs.getString("kd_barang"));
                mm.setNamaBrg(rs.getString("nama"));
                mm.setKondisiBrg(rs.getString("kondisi"));
                mm.setSatuanBrg(rs.getString("satuan"));
                mm.setStok(rs.getInt("stok"));
                mm.setHargajual(rs.getString("hargajual"));
                data.add(mm);
            }
        } catch (SQLException ex) {
            msg.notload(ex);
        }
        return data;
    }
    
    public Barang pilihdata1(String kd_brg) {
        Barang ld = new Barang();
        String QueryLoad = "select * from barang where kd_barang=?";
        try {
            pstmt = conn.prepareStatement(QueryLoad);
            pstmt.setString(1, kd_brg);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ld.setKodeBrg(rs.getString("kd_barang"));
                ld.setNamaBrg(rs.getString("nama"));
                ld.setKondisiBrg(rs.getString("kondisi"));
                ld.setSatuanBrg(rs.getString("satuan"));
                ld.setStokBrg(rs.getInt("stok"));
                ld.setHarga(rs.getString("hargabeli"));
                ld.setHargajual(rs.getString("hargajual"));
            }

        } catch (SQLException ex) {
            msg.notload(ex);
        }
        return ld;
    }
    
    public void Simpan(){
        this.setQuerySave ("INSERT INTO barang(kd_barang,nama,kondisi,satuan,stok,hargabeli,hargajual) values"
                + "('" + getKodeBrg()+ "',"
                + "'" + getNamaBrg()+ "'" + ","
                + "'" + getKondisiBrg()+ "'" + ","
                + "'" + getSatuanBrg()+ "'" + ","
                + "'" + getStokBrg()+ "'" + ","
                + "'" + getHarga()+ "'" + "," 
                + "'" + getHargajual()+ "')");
        this.SimpanData(QuerySave);
    }
    
    public void Updatesup(){
        this.setQueryEdit("UPDATE barang set "
                + "nama = '" + getNamaBrg() + "',"
                + "kondisi = '" + getKondisiBrg()+ "',"
                + "satuan = '" + getSatuanBrg() + "',"
                + "stok = '" + getStokBrg() + "',"
                + "hargabeli = '" + getHarga() + "',"
                + "hargajual = '" + getHargajual() + "'"        
                + " WHERE kd_barang = '" + getKodeBrg()+ "'");
        this.UpdateData(QueryEdit);
    }
     
    public void Delete(){
        this.setQueryHapus("DELETE FROM barang "
                + " WHERE kd_barang = '" +getKodeBrg()+ "'");
         this.DeleteData(this.getQueryHapus());
    }
    
    public void Cari(JTextField t_cari ,JTable tbl_brg){
        String QueryLoad = "select * from barang where nama like'" + t_cari.getText() + "%'";
        this.cariBrg(QueryLoad, tbl_brg);
    }
    
    public void Cari2(JTextField t_cari ,JTable tbl_brg){
        String QueryLoad = "select * from barang where nama like'" + t_cari.getText() + "%'";
        this.cariBrg2(QueryLoad, tbl_brg);
    }
    
    public void KeGantiPass(JLabel id){
        String QueryLoad = "Select * from user where id_user='" + id.getText() + "'";
        GantiPass(QueryLoad);
    }
    
    public String Barangkode(){
        String urutan = null;
        try{
            koneksi();
            rs = st.executeQuery("select right(kd_barang,3)+1 "
                    + "from barang as kd_barang order by kd_barang desc");
            if(rs.next()){
                urutan=rs.getString(1);
                while(urutan.length()<3)
                    urutan="0"+urutan;
                urutan="BRG"+urutan;
            }else{
                urutan="BRG"+"001";
            }
        }catch(SQLException EX){
            msg.notload(EX);
        }
        return urutan;
    }
}
