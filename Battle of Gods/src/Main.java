import javax.swing.JFrame;

import gods.Hank;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller c = new Controller();
		c.makeNewClassicBoard();
		c.addGod(new Hank(0), 4, 0);
		c.addGod(new Hank(1), 4, 8);
		c.moveGod(4, 0, 5, 0);
		c.printBoard();

		Display x = new Display(c.getBoard());
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setSize(1500, 1000);
		x.setVisible(true);
	}

}
