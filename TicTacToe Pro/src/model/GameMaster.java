package model;

public class GameMaster {

	private Game gameOptions[];
	private Game gameChosen;

	public GameMaster(){
		gameOptions[0] = new PvP();
		gameOptions[1] = new MasterCPU();
		gameChosen = gameOptions[0];
	}

	public void setGameOption(int option){
		if(gameChosen != gameOptions[option])
			gameChosen = gameOptions[option];
	}

}
