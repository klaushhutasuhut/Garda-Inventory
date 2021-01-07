/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
import controllers.Kasir;
import controllers.Suppliers;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author Klaus
 */
public class Message {
    
    public void keluar(){
        int pesan=JOptionPane.showConfirmDialog(null, "Yakin Mau Keluar?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pesan==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    public void Hapustable(JTable sub){
        int pesan=JOptionPane.showConfirmDialog(null, "Hapus Pembelian Barang?", "Batal", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pesan==JOptionPane.YES_OPTION){
            Suppliers ctrl = new Suppliers();
            ctrl.hapusrow(sub);
        }
    }
    
    public void cetstruk(String nofaktur){
        int pesan=JOptionPane.showConfirmDialog(null, "Print Struk", "Print", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pesan==JOptionPane.YES_OPTION){
            Kasir x = new Kasir();
            x.Struk(nofaktur);
        }
    }
    
    public void notloadcombo(SQLException ex){
        JOptionPane.showMessageDialog(null,"Load Combo Gagal:" + ex,"Message",JOptionPane.WARNING_MESSAGE);
    }
    
    public void validasi(){
        JOptionPane.showMessageDialog(null,"Isi Email dan Password","Message",JOptionPane.INFORMATION_MESSAGE);      
    }
    
    public void valus(){
        JOptionPane.showMessageDialog(null,"Isi Email","Message",JOptionPane.INFORMATION_MESSAGE);      
    }
    
    public void valpass(){
        JOptionPane.showMessageDialog(null,"Isi Password","Message",JOptionPane.INFORMATION_MESSAGE);      
    }
    
    public void validasidata(){
        JOptionPane.showMessageDialog(null,"Isi Data","Message",JOptionPane.INFORMATION_MESSAGE);      
    }
    
    public void logininvalid(){
        JOptionPane.showMessageDialog(null,"Email dan Password Salah","Message",JOptionPane.INFORMATION_MESSAGE);      
    }
    
    public void logfail(SQLException ex){
        JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" + ex,"ERROR!",JOptionPane.WARNING_MESSAGE);
    }
    
    public void simpan(){
        JOptionPane.showMessageDialog(null,"Data berhasil disimpan","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    public void notsimpan(SQLException ex){
        JOptionPane.showMessageDialog(null,"Data gagal disimpan:" + ex,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    
    public void teredit(){
        JOptionPane.showMessageDialog(null,"Data berhasil diubah","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    public void notteredit(SQLException e){
        JOptionPane.showMessageDialog(null,"Data gagal dirubah:" + e,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    
    public void terhapus(){
        JOptionPane.showMessageDialog(null,"Data berhasil dihapus","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    public void notterhapus(SQLException e){
        JOptionPane.showMessageDialog(null,"Data gagal dihapus:" + e,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    
    public void notload(SQLException ex){
        JOptionPane.showMessageDialog(null,"Data gagal ditampilkan:" + ex,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
     
    public void Salah(){
        JOptionPane.showMessageDialog(null,"Password tidak ditemukan","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    public void Salaherror(SQLException ex){
        JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" + ex,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    
    public void passok(){
        JOptionPane.showMessageDialog(null,"Password berhasil di ganti","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    public void passerror(SQLException ex){
        JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" + ex,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    
    public void passmatch(){
        JOptionPane.showMessageDialog(null,"Password tidak sama","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void not(String e){
        JOptionPane.showMessageDialog(null,"Error id" + e,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    
    public void seleksi(){
        JOptionPane.showMessageDialog(null,"Stok Habis","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void seleksitotal(){
        JOptionPane.showMessageDialog(null,"Pembayaran kurang","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void hargams(){
        JOptionPane.showMessageDialog(null,"Barang belum siap dijual","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void lebih(){
        JOptionPane.showMessageDialog(null,"Jumlah beli lebih dari stok","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void Passwordkosong(){
        JOptionPane.showMessageDialog(null,"Isi password","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void JUMBEL(){
        JOptionPane.showMessageDialog(null,"Isi Jumlah beli","Message",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void Tanggal(){
        JOptionPane.showMessageDialog(null,"Isi tanggal","Message",JOptionPane.INFORMATION_MESSAGE);
    }
}
