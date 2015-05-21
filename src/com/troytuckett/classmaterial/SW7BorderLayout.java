package com.troytuckett.classmaterial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SW7BorderLayout extends JFrame {
    
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel messageLabel;
    private JTextField convertTextField;
    private JButton calcMilesButton;
    private JButton calcFarenheitButton;
    private JButton calcCelsiusButton;
    private JLabel resultLabel;
    private JLabel startLabel;
    private JLabel endLabel;
    private JTextField resultTextField;

    public SW7BorderLayout() {
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
	calcMilesButton = new JButton("Calc Miles");
	calcMilesButton.addActionListener(new CalcButtonListener());
	calcFarenheitButton = new JButton("Calc Farenheit");
	calcFarenheitButton.addActionListener(new CalcButtonListener());
	calcCelsiusButton = new JButton("Calc Celsius");
	calcCelsiusButton.addActionListener(new CalcButtonListener());
	resultLabel = new JLabel(" = ");
	startLabel = new JLabel("");
	endLabel = new JLabel("");
	resultTextField = new JTextField(10);
	resultTextField.setEditable(false);
	
	topPanel = new JPanel();
	topPanel.add(messageLabel);
	topPanel.add(convertTextField);
	
	bottomPanel = new JPanel();
	bottomPanel.add(startLabel);
	bottomPanel.add(resultLabel);
	bottomPanel.add(resultTextField);
	bottomPanel.add(endLabel);
	
	mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	
	mainPanel.add(topPanel, BorderLayout.NORTH);
	mainPanel.add(calcMilesButton, BorderLayout.WEST);	
	mainPanel.add(calcFarenheitButton, BorderLayout.CENTER);
	mainPanel.add(calcCelsiusButton, BorderLayout.EAST);
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
	    
	    if (e.getSource()==calcMilesButton) {
		 result = Conversions.convertKilometersToMiles(Double.parseDouble(str));
		 start = "kilometers"; end = "miles";
	    }
	    else if (e.getSource()==calcFarenheitButton) {
		result = Conversions.convertCelsiusToFarenheit(Double.parseDouble(str));
		start = "Celsius"; end = "Farenheit";
	    }
	    else if (e.getSource()==calcCelsiusButton) {
		result = Conversions.convertFarenheitToCelsius(Double.parseDouble(str));
		start = "Farenheit"; end = "Celsius";
	    }	   

	    startLabel.setText(start); endLabel.setText(end);
	    resultTextField.setText(Double.toString(result));	    
	}
    }
    
    public static void main(String args[]) {
	SW7BorderLayout window = new SW7BorderLayout();
    }
}
