/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author Klaus
 */
public class List_barang2 {
    private String kd_brg, nm_brg, kds_brg,satuan,hrg;
    private int stok;
    
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
    
    public String getHargajual(){
        return hrg;
    }

    public void setHargajual(String hrg){
        this.hrg = hrg;
    }
    
    public int getStok(){
        return stok;
    }

    public void setStok(int stok){
        this.stok = stok;
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
}


