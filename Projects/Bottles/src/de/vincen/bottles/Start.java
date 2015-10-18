package de.vincen.bottles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

public class Start {

	public static void main(String[] args) {

		int noOfBottles = 0;
		int noOfContainers = 0;

		String zeile1;
		String zeile2;
		String zeile3 = "";
		
		
		try {
			FileReader fr;
			fr = new FileReader(args[0]);
		    BufferedReader br = new BufferedReader(fr);
			
		    zeile1 = br.readLine();
			noOfBottles = new Integer(zeile1).intValue();
			System.out.println("noOfBottles:" + noOfBottles);
		    
		    zeile2 = br.readLine();
		    noOfContainers = new Integer(zeile2).intValue();
			System.out.println("noOfContainers:" + noOfContainers);
		    	    
		    zeile3 = br.readLine();
		    System.out.println("Container Sizes:" + zeile3); 
		    
		    br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String delims = "[ ]+";
		String[] containerSizes = zeile3.split(delims);
		
		NewBottleSolution bs = new NewBottleSolution(noOfBottles);
		
		Collection solutions = new Vector();
		
		Collection containers = bs.createContainers(containerSizes); 
		
		bs.findSolutions(containers);
	
	}

}
