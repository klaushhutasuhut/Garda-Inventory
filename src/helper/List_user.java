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
public class List_user {
    private String id_user, nama, tggl_lahir, pendidikan, posisi;
    
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
    
    public String getTanggalLahir(){
        return tggl_lahir;
    }

    public void setTanggalLahir(String tggl_lahir){
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
}
