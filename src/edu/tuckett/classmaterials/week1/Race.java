/*
 * Individual: Singleton Pattern Program
 * Instructions:
 * Write a Java program (non-GUI preferred) to demonstrate the Singleton
 * pattern.
 *
 * Using these key parts, write a Java program that will allow a user of the
 * program to assign only one runner to each of the 8 lanes of running
 * track in a field.
 * 
 * Include a brief documentation (in the code or in a separate document)
 * to explain the input (if any), processing and output of the program.
 * Submit your assignment using the Assignment Files tab above.
 */

package edu.tuckett.classmaterials.week1;

import java.util.*;

/**
 * This class implements a Race which is a list of 8 Lanes each with a single runner.
 * A single runner is maintained through the use of a singleton for each Lane.
 * Each lane inherits from Lane.  Individual lanes are created from Lane. 
 *
 * @author troy tuckett
 *
 */
public class Race {
	
	List<Lane> list;
	
	/** Creates a race by instantiating an array list of Lanes with 8 positions */
	public Race() {
		
		list = new ArrayList<Lane>(8);
		
	}
	
	/** This method creates each lane and adds a runner */
	public void setUpRace() {
		list.add(Lane1.getLane(new Runner("One")));
		list.add(Lane2.getLane(new Runner("Two")));
		list.add(Lane3.getLane(new Runner("Three")));
		list.add(Lane4.getLane(new Runner("Four")));
		list.add(Lane5.getLane(new Runner("Five")));
		list.add(Lane6.getLane(new Runner("Six")));
		list.add(Lane7.getLane(new Runner("Seven")));
		list.add(Lane8.getLane(new Runner("Eight")));
	}
	
	/** As you start a race, this lists the runners */
	public void startRace() {
		
		for (Lane lane : list) {
			System.out.println(lane);
		}
		
	}
	
	/** Tests the race.  Especially by trying to add another runner to Lane1 */
	public static void main(String args[]) {
		
		Race race = new Race();
		race.setUpRace();
		race.startRace();
		
		Lane l1 = race.list.get(0);	
		l1 = Lane1.getLane(new Runner("TwentyTwo"));
		
		race.startRace();
	}

}
