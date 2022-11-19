package com.SI.Controller;

import com.SI.View.HeaderDia;
import com.SI.View.HeaderItemsDia;
import com.SI.View.LayoutFrameForSIG;
import com.SI.model.Invoice;
import com.SI.model.InvoiceLines;
import com.SI.model.headersInvoicesTableModel;
import com.SI.model.itemInvoicesTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class ControllerForSIG implements ActionListener {

    
    
    private LayoutFrameForSIG frame;
    private HeaderDia headerDialog;
    private HeaderItemsDia itemDialog;
    public ControllerForSIG(LayoutFrameForSIG frame) {
        this.frame=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

 
//        if (command == "Load File") {
//        } else if (command == "Save File") {
//        } else if (command == "Create new invoice") {
//        } else if (command == "Delete invoice") {
//        } else if (command == "Save item") {
//        } else if (command == "Delete Purchase") {
//        }
//        else{}
        switch (command) {

            case "Save File":
                saveFile();
                break;
            case "Load File":
                loadFile();
                break;
            case "Create new invoice":
                createInvoice();
                break;
            case "Delete invoice":
                delInvoice();
                break;
            case "Add New Purchase":
                addPurchase();
                break;
            case "Delete Purchase":
                delPurchase();
                break;
            case "createPurchaseLineOK":
                createPurchaseLineOK();
                break;
            case "createPurchaseCancel":
                createPurchaseCancel();
                break;    
            case "createHeaderCancel":
                createHeaderCancel();
                break;
            case "createHeaderOK":
                createHeaderOK();
                break;
        }

    }
    
  
    
    
    private void saveFile() {
        ArrayList<Invoice> invoicesTemp =frame.getInvoices();
        String headersCSV="";
        String itemsCSV="";
        for(Invoice i:invoicesTemp)
        {
        String invoiceSCV= i.returnFileAsCSV();
        headersCSV +=invoiceSCV;
        headersCSV +="\n";
        for(InvoiceLines j:i.getPurcheses())
        {
        String lineAsCSV=j.returnFileAsCSV();
        itemsCSV+=lineAsCSV;
        itemsCSV+="\n";
        }
        }
         try {
       JFileChooser fileChooser=new JFileChooser();
        
        int selectedFolder=fileChooser.showOpenDialog(frame);
        if(selectedFolder==JFileChooser.APPROVE_OPTION){
          File header=fileChooser.getSelectedFile();
           
                FileWriter headerFileWriter=new FileWriter(header);
                headerFileWriter.write(headersCSV);
                headerFileWriter.flush();
                headerFileWriter.close();
            } 
             selectedFolder=fileChooser.showOpenDialog(frame);
             if(selectedFolder==JFileChooser.APPROVE_OPTION){
              File line=fileChooser.getSelectedFile();
              
                FileWriter lineFileWriter=new FileWriter(line);
                lineFileWriter.write(itemsCSV);
                lineFileWriter.flush();
                lineFileWriter.close();
             
             }
        }
        catch (IOException ex) {
                 }
        
    }
    private void loadFile() {
        JFileChooser fileChooser=new JFileChooser();
         try {
        int selectedFile=fileChooser.showOpenDialog(frame);
        if(selectedFile==JFileChooser.APPROVE_OPTION){
            File headerSample=fileChooser.getSelectedFile();
            Path headerPath=Paths.get(headerSample.getAbsolutePath());
               
            java.util.List <String> headers = Files.readAllLines(headerPath); 
//            System.out.println(headers);
            ArrayList<Invoice> invoiceList = new ArrayList<>();
            for (String header:headers)
            {
                String[] headerElement=header.split(",");
                int invoiceNum=Integer.parseInt(headerElement[0]);

                String dateOfRelease=headerElement[1];
                String nameOFCustomer=headerElement[2];
                Invoice recepit=new Invoice(invoiceNum,dateOfRelease,nameOFCustomer);
                invoiceList.add(recepit);
            }
//            System.out.println("Cheese Point");
        
        int selectedLines =fileChooser.showOpenDialog(frame);
        if(selectedLines==JFileChooser.APPROVE_OPTION){
            File linesSample=fileChooser.getSelectedFile();
            Path linesPath=Paths.get(linesSample.getAbsolutePath());
            java.util.List <String> lines=Files.readAllLines(linesPath);
            for(String line:lines){
            String[] lineElement=line.split(",");
            int invoiceNumber=Integer.parseInt( lineElement[0]);
            String itemName=lineElement[1];   
            double itemPrice=Double.parseDouble(lineElement[2]);
            int numberOfItems=Integer.parseInt( lineElement[3]);
           
            Invoice tempInvoice=null;
            for(Invoice invoice:invoiceList)
            {
            if(invoice.getNumberOfInvoice()==invoiceNumber){
            tempInvoice=invoice;
            break;
            }
            
            }
            InvoiceLines fullDetailedRecepit = new InvoiceLines(itemName,numberOfItems,itemPrice,tempInvoice);
            tempInvoice.getPurcheses().add(fullDetailedRecepit); //
            }
        
        }

     headersInvoicesTableModel tableModel=new headersInvoicesTableModel(invoiceList);
        frame.setInvoices(invoiceList);
        frame.setTableModel(tableModel);
        frame.getHeadersTable().setModel(tableModel);
        frame.getHeaderTableModel().fireTableDataChanged();
        }
         }

         catch (IOException ex) {
                ex.printStackTrace();
            }
        
    }

    private void createInvoice() {
            headerDialog=new HeaderDia(frame);
            headerDialog.setVisible(true);
        }
    
    



    private void addPurchase() {
        itemDialog = new HeaderItemsDia(frame);
        itemDialog.setVisible(true);
    }
    
    private void delInvoice() {
           int highlightedRow= frame.getHeadersTable().getSelectedRow();
        if(highlightedRow != -1)
        {
        frame.getInvoices().remove(highlightedRow);
        frame.getHeaderTableModel().fireTableDataChanged();
        }
        
    }

    private void delPurchase() {
         int  highlightedInvoice=  frame.getHeadersTable().getSelectedRow();
         int highlightedRow= frame.getPurchesesTable().getSelectedRow();
        if(highlightedRow != -1 && highlightedInvoice != -1)
        { 
           Invoice invTemp=frame.getInvoices().get(highlightedInvoice);
           invTemp.getPurcheses().remove(highlightedRow);
           itemInvoicesTableModel itemsTempModel=new itemInvoicesTableModel(invTemp.getPurcheses());
           frame.getPurchesesTable().setModel(itemsTempModel);
           itemsTempModel.fireTableDataChanged();
            frame.getHeaderTableModel().fireTableDataChanged();
        }
    }

    private void createPurchaseLineOK() {
         String itemName=itemDialog.getItemNameField().getText();
        String stringCount=itemDialog.getItemCountField().getText();
        String stringPrice=itemDialog.getItemPriceField().getText(); 
         int numOfItems=Integer.parseInt(stringCount);
          double price=Double.parseDouble(stringPrice);
            int highlightedInvoice=frame.getHeadersTable().getSelectedRow();
                if(highlightedInvoice !=-1){
                    Invoice invoice =frame.getInvoices().get(highlightedInvoice);
                    InvoiceLines lineTemp= new InvoiceLines(itemName,numOfItems,price,invoice);
                    invoice.getPurcheses().add(lineTemp);
                    itemInvoicesTableModel itemTableTemp =(itemInvoicesTableModel) frame.getPurchesesTable().getModel();
                    itemTableTemp.fireTableDataChanged();
                    frame.getHeaderTableModel().fireTableDataChanged();
                }
        
        
        itemDialog.setVisible(false);
        itemDialog.dispose();
        itemDialog=null;
           }

    private void createPurchaseCancel() {
         itemDialog.setVisible(false);
        itemDialog.dispose();
        itemDialog=null;
       
          }

    private void createHeaderCancel() {
    headerDialog.setVisible(false);
    headerDialog.dispose();
    headerDialog=null;
    }
    private void createHeaderOK() {
        String date=headerDialog.getDateOfRelease().getText();
        String customerName=headerDialog.getcustomerNameField().getText();
        int noOfInvoice=frame.getNextHeaderNumber();
        Invoice invoice=new Invoice(noOfInvoice,date,customerName);
        frame.getInvoices().add(invoice);
        frame.getHeaderTableModel().fireTableDataChanged();
        headerDialog.setVisible(false);
        headerDialog.dispose();
        headerDialog=null;            
    }

}
