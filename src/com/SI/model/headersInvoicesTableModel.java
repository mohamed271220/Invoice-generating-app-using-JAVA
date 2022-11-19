
package com.SI.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class headersInvoicesTableModel extends AbstractTableModel {
    public headersInvoicesTableModel(ArrayList<Invoice> invoiceTemp) {
        this.invoiceTemp = invoiceTemp;
    }
    
    
   private ArrayList<Invoice>  invoiceTemp;

   private String[] columns={"No.","Date","Customer","Total"};
    @Override
    public int getRowCount() {
      
    return invoiceTemp.size();
    
    }

    @Override
   public String getColumnName(int col){
   return columns[col];
   
   }
    @Override
    public Object getValueAt(int rowIndex,int columnIndex)
    {
    Invoice invoice=invoiceTemp.get(rowIndex);
            switch (columnIndex){
            
            
                case 0 : return invoice.getNumberOfInvoice();
            case 1 : return invoice.getDate();
            case 2 : return invoice.getCustomer();
            case 3 : return invoice.getTotal();
                    default:return" ";
            
            }
    }
    
    @Override
    
    public int getColumnCount() {
         return columns.length;
       }

  

    
}
