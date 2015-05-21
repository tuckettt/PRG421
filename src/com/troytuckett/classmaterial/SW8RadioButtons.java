package com.troytuckett.classmaterial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SW8RadioButtons extends JFrame {
    
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;
    private JLabel messageLabel;
    private JTextField convertTextField;
      
    private JRadioButton radioMiles;
    private JRadioButton radioKilometers;
    private JRadioButton radioFarenheit;
    private JRadioButton radioCelsius;   
    private ButtonGroup radioButtonGroup;
    
    private JLabel resultLabel;
    private JLabel startLabel;
    private JLabel endLabel;
    private JTextField resultTextField;

    public SW8RadioButtons() {
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
	
	radioMiles = new JRadioButton("Calc Miles");
	radioMiles.addActionListener(new CalcButtonListener());
	radioKilometers = new JRadioButton("Calc Kilometers");
	radioKilometers.addActionListener(new CalcButtonListener());
	radioFarenheit = new JRadioButton("Calc Farenheit");
	radioFarenheit.addActionListener(new CalcButtonListener());
	radioCelsius = new JRadioButton("Calc Celsius");
	radioCelsius.addActionListener(new CalcButtonListener());
	
	radioButtonGroup  = new ButtonGroup();
	radioButtonGroup.add(radioMiles);	
	radioButtonGroup.add(radioKilometers);
	radioButtonGroup.add(radioFarenheit);
	radioButtonGroup.add(radioCelsius);
	
	resultLabel = new JLabel(" = ");
	startLabel = new JLabel("");
	endLabel = new JLabel("");
	resultTextField = new JTextField(10);
	resultTextField.setEditable(false);
	
	topPanel = new JPanel();
	topPanel.add(messageLabel);
	topPanel.add(convertTextField);
	
	centerPanel = new JPanel();
	centerPanel.add(radioMiles);
	centerPanel.add(radioKilometers);
	centerPanel.add(radioFarenheit);
	centerPanel.add(radioCelsius);
	
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
	    
	    if (e.getSource()==radioMiles) {
		 result = Conversions.convertKilometersToMiles(Double.parseDouble(str));
		 start = "kilometers"; end = "miles";
	    }
	    else if (e.getSource()==radioKilometers) {
		result = Conversions.convertMilesToKilometers(Double.parseDouble(str));
		start = "miles"; end = "kilometers";
	    }
	    else if (e.getSource()==radioFarenheit) {
		result = Conversions.convertCelsiusToFarenheit(Double.parseDouble(str));
		start = "Celsius"; end = "Farenheit";
	    }
	    else if (e.getSource()==radioCelsius) {
		result = Conversions.convertFarenheitToCelsius(Double.parseDouble(str));
		start = "Farenheit"; end = "Celsius";
	    }	   

	    startLabel.setText(start); endLabel.setText(end);
	    resultTextField.setText(Double.toString(result));	    
	}
    }
    
    public static void main(String args[]) {
	SW8RadioButtons window = new SW8RadioButtons();
    }

}
