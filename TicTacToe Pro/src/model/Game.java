package model;

public class Game {

	protected Slut sluts[];
	protected int turn;
	protected boolean gameOver;

	public Game(){
		sluts = new Slut[9];
		for(int x = 0; x < sluts.length; x++)
			sluts[x] = new Slut();
		turn = 1;
		gameOver = true;
	}

	public void startGame(){
		gameOver = false;
	}

	public int getTurn(){
		return turn;
	}

	public void playerTurn(int slutNumber){
		if(turn % 2 == 1)
			sluts[slutNumber].setValue(0);
		else
			sluts[slutNumber].setValue(1);
		turn++;
	}

	// check if there is immediate danger; if yes, return the location of the danger; if not, return 9
	public int checkDanger(int value){

		// check column
		for(int x = 0; x < 3; x++){
			if(sluts[x].getValue() == sluts[x + 3].getValue() && sluts[x].getValue() == value && sluts[x + 6].getValue() == 2)
				return x + 6;
			else if(sluts[x].getValue() == sluts[x + 6].getValue() && sluts[x].getValue() == value && sluts[x + 3].getValue() == 2)
				return x + 3;
			else if(sluts[x + 3].getValue() == sluts[x + 6].getValue() && sluts[x + 3].getValue() == value && sluts[x].getValue() == 2)
				return x;
		}

		// check row
		for(int y = 0; y < 7; y+=3){
			if(sluts[y].getValue() == sluts[y + 1].getValue() && sluts[y].getValue() == value && sluts[y + 2].getValue() == 2)
				return y + 2;
			else if(sluts[y].getValue() == sluts[y + 2].getValue() && sluts[y].getValue() == value && sluts[y + 1].getValue() == 2)
				return y + 1;
			else if(sluts[y + 1].getValue() == sluts[y + 2].getValue() && sluts[y + 1].getValue() == value && sluts[y].getValue() == 2)
				return y;
		}

		// check diagonal
		if(sluts[4].getValue() == value){
			if(sluts[0].getValue() == value && sluts[8].getValue() == 2)
				return 8;
			else if(sluts[8].getValue() == value && sluts[0].getValue() == 2)
				return 0;
			else if(sluts[2].getValue() == value && sluts[6].getValue() == 2)
				return 6;
			else if(sluts[6].getValue() == value && sluts[2].getValue() == 2)
				return 2;
		}

		return 9;
	}

	/* given a board, check if there is a winner; if winner, return the winner, if not return 2 */
	public int checkWinner(){

		// check column
		for(int x = 0; x < 3; x++){
			if(sluts[x].getValue() == sluts[x + 3].getValue() && sluts[x].getValue() == sluts[x + 6].getValue())
				return sluts[0].getValue();
		}

		// check row
		for(int y = 0; y < 7; y+=3){
			if(sluts[y].getValue() == sluts[y + 1].getValue() && sluts[y].getValue() == sluts[y + 2].getValue())
				return sluts[0].getValue();
		}

		// check diagonals
		if((sluts[0].getValue() == sluts[4].getValue() && sluts[0].getValue() == sluts[8].getValue())
				|| (sluts[2].getValue() == sluts[4].getValue() && sluts[2].getValue() == sluts[6].getValue()))
			return sluts[0].getValue();

		return 2;
	}

}
