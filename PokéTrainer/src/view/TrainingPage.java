package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Location;
import model.Manager;
import model.Trainee;

public class TrainingPage extends JFrame {

	private static final long serialVersionUID = -7552245854084086074L;

	// for display error
	private String error = null;
	private JLabel errorMessage;

	// for general settings
	private JPanel blankPanel;
	private JButton  exitButton;
	private JPanel mainPanel;

	// for create and display trainee
	private JPanel trainingPanel;
	private JPanel traineePanel;
	private JPanel traineeLayoutPanel1;
	private JPanel traineeIconPanel;
	private JPanel traineeInfoPanel;
	private JLabel traineeIconLabel;
	private JLabel traineeNameLabel;
	private JLabel[] traineeEVLabels;
	private String[] traineeEVs = {"HP:", "Atk:", "Def:\t", "Sp.Atk:\t", "Sp.Def:\t", "Spd:\t"};
	private Icon traineeIcon;
	private JButton changeTraineeButton;

	// for training
	private JPanel opponentPanel;
	private Location selectedLocation;
	private JButton[] opponentButtons;
	private Trainee selectedTrainee;
	
	// for select power item
	private JPanel itemPanel;
	private JRadioButton[] itemButtons;

	// for select location
	private JPanel locationPanel;

	// for display training history
	private JPanel historyPanel;

	/* Creates new form EquipmentSuppliesPage */
	public TrainingPage() {
		initComponents();
		refreshData();
	}

	private void initComponents() {
		
		Manager m = Manager.getInstance();
		// for testing
		selectedLocation = m.getLocation(0);
		
		// elements for error message
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);

		// for training
		trainingPanel = new JPanel();
		traineePanel = new JPanel();
		traineeLayoutPanel1 = new JPanel();
		traineeIconPanel = new JPanel();
		traineeInfoPanel = new JPanel();
		opponentPanel = new JPanel();
		
		trainingPanel.setBackground(Color.PINK);
		trainingPanel.setPreferredSize(new Dimension(900, 900));
		trainingPanel.add(traineePanel, BorderLayout.NORTH);
		trainingPanel.add(opponentPanel, BorderLayout.SOUTH);
		
		traineePanel.setPreferredSize(new Dimension(850,500));
		traineePanel.add(traineeLayoutPanel1, BorderLayout.WEST);
		traineePanel.add(traineeInfoPanel, BorderLayout.EAST);

		traineeLayoutPanel1.setPreferredSize(new Dimension(400, 450));
		traineeLayoutPanel1.add(traineeIconPanel);
		
		traineeIconPanel.setBackground(Color.YELLOW);
		traineeIconPanel.setPreferredSize(new Dimension(350, 350));
		
		changeTraineeButton = new JButton("Change Trainee");
		changeTraineeButton.setFont(new Font("Arial", Font.BOLD, 20));
		changeTraineeButton.setBackground(Color.PINK);
		changeTraineeButton.setPreferredSize(new Dimension(300, 80));
		traineeLayoutPanel1.add(changeTraineeButton);
		
		traineeIconLabel = new JLabel();
		traineeIconPanel.add(traineeIconLabel);
		
		traineeIcon = m.getTrainee(0).getPokemon().getimage();
		traineeIconLabel.setIcon(traineeIcon);
		
		traineeInfoPanel.setBackground(Color.RED);
		traineeInfoPanel.setPreferredSize(new Dimension(400, 450));
		traineeNameLabel = new JLabel();
		traineeNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
		traineeNameLabel.setPreferredSize(new Dimension(350, 50));
		traineeNameLabel.setText("Name: " + m.getTrainee(0).getPokemon().getName());
		traineeInfoPanel.add(traineeNameLabel);
		traineeEVLabels = new JLabel[6];
		for (int x = 0; x < traineeEVLabels.length; x++) {
			traineeEVLabels[x] = new JLabel();
			traineeEVLabels[x].setFont(new Font("Arial", Font.BOLD, 20));
			traineeEVLabels[x].setPreferredSize(new Dimension(350, 50));
			traineeEVLabels[x].setText(String.format("%s     %s", traineeEVs[x], Integer.toString(m.getTrainee(0).getEV(x))));
			traineeInfoPanel.add(traineeEVLabels[x]);
		}
		
