package com.troytuckett.classmaterial;

public class GraphCalculate {
    
    public static double calculateSum(double[] array) {
	
	//System.out.println(array.length);
	
	double sum = 0;
	for(int c=0;c < array.length;c++) {
 
	    sum+=array[c];    
	}
	
	return sum;	
    }
    
    public static double calculatePercent(double sum, double item) {
	
	return item/sum;
    }
    
    public static double calculateAngle(double percentage) {
	return percentage*360;
    }
}
