package com.troytuckett.classmaterial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SW9CheckBox extends JFrame {
    
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;
    private JLabel messageLabel;
    private JTextField convertTextField;
      
    private JCheckBox checkMiles;
    private JCheckBox checkFarenheit;
    private JCheckBox checkCelsius;   
    
    private JLabel resultLabel;
    private JLabel startLabel;
    private JLabel endLabel;
    private JTextField resultTextField;

    public SW9CheckBox() {
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
	
	checkMiles = new JCheckBox("Calc Miles");
	checkMiles.addActionListener(new CalcButtonListener());
	checkFarenheit = new JCheckBox("Calc Farenheit");
	checkFarenheit.addActionListener(new CalcButtonListener());
	checkCelsius = new JCheckBox("Calc Celsius");
	checkCelsius.addActionListener(new CalcButtonListener());
	
	resultLabel = new JLabel(" = ");
	startLabel = new JLabel("");
	endLabel = new JLabel("");
	resultTextField = new JTextField(10);
	resultTextField.setEditable(false);
	
	topPanel = new JPanel();
	topPanel.add(messageLabel);
	topPanel.add(convertTextField);
	
	centerPanel = new JPanel();
	centerPanel.add(checkMiles);
	centerPanel.add(checkFarenheit);
	centerPanel.add(checkCelsius);
	
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
    private class CalcButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    String str;   // To hold text entered
	    double result=0; // To hold miles
	    String start="none";
	    String end ="none";
	    
	    // Get the number of kilometers entered in the
	    // text field. The input is a string.
	    str = convertTextField.getText();
	    
	    if (e.getSource()==checkMiles) {
		 result = Conversions.convertKilometersToMiles(Double.parseDouble(str));
		 start = "kilometers"; end = "miles";
	    }
	    else if (e.getSource()==checkFarenheit) {
		result = Conversions.convertCelsiusToFarenheit(Double.parseDouble(str));
		start = "Celsius"; end = "Farenheit";
	    }
	    else if (e.getSource()==checkCelsius) {
		result = Conversions.convertFarenheitToCelsius(Double.parseDouble(str));
		start = "Farenheit"; end = "Celsius";
	    }	   

	    startLabel.setText(start); endLabel.setText(end);
	    resultTextField.setText(Double.toString(result));	    
	}
    }
    
    public static void main(String args[]) {
	SW9CheckBox window = new SW9CheckBox();
    }

}
