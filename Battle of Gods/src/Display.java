import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Display extends JFrame{
	
	private JPanel topPanel;
	private JPanel midPanel;
	private JPanel botPanel;
	
	private JPanel gamePanel;
	
	private JLayeredPane[][] gameCases;
	private JLabel[][] gameEnv;
	private JLabel[][] gameGods;
	
	private Board board;
	
	private Icon[] tiles;
	private Icon[] gods;
	
	// constructor used for testing
	public Display(Board board) {
		super("Battle of Gods");
		tiles = new Icon[5];
		gods = new Icon[5];
		tiles[0] = new ImageIcon(getClass().getResource("grass.jpg"));
		tiles[1] = new ImageIcon(getClass().getResource("water.jpg"));
		gods[1] = new ImageIcon(getClass().getResource("hank.png"));
		newGame(board);
		refreshBoard();
	}
	
	// default constructor
	public Display() {
		super("Battle of Gods");
		tiles = new Icon[5];
		gods = new Icon[5];
		tiles[0] = new ImageIcon(getClass().getResource("grass.jpg"));
		tiles[1] = new ImageIcon(getClass().getResource("water.jpg"));
		gods[1] = new ImageIcon(getClass().getResource("hank.png"));
		newGame(new ClassicBoard());
		refreshBoard();
	}
	
	// initialize game
	private void newGame(Board board) {
		
		this.board = board;
		
		// create and add the three core panels
		topPanel = new JPanel();
		topPanel.setBackground(Color.ORANGE);
		topPanel.setPreferredSize(new Dimension(100, 20));
		
		midPanel = new JPanel();
		midPanel.setBackground(Color.BLUE);
		
		botPanel = new JPanel();
		botPanel.setBackground(Color.GRAY);
		botPanel.setPreferredSize(new Dimension(50, 30));
		
		add(topPanel, BorderLayout.NORTH);
		add(midPanel);
		add(botPanel, BorderLayout.SOUTH);
		
		// add the gamePanel to the midPanel
		gamePanel = new JPanel(new GridLayout(9, 9));
		gamePanel.setBackground(Color.WHITE);
		gamePanel.setPreferredSize(new Dimension(900, 900));
		midPanel.add(gamePanel, BorderLayout.NORTH);
		
		// add the gameCases to the gamePanel
		gameCases = new JLayeredPane[9][9];
		gameEnv = new JLabel[9][9];
		gameGods = new JLabel[9][9];
		
		for ( int x = 0; x < getBoard().getsize(); x++ ) {
			for ( int y = 0; y < getBoard().getsize(); y++ ) {
				
				gameCases[y][x] = new JLayeredPane();
				gameCases[y][x].setPreferredSize(new Dimension(100, 100));
				

				gameGods[y][x] = new JLabel();
				gameCases[y][x].add(gameGods[y][x], 0);
				gameGods[y][x].setBounds(0, 0, 100, 100);
				
				gameEnv[y][x] = new JLabel();
				gameEnv[y][x].setBounds(0, 0, 100, 100);
				gameEnv[y][x].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
				gameCases[y][x].add(gameEnv[y][x], 1);
				
				switch ( board.getCase(y, x).getEnv() ) {
					case 0 :
						gameEnv[y][x].setIcon(tiles[0]);
						break;
					case 1 :
						gameEnv[y][x].setIcon(tiles[1]);
						break;
					default :
						break;
				}

				gameCases[y][x].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e){
						
						for( int x = 0; x < getBoard().getsize(); x++ ){
							for ( int y = 0; y < getBoard().getsize(); y++ ) {

								if( gameCases[y][x] == e.getSource() ) {
									if ( getBoard().getCase(y, x).getOccupied() == 0 ) {
										gameGods[y][x].setIcon(gods[1]);
										getBoard().getCase(y, x).setOccupied(1);
									}
									else {
										
									}
								}
							}
						}
					}
				});
				gamePanel.add(gameCases[y][x]);
				
			}
		}
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public void refreshBoard() {
		// refresh gods
		for ( int y = 0; y < 9; y++ ) {
			for ( int x = 0; x < 9; x++ ) {
				switch ( board.getCase(x, y).getOccupied() ) {
					case 0 :
						break;
					case 1 :
						gameGods[x][y].setIcon(gods[1]);
						break;
					default :
						break;
				}
			}
		}
	}
}
