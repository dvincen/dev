package de.vincen.bottles;

public class Digit {
	
	int maxValue;
	int value = 0;
	
	public Digit(int maxValue){
		this.maxValue = maxValue;
	}
	
	public void reset() {
		value = 0;
	}
	
	public boolean increment() {
		if (value == maxValue) {
			value = 0;
			return false;
		} else {
			value++;
			return true;
		}
	}

}