		opponentPanel.setPreferredSize(new Dimension(850, 370));
		opponentPanel.setBackground(Color.GREEN);
		opponentButtons = new JButton[selectedLocation.getPokemons().size()];
		for (int x = 0; x < opponentButtons.length; x++) {
			opponentButtons[x] = new JButton();
			opponentButtons[x].setBackground(Color.RED);
			opponentButtons[x].setIcon(selectedLocation.getPokemon(x).getimage());
			opponentButtons[x].setPreferredSize(new Dimension(400, 200));
			opponentPanel.add(opponentButtons[x]);
		}
		// for display history
		historyPanel = new JPanel();
		historyPanel.setPreferredSize(new Dimension(450, 900));
		historyPanel.setBackground(Color.BLUE);

		// for selecting location
		locationPanel = new JPanel();
		locationPanel.setPreferredSize(new Dimension(450, 900));
		locationPanel.setBackground(Color.ORANGE);

		// for select power item
		itemPanel = new JPanel();
		itemPanel.setBackground(Color.PINK);
		itemButtons = new JRadioButton[7];
		itemButtons[0] = new JRadioButton("Macho Brace (2x)");
		itemButtons[1] = new JRadioButton("Power Weight (HP)");
		itemButtons[2] = new JRadioButton("Power Anklet (Spd)");
		itemButtons[3] = new JRadioButton("Power Bracer (Atk)");
		itemButtons[4] = new JRadioButton("Power Belt (Def)");
		itemButtons[5] = new JRadioButton("Power Lens (Sp. Atk)");
		itemButtons[6] = new JRadioButton("Power Band (Sp. Def)");

		ButtonGroup group = new ButtonGroup();
		for (int x = 0; x < itemButtons.length; x++)
			group.add(itemButtons[x]);

		for (int x = 0; x < itemButtons.length; x++) {
			itemButtons[x].setBackground(Color.PINK);
			itemButtons[x].setFont(new Font("Arial", Font.PLAIN, 20));
			itemButtons[x].setPreferredSize(new Dimension(260, 70));
			itemButtons[x].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					// TODO Auto-generated method stub
				}
			});
			itemPanel.add(itemButtons[x]);
		}

		// for general settings
		blankPanel = new JPanel();
		blankPanel.setBackground(Color.PINK);
		mainPanel =new JPanel();
		mainPanel.setBackground(Color.CYAN);
		mainPanel.add(locationPanel, BorderLayout.WEST);
		mainPanel.add(trainingPanel, BorderLayout.CENTER);
		mainPanel.add(historyPanel, BorderLayout.EAST);

		exitButton = new JButton("X");
		exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font("Arial", Font.BOLD, 24));
		exitButton.setBackground(Color.GRAY);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
				GraphicsDevice vc = env.getDefaultScreenDevice();
				Window w = vc.getFullScreenWindow();
				if (w != null)
					w.dispose();
				vc.setFullScreenWindow(null);
			}
		});

		// layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
						.addComponent(blankPanel)
						.addComponent(exitButton, 50, 50, 50))
				.addComponent(itemPanel)
				.addComponent(mainPanel)
				);

		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
						.addComponent(blankPanel, 50, 50, 50)
						.addComponent(exitButton, 50, 50, 50)
						)
				.addComponent(itemPanel, 80, 80, 80)
				.addComponent(mainPanel)
				);
		refreshData();
	}

	private void refreshData() {

	}

	public void run(DisplayMode dm){
		//		getContentPane().setBackground(Color.BLUE);
		//		this.setForeground(Color.WHITE);

		Screen screen = new Screen();
		screen.setFullScreen(dm, this);
	}

}
