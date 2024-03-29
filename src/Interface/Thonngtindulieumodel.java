/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.*;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ByKyTa
 */
public class Thonngtindulieumodel extends  AbstractTableModel{
    
    private  String[] hearders = {"Tiêu Đề", "Người Gửi", "Thời Gian"};
    private List<ThongtinDuLieu> Data = new  LinkedList<>();

    public  Thonngtindulieumodel(String[] hearders,List<ThongtinDuLieu> Data)
    {
        this.hearders   =hearders;
        this.Data  = Data;
    }
    @Override
    public int getRowCount() {
        if(Data!=null)
        {
            return  Data.size();
        }
        return  0;
    }
    public String getColumnName(int columnIndex)
    {
        if(columnIndex<getColumnCount())
        {
            return hearders[columnIndex];
        }
        return "";
    }
    @Override
    public int getColumnCount() {
         if(hearders!=null)
        {
            return  hearders.length;
        }
        return  0;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex> getRowCount()||columnIndex>getColumnCount())
        {
            return "";
        }
        ThongtinDuLieu row = Data.get(rowIndex);
        switch(columnIndex)
                {
            case  0:
                return row.getTieuDe();
            case 1:
                return  row.getNguoigui();
            case 2:
                return  row.getDate();
            default:
                return "";
        }
    }
    
}
