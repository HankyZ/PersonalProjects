package gods;

public class God {
	
	private int mvt;
	private int range;
	private int atk;
	private int def;
	private int hp;
	private int id;
	private int side;
	
	public God(int mvt, int range, int atk, int def, int hp, int id, int side) {
		this.mvt = mvt;
		this.range = range;
		this.atk = atk;
		this.def = def;
		this.hp = hp;
		this.id = id;
		this.side = side;
	}
	
	public void setMvt(int mvt) {
		this.mvt = mvt;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMvt() {
		return this.mvt;
	}
	public int getRange() {
		return this.range;
	}
	public int getAtk() {
		return this.atk;
	}
	public int getDef() {
		return this.def;
	}
	public int getHp() {
		return this.hp;
	}
	
	public int getId() {
		return this.id;
	}
}
