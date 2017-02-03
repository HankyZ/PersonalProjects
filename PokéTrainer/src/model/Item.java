package model;

public class Item {
	//Item Attributes
	private String name;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Item(String aName) {
		name = aName;
	}

	//------------------------
	// INTERFACE
	//------------------------

	public void setName(String aName) {
		name = aName;
	}

	public String getName() {
		return name;
	}

	public void delete() {
	}

	public String toString() {
		String outputString = "";
		return super.toString() + "["+
		"name" + ":" + getName()+ "]"
		+ outputString;
	}
}