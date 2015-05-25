package edu.tuckett.classmaterials.week2;

public class Animal {
	
	protected String color;
	protected Vertebrae vert;
	protected SwimBehaviour swimBehaviour;
	
	public void performSwim() {
		swimBehaviour.swim();
	}
	
	public boolean equals(Object object) {
		
		if ( !(object instanceof Animal) ) return false;
		Animal that = (Animal)object;
		if (!this.color.equals(that.color)) return false;
		if (!this.vert.equals(that.vert)) return false;
		  
		return true;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setVert(Vertebrae vert) {
		this.vert = vert;
	}
	
	public void setSwimBehaviour(SwimBehaviour swimBehaviour) {
		this.swimBehaviour = swimBehaviour;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public Vertebrae getVert() {
		return this.vert;
	}
	
	public SwimBehaviour getSwimBehaviour() {
		return this.swimBehaviour;
	}
	
	
	public String toString() {
		return "Animal = Color: " + color + " Vertebrae: " + vert.toString() + " Class: " + this.getClass().toString();
	}

}
