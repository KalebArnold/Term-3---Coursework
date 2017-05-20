import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Leaderboard 
{
	
	private JFrame screen;
	private JPanel mainPanel;
	private JPanel easyPanel;
	private JPanel mediumPanel;
	private JPanel hardPanel;
	private JLabel title;
	
	
	
	
	public Leaderboard(){
		
		
		//main components
		screen = new JFrame();
		mainPanel = new JPanel();
		easyPanel = new JPanel();
		mediumPanel = new JPanel();
		hardPanel = new JPanel();
		
		
		//Declare Layouts
		GridLayout mainLayout = new GridLayout(4,1);
		GridLayout easyLayout = new GridLayout(4,1);
		GridLayout mediumLayout = new GridLayout(4,1);
		GridLayout hardLayout = new GridLayout(4,1);
		
		//setLayouts
		screen.setContentPane(mainPanel);
		mainPanel.setLayout(mainLayout);
		easyPanel.setLayout(easyLayout);
		mediumPanel.setLayout(mediumLayout);
		hardPanel.setLayout(hardLayout);
		
		
		title = new JLabel("Leaderboard", SwingConstants.CENTER);
		
		
		mainPanel.add(title);
		mainPanel.add(easyPanel);
		mainPanel.add(mediumPanel);
		mainPanel.add(hardPanel);
		
		
		screen.setVisible(false);
		screen.setTitle("Leaderboard");
		screen.setSize(200, 300);
		screen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	
	public void visible()
	{
		screen.setVisible(true);
	}
	
}