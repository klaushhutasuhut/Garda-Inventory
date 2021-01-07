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
public class Tbl_penjualan extends AbstractTableModel{
    private List<List_penjualan> list = new ArrayList<>();     
    public void setList(List<List_penjualan> list){
    this.list = list;     
    } 
    List<List_penjualan> data;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Tbl_penjualan(List<List_penjualan> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public int getColumnCount() {
        return 10;
    }
    
    @Override
     public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getTanggal();
            case 1:
                return data.get(rowIndex).getNoFaktur();
            case 2:
                return data.get(rowIndex).getKode();
            case 3:
                return data.get(rowIndex).getNamaBrg();
            case 4:
                return data.get(rowIndex).getSatuanBrg();    
            case 5:
                return data.get(rowIndex).getJumlah();      
            case 6:
                return data.get(rowIndex).getHargajual();
            case 7:
                return data.get(rowIndex).getSubtotal();    
            case 8:
                return data.get(rowIndex).getHargajual();
            case 9:
                return data.get(rowIndex).getStok();    
            default:
                return null;
        }
    }
     
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Tanggal";
            case 1:
                return "No Persediaan";
            case 2:
                return "Kode Barang";
            case 3:
                return "Nama Barang";
            case 4:
                return "Satuan";    
            case 5:
                return "Jumlah";
            case 6:
                return "Harga";
            case 7:
                return "Subtotal";     
            case 8:
                return "Harga Satuan"; 
            case 9:
                return "Stok";  
            default:
                return null;
        }
    }
}
