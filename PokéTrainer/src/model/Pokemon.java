package model;

import javax.swing.Icon;

public class Pokemon {

	//Pokemon Attributes
	private String name;
	private int EVYield;
	private int EVYieldValue;
	private Icon image;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Pokemon(String aName, int aEVYield, int aEVYieldValue, Icon image) {
		name = aName;
		EVYield = aEVYield;
		EVYieldValue = aEVYieldValue;
		this.image = image;
	}

	public void setImage(Icon image) {
		this.image = image;
	}
	
	public Icon getimage() {
		return image;
	}
	
	public void setName(String aName)	{
		name = aName;
	}

	public void setEVYield(int aEVYield) {
		EVYield = aEVYield;
	}

	public void setEVYieldValue(int aEVYieldValue) {
		EVYieldValue = aEVYieldValue;
	}

	public String getName() {
		return name;
	}

	public int getEVYield() {
		return EVYield;
	}

	public int getEVYieldValue() {
		return EVYieldValue;
	}

	public void delete() {

	}

	public String toString() {
		String outputString = "";
		return super.toString() + "["+
		"name" + ":" + getName()+ "," +
		"EVYield" + ":" + getEVYield()+ "," +
		"EVYieldValue" + ":" + getEVYieldValue()+ "]" 
		+ outputString;
	}
}