/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;

/**
 *
 * @author Klaus
 */
public class List_penjualan {
    private String no_faktur, kd_brg, nm_brg, satuan, hargajual, subtotal;
    private int jumlah, stok;
    private Date tanggal;
    
    public Date getTanggal(){
        return tanggal;
    }

    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    
    public String getNoFaktur(){
        return no_faktur;
    }

    public void setNoFaktur(String no_faktur){
        this.no_faktur = no_faktur;
    }
    
    public String getKode(){
        return kd_brg;
    }

    public void setKode(String kd_brg){
        this.kd_brg = kd_brg;
    }
    
    public String getNamaBrg(){
        return nm_brg;
    }

    public void setNamaBrg(String nm_brg){
        this.nm_brg = nm_brg;
    }
    
    public String getHargajual(){
        return hargajual;
    }

    public void setHargajual(String hargajual){
        this.hargajual = hargajual;
    }
    
    public int getJumlah(){
        return jumlah;
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }
    
    public int getStok(){
        return stok;
    }

    public void setStok(int stok){
        this.stok = stok;
    }
    
    public String getSatuanBrg(){
        return satuan;
    }

    public void setSatuanBrg(String satuan){
        this.satuan = satuan;
    }
    
    public String getSubtotal(){
        return subtotal;
    }

    public void setSubtotal(String subtotal){
        this.subtotal = subtotal;
    }
}


