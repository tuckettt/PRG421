package edu.tuckett.classmaterials.week2;

public class MuskRat extends Animal {
	
	public MuskRat(String color) {
		
		this.color = color;
		vert = Vertebrae.VERTEBRATE;
		swimBehaviour = new SwimDoSwim();
	}
	
	public String toString() {
		return "MuskRat = Color: " + color + " Vertebrae: " + vert.toString() + " Class: " + this.getClass().toString();
	}

}
