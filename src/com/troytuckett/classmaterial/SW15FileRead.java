package com.troytuckett.classmaterial;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SW15FileRead extends JFrame {
    
    private MyPanel graphPanel;
    private JPanel mainPanel;
    private JPanel filePanel;
    private JLabel fileLabel;
    private JTextField fileNameTextField;
    private JButton fileButton;    
    double numbers[] = {25.0,10.0,60.0,80.0,20.0,5.0,43,5,40};
    Color colors[] = {Color.MAGENTA,Color.RED,Color.BLUE,Color.ORANGE,Color.CYAN,Color.YELLOW,Color.GREEN,Color.GRAY,Color.PINK};

    public SW15FileRead() {
	super ("Pie Chart");
	setSize(350,350);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	buildPanel();
	add(mainPanel);
	
	setVisible(true);	
    }    
    
    private void buildPanel() {
	
	fileButton = new JButton("Pick File To Graph");
	fileButton.addActionListener(new FileSelectionListener());
	
	filePanel = new JPanel();
	filePanel.add(fileButton);
	
	graphPanel = new MyPanel();
	
	mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());	
	mainPanel.add(filePanel, BorderLayout.NORTH);
	mainPanel.add(graphPanel, BorderLayout.CENTER);
    }         
    
    private class MyPanel extends JPanel {
	
	MyPanel() {
	    setPreferredSize(new Dimension(500,100));
	}
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    int trackStart = 0;
	    for (int c=0;c<numbers.length;c++) {
		    
		double angle = GraphCalculate.calculateAngle(
			GraphCalculate.calculatePercent(
				GraphCalculate.calculateSum(numbers),
				numbers[c]));
		    
		g.setColor(colors[c]);
		g.fillArc(50, 50, 200, 200, trackStart, (int)Math.round(angle));
		    
		trackStart += (int)Math.round(angle);
	    }	    
	}
    }
   
    /**
     * Private inner class that handles the event when
     * the user clicks the calculate button.
     */
    private class FileSelectionListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {

	    JFileChooser fileChooser = new JFileChooser();
	    int status = fileChooser.showOpenDialog(null);
	    if (status==JFileChooser.APPROVE_OPTION) {
		File selectedFile = fileChooser.getSelectedFile();
		String filename = selectedFile.getPath();
		reloadArray(filename);
		
		graphPanel.repaint();
		
	    }
	}
    }
    
    public void reloadArray(String path) {
	
	int arraySize = determineFileSize(path);		
		
	File file = new File(path);
	Scanner inputFile=null;
	try {
	    inputFile = new Scanner(file);
	    
	    this.numbers = new double[arraySize];
	    int index = 0;
	    
	    while (inputFile.hasNext()) {
		  String input = inputFile.nextLine();
		  numbers[index] = Double.parseDouble(input);
		  index++;
	    }	
		
	    inputFile.close();
	    
	} catch (IOException e) {
	    System.err.println("Problem loading file");
	}		
    }
    
    private int determineFileSize(String path) {
	
	int fileCount = 0;
	
	File file = new File(path);
	Scanner inputFile=null;
	try {
	    inputFile = new Scanner(file);
	    
	    while (inputFile.hasNext()) {
		inputFile.nextLine();
		fileCount++;   
	    }		
		
	    inputFile.close();
	    
	} catch (IOException e) {
	    System.err.println("Problem loading file");
	}
	
	return fileCount;	
    }
    
    public static void main(String args[]) {
	SW15FileRead window = new SW15FileRead();
    }

}