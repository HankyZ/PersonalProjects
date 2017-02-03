package controller;

import model.GameMaster;

public class Controller {

	GameMaster gm;

	public Controller(){
		gm = new GameMaster();

	}

	public void changeGameOption(int option){
		gm.setGameOption(option);
	}
	
	
}
