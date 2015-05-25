package edu.tuckett.classmaterials.week2;

public class Fish extends Animal {
	
	public Fish(String color) {
		
		this.color = color;
		vert = Vertebrae.VERTEBRATE;
		swimBehaviour = new SwimDoSwim();
	}
	
	public String toString() {
		return "Fish = Color: " + color + " Vertebrae: " + vert.toString() + " Class: " + this.getClass().toString();
	}

}
