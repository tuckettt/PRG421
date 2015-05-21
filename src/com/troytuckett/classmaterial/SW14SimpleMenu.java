package com.troytuckett.classmaterial;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class SW14SimpleMenu extends JFrame {
    
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;
    private JLabel messageLabel;
    private JTextField convertTextField;
    
    private String[] selection = {"Miles","Farenheit","Celsius"};
    private JComboBox selectionDropDown;    
    
    private JLabel resultLabel;
    private JLabel startLabel;
    private JLabel endLabel;
    private JTextField resultTextField;
    
    private JMenuBar menuBar;   // The menu bar
    private JMenu actionMenu;     // The File menu
    private JMenuItem calculateItem; // An item to exit the application
    private JMenuItem exitItem; // An item to exit the application

    public SW14SimpleMenu() {
	super ("Perform Conversions");
	setSize(350,150);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	buildPanel();
	add(mainPanel);
	
	buildMenu();
	
	setVisible(true);	
    }    
    
    private void buildPanel() {
	
	messageLabel = new JLabel("Enter a number to be converted");
	convertTextField = new JTextField(10);
	
	selectionDropDown = new JComboBox(selection);
	selectionDropDown.addActionListener(new DropDownListener());

	resultLabel = new JLabel(" = ");
	startLabel = new JLabel("");
	endLabel = new JLabel("");
	resultTextField = new JTextField(10);
	resultTextField.setEditable(false);
	
	topPanel = new JPanel();
	topPanel.add(messageLabel);
	topPanel.add(convertTextField);
	
	centerPanel = new JPanel();
	centerPanel.add(selectionDropDown);
	
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
    
    public void buildMenu() {
	menuBar = new JMenuBar();
	
	exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ExitListener());

        calculateItem = new JMenuItem("Calculate");
        calculateItem.addActionListener(new ExitListener());
        
	actionMenu = new JMenu("Action");
	actionMenu.add(exitItem);
	actionMenu.add(calculateItem);
	
	menuBar.add(actionMenu);
	setJMenuBar(menuBar);
    }
    
    private class ExitListener implements ActionListener {
    
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == exitItem)
		System.exit(0);
	}
    }
    
    /**
     * Private inner class that handles the event when
     * the user clicks the calculate button.
     */
    private class DropDownListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    String str;   // To hold text entered
	    double result=0; // To hold miles
	    String start="none";
	    String end ="none";
	    
	    // Get the number of kilometers entered in the
	    // text field. The input is a string.
	    str = convertTextField.getText();
	    
	    if (selectionDropDown.getSelectedIndex()==0) {
		 result = Conversions.convertKilometersToMiles(Double.parseDouble(str));
		 start = "kilometers"; end = "miles";
	    }
	    else if (selectionDropDown.getSelectedIndex()==1) {
		result = Conversions.convertCelsiusToFarenheit(Double.parseDouble(str));
		start = "Celsius"; end = "Farenheit";
	    }
	    else if (selectionDropDown.getSelectedIndex()==2) {
		result = Conversions.convertFarenheitToCelsius(Double.parseDouble(str));
		start = "Farenheit"; end = "Celsius";
	    }	   

	    startLabel.setText(start); endLabel.setText(end);
	    resultTextField.setText(Double.toString(result));	    
	}
    }
    
    public static void main(String args[]) {
	SW14SimpleMenu window = new SW14SimpleMenu();
    }

}