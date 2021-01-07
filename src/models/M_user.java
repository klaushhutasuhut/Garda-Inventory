/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import controllers.User;
import helper.List_user;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author Klaus
 */
public class M_user extends User{
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
    
    public List<List_user> LoadTable(String where){
        String QueryLoad = "SELECT * FROM user " + where;
        List<List_user> data = new ArrayList<>();
        try {
            koneksi();
            pstmt = conn.prepareStatement(QueryLoad);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                List_user mm = new List_user();
                mm.setIdUser(rs.getString("id_user"));
                mm.setNamaUser(rs.getString("namaus"));
                mm.setPosisi(rs.getString("posisi"));
                mm.setTanggalLahir(rs.getString("tanggal_lahir"));
                mm.setPendidikan(rs.getString("pendidikan"));
                data.add(mm);
            }
        } catch (SQLException ex) {
            msg.notload(ex);
        }
        return data;
    }
    
    public User pilihdataTable(String id_user) {
        User ld = new User();
        String QueryLoad = "select * from user where id_user=?";
        try {
            koneksi();
            pstmt = conn.prepareStatement(QueryLoad);
            pstmt.setString(1, id_user);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ld.setIdUser(rs.getString("id_user"));
                ld.setNamaUser(rs.getString("namaus"));
                ld.setPosisi(rs.getString("posisi"));
                ld.setTanggalLahir(rs.getDate("tanggal_lahir"));
                ld.setPendidikan(rs.getString("pendidikan"));
                ld.setEmail(rs.getString("email"));
                ld.setPassword(rs.getString("pass"));
            }

        } catch (SQLException ex) {
            msg.notload(ex);
        }
        return ld;
    }
    
    public void LoadCombo(JComboBox Cb){
        this.loaddatacb("Select * from user", "pendidikan", Cb);
    }
    
    public void Simpan(){
        Timestamp tanggal = new Timestamp(getTanggalLahir().getTime());
        this.setQuerySave ("INSERT INTO user(id_user,namaus,posisi,tanggal_lahir,pendidikan,email,pass) values"
                + "('" + getIdUser() + "',"
                + "'" + getNamaUser() + "'" + ","
                + "'" + getPosisi() + "'" + ","
                + "'" + tanggal + "'" + ","
                + "'" + getPendidikan()+ "'" + ","
                + "'" + getEmail()+ "'" + ","       
                + "'" + getPassword()+ "')");
        this.SimpanData(QuerySave);
    }
    
    public void Updatesup(){
        Timestamp tanggal = new Timestamp(getTanggalLahir().getTime());
        this.setQueryEdit("UPDATE user set "
                + "namaus = '" + getNamaUser() + "',"
                + "posisi = '" + getPosisi() + "',"
                + "tanggal_lahir = '" + tanggal + "',"
                + "pendidikan = '" + getPendidikan() + "',"
                + "email = '" + getEmail() + "',"      
                + "pass = '" + getPassword() + "'"
                + " WHERE id_user = '" + getIdUser() + "'");
        this.UpdateData(QueryEdit);
    }
     
    public void Delete(){
        this.setQueryHapus("DELETE FROM user "
                + " WHERE id_user = '" + getIdUser()+ "'");
         this.DeleteData(this.getQueryHapus());
    }
    
    public void Cari(JTextField t_cari ,JTable tbl_user){
        String QueryLoad = "select * from user where namaus like'" + t_cari.getText() + "%'";
        this.cariBrg(QueryLoad, tbl_user);
    }
    
    public void KeGantiPass(JLabel id){
        String QueryLoad = "Select * from user where id_user='" + id.getText() + "'";
        GantiPass(QueryLoad);
    }
    
    public void Confirmpass(JTextField passlama, JTextField passbaru, JTextField samaulang, JLabel id){
        String QueryLoad = "Select id_user, pass FROM user WHERE id_user='" + id.getText() + 
                "' AND pass='" + passlama.getText() + "'";
        this.Confirm(QueryLoad, passlama, passbaru, samaulang);
    }
    
    public void okuser(JTextField passok, JLabel id){
        String QueryLoad = "Update user set pass='" + passok.getText() +
                "' where id_user='" + id.getText() + "'";
        okpass(QueryLoad);
    }
    
     public String Userkode(String pos){
        String urutan = null;
        String gg="";
        switch (pos) {
            case "Admin":
                gg="ADM";
                break;
            case "Supplier":
                gg="SUP";
                break;
            default:
                gg="KAS";
                break;
        }
        try{
            koneksi();
            rs = st.executeQuery("select right(id_user,3)+1 "
                    + "from user as id_user order by id_user desc");
            if(rs.next()){
                urutan=rs.getString(1);
                while(urutan.length()<3)
                    urutan="0"+urutan;
                urutan=gg+urutan;
            }else{
                urutan=gg+"001";
            }
        }catch(SQLException EX){
            msg.notload(EX);
        }
        return urutan;
    }
}
