package model;

public class Trainee {


	//Trainee Attributes
	private Pokemon pokemon;
	private int [] EVs;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Trainee(Pokemon aPokemon) {
		pokemon = aPokemon;
		EVs = new int[6];
		for (int x = 0; x < 6; x++)
			EVs[x] = 0;
	}

	public void setPokemon(Pokemon aPokemon) {
		pokemon = aPokemon;
	}

	public void addEV(int aEVYield, int aEVYieldValue)	{
		EVs[aEVYield] += aEVYieldValue;
	}

	public void removeEV(int aEVYield, int aEVYieldValue) {
		EVs[aEVYield] -= aEVYieldValue;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public int getEV(int index) {
		return EVs[index];
	}

	public int[] getEVs() {
		return EVs;
	}

	public int numberOfEVs() {
		return  EVs.length;
	}

	public void delete() {

	}

	public String toString() {
		String outputString = "";
		return super.toString() +
				"name" + ":" + getPokemon().getName()
				+ outputString;
	}
}

