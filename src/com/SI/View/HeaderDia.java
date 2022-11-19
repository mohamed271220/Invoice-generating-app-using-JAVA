/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SI.View;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class HeaderDia extends JDialog {
    private JTextField customerNameField;
    private JTextField invoiceReleaseDateField;
    private JLabel customerNameLbl;
    private JLabel dateOfRelease;
    private JButton okBtn;
    private JButton cancelBtn;

    public HeaderDia(LayoutFrameForSIG frame) {
        customerNameLbl = new JLabel("Customer Name:");
        customerNameField = new JTextField(20);
        dateOfRelease = new JLabel("Invoice Date:");
        invoiceReleaseDateField = new JTextField(20);
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        okBtn.setActionCommand("createHeaderOK");
        cancelBtn.setActionCommand("createHeaderCancel");
        
        okBtn.addActionListener(frame.getController());
        cancelBtn.addActionListener(frame.getController());
        setLayout(new GridLayout(3, 2));
        
        add(dateOfRelease);
        add(invoiceReleaseDateField);
        add(customerNameLbl);
        add(customerNameField);
        add(okBtn);
        add(cancelBtn);
        
        pack();
        
    }

    public JTextField getcustomerNameField() {
        return customerNameField;
    }

    public JTextField getDateOfRelease() {
        return invoiceReleaseDateField;
    }
    
}
