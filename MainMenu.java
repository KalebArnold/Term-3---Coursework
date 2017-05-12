import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainMenu {
// variables and locals to this class
	private JLabel title;
	private JButton play;
	private JButton leaderStats;
	private Game g;

	public MainMenu(){
		g = new Game();
		//Below is the decloration of the main components of the interface.
		JFrame screen = new JFrame(); 
		JPanel menuPanel = new JPanel();
		GridLayout mainLayout = new GridLayout(3,1);
		
		//Setting up the main components
		screen.setContentPane(menuPanel);
		menuPanel.setLayout(mainLayout);
		
		//Setting text
		title = new JLabel("Main Menu", SwingConstants.CENTER);
		play = new JButton("Play!");
		leaderStats = new JButton("Leaderboard!");
		
		//Setting menu
		menuPanel.add(title);
		menuPanel.add(play);
		menuPanel.add(leaderStats);
		
		//Making the buttons work.
		play.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				g.visible();
				//g.drawBackground();
			} 
		} );
		
		
		
		//Settings for the window
		screen.setVisible(true);
		screen.setTitle("Puzzle Game...");
		screen.setSize(400,350);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}