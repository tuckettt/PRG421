package com.troytuckett.classmaterial;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class SW11SimpleList extends JFrame {
    
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;
    private JLabel messageLabel;
    private JTextField convertTextField;
    
    private String[] selection = {"Miles","Farenheit","Celsius"};
    private JList selectionList;    
      
    private JCheckBox checkMiles;
    private JCheckBox checkFarenheit;
    private JCheckBox checkCelsius;   
    
    private JLabel resultLabel;
    private JLabel startLabel;
    private JLabel endLabel;
    private JTextField resultTextField;

    public SW11SimpleList() {
	super ("Perform Conversions");
	setSize(350,150);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	buildPanel();
	add(mainPanel);
	
	setVisible(true);	
    }    
    
    private void buildPanel() {
	
	messageLabel = new JLabel("Enter a number to be converted");
	convertTextField = new JTextField(10);
	
	selectionList = new JList(selection);
	selectionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	selectionList.addListSelectionListener(new ListListener());

	resultLabel = new JLabel(" = ");
	startLabel = new JLabel("");
	endLabel = new JLabel("");
	resultTextField = new JTextField(10);
	resultTextField.setEditable(false);
	
	topPanel = new JPanel();
	topPanel.add(messageLabel);
	topPanel.add(convertTextField);
	
	centerPanel = new JPanel();
	centerPanel.add(selectionList);
	
	bottomPanel = new JPanel();
	bottomPanel.add(startLabel);
	bottomPanel.add(resultLabel);
	bottomPanel.add(resultTextField);
	bottomPanel.add(endLabel);
	
	mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	
	mainPanel.add(topPanel, BorderLayout.NORTH);
	mainPanel.add(centerPanel, BorderLayout.CENTER);
	mainPanel.add(bottomPanel, BorderLayout.SOUTH);

    }   
    
    /**
     * Private inner class that handles the event when
     * the user clicks the calculate button.
     */
    private class ListListener implements ListSelectionListener {

	public void valueChanged(ListSelectionEvent e) {
	    String str;   // To hold text entered
	    double result=0; // To hold miles
	    String start="none";
	    String end ="none";
	    
	    // Get the number of kilometers entered in the
	    // text field. The input is a string.
	    str = convertTextField.getText();
	    
	    if (selectionList.getSelectedIndex()==0) {
		 result = Conversions.convertKilometersToMiles(Double.parseDouble(str));
		 start = "kilometers"; end = "miles";
	    }
	    else if (selectionList.getSelectedIndex()==1) {
		result = Conversions.convertCelsiusToFarenheit(Double.parseDouble(str));
		start = "Celsius"; end = "Farenheit";
	    }
	    else if (selectionList.getSelectedIndex()==2) {
		result = Conversions.convertFarenheitToCelsius(Double.parseDouble(str));
		start = "Farenheit"; end = "Celsius";
	    }	   

	    startLabel.setText(start); endLabel.setText(end);
	    resultTextField.setText(Double.toString(result));	    
	}
    }
    
    public static void main(String args[]) {
	SW11SimpleList window = new SW11SimpleList();
    }

}
