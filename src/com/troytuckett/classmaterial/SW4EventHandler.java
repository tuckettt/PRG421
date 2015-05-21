package com.troytuckett.classmaterial;

import javax.swing.*;
import java.awt.event.*;

public class SW4EventHandler extends JFrame {
    
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField kiloTextField;
    private JButton calcButton;

    public SW4EventHandler() {
	super ("Almost as Simple Window");
	setSize(350,150);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	buildPanel();
	add(panel);
	
	setVisible(true);	
    }    
    
    private void buildPanel() {
	
	messageLabel = new JLabel("Enter a distance in kilometers");
	kiloTextField = new JTextField(10);
	calcButton = new JButton("Calculate");
	calcButton.addActionListener(new CalcButtonListener());
	
	panel = new JPanel();
	
	panel.add(messageLabel);
	panel.add(kiloTextField);
	panel.add(calcButton);	
	
    }
    
    /**
     * Private inner class that handles the event when
     * the user clicks the calculate button.
     */
    private class CalcButtonListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
	    String str;   // To hold text entered
	    double miles; // To hold miles
	    
	    // Get the number of kilometers entered in the
	    // text field. The input is a string.
	    str = kiloTextField.getText();
	    
	    // Convert the kilometers to miles.
	    miles = Conversions.convertKilometersToMiles(Double.parseDouble(str));
	    
	    // Display a message dialog showing the miles.
	    JOptionPane.showMessageDialog(null, str +
		    " kilometers is " + miles + " miles.");
	}
    }
    
    public static void main(String args[]) {
	SW4EventHandler window = new SW4EventHandler();
    }

}
