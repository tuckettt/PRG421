package com.troytuckett.classmaterial;

import javax.swing.*;
import java.awt.event.*;

public class SW5SeparateButtons extends JFrame {
    
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField convertTextField;
    private JButton calcMilesButton;
    private JButton calcFarenheitButton;
    private JButton calcCelsiusButton;

    public SW5SeparateButtons() {
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

	
	panel = new JPanel();
	
	panel.add(messageLabel);
	panel.add(convertTextField);
	panel.add(calcMilesButton);	
	panel.add(calcFarenheitButton);
	panel.add(calcCelsiusButton);
	
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
	    
	    // Display a message dialog showing the miles.
	    JOptionPane.showMessageDialog(null, str + " " +
		    start + " is " + result + " " + end + ".");
	}
    }
    
    public static void main(String args[]) {
	SW5SeparateButtons window = new SW5SeparateButtons();
    }

}
