package de.vincen.bottles;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class NewBottleSolution {

	int noOfBottlesLeft = 0;
	int noOfBottles = 0;
	int[][] solutions;
	
	public NewBottleSolution(int noOfBottles) {
		this.noOfBottles = noOfBottles;
		this.noOfBottlesLeft = noOfBottles;
	};
	
	public Collection findSolutions(Collection<Container> containers) {
		
		Iterator<Container> it = containers.iterator();
		
		List solutionList = new Vector();
		
		int numberOfPossibleSolutions = 1;
		int numberOfContainers = containers.size();
		double t = 1;
		
		while (it.hasNext()) {
			
			Container c = it.next();
			t = t * (c.getSize()+1);
		}
		System.out.println("Number of possibilities=" + t);
		double d = 0;
		long time1 = System.currentTimeMillis();
		System.out.println("start");
		while (d < t) {
			d++; 
			if (d % 1000000000 == 0) {
				System.out.println("d=" + d);
			}
		}
		long time2 = System.currentTimeMillis();
		System.out.println("stop");
		System.out.println("Elapsed:" + (time2-time1));		
		
		numberOfPossibleSolutions = (int)t;
		
		it = containers.iterator();
		solutions = new int[numberOfPossibleSolutions][numberOfContainers];
		
		int column = 0;

		Container[] contis = new Container[containers.size()];
		containers.toArray(contis);
		
		int countdown = numberOfPossibleSolutions;
		while (it.hasNext()) {
			Container container = (Container) it.next();
			countdown = countdown/(container.getSize()+1);
			int cursor = 0;
			for (int j = 0; j < container.getSize()+1|| cursor < numberOfPossibleSolutions; j++) {

				for (int i = 0; i < countdown; i++) {
					solutions[cursor++][column] = container.getNoOfBottles();
				}
				
				if (!container.addBottle()){
					container.setNoOfBottles(0);
				}
			}
			column++;
		}
		
		for (int i = 0; i < solutions.length; i++) {

			int amountOfBottles = 0;
			for (int j = 0; j < numberOfContainers; j++) {
				amountOfBottles = amountOfBottles + solutions[i][j];
			}
			if (amountOfBottles == noOfBottles) {
				Vector result = new Vector();
				for (int j = 0; j < numberOfContainers; j++) {
					result.addElement(solutions[i][j]);
				}
				solutionList.add(result);
			}
		}
		
		System.out.println("Number of solutions=" + solutionList.size());
		System.out.println("Solutions:");
		System.out.println(solutionList);

		
		return solutionList;
	}
	
	
	public Collection createContainers(String[] containerSizes) {
		
		Collection<Container> containers = new Vector<Container>();

		for (int i = 0; i < containerSizes.length; i++) {
			Container c = new Container(new Integer(containerSizes[i]).intValue());
			containers.add(c);
		}
		
		return containers;
	}

}
