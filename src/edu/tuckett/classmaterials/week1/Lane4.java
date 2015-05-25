package edu.tuckett.classmaterials.week1;

public class Lane4 extends Lane {
	
	private static Lane lane;
	
	public static Lane getLane(Runner runner) { 
		
		if (lane==null) {
			lane = new Lane();
			lane.runner = runner;
		}
		
		return lane;
	}
}
