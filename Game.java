import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class Game {
// variables and locals to this class
	private int rows = 13;
	private int columns = 9;
	private int invRows = 13;
	private int invColumns = 5;
	private int tileNum = 0;
	private int invTileNum = 0;
	private int backSelect = 0;
	
	private JButton map[] = new JButton[225];
	private JButton inventory[] = new JButton[225];
	private JFrame screen;
	private JPanel mainPanel;
	private JPanel gamePanel;
	private JPanel invPanel;
	
	private Random rnd = new Random();

//	Log variables
	private boolean log = false;
	private boolean longLog = false;
	
// Images for the game
	private ImageIcon topImage = new ImageIcon("Images/bank2.jpg");
	private ImageIcon bottomImage = new ImageIcon("Images/bank1.jpg");
	private ImageIcon backgroundImageOne = new ImageIcon("Images/water1.jpg");
	private ImageIcon backgroundImageTwo = new ImageIcon("Images/water2.jpg");
	private ImageIcon backgroundImageThree = new ImageIcon("Images/water3.jpg");
	private ImageIcon backgroundImageFour = new ImageIcon("Images/water4.jpg");
	
	
	
	public Game(){
		//Below is the decloration of the main components of the interface.
		screen = new JFrame(); 
		gamePanel = new JPanel();
		mainPanel = new JPanel();
		invPanel = new JPanel();
		BorderLayout mainLayout = new BorderLayout();
		GridLayout gameLayout = new GridLayout(rows,columns);
		GridLayout invLayout = new GridLayout(invRows, invColumns);
		
		
		//Setting up the main components
		screen.setContentPane(mainPanel);
		mainPanel.setLayout(mainLayout);
		gamePanel.setLayout(gameLayout);
		invPanel.setLayout(invLayout);
		
		mainPanel.add("West", gamePanel);
		mainPanel.add("East", invPanel);
		
		
		//Setting tiles
		backgroundSetup();
		inventorySetup();
		
		
		//Settings for the window
		screen.setVisible(false);
		screen.setTitle("Puzzle Game...");
		screen.setSize(576,456);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void backgroundSetup()
	{
		for(int i = 0; i<rows; i++){
			
			background();
			
			if (i == 0){
				map[tileNum] = new JButton(topImage);
			} else if (i == 12){
				map[tileNum] = new JButton(bottomImage);
			} else if (backSelect <= 17){
				map[tileNum] = new JButton(backgroundImageOne);
			} else if (backSelect == 18){
				map[tileNum] = new JButton(backgroundImageTwo);
			} else if (backSelect == 19){
				map[tileNum] = new JButton(backgroundImageThree);
			} else if (backSelect == 20){
				map[tileNum] = new JButton(backgroundImageFour);
			}
		
			map[tileNum].setMargin(new Insets(0,0,0,0));
			map[tileNum].setBorder(null);
			gamePanel.add(map[tileNum]);
			tileNum++;
			
			for (int j = 0; j<columns; j++){
				background();
				if (i == 0){
					map[tileNum] = new JButton(topImage);
				} else if (i == 12){
					map[tileNum] = new JButton(bottomImage);
				} else if (backSelect <= 17){
					map[tileNum] = new JButton(backgroundImageOne);
				} else if (backSelect == 18){
					map[tileNum] = new JButton(backgroundImageTwo);
				} else if (backSelect == 19){
					map[tileNum] = new JButton(backgroundImageThree);
				} else if (backSelect == 20){
					map[tileNum] = new JButton(backgroundImageFour);
				}
				map[tileNum].setMargin(new Insets(0,0,0,0));
				map[tileNum].setBorder(null);
				gamePanel.add(map[tileNum]);
				tileNum++;
			}
		}
	}
	
	private void inventorySetup()
	{
		for(int i = 0; i<invRows; i++)
		{
			if (i == 0){
				inventory[invTileNum] = new JButton(topImage);
			} else if (i == 12){
				inventory[invTileNum] = new JButton(bottomImage);
			} else {
				inventory[invTileNum] = new JButton(backgroundImageOne);
			}
			inventory[invTileNum].setMargin(new Insets(0,0,0,0));
			inventory[invTileNum].setBorder(null);
			invPanel.add(inventory[invTileNum]);
			invTileNum++;
			for(int j = 0; j<invColumns; j++){
				if (i == 0){
					inventory[invTileNum] = new JButton(topImage);
				} else if (i == 12){
					inventory[invTileNum] = new JButton(bottomImage);
				} else {
					inventory[invTileNum] = new JButton(backgroundImageOne);
				}
				inventory[invTileNum].setMargin(new Insets(0,0,0,0));
				inventory[invTileNum].setBorder(null);
				invPanel.add(inventory[invTileNum]);
				invTileNum++;
			}
		}
	}
	
	
	public void visible()
	{
		screen.setVisible(true);
		
	}
	
	private void background()
	{
		backSelect = rnd.nextInt((20 - 0) + 1) + 0;
	}

}