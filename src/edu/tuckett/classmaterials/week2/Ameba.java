package edu.tuckett.classmaterials.week2;

public class Ameba extends Animal {
	
	public Ameba(String color) {
		
		this.color = color;
		vert = Vertebrae.INVERTEBRATE;
		swimBehaviour = new SwimDoSwim();
	}
	
	public String toString() {
		return "Ameba = Color: " + color + " Vertebrae: " + vert.toString() + " Class: " + this.getClass().toString();
	}

}
