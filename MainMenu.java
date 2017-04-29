import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainMenu {
// variables and locals to this class
	private JLabel title;
	private JButton play;
	private JButton leaderStats;
	

	public MainMenu(){
		//Below is the decloration of the main components of the interface.
		JFrame screen = new JFrame(); 
		JPanel mainPanel = new JPanel();
		JPanel menuPanel = new JPanel();
		BorderLayout firstLayout = new BorderLayout();
		GridLayout secondLayout = new GridLayout(3,1);
		
		//Setting up the main components
		screen.setContentPane(mainPanel);
		mainPanel.setLayout(firstLayout);
		mainPanel.add("Center", menuPanel);
		menuPanel.setLayout(secondLayout);
		
		//Setting text
		title = new JLabel("Main Menu");
		play = new JButton("Play!");
		leaderStats = new JButton("Leaderboard!");
		
		//Setting menu
		menuPanel.add(title);
		menuPanel.add(play);
		menuPanel.add(leaderStats);
		
		
		//Settings for the window
		screen.setVisible(true);
		screen.setTitle("Puzzle Game...");
		screen.setSize(800,650);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}