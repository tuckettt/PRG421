package com.troytuckett.classmaterial;

public class Conversions {
    
    public static double convertKilometersToMiles(double kilometers) {
	return  kilometers * 0.6214;
    }

    public static double convertMilesToKilometers(double miles) {
	return  miles / 0.6214;
    }
    
    public static double convertFarenheitToCelsius(double farenheit) {
	return (5.0/9.0) * (farenheit - 32.0);
    }
    
    public static double convertCelsiusToFarenheit(double celsius) {
	return celsius * (9.0/5.0) + 32.0;
    }

}
