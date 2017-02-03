package model;

public class PvP extends Game {

	public void PvPTurn(int slutNumber){

		if(turn % 2 == 1)
			sluts[slutNumber].setValue(0);
		else
			sluts[slutNumber].setValue(1);
		turn++;
	}


}
