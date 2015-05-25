package edu.tuckett.classmaterials.week2;

public class Cat extends Animal {
	
	public Cat(String color) {
		
		this.color = color;
		vert = Vertebrae.VERTEBRATE;
		swimBehaviour = new SwimNoSwim();
	}
	
	public boolean equals(Object object) {
		
		if ( !(object instanceof Cat) ) return false;
		Cat that = (Cat)object;
		if (!this.color.equals(that.color)) return false;
		if (!this.vert.equals(that.vert)) return false;
		  
		return true;
	}
	
	public String toString() {
		return "Cat = Color: " + color + " Vertebrae: " + vert.toString()  + " Class: " + this.getClass().toString();
	}

}
