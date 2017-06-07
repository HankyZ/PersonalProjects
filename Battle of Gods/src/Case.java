
public class Case {
	
	// 0: grass, 1: river
	private int env;	// used for forest, river, etc, default is 0
	// 1: Hank 2: 
	private int occupied; // used to show occupied by what, empty is 0
	
	public Case(int env, int occupied) {
		this.env = env;
		this.occupied = occupied;
	}
	
	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}
	
	public int getOccupied() {
		return this.occupied;
	}
	
	public void setEnv(int env) {
		this.env = env;
	}
	
	public int getEnv() {
		return this.env;
	}
	
	public String toString() {
		String s = "";
		s += env;
		s += "  ";
		s += occupied;
		return s;
	}
}
