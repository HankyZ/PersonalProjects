package model;

public class Slut {

	private int value; // can be 0, 1 or 2

	public Slut(){
		value = 2;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	public void reset(){
		value = 0;
	}

}
