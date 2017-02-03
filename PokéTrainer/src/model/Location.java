package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Location {

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	//Location Attributes
	private String name;

	//Location Associations
	private List<Pokemon> pokemons;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Location(String aName) {
		name = aName;
		pokemons = new ArrayList<Pokemon>();
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

	public Pokemon getPokemon(int index) {
		return pokemons.get(index);
	}

	public List<Pokemon> getPokemons() {
		List<Pokemon> newPokemons = Collections.unmodifiableList(pokemons);
		return newPokemons;
	}

	public int numberOfPokemons() {
		return pokemons.size();
	}

	public void addPokemon(Pokemon aPokemon) {
		pokemons.add(aPokemon);
	}

	public void removePokemon(Pokemon aPokemon) {
		pokemons.remove(aPokemon);
	}

	public void delete() {
	}


	public String toString()
	{
		String outputString = "";
		return super.toString() + "["+
		"name" + ":" + getName()+ "]"
		+ outputString;
	}
}