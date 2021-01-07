/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import helper.Message;
import views.v_admin;
import views.v_kasir;
import views.v_supplier;
import views.v_login;
import java.sql.SQLException;
/**
 *
 * @author Klaus
 */
public class session extends database{
    public v_login login = null;
    Message mail = new Message();
    String email, pass;
    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPass(){
        return pass;
    }

    public void setPass(String pass){
        this.pass = pass;
    }
    
    public void simpleSession(){  
        String posisi = "";
        String nama = "";
        String ids = "";
        String session = "SELECT id_user, namaus, posisi FROM user WHERE email='"
                             + getEmail() + "' AND pass='" + getPass() + "'";
        try{
            koneksi();
            rs = st.executeQuery(session);
            while(rs.next()){
                posisi = rs.getString("posisi");
                nama = rs.getString("namaus"); 
                ids = rs.getString("id_user"); 
            }
                if(posisi.equals("Admin")){
                    v_admin adm = new v_admin(ids, nama, posisi);
                    adm.setVisible(true);
                    adm.setLocationRelativeTo(null);
                    login.dispose();                        
                }else if(posisi.equals("Kasir")){
                    v_kasir ksr = new v_kasir(ids, nama, posisi);
                    ksr.setVisible(true);
                    ksr.setLocationRelativeTo(null);
                    login.dispose();
                }else if (posisi.equals("Supplier")){
                    v_supplier sup = new v_supplier(ids, nama, posisi);
                    sup.setVisible(true);
                    sup.setLocationRelativeTo(null);
                    login.dispose();
                }else{
                    mail.logininvalid();
                }
            
        }catch(SQLException ex){
            mail.logfail(ex);
        }
    }
}

