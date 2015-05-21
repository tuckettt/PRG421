package com.troytuckett.classmaterial;

import javax.swing.*;

public class SW2ExtendJFrame extends JFrame {

    public SW2ExtendJFrame() {
	super ("Almost as Simple Window");
	setSize(200,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);	
    }    
    
    public static void main(String args[]) {
	SW2ExtendJFrame window = new SW2ExtendJFrame();
    }
}
