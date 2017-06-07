
public class ClassicBoard extends Board {
	private Case[][] board;
	
	public ClassicBoard() {
		
			super();
			
			// create a board with water tiles in the middle		
			for ( int x = 0; x < 9; x++ ) {
				this.getCase(x, 4).setEnv(1);
			}
	}
	
}
