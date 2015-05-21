package com.troytuckett.classmaterial;

import javax.swing.*;
import java.awt.*;
/**
 * This class is an applet that demonstrates how
 * arcs can be drawn.
 */

public class ArcDemo extends JApplet { 
    
    double numbers[] = {25.0,10.0,60.0,80.0,20.0,5.0,43,5,40};
    Color colors[] = {Color.MAGENTA,Color.RED,Color.BLUE,Color.ORANGE,Color.CYAN,Color.GREEN,Color.GRAY,Color.PINK,Color.YELLOW};
    
    /**
     * init method
     */
    public void init() {
       // Set the background color to white.
       getContentPane().setBackground(Color.WHITE);
    }
    
    /**
      * paint method
    */
    public void paint(Graphics g) {
	
	// Call the superclass paint method.
	super.paint(g);

	int trackStart = 0;
	for (int c=0;c<numbers.length;c++) {
	    
	    double angle = GraphCalculate.calculateAngle(
		    GraphCalculate.calculatePercent(
			    GraphCalculate.calculateSum(numbers),
			    	numbers[c]));
	    
	    //System.out.println(angle);
	    
	    g.setColor(colors[c]);
	    g.fillArc(0, 0, 200, 200, trackStart, (int)Math.round(angle));
	    
	    trackStart += (int)Math.round(angle);
	}
    }
}