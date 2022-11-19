
package com.SI.Controller ;

import com.SI.View.LayoutFrameForSIG;
import com.SI.model.Invoice;
import com.SI.model.itemInvoicesTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class SelectionListener implements ListSelectionListener {

    
    
    LayoutFrameForSIG frame;
    
    public SelectionListener(LayoutFrameForSIG frame) {
        this.frame=frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) { 
        int selectedIndex= frame.getHeadersTable().getSelectedRow();
        if(selectedIndex != -1){
        System.out.println("you selected row: "+ frame.getHeadersTable().getSelectedRow());
        Invoice breifInvoice=frame.getInvoices().get(selectedIndex);
        frame.getInvoiceNoLbl().setText(""+breifInvoice.getNumberOfInvoice());
        frame.getDateLbl().setText(breifInvoice.getDate());
        frame.getNameLBL().setText(breifInvoice.getCustomer()); 
        frame.getTotalLBL().setText(""+breifInvoice.getTotal());
        itemInvoicesTableModel itemsTable=new itemInvoicesTableModel(breifInvoice.getPurcheses());
        frame.getPurchesesTable().setModel(itemsTable);
        itemsTable.fireTableDataChanged();
         
       }
    
    }
    
}
