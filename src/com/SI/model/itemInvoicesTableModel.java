
package com.SI.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class itemInvoicesTableModel extends AbstractTableModel {

    public itemInvoicesTableModel(ArrayList<InvoiceLines> purcheses) {
        this.purcheses = purcheses;
    }

    private ArrayList<InvoiceLines> purcheses;
       private String[] columnsOfItemsTable={"No.","Item Name","Item Price","count","items Total"};    @Override
    public int getRowCount() {
    return       purcheses.size();
    }

    @Override
    public int getColumnCount() {
        return columnsOfItemsTable.length; }

    @Override
    public String getColumnName(int column) {
        return columnsOfItemsTable[column];
                }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLines purchese=purcheses.get(rowIndex);
        switch(columnIndex){
            case 0 : return purchese.getInvoice().getNumberOfInvoice();
            case 1 : return purchese.getNameOfItem();
            case 2 : return purchese.getPrice();        
            case 3 : return purchese.getNumberOfItems();
            case 4 : return purchese.getTotalItems();
            default :   return " ";
          }
        
    }
}
