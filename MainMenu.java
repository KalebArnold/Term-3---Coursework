import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


/**
* @author Kaleb Arnold
* This class is the main menu class:
* Easy/medium/hard buttons and leaderboard. (this is also used for the transfer of variables from the game to the leaderboard)
* Declaring variables
* Including: 
* - Buttons for the main menu
* - Player postions
* - Level stats and all the Swing variables
**/

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
		
	// this is the easy button
		playEasy.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				g.visible();
				level = 1;
				levelUpdate();
				g.setText();
				g.resetLevelCounter(0);
				easyHigh();
			} 
		} );
		// this is the medium button
		playMedium.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				g.visible();
				level = 2;
				levelUpdate();
				g.setText();
				g.resetLevelCounter(0);
				mediumHigh();
			} 
		} );
		// this is the hard button
		playHard.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				g.visible();
				level = 3;
				levelUpdate();
				g.setText();
				g.resetLevelCounter(0);
				hardHigh();
			} 
		} );
		// this is the leaderboard button
		leaderStats.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				leader.visible();
				if (level == 1)
				{
					easyScore();
				}
				else if (level == 2)
				{
					mediumScore();
				}
				else if (level == 3)
				{
					hardScore();
				}
				
				
				
				
			} 
		} );
		
		
		//Settings for the window
		screen.setVisible(true);
		screen.setTitle("Puzzle Game...");
		screen.setSize(400,350);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// this tells the game what difficulty the game should be on
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
// These are the things which push your game score into the leaderboards
	public void easyScore()
	{
		System.out.println("Final Time: " +g.pushEasy());
		leader.getEasy(g.pushEasy());
		leader.setEasy();
	}
	public void hardScore()
	{
		leader.getHard(g.pushHard());
		leader.setHard();
	}
	public void mediumScore()
	{
		leader.getMedium(g.pushMedium());
		leader.setMedium();
	}
	// These are the things which put the high score into the game interface
	private void easyHigh()
	{
		g.easyHighScore(leader.easyHigh());
		g.setText();
	}
	private void mediumHigh()
	{
		g.mediumHighScore(leader.mediumHigh());
		g.setText();
	}
	private void hardHigh()
	{
		g.hardHighScore(leader.hardHigh());
		g.setText();
	}
	//This is used to update the time
	public void updateTime()
	{
		g.updateTime();
	}
	private void resetTime()
	{
		g.resetTopScore();
	}
	
}