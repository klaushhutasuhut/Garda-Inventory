/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Klaus
 */
public class Tbl_user extends AbstractTableModel{
    private List<List_user> list = new ArrayList<>();     
    public void setList(List<List_user> list){
    this.list = list;     
    } 
    List<List_user> data;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Tbl_user(List<List_user> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
     public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getIdUser();
            case 1:
                return data.get(rowIndex).getNamaUser();
            case 2:
                return data.get(rowIndex).getPosisi();
            case 3:
                return data.get(rowIndex).getTanggalLahir();
            case 4:
                return data.get(rowIndex).getPendidikan();         
            default:
                return null;
        }
    }
     
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Anggota";
            case 1:
                return "Nama";
            case 2:
                return "Jabatan";
            case 3:
                return "Tanggal Lahir";
            case 4:
                return "Pendidikan Terakhir";  
            default:
                return null;
        }
    }
}
