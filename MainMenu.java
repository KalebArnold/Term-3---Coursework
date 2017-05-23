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
	private Leaderboard leader;
	private int level = 0; // Easy = 1, Medium = 2, Hard = 3
	

	public MainMenu()
	{
		leader = new Leaderboard();
		g = new Game();
		//Below is the decloration of the main components of the interface.
		JFrame screen = new JFrame(); 
		JPanel menuPanel = new JPanel();
		JPanel gamePanel = new JPanel();
		GridLayout mainLayout = new GridLayout(3,1);
		BorderLayout gameLayout = new BorderLayout();
		
		//Setting up the main components
		screen.setContentPane(menuPanel);
		menuPanel.setLayout(mainLayout);
		gamePanel.setLayout(gameLayout);
		
		//Setting text
		title = new JLabel("Main Menu", SwingConstants.CENTER);
		playEasy = new JButton("Easy!");
		playMedium = new JButton("Medium!");
		playHard = new JButton("Hard!");
		leaderStats = new JButton("Leaderboard!");
		
		//Setting menu
		menuPanel.add(title);
		menuPanel.add(gamePanel);
		menuPanel.add(leaderStats);
		gamePanel.add("West", playEasy);
		gamePanel.add("Center", playMedium);
		gamePanel.add("East", playHard);
		
		/**
		**This is where all the buttons work from (Easy, Medium, Hard and Leaderboard buttons)
		**/
		
		
		playEasy.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				g.visible();
				level = 1;
				levelUpdate();
				g.setText();
			} 
		} );
		playMedium.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				g.visible();
				level = 2;
				levelUpdate();
				g.setText();
			} 
		} );
		playHard.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				g.visible();
				level = 3;
				levelUpdate();
				g.setText();
			} 
		} );
		leaderStats.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				leader.visible();
			} 
		} );
		
		
		//Settings for the window
		screen.setVisible(true);
		screen.setTitle("Puzzle Game...");
		screen.setSize(400,350);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void levelUpdate()
	{
		if (level == 1)
		{
			g.getDifficulty(1);
		}
		if (level == 2)
		{
			g.getDifficulty(2);
		}
		if (level == 3)
		{
			g.getDifficulty(3);
		}
	}

	public void updateTime()
	{
		g.updateTime();
	}
	
}