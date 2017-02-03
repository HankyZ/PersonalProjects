package persistence;

import java.util.Iterator;
import model.*;

public class Persistence {
	public static void initializeXStream(String filename) {
		PersistenceXStream.setFilename(filename);
		PersistenceXStream.setAlias("location", Location.class);
		PersistenceXStream.setAlias("pokemon", Pokemon.class);
		PersistenceXStream.setAlias("item", Item.class);
		PersistenceXStream.setAlias("training", Training.class);
		PersistenceXStream.setAlias("manager", Manager.class);
		PersistenceXStream.setAlias("trainee", Trainee.class);
	}

	public static void loadModel(String filename) {
		Manager m = Manager.getInstance();
		Persistence.initializeXStream(filename);
		Manager m2 = (Manager) PersistenceXStream.loadFromXMLwithXStream();
		if (m2 != null) {
			// unfortunately this creates a second RegistrationManager object, even though it is a singleton
			// copy loaded model into singleton instance of RegistrationManger, because this will be used throughout the application
			Iterator<Location> lIt = m2.getLocations().iterator();
			while (lIt.hasNext())
				m.addLocation(lIt.next());
			Iterator<Pokemon> pIt = m2.getPokemons().iterator();
			while (pIt.hasNext())
				m.addPokemon(pIt.next());
			Iterator<Item> iIt = m2.getItems().iterator();
			while (iIt.hasNext())
				m.addItem(iIt.next());
			Iterator<Training> tIt = m2.getTrainings().iterator();
			while (tIt.hasNext())
				m.addTraining(tIt.next());
			Iterator<Trainee> traineeIt = m2.getTrainees().iterator();
			while (traineeIt.hasNext())
				m.addTrainee(traineeIt.next());
		}
	}

}
