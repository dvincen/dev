package de.vincen.bottles;

public class Container {

	int size = 0;

	int noOfBottles = 0;
	

	public Container(int size) {
		this.size = size;
	}
	
	public int getNoOfBottles() {
		return noOfBottles;
	}
	
	public void setNoOfBottles(int noOfBottles) {
		this.noOfBottles = noOfBottles;
	}

	public boolean spaceLeft() {
		return (size > noOfBottles );
	}

	public int getSize() {
		return size;
	}

	public boolean addBottle(){
		if (size - noOfBottles > 0) {
			noOfBottles++;
			return true;
		} else {
			return false;
		}
			
	}
	
}
