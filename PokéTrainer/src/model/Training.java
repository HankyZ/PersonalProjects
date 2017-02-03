package model;

public class Training {

	//------------------------
	// STATIC VARIABLES
	//------------------------

	private static int nextId = 1;

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	//Training Attributes
	private Trainee trainee;
	private Pokemon foe;
	private Item item;

	//Autounique Attributes
	private int id;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Training(Trainee aTrainee, Pokemon aFoe, Item aItem) {
		trainee = aTrainee;
		foe = aFoe;
		item = aItem;
		id = nextId++;
	}

	//------------------------
	// INTERFACE
	//------------------------

	public void setTrainee(Trainee aTrainee) {
		trainee = aTrainee;
	}

	public void setFoe(Pokemon aFoe) {
		foe = aFoe;
	}

	public void setItem(Item aItem) {
		item = aItem;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public Pokemon getFoe() {
		return foe;
	}

	public Item getItem() {
		return item;
	}

	public int getId() {
		return id;
	}


	public void delete() {
	}


	public String toString() {
		String outputString = "";
		return super.toString() + "["+
		"id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
		"  " + "trainee" + "=" + (getTrainee() != null ? !getTrainee().equals(this)  ? getTrainee().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
		"  " + "foe" + "=" + (getFoe() != null ? !getFoe().equals(this)  ? getFoe().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
		"  " + "item" + "=" + (getItem() != null ? !getItem().equals(this)  ? getItem().toString().replaceAll("  ","    ") : "this" : "null")
		+ outputString;
	}
}