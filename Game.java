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
	private int gameX = 0;
	private int gameY = 0;
	private int invTileNum = 0;
	private int backSelect = 0;
	private int checkLevel = 0;
	
	private JButton map[][] = new JButton[13][13];
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
	private ImageIcon logImage = new ImageIcon("Images/stump1.jpg");
	private ImageIcon bottomLogImage = new ImageIcon("Images/stump2.jpg");
	private ImageIcon topLogImage = new ImageIcon("Images/stump3.jpg");
	
	
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
		levelSetup();
		
		
		
		//Tile print
		
		
		
		/*map[].addActionListener(new ActionListener() 
		{ 
			public void mouseEntered(MouseEvent e) 
			{ 
				print(""+ tileNum+"");
			} 
		} );*/
		
		
		
		
		
		
		//Settings for the window
		screen.setVisible(false);
		screen.setTitle("Puzzle Game...");
		screen.setSize(576,456);
		screen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	private void backgroundSetup()
	{
		for(int i = 0; i<rows; i++){
			
			background();
			
			if (i == 0){
				map[i][gameX] = new JButton(topImage);
			} else if (i == 12){
				map[i][gameX] = new JButton(bottomImage);
			} else if (backSelect <= 17){
				map[i][gameX] = new JButton(backgroundImageOne);
			} else if (backSelect == 18){
				map[i][gameX] = new JButton(backgroundImageTwo);
			} else if (backSelect == 19){
				map[i][gameX] = new JButton(backgroundImageThree);
			} else if (backSelect == 20){
				map[i][gameX] = new JButton(backgroundImageFour);
			}
		
			map[i][gameX].setMargin(new Insets(0,0,0,0));
			map[i][gameX].setBorder(null);
			gamePanel.add(map[i][gameX]);
			//i = gameY;
			
			for (int j = 0; j<columns; j++){
				background();
				if (i == 0){
					map[i][j] = new JButton(topImage);
				} else if (i == 12){
					map[i][j] = new JButton(bottomImage);
				} else if (backSelect <= 17){
					map[i][j] = new JButton(backgroundImageOne);
				} else if (backSelect == 18){
					map[i][j] = new JButton(backgroundImageTwo);
				} else if (backSelect == 19){
					map[i][j] = new JButton(backgroundImageThree);
				} else if (backSelect == 20){
					map[i][j] = new JButton(backgroundImageFour);
				}
				map[i][j].setMargin(new Insets(0,0,0,0));
				map[i][j].setBorder(null);
				gamePanel.add(map[i][j]);
				gameX = j;
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
	
	private void levelSetup(){
		
		if (checkLevel == 0){
			levelOne();
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
	
	private void levelOne()
	{
		map[0][2].setIcon(topLogImage);
		map[2][2].setIcon(logImage);
		map[2][4].setIcon(logImage);
		map[5][4].setIcon(logImage);
		map[5][5].setIcon(logImage);
		map[8][5].setIcon(logImage);
		map[10][5].setIcon(logImage);
		map[10][7].setIcon(logImage);
		map[12][7].setIcon(bottomLogImage);
	}

}