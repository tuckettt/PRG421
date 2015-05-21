package com.troytuckett.classmaterial.bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BankMain extends JFrame {
    
    private JPanel dashboard;
    private JButton basicDeposit;
    private JButton checking;
    
    public BankMain() {
	super ("Troys Bank");
	
	setSize(350,150);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	buildPanel();
	add(dashboard);
	
	setVisible(true);	
    }    

private void buildPanel() {
	
    	basicDeposit = new JButton("Basic Deposit");
	basicDeposit.addActionListener(new CalcButtonListener());
	checking = new JButton("Checking");
	checking.addActionListener(new CalcButtonListener());
	
	dashboard = new JPanel();
	//topPanel.setBorder(BorderFactory.createTitledBorder("Enter Number to Convert"));
	dashboard.add(basicDeposit);
	dashboard.add(checking);

    }   

/**
 * Private inner class that handles the event when
 * the user clicks the calculate button.
 */
private class CalcButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	        
	    if (e.getSource()==basicDeposit) {
		 //
	    }
	    else if (e.getSource()==checking) {
		//
	    }	   
	}
}

public static void main(String args[]) {
	BankMain window = new BankMain();
}
    
}
