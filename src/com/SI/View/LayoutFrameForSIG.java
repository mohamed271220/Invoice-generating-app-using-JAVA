

package com.SI.View;

import com.SI.Controller.ControllerForSIG;
import com.SI.Controller.SelectionListener;
import com.SI.model.Invoice;
import com.SI.model.headersInvoicesTableModel;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;


public class LayoutFrameForSIG extends javax.swing.JFrame {

   private headersInvoicesTableModel tableModel;
    public JTable getPurchesesTable() {
        return purchesesTable;
    }

    public JTable getHeadersTable() {
        return headersTable;
    }

    public ControllerForSIG getController() {
        return controller;
    }

    public JLabel getDateLbl() {
        return dateLbl;
    }

    public JLabel getInvoiceNoLbl() {
        return invoiceNoLbl;
    }

    public JLabel getNameLBL() {
        return nameLBL;
    }

    public JLabel getTotalLBL() {
        return totalLBL;
    }
    
    public LayoutFrameForSIG() {
        initComponents();
    }

    public headersInvoicesTableModel getHeaderTableModel() {
         
        return tableModel;
    }

    public void setTableModel(headersInvoicesTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setPurchesesTable(JTable purchesesTable) {
        this.purchesesTable = purchesesTable;
    }

    private ArrayList<Invoice> invoiceTemp;

    public ArrayList<Invoice> getInvoices() {
      
        
        return invoiceTemp;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoiceTemp = invoices;
    }
 SelectionListener listner=new SelectionListener(this);
ControllerForSIG controller =new ControllerForSIG(this);
public int getNextHeaderNumber(){

int count=0;
for(Invoice invoice: getInvoices())
{
    if(invoice.getNumberOfInvoice()>count)count=invoice.getNumberOfInvoice();
}
return ++count;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        headersTable = new javax.swing.JTable();
        headersTable.getSelectionModel().addListSelectionListener(listner);
        delInvoiceButton = new javax.swing.JButton();
        delInvoiceButton.addActionListener(controller);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameLBL = new javax.swing.JLabel();
        invoiceNoLbl = new javax.swing.JLabel();
        totalLBL = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        purchesesTable = new javax.swing.JTable();
        addNewItemButton = new javax.swing.JButton();
        addNewItemButton.addActionListener(controller);
        deletePurchButton = new javax.swing.JButton();
        deletePurchButton.addActionListener(controller);
        newInvoiceButton = new javax.swing.JButton();
        newInvoiceButton.addActionListener(controller);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadInvoice = new javax.swing.JMenuItem();
        loadInvoice.addActionListener(controller);
        saveInvoice = new javax.swing.JMenuItem();
        saveInvoice.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 204));

        headersTable.setAutoCreateRowSorter(true);
        headersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(headersTable);

        delInvoiceButton.setText("Delete invoice");
        delInvoiceButton.setToolTipText("");
        delInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delInvoiceButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Date of Release:");

        jLabel2.setText("Invoice code:");

        jLabel3.setText("Total :");

        jLabel4.setText("Name:");

        invoiceNoLbl.setToolTipText("");

        purchesesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(purchesesTable);

        addNewItemButton.setText("Add New Purchase");
        addNewItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewItemButtonActionPerformed(evt);
            }
        });

        deletePurchButton.setText("Delete Purchase");
        deletePurchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePurchButtonActionPerformed(evt);
            }
        });

        newInvoiceButton.setText("Create new invoice");
        newInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInvoiceButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        loadInvoice.setText("Load File");
        loadInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadInvoiceActionPerformed(evt);
            }
        });
        jMenu1.add(loadInvoice);

        saveInvoice.setText("Save File");
        jMenu1.add(saveInvoice);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invoiceNoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(newInvoiceButton)
                        .addGap(43, 43, 43)
                        .addComponent(delInvoiceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addNewItemButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deletePurchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invoiceNoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addNewItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deletePurchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletePurchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePurchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletePurchButtonActionPerformed

    private void addNewItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewItemButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNewItemButtonActionPerformed

    private void delInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delInvoiceButtonActionPerformed

    private void newInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newInvoiceButtonActionPerformed

    private void loadInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadInvoiceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LayoutFrameForSIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LayoutFrameForSIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LayoutFrameForSIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LayoutFrameForSIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LayoutFrameForSIG().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewItemButton;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JButton delInvoiceButton;
    private javax.swing.JButton deletePurchButton;
    private javax.swing.JTable headersTable;
    private javax.swing.JLabel invoiceNoLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadInvoice;
    private javax.swing.JLabel nameLBL;
    private javax.swing.JButton newInvoiceButton;
    private javax.swing.JTable purchesesTable;
    private javax.swing.JMenuItem saveInvoice;
    private javax.swing.JLabel totalLBL;
    // End of variables declaration//GEN-END:variables

}
