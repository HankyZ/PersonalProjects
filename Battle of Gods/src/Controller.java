import gods.God;

public class Controller {

	private Board board;
	
	public Controller() {
	}
	
	public void makeNewClassicBoard() {
		this.board = new ClassicBoard();
	}
	
	public void addGod(God god, int x, int y) {
		if ( board.getCase(x, y).getOccupied() == 0 ) {
			board.getCase(x, y).setOccupied(god.getId());
		} else {
			System.out.println("Case not empty!");
		}
	}
	
	public void moveGod(int sx, int sy, int dx, int dy) {
		if ( board.getCase(sx, sy).getOccupied() != 0 && board.getCase(dx, dy).getOccupied() == 0 ) {
			board.getCase(dx, dy).setOccupied(board.getCase(sx, sy).getOccupied());
			board.getCase(sx, sy).setOccupied(0);
		} else {
			System.out.println("Move failed!");
		}
	}
	
	public void printBoard() {
		System.out.print(board.toString());
	}
	
	public Board getBoard() {
		return this.board;
	}
	
}
