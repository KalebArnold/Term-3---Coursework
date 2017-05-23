import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
* @author Kaleb Arnold
* This class is the leader board class:
* Easy/medium/hard leaderboards. (this also gets the score from the game via the main menu and this also sends the high scores back to the game)
* Declaring variables
* Including: 
* - Buttons for the main menu
* - Player postions
* - Level stats and all the Swing variables
**/
public class Leaderboard 
{
	
	private JFrame screen;
	private JPanel mainPanel;
	private JPanel easyPanel;
	private JPanel mediumPanel;
	private JPanel hardPanel;
	private JLabel title;
	private JLabel easyTitle;
	private JLabel mediumTitle;
	private JLabel hardTitle;
	
	private int[] easyLeader = {60, 100, 40};	
	private int[] mediumLeader = {450, 600, 1000};	
	private int[] hardLeader = {600, 800, 1000};	
	private String[] position = {"First: ", "Second: ", "Third: "};
	
	private JLabel[] easyScore = new JLabel[3];
	private JLabel[] mediumScore = new JLabel[3];
	private JLabel[] hardScore = new JLabel[3];
	
	private int min = 0;
	private int easyTime;
	private int mediumTime;
	private int hardTime;
	
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
		
		updateBoard();
		
		//easyScore[0] = new JLabel ("1. " +easyLeader )
		easyTitle = new JLabel("Easy Leaderboard", SwingConstants.CENTER);
		easyPanel.add(easyTitle);
		for (int i = 0; i < 3; i ++)
		{
			int temp = easyLeader[i];
			for (int j = 0; temp >= 60; j++)
			{
				temp -= 60;
				min++;
			}
			if (temp <= 9){
					easyScore[i] = new JLabel(position[i] +min+ ":"+"0" +temp, SwingConstants.CENTER);
			} else {
				easyScore[i] = new JLabel(position[i] +min+ ":" +temp, SwingConstants.CENTER);
			}
			easyPanel.add(easyScore[i]);
			min = 0;
		}
		
		mediumTitle = new JLabel("Medium Leaderboard", SwingConstants.CENTER);
		mediumPanel.add(mediumTitle);
		for (int i = 0; i < 3; i ++)
		{
			int temp = mediumLeader[i];
			for (int j = 0; temp >= 60; j++)
			{
				temp -= 60;
				min++;
			}
			if (temp <= 9){
				mediumScore[i] = new JLabel(position[i]+min+ ":" +"0"+temp, SwingConstants.CENTER);
			} else {
				mediumScore[i] = new JLabel(position[i] +min+ ":" +temp, SwingConstants.CENTER);
			}
			mediumPanel.add(mediumScore[i]);
			min = 0;
		}
		
		hardTitle = new JLabel("Hard Leaderboard", SwingConstants.CENTER);
		hardPanel.add(hardTitle);
		for (int i = 0; i < 3; i ++)
		{
			int temp = hardLeader[i];
			for (int j = 0; temp >= 60; j++)
			{
				temp -= 60;
				min++;
			}
			if (temp <= 9){
					hardScore[i] = new JLabel(position[i] +min+ ":"+"0" +temp, SwingConstants.CENTER);
			} else {
				hardScore[i] = new JLabel(position[i] +min+ ":" +temp, SwingConstants.CENTER);
			}
			hardPanel.add(hardScore[i]);
			min = 0;
		}
		
		
		screen.setVisible(false);
		screen.setTitle("Leaderboard");
		screen.setSize(450, 450);
		screen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	
	private void updateBoard()
	{
		for (int i = 1; i<easyLeader.length; i++)
		{
			int x = easyLeader[i];
			int j;
			for (j=i-1; j>=0 && easyLeader[j]>x; j--){
				easyLeader[j+1] = easyLeader[j];
			}
			easyLeader[j+1] = x;
		}		
		for (int i = 1; i<mediumLeader.length; i++)
		{
			int x = mediumLeader[i];
			int j;
			for (j=i-1; j>=0 && mediumLeader[j]>x; j--){
				mediumLeader[j+1] = mediumLeader[j];
			}
			mediumLeader[j+1] = x;
		}	
		for (int i = 1; i<hardLeader.length; i++)
		{
			int x = hardLeader[i];
			int j;
			for (j=i-1; j>=0 && hardLeader[j]>x; j--){
				hardLeader[j+1] = hardLeader[j];
			}
			hardLeader[j+1] = x;
		}	
		
		
	}
	public void updateText()
	{
		for (int i = 0; i < 3; i ++)
		{
			int temp = easyLeader[i];
			for (int j = 0; temp >= 60; j++)
			{
				temp -= 60;
				min++;
			}
			if (temp <= 9){
					easyScore[i].setText("" +position[i] +min+ ":" +"0"+temp );
			} else {
				easyScore[i].setText("" +position[i] +min+ ":" +temp);
			}
			min = 0;
		}
		for (int i = 0; i < 3; i ++)
		{
			int temp = mediumLeader[i];
			for (int j = 0; temp >= 60; j++)
			{
				temp -= 60;
				min++;
			}
			if (temp <= 9){
				mediumScore[i].setText("" +position[i]+min+ ":"+"0" +temp);
			} else {
				mediumScore[i].setText("" +position[i] +min+ ":" +temp);
			}
			min = 0;
		}
		for (int i = 0; i < 3; i ++)
		{
			int temp = hardLeader[i];
			for (int j = 0; temp >= 60; j++)
			{
				temp -= 60;
				min++;
			}
			if (temp <= 9){
				hardScore[i].setText("" +position[i] +min+ ":"+"0" +temp);
			} else {
				hardScore[i].setText("" +position[i] +min+ ":" +temp);
			}
			min = 0;
		}
	}
	
	public void visible()
	{
		screen.setVisible(true);
	}
	/*public void refreshLeader()
	{
		updateEasy();
		updateMedium();
		updateHard();
	}*/
	
	
	private void updateEasy(){
		if (easyTime >= 1)
		{
			if (easyLeader[2] > easyTime)
			{
				easyLeader[2] = easyTime;
				System.out.println("asdasd" + easyLeader[2]);
				System.out.println("asdasd" + easyTime);
				easyTime = 0;
			}
		}
		updateBoard();
		updateText();
	}
	private void updateMedium(){
		if (mediumTime >= 5)
		{
			if (mediumLeader[2] > mediumTime)
			{
				mediumLeader[2] = mediumTime;
				mediumTime = 0;
			}
		}
		updateBoard();
	}
	private void updateHard(){
		if (hardTime >= 5)
		{
			if (hardLeader[2] > hardTime)
			{
				hardLeader[2] = hardTime;
				hardTime = 0;
			}
		}
		updateBoard();
	}
	
	public void setEasy()
	{
		updateEasy();
	}
	public void setMedium()
	{
		updateMedium();
	}
	public void setHard()
	{
		updateHard();
	}
	
	public void getEasy(int x)
	{
		easyTime = x;
		System.out.println("xxxxx " + x);
	}
	public void getMedium(int x)
	{
		mediumTime = x;
	}
	public void getHard(int x)
	{
		hardTime = x;
	}
	
	public int easyHigh(){
		return easyLeader[0];
	}
	public int mediumHigh(){
		return mediumLeader[0];
	}
	public int hardHigh(){
		return hardLeader[0];
	}
	
	
	
}