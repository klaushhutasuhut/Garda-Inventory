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
public class Tbl_barang2 extends AbstractTableModel{
    private List<List_barang2> list = new ArrayList<>();     
    public void setList(List<List_barang2> list){
    this.list = list;     
    } 
    List<List_barang2> data;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Tbl_barang2(List<List_barang2> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
     public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getKodeBrg();
            case 1:
                return data.get(rowIndex).getNamaBrg();
            case 2:
                return data.get(rowIndex).getKondisiBrg();
            case 3:
                return data.get(rowIndex).getSatuanBrg();
            case 4:
                return data.get(rowIndex).getStok();      
            case 5:
                return data.get(rowIndex).getHargajual();    
            default:
                return null;
        }
    }
     
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Barang";
            case 1:
                return "Nama Barang";
            case 2:
                return "Kondisi Barang";
            case 3:
                return "Satuan";
            case 4:
                return "Stok";
            case 5:
                return "Harga";    
            default:
                return null;
        }
    }
}
