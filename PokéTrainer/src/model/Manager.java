package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {

	//------------------------
	// STATIC VARIABLES
	//------------------------

	private static Manager theInstance = null;

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	//Manager Associations
	private List<Location> locations;
	private List<Pokemon> pokemons;
	private List<Item> items;
	private List<Training> trainings;
	private List<Trainee> trainees;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	private Manager() {
		locations = new ArrayList<Location>();
		pokemons = new ArrayList<Pokemon>();
		items = new ArrayList<Item>();
		trainings = new ArrayList<Training>();
		trainees = new ArrayList<Trainee>();
	}

	public static Manager getInstance() {
		if (theInstance == null) {
			theInstance = new Manager();
		}
		return theInstance;
	}

	//------------------------
	// INTERFACE
	//------------------------

	public Location getLocation(int index) {
		Location aLocation = locations.get(index);
		return aLocation;
	}

	public List<Location> getLocations() {
		List<Location> newLocations = Collections.unmodifiableList(locations);
		return newLocations;
	}

	public int numberOfLocations() {
		int number = locations.size();
		return number;
	}

	public boolean hasLocations() {
		boolean has = locations.size() > 0;
		return has;
	}

	public int indexOfLocation(Location aLocation) {
		int index = locations.indexOf(aLocation);
		return index;
	}

	public Pokemon getPokemon(int index) {
		Pokemon aPokemon = pokemons.get(index);
		return aPokemon;
	}

	public List<Pokemon> getPokemons() {
		List<Pokemon> newPokemons = Collections.unmodifiableList(pokemons);
		return newPokemons;
	}

	public int numberOfPokemons() {
		int number = pokemons.size();
		return number;
	}

	public boolean hasPokemons() {
		boolean has = pokemons.size() > 0;
		return has;
	}

	public int indexOfPokemon(Pokemon aPokemon) {
		int index = pokemons.indexOf(aPokemon);
		return index;
	}

	public Trainee getTrainee(int index) {
		return trainees.get(index);
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public Item getItem(int index) {
		Item aItem = items.get(index);
		return aItem;
	}

	public List<Item> getItems() {
		List<Item> newItems = Collections.unmodifiableList(items);
		return newItems;
	}

	public int numberOfItems() {
		int number = items.size();
		return number;
	}

	public boolean hasItems() {
		boolean has = items.size() > 0;
		return has;
	}

	public int indexOfItem(Item aItem) {
		int index = items.indexOf(aItem);
		return index;
	}

	public Training getTraining(int index) {
		Training aTraining = trainings.get(index);
		return aTraining;
	}

	public List<Training> getTrainings() {
		List<Training> newTrainings = Collections.unmodifiableList(trainings);
		return newTrainings;
	}

	public int numberOfTrainings() {
		int number = trainings.size();
		return number;
	}

	public boolean hasTrainings() {
		boolean has = trainings.size() > 0;
		return has;
	}

	public int indexOfTraining(Training aTraining) {
		int index = trainings.indexOf(aTraining);
		return index;
	}

	public void addLocation(Location aLocation) {
		locations.add(aLocation);
	}

	public void removeLocation(Location aLocation) {
		locations.remove(aLocation);
	}

	public void addOrMoveLocationAt(Location aLocation, int index) {
		locations.remove(aLocation);
		locations.add(index, aLocation);
	}

	public void addPokemon(Pokemon aPokemon) {
		pokemons.add(aPokemon);
	}

	public void removePokemon(Pokemon aPokemon) {
		pokemons.remove(aPokemon);
	}

	public void addOrMovePokemonAt(Pokemon aPokemon, int index) {
		pokemons.remove(aPokemon);
		pokemons.add(index, aPokemon);
	}

	public void addTrainee(Trainee aTrainee) {
		trainees.add(aTrainee);
	}

	public void removeTrainee(Trainee aTrainee) {
		trainees.remove(aTrainee);
	}

	public void addOrMoveTraineeAt(Trainee aTrainee, int index) {
		trainees.remove(aTrainee);
		trainees.add(index, aTrainee);
	}

	public void addItem(Item aItem) {
		items.add(aItem);
	}

	public void removeItem(Item aItem) {
		items.remove(aItem);
	}

	public void addOrMoveItemAt(Item aItem, int index) {
		items.remove(aItem);
		items.add(index, aItem);
	}

	public void addTraining(Training aTraining) {
		trainings.add(aTraining);
	}

	public void removeTraining(Training aTraining) {
		trainings.remove(aTraining);
	}

	public void addOrMoveTrainingAt(Training aTraining, int index) {
		trainings.remove(aTraining);
		trainings.add(index, aTraining);
	}

	public void delete() {
		for (int i=locations.size(); i > 0; i--) {
			Location aLocation = locations.get(i - 1);
			aLocation.delete();
		}
		for (int i=pokemons.size(); i > 0; i--) {
			Pokemon aPokemon = pokemons.get(i - 1);
			aPokemon.delete();
		}
		for (int i=items.size(); i > 0; i--) {
			Item aItem = items.get(i - 1);
			aItem.delete();
		}
		for (int i=trainings.size(); i > 0; i--) {
			Training aTraining = trainings.get(i - 1);
			aTraining.delete();
		}
	}

}