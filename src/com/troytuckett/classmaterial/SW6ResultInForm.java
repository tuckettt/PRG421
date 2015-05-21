package com.troytuckett.classmaterial;

import javax.swing.*;
import java.awt.event.*;

public class SW6ResultInForm extends JFrame {
    
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField convertTextField;
    private JButton calcMilesButton;
    private JButton calcFarenheitButton;
    private JButton calcCelsiusButton;
    private JLabel resultLabel;
    private JLabel startLabel;
    private JLabel endLabel;
    private JTextField resultTextField;

    public SW6ResultInForm() {
	super ("Perform Conversions");
	setSize(350,150);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	buildPanel();
	add(panel);
	
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
	
	panel = new JPanel();
	
	panel.add(messageLabel);
	panel.add(convertTextField);
	panel.add(calcMilesButton);	
	panel.add(calcFarenheitButton);
	panel.add(calcCelsiusButton);
	panel.add(startLabel);
	panel.add(resultLabel);
	panel.add(resultTextField);
	panel.add(endLabel);
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
	SW6ResultInForm window = new SW6ResultInForm();
    }
}
