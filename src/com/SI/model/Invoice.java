/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SI.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author TECHNICAL
 */
public class Invoice {

    private int numberOfInvoice;
    private String customer;
    private String date;
    private ArrayList<InvoiceLines> purcheses;
    private double total;
    public Invoice(int numberOfInvoice,String date ,String customer ) {
        this.numberOfInvoice = numberOfInvoice;
        this.customer = customer;
        this.date = date;
    }
         public String returnFileAsCSV() {
                return numberOfInvoice + "," + date + "," + customer;
}
    
    
    public Invoice() {
    }

    public int getNumberOfInvoice() {
        return numberOfInvoice;
    }

    public void setNumberOfInvoice(int numberOfInvoice) {
        this.numberOfInvoice = numberOfInvoice;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<InvoiceLines> getPurcheses() {
        if(purcheses==null){
        purcheses=new ArrayList<>();
        }
        return purcheses;
    }

    public void setPurcheses(ArrayList<InvoiceLines> purcheses) {
        this.purcheses = purcheses;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" + "numberOfInvoice=" + numberOfInvoice + ", customer=" + customer + ", date=" + date + '}';
    }
    public double getTotal(){
      double sumTotal=0.0;
        for(InvoiceLines purchese: getPurcheses())
        {
        sumTotal+=purchese.getTotalItems();
        }
      return sumTotal;
    }
    
}
  


 