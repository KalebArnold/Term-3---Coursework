import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainMenu 
{
// variables and locals to this class
	private JLabel title;
	private JButton play;
	private JButton playEasy;
	private JButton playMedium;
	private JButton playHard;
	private JButton leaderStats;
	private Game g;
	
	private int level = 0; // Easy = 1, Medium = 2, Hard = 3
	

	public MainMenu()
	{
		g = new Game();
		//Below is the decloration of the main components of the interface.
		JFrame screen = new JFrame(); 
		JPanel menuPanel = new JPanel();
		JPanel gamePanel = new JPanel();
		GridLayout mainLayout = new GridLayout(4,1);
		BorderLayout gameLayout = new BorderLayout();
		
		//Setting up the main components
		screen.setContentPane(menuPanel);
		menuPanel.setLayout(mainLayout);
		gamePanel.setLayout(gameLayout);
		
		//Setting text
		title = new JLabel("Main Menu", SwingConstants.CENTER);
		play = new JButton("Play!");
		playEasy = new JButton("Easy!");
		playMedium = new JButton("Medium!");
		playHard = new JButton("Hard!");
		leaderStats = new JButton("Leaderboard!");
		
		//Setting menu
		menuPanel.add(title);
		menuPanel.add(play);
		menuPanel.add(gamePanel);
		menuPanel.add(leaderStats);
		gamePanel.add("West", playEasy);
		gamePanel.add("Center", playMedium);
		gamePanel.add("East", playHard);
		
		//Making the buttons work.
		play.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				g.visible();
			} 
		} );
		
		
		
		//Settings for the window
		screen.setVisible(true);
		screen.setTitle("Puzzle Game...");
		screen.setSize(400,350);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void 

}