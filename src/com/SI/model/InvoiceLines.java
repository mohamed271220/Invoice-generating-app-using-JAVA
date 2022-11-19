
package com.SI.model;


public class InvoiceLines {

    private Invoice invoice;
    private String nameOfItem;
    private int numberOfItems;
    private double price;
//      private double totalLine;

    public InvoiceLines( String nameOfItem, int numberOfItems, double price,Invoice invoice) {
        this.invoice = invoice;
        this.nameOfItem = nameOfItem;
        this.numberOfItems = numberOfItems;
        this.price = price;
    }

    public double getTotalItems() {
      return  price*numberOfItems;
      
    }

             public String returnFileAsCSV() {
                return invoice.getNumberOfInvoice() + "," + nameOfItem + "," + price +"," + numberOfItems;
}
    

    public Invoice getInvoice() {
       
        return invoice;
    }

    @Override
    public String toString() {
        return "InvoiceLines{" + "num=" + invoice.getNumberOfInvoice() + ", nameOfItem=" + nameOfItem + ", numberOfItems=" + numberOfItems + ", price=" + price + '}';
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
