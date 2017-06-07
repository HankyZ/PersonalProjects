
public class ClassicBoard extends Board {
	private Case[][] board;
	
	public ClassicBoard() {
			super();
			for ( int x = 0; x < 9; x++ ) {
				this.getCase(x, 4).setEnv(1);
			}
	}
	
}
