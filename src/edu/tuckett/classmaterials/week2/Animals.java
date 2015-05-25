/*
 * Individual: ArrayList Program
 * Instructions:
 * Write a Java program (non-GUI preferred) to demonstrate the use of an
 * ArrayList.
 * The program should allow a user to do the following:
 * • Add, edit, delete different types of animals
 * • Select an animal, and the corresponding characteristics will be
 * displayed (such as color, vertebrate or invertebrate, can swim, etc.)
 * • The program must use ArrayList(s) to work with these animal
 * objects.
 * Include a brief documentation (in the code or in a separate document)
 * to explain the input (if any), processing and output of the program.
 * Submit your assignment using the Assignment Files tab above.
 */

package edu.tuckett.classmaterials.week2;

import java.util.*;

public class Animals {
	
	private List<Animal> animals;
	
	public Animals() {
		
		animals = new ArrayList<Animal>();
		
	}
	
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	
	public Animal searchAnimal(Animal animal) {
		
		int index = animals.indexOf(animal);
		if (index > -1)
			return animals.get(index);
		else
			return null;
	}
	
	public void editAnimal(Animal currentAnimal, Animal newAnimal) {
	
		currentAnimal.setColor(newAnimal.getColor());
		currentAnimal.setVert(newAnimal.getVert());
		currentAnimal.setSwimBehaviour(newAnimal.getSwimBehaviour());
	}
	
	public boolean deleteAnimal(Animal animal) {
		
		boolean result = animals.remove(animal);
		animal=null;
		return result;
	}
	
	public static void main(String args[]) {
		
		Animals testAnimals = new Animals();
		testAnimals.animals.add(new Cat("White"));
		testAnimals.animals.add(new Fish("Rainbow"));
		testAnimals.animals.add(new Ameba("Clear"));
		
		testAnimals.editAnimal(testAnimals.searchAnimal(testAnimals.animals.get(1)),new Cat("Red"));
		System.out.println(testAnimals.deleteAnimal(testAnimals.searchAnimal(testAnimals.animals.get(1))));
		
		for (Animal animal : testAnimals.animals) {
			System.out.println(animal);
			animal.performSwim();
		}
		
	}
	
	

}
