package application;

import java.awt.DisplayMode;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;
import controller.InvalidInputException;
import model.Manager;
import model.Pokemon;
import persistence.Persistence;
import persistence.PersistenceXStream;
import view.TrainingPage;

public class PokéTrainer extends JFrame {

	private static final long serialVersionUID = -7031223239328394620L;

	public static void main(String[] args) {
		Persistence.loadModel("data.xml");
		PokéTrainer p = new PokéTrainer();
		//				p.createPokemonOnce();
		//		p.createTraineeOnce();
		//		p.createLocationOnce();
		//		p.addPokemonToLocation();
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		TrainingPage tp = new TrainingPage();
		tp.run(dm);
	}

	public void createPokemonOnce() {
		Icon image = new ImageIcon(getClass().getResource("geodude.png"));
		Controller c = new Controller();
		try {
			c.createPokemon("Geodude", 4, 2, image);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createTraineeOnce() {
		Controller c = new Controller();
		int EVs[] = {0, 0, 0, 0, 0, 0};
		try {
			c.createTrainee("Milotic", EVs);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createLocationOnce() {
		Manager m = Manager.getInstance();
		Controller c = new Controller();
		ArrayList pokemons = new ArrayList<Pokemon>();
		pokemons.add(m.getPokemon(1));
		try {
			c.createLocation("Route 35", pokemons);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
	}

	public void  addPokemonToLocation() {
		Manager m = Manager.getInstance();
		for (int x = 0; x < m.getLocations().size(); x++) {
			if ("Route 35".equals(m.getLocation(x).getName()))
				m.getLocation(x).addPokemon(m.getPokemon(2));
		}
		PersistenceXStream.saveToXMLwithXStream(m);
	}

	public void createAllItems() {
		Manager m = Manager.getInstance();
		Controller c = new Controller();
		String name = "Macho Brace";
		try {
			c.createItem(name);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		name = "Power Weight";
	}
}
