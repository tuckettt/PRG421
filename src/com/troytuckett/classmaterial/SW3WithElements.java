package com.troytuckett.classmaterial;

import javax.swing.*;
import java.awt.event.*;

public class SW3WithElements extends JFrame {
    
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField kiloTextField;
    private JButton calcButton;

    public SW3WithElements() {
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
	
	panel = new JPanel();
	
	panel.add(messageLabel);
	panel.add(kiloTextField);
	panel.add(calcButton);	
	
    }
    
    public static void main(String args[]) {
	SW3WithElements window = new SW3WithElements();
    }
}
