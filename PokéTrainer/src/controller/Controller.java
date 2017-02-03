package controller;

import java.util.ArrayList;

import javax.swing.Icon;

import model.*;
import persistence.PersistenceXStream;

public class Controller {

	/* used by the developer
	 * EVYeild configuration: 0 = HP, 1 = Atk, 2 =  Def, 3 = Sp.Atk, 4 = Sp.Def, 5 = Spd
	 */
	public void createPokemon(String name, int EVYield, int EVYieldValue, Icon image ) throws InvalidInputException {
		String error = "";
		Manager m = Manager.getInstance();
		// name must start with an upper case  letter
		if (name.charAt(0) < 'A' || name.charAt(0) > 'Z')
			error += "Name must start with an upper case letter! ";
		// name must be followed with lower case letters or numbers
		for (int x = 1; x < name.length(); x++) {
			if ((name.charAt(x) < '0' || name.charAt(x) > '9') && (name.charAt(x) < 'a' || name.charAt(x) > 'z'))
				error += "Name must be followed with lower case letters or numbers! ";
		}
		// check if the same Pokemon has been already added
		for (int x = 0; x < m.getPokemons().size(); x++ ) {
			if (name.equals(m.getPokemon(x).getName()))
				error += "The same Pokémon has already been added! ";
		}
		// check if EVYield is from 0 - 5
		if (EVYield < 0 || EVYield > 5)
			error += "The EV Yield must be between 0 and 5! ";
		error .trim();
		if (error.length() > 0)
			throw new InvalidInputException(error);
		Pokemon pokemon = new Pokemon(name, EVYield, EVYieldValue, image);
		m.addPokemon(pokemon);
		PersistenceXStream.saveToXMLwithXStream(m);
	}

	public void createTrainee(String name, int [] EVs) throws InvalidInputException {
		String error = "";
		Manager m = Manager.getInstance();
		Pokemon p = null;
		// name must start with an upper case  letter
		if (name.charAt(0) < 'A' || name.charAt(0) > 'Z')
			error += "Name must start with an upper case letter! ";
		// name must be followed with lower case letters or numbers
		for (int x = 1; x < name.length(); x++) {
			if ((name.charAt(x) < '0' || name.charAt(x) > '9') && (name.charAt(x) < 'a' || name.charAt(x) > 'z'))
				error += "Name must be followed with lower case letters or numbers! ";
		}
		int flag = 0;
		for (int x = 0; x < m.getPokemons().size(); x++) {
			if (name.equals(m.getPokemon(x).getName())) {
				p = m.getPokemon(x);
				flag = 1;
			}
			if (flag == 1)
				break;
		}
		if (flag == 0)
			error += "This Pokémon does not exist! ";
		error .trim();
		if (error.length() > 0)
			throw new InvalidInputException(error);
		Trainee trainee = new Trainee(p);
		for (int x = 0; x < 6; x++)
			trainee.addEV(x, EVs[x]); 
		m.addTrainee(trainee);
		PersistenceXStream.saveToXMLwithXStream(m);
	}

	public void createTraining(Trainee trainee, Pokemon opponent, Item item) {
		int EVYield1 = opponent.getEVYield();
		switch (item.getName()) {
		}
		//		int EVYield2 = 
	}

	public void createLocation(String name, ArrayList<Pokemon> pokemons) throws InvalidInputException {
		String error = "";
		Manager m = Manager.getInstance();
		for (int x = 0; x < m.getLocations().size(); x++) {
			if (name.equals(m.getLocation(x).getName())) {
				error += "This location has already been added! ";
				break;
			}
		}
		error.trim();
		if (error.length() > 0)
			throw new InvalidInputException(error);
		Location location = new Location(name);
		for (int x = 0; x < pokemons.size(); x++)
			location.addPokemon(pokemons.get(x));
		m.addLocation(location);
		PersistenceXStream.saveToXMLwithXStream(m);
	}

	public void createItem(String name) throws InvalidInputException {
		String error = "";
		Manager m = Manager.getInstance();
		for (int x = 0; x < m.getItems().size(); x++) {
			if (name.equals(m.getItem(x).getName())) {
				error +=  "This item has already been added! ";
				break;
			}
		}
		error.trim();
		if (error.length() > 0)
			throw new InvalidInputException(error);
		Item item = new Item(name);
		m.addItem(item);
		PersistenceXStream.saveToXMLwithXStream(m);
	}
}
