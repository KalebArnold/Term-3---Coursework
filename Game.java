import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class Game implements MouseListener{
// variables and locals to this class
/**
* This class is the main game class:
* Player Movement, Plank Placing, Level loading, Inventory Update.
* Declaring variables
* Including: 
* - Array for the map and inventory
* - Player postions
* - Level stats and all the Swing variables
**/
	private int rows = 13;
	private int columns = 9;
	private int invRows = 13;
	private int invColumns = 4;
	private int gameX = 0;
	private int gameY = 0;
	private int invX = 0;
	private int backSelect = 0; //This is for the random for the background select.
	private int checkLevel = 0;
	private int difficulty = 0; //Easy = 1; Medium = 2; Hard = 3
	private int level = 0;// Easy = 1 Levels; Medium = 3 Levels; Hard = 6
	private int mapX = 0;
	private int mapY = 0;
	private int playerX = 0;
	private int playerY = 0;
	private boolean playerCheck = false;
	
	private JButton map[][] = new JButton[rows][columns];
	private JButton inventory[][] = new JButton[invRows][invColumns];
	
	private JFrame screen;
	private JPanel mainPanel;
	private JPanel gamePanel;
	private JPanel invPanel;
	private JPanel textPanel;
	private JLabel timeLabel;
	private JLabel levelLabel;
	private JLabel difLabel;
	private JLabel bestTime;
	
	private Random rnd = new Random();
	private Graphics graph = new Graphics();
	private Level lvl = new Level();

	//Log variables
	private boolean log = false;
	private boolean longLog = false;
	
	//private Timer timer;
	
	public Game(){
		//Below is the decloration of the main components of the interface.
		screen = new JFrame(); 
		gamePanel = new JPanel();
		mainPanel = new JPanel();
		invPanel = new JPanel();
		textPanel = new JPanel();
		BorderLayout mainLayout = new BorderLayout();
		GridLayout gameLayout = new GridLayout(rows,columns);
		GridLayout invLayout = new GridLayout(invRows, invColumns);
		GridLayout textLayout = new GridLayout(1, 4);
		
		
		//Setting up the main components
		screen.setContentPane(mainPanel);
		mainPanel.setLayout(mainLayout);
		gamePanel.setLayout(gameLayout);
		invPanel.setLayout(invLayout);
		textPanel.setLayout(textLayout);
		
		//Positing the GUI
		mainPanel.add("West", gamePanel);
		mainPanel.add("East", invPanel);
		mainPanel.add("North", textPanel);
		
		//Adding the text
		
		difLabel = new JLabel("Difficulty: Null");
		levelLabel = new JLabel("Level: " + level);
		
		
		textPanel.add(levelLabel);
		textPanel.add(difLabel);
		
		
		//Setting tiles
		backgroundSetup();
		inventorySetup();
		
		
		//JLabel score = new JLabel("Score: " + timer.getTime());
		
		//Settings for the window
		screen.setVisible(false);
		screen.setTitle("Puzzle Game...");
		screen.setSize(((16*32)-16),(rows*32));
		screen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			for(int i=0; i <= (rows-1); i++){
				for (int j=0; j <= (columns-1); j++){
					if (e.getSource() == map[i][j]){
						mapX = i;
						mapY = j;
					}
				
				}
			}
			//Picking up in a vertical position
			if (map[mapX][mapY].getIcon().equals(graph.getPlankV()))
			{
				if (!log && !longLog)
				{
					if (playerX == (mapX+1) && (map[mapX][mapY].getIcon().equals(graph.getPlankV()))&& (map[mapX-1][mapY].getIcon().equals(graph.getPlankV())))
					{					
						if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan())))
						{
							map[mapX][mapY].setIcon(graph.getWaterOne());
							map[mapX-1][mapY].setIcon(graph.getWaterOne());
							longLog = true;
							invUpdate();
						}	
					} 
					else if (playerX == (mapX-1) && (map[mapX][mapY].getIcon().equals(graph.getPlankV()))&& (map[mapX+1][mapY].getIcon().equals(graph.getPlankV())))
					{					
						if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan())))
						{
							map[mapX][mapY].setIcon(graph.getWaterOne());
							map[mapX+1][mapY].setIcon(graph.getWaterOne());
							longLog = true;
							invUpdate();
						}	
					} 
					else if (playerX == (mapX+1) || playerX == (mapX-1))
					{					
						if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan())))
						{
							map[mapX][mapY].setIcon(graph.getWaterOne());
							log = true;
							invUpdate();
						}	
					} 
				}
				//Placing in a vertical position
			} else if ((map[mapX][mapY].getIcon().equals(graph.getWaterOne())) || (map[mapX][mapY].getIcon().equals(graph.getWaterTwo())) || (map[mapX][mapY].getIcon().equals(graph.getWaterThree())) || (map[mapX][mapY].getIcon().equals(graph.getWaterFour())))
			{	
				if (log){
					if (playerX == (mapX-1) && playerX <= 10 && mapY == playerY)
					{
						if ((map[playerX+2][playerY].getIcon().equals(graph.getStump())) || (map[playerX+2][playerY].getIcon().equals(graph.getTopStump())) || (map[playerX+2][playerY].getIcon().equals(graph.getBottomStump())))
						{
							if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan()))){
								placeLogV(playerX+1, mapY, 0);
							}
						}
					}else if (playerX == (mapX+1) && playerX >= 1 && mapY == playerY)
					{
						if ((map[playerX-2][playerY].getIcon().equals(graph.getStump())) || (map[playerX-2][playerY].getIcon().equals(graph.getTopStump())) || (map[playerX-2][playerY].getIcon().equals(graph.getBottomStump())))
						{
							if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan()))){
								placeLogV(playerX-1, mapY, 0);
							}
						}
					}
				}
				if (longLog){
					if (playerX == (mapX-1) && playerX <= 9 && mapY == playerY)
					{
						if ((map[playerX+3][playerY].getIcon().equals(graph.getStump())) || (map[playerX+3][playerY].getIcon().equals(graph.getTopStump())) || (map[playerX+3][playerY].getIcon().equals(graph.getBottomStump())))
						{
							if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan()))){
								placeLogV(playerX+1, mapY, 2);
							}
						}
					}else if (playerX == (mapX+1) && playerX > 2 && mapY == playerY)
					{
						if ((map[playerX-3][playerY].getIcon().equals(graph.getStump())) || (map[playerX-3][playerY].getIcon().equals(graph.getTopStump())) || (map[playerX-3][playerY].getIcon().equals(graph.getBottomStump())))
						{
							if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan()))){
								placeLogV(playerX-1, mapY, 1);
							}
						}
					}
				}
			}
			// Picking up planks in a horizontal position
			if (map[mapX][mapY].getIcon().equals(graph.getPlankH()))
			{
				if (!log && !longLog)
				{
					if (playerX == (mapY+1) && (map[mapX][mapY].getIcon().equals(graph.getPlankV()))&& (map[mapY-1][mapY].getIcon().equals(graph.getPlankV())))
					{					
						if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan())))
						{
							map[mapX][mapY].setIcon(graph.getWaterOne());
							map[mapX][mapY-1].setIcon(graph.getWaterOne());
							longLog = true;
							invUpdate();
						}	
					} 
					else if (playerX == (mapX-1) && (map[mapX][mapY].getIcon().equals(graph.getPlankV()))&& (map[mapX+1][mapY].getIcon().equals(graph.getPlankV())))
					{					
						if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan())))
						{
							map[mapX][mapY].setIcon(graph.getWaterOne());
							map[mapX][mapY+1].setIcon(graph.getWaterOne());
							longLog = true;
							invUpdate();
						}	
					}
					else if (playerY == (mapY+1) || playerY == (mapY-1))
					{
						if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan()))){
							map[mapX][mapY].setIcon(graph.getWaterOne());
							System.out.print("A: working!");
							log = true;
							invUpdate();
						}
					} 
				}	
			} 
			// Placing planks in a horizontal position
			else if ((map[mapX][mapY].getIcon().equals(graph.getWaterOne())) || (map[mapX][mapY].getIcon().equals(graph.getWaterTwo())) || (map[mapX][mapY].getIcon().equals(graph.getWaterThree())) || (map[mapX][mapY].getIcon().equals(graph.getWaterFour())))
			{
				if (log && !longLog)
				{
					if (playerY == (mapY-1) && playerY <= 12 && mapX == playerX)
					{
						if ((map[playerX][playerY+2].getIcon().equals(graph.getStump())) || (map[playerX][playerY+2].getIcon().equals(graph.getTopStump())) || (map[playerX][playerY+2].getIcon().equals(graph.getBottomStump())))
						{
							if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan()))){
								placeLogH(mapX, playerY+1, 2);
							}
						}
					} 
					else if (playerY == (mapY+1) && playerY >= 1 && mapX == playerX)
					{
						if ((map[playerX][playerY-2].getIcon().equals(graph.getStump())) || (map[playerX][playerY-2].getIcon().equals(graph.getTopStump())) || (map[playerX][playerY-2].getIcon().equals(graph.getBottomStump())))
						{
							if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan()))){
								placeLogH(mapX, playerY-1, 1);
							}
						}
					}
				}
				if (longLog){
					if (playerY == (mapY-1) && playerY <= 12 && mapX == playerX)
					{
						if ((map[playerX][playerY+3].getIcon().equals(graph.getStump())) || (map[playerX][playerY+3].getIcon().equals(graph.getTopStump())) || (map[playerX][playerY+3].getIcon().equals(graph.getBottomStump())))
						{
							if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan()))){
								placeLogH(mapX, playerY+1, 1);
							}
						}
					}else if (playerY == (mapY+1) && playerY >= 1 && mapX == playerX)
					{
						if ((map[playerX][playerY-3].getIcon().equals(graph.getStump())) || (map[playerX][playerY-3].getIcon().equals(graph.getTopStump())) || (map[playerX][playerY-3].getIcon().equals(graph.getBottomStump())))
						{
							if ((map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())) || (map[playerX][playerY].getIcon().equals(graph.getStumpMan()))){
								placeLogH(mapX, playerY-1, 2);
							}
						}
					}
				}
			}
	}
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			for(int i=0; i <= (rows-1); i++){
				for (int j=0; j <= (columns-1); j++){
					if (e.getSource() == map[i][j]){
						System.out.println("" + i + " " + j);
						mapX = i;
						mapY = j;
					}
				
				}
			}
			if (playerCheck == false)
			{
				playerUpdate();
				playerCheck = true;
			}
			System.out.println("Player X:" +playerX+ " Y:" +playerY);
			//Vertical check for movement.
			if ((map[mapX][mapY].getIcon().equals(graph.getPlankV())) || (map[mapX][mapY].getIcon().equals(graph.getBottomStump())) || (map[mapX][mapY].getIcon().equals(graph.getStump())) || (map[mapX][mapY].getIcon().equals(graph.getTopStump())))
			{
				if (playerX == (mapX+1) || playerX == (mapX-1))
				{
					if (playerY == mapY)
					{
						if (map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())){
							map[playerX][playerY].setIcon(graph.getBottomStump());
						}
						if (map[playerX][playerY].getIcon().equals(graph.getTopStumpMan())){
							map[playerX][playerY].setIcon(graph.getTopStump());
						}
						if (map[playerX][playerY].getIcon().equals(graph.getStumpMan())){
							map[playerX][playerY].setIcon(graph.getStump());
						}
						if (map[playerX][playerY].getIcon().equals(graph.getPlankVMan())){
							map[playerX][playerY].setIcon(graph.getPlankV());
						}
						if (map[mapX][mapY].getIcon().equals(graph.getPlankV()))
						{
							map[mapX][mapY].setIcon(graph.getPlankVMan());
						}
						if (map[mapX][mapY].getIcon().equals(graph.getBottomStump()))
						{
							map[mapX][mapY].setIcon(graph.getBottomStumpMan());
						}
						if (map[mapX][mapY].getIcon().equals(graph.getStump()))
						{
							map[mapX][mapY].setIcon(graph.getStumpMan());
						}
						if (map[mapX][mapY].getIcon().equals(graph.getTopStump()))
						{
							map[mapX][mapY].setIcon(graph.getTopStumpMan());
							levelComplete();
						}
						
						playerX = mapX;
						playerY = mapY;
					}
				}  
			}			
			//Horisontal check for movement.
			if ((map[mapX][mapY].getIcon().equals(graph.getPlankH())) || (map[mapX][mapY].getIcon().equals(graph.getBottomStump())) || (map[mapX][mapY].getIcon().equals(graph.getStump())) || (map[mapX][mapY].getIcon().equals(graph.getTopStump())))
			{
				if (playerY == (mapY+1) || playerY == (mapY-1))
				{
					if (playerX == mapX)
					{
						if (map[playerX][playerY].getIcon().equals(graph.getBottomStumpMan())){
							map[playerX][playerY].setIcon(graph.getBottomStump());
						}
						if (map[playerX][playerY].getIcon().equals(graph.getTopStumpMan())){
							map[playerX][playerY].setIcon(graph.getTopStump());
						}
						if (map[playerX][playerY].getIcon().equals(graph.getStumpMan())){
							map[playerX][playerY].setIcon(graph.getStump());
						}
						if (map[playerX][playerY].getIcon().equals(graph.getPlankHMan())){
							map[playerX][playerY].setIcon(graph.getPlankH());
						}
						if (map[mapX][mapY].getIcon().equals(graph.getPlankH()))
						{
							map[mapX][mapY].setIcon(graph.getPlankHMan());
						}
						if (map[mapX][mapY].getIcon().equals(graph.getBottomStump()))
						{
							map[mapX][mapY].setIcon(graph.getBottomStumpMan());
						}
						if (map[mapX][mapY].getIcon().equals(graph.getStump()))
						{
							map[mapX][mapY].setIcon(graph.getStumpMan());
						}
						if (map[mapX][mapY].getIcon().equals(graph.getTopStump()))
						{
							map[mapX][mapY].setIcon(graph.getTopStumpMan());
						}
						playerX = mapX;
						playerY = mapY;
					}
				} 
			}		
		}
		
	}
	
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	
	private void backgroundSetup()
	{
		for(int i = 0; i<rows; i++){
			background();
			if (i == 0){
				map[i][gameX] = new JButton(graph.getTopBank());
			} else if (i == 12){
				map[i][gameX] = new JButton(graph.getBottomBank());
			} else if (backSelect <= 17){
				map[i][gameX] = new JButton(graph.getWaterOne());
			} else if (backSelect == 18){
				map[i][gameX] = new JButton(graph.getWaterTwo());
			} else if (backSelect == 19){
				map[i][gameX] = new JButton(graph.getWaterThree());
			} else if (backSelect == 20){
				map[i][gameX] = new JButton(graph.getWaterFour());
			}
			map[i][gameX].setMargin(new Insets(0,0,0,0));
			map[i][gameX].setBorder(null);
			gamePanel.add(map[i][gameX]);
			map[i][gameX].addMouseListener(this);
			for (int j = 0; j<columns; j++){
				background();
				if (i == 0){
					map[i][j] = new JButton(graph.getTopBank());
				} else if (i == 12){
					map[i][j] = new JButton(graph.getBottomBank());
				} else if (backSelect <= 17){
					map[i][j] = new JButton(graph.getWaterOne());
				} else if (backSelect == 18){
					map[i][j] = new JButton(graph.getWaterTwo());
				} else if (backSelect == 19){
					map[i][j] = new JButton(graph.getWaterThree());
				} else if (backSelect == 20){
					map[i][j] = new JButton(graph.getWaterFour());
				}
				map[i][j].setMargin(new Insets(0,0,0,0));
				map[i][j].setBorder(null);
				gamePanel.add(map[i][j]);
				map[i][j].addMouseListener(this);
				gameX = j;
			}
		}
	gameX = 0;
	}
	
	private void backgroundRefresh()
	{
		for(int i = 0; i<rows; i++){
			background();
			if (i == 0 ){
				map[i][gameX].setIcon(graph.getTopBank());
			} 
			else if (i == 12)
			{
				map[i][gameX].setIcon(graph.getBottomBank());
			} else if (backSelect <= 17){
				map[i][gameX].setIcon(graph.getWaterOne());
			} else if (backSelect == 18){
				map[i][gameX].setIcon(graph.getWaterTwo());
			} else if (backSelect == 19){
				map[i][gameX].setIcon(graph.getWaterThree());
			} else if (backSelect == 20){
				map[i][gameX].setIcon(graph.getWaterFour());
			}
			for (int j = 0; j<columns; j++){
				background();
				if (i == 0){
					map[i][j].setIcon(graph.getTopBank());
				} else if (i == 12){
					map[i][j].setIcon(graph.getBottomBank());
				} else if (backSelect <= 17){
					map[i][j].setIcon(graph.getWaterOne());
				} else if (backSelect == 18){
					map[i][j].setIcon(graph.getWaterTwo());
				} else if (backSelect == 19){
					map[i][j].setIcon(graph.getWaterThree());
				} else if (backSelect == 20){
					map[i][j].setIcon(graph.getWaterFour());
				}
				gameX = j;
			}
		}
		gameX = 0;
	}
	
	private void inventorySetup()
	{
		for(int i = 0; i<invRows; i++)
		{	
			if (i > 0 && i < 12){
				inventory[i][invX] = new JButton(graph.getPlankV());
			} else if (i == 0 && invX == 0 ){
				inventory[i][invX] = new JButton(graph.getTopStump());
			} else if (i == 12 && invX == 0 ){
				inventory[i][invX] = new JButton(graph.getBottomStump()); 
			} else if (i == 0){
				inventory[i][invX] = new JButton(graph.getTopBank());
			} else if (i == 12){
				inventory[i][invX] = new JButton(graph.getBottomBank());
			} else {
				inventory[i][invX] = new JButton(graph.getWaterOne());
			}
			inventory[i][invX].setMargin(new Insets(0,0,0,0));
			inventory[i][invX].setBorder(null);
			invPanel.add(inventory[i][invX]);
			for(int j = 0; j<invColumns; j++){
				if (i == 0){
					inventory[i][j] = new JButton(graph.getTopBank());
				} else if (i == 12){
					inventory[i][j] = new JButton(graph.getBottomBank());
				} else {
					inventory[i][j] = new JButton(graph.getWaterOne());
				}
				inventory[i][j].setMargin(new Insets(0,0,0,0));
				inventory[i][j].setBorder(null);
				invPanel.add(inventory[i][j]);
				invX = j;
			}
		invX = 0;	
		}
	}
	
	public void drawBackground()
	{
		backgroundSetup();
	}
	public void visible()
	{
		screen.setVisible(true);
		backgroundRefresh();
		getLevel();
	}
	
	private void background()
	{
		backSelect = rnd.nextInt((20 - 0) + 1) + 0;
	}
	
	private void placeLogV(int x, int y, int left)
	{
		if (log)
		{
			map[x][y].setIcon(graph.getPlankV());
			log = false;
			invUpdate();
		}
		if (longLog)
		{
			map[x][y].setIcon(graph.getPlankV());
			// left 1 means that it's going left
			if (left == 1)
			{;
				map[x-1][y].setIcon(graph.getPlankV());
				longLog = false;
				invUpdate();
			}
			// left 2 means that it's going right
			if (left == 2)
			{
				map[x+1][y].setIcon(graph.getPlankV());
				longLog = false;
				invUpdate();
			}
		}
		
	}
	private void placeLogH(int x, int y, int down)
	{
		if (log)
		{
			map[x][y].setIcon(graph.getPlankH());
			log = false;
			invUpdate();
		}
		if (longLog)
		{
			map[x][y].setIcon(graph.getPlankH());
			// down 1 means that it's going down
			if (down == 1)
			{
				map[x][y+1].setIcon(graph.getPlankH());
				longLog = false;
				invUpdate();
			}
			// down 2 means that it's going down
			if (down == 2)
			{
				map[x][y-1].setIcon(graph.getPlankH());
				longLog = false;
				invUpdate();
			}
		}
		
	}
	
	private void invUpdate()
	{
		if (log == true)
		{
			inventory[1][1].setIcon(graph.getPlankV());
		}
		if (longLog == true)
		{
			inventory[1][1].setIcon(graph.getPlankV());
			inventory[2][1].setIcon(graph.getPlankV());
		}
		if (!log && !longLog)
		{
			inventory[1][1].setIcon(graph.getWaterOne());
			inventory[2][1].setIcon(graph.getWaterOne());
		}
	}
	
	private void getLevel()
	{
		lvl.newLevel();
		int x = 0;
		int y = 0;
		String get = "";
		for (int i = 0; i < 13; i++)
		{
			
			if (i == 0)//Top Stump
			{
			get = (lvl.getTopStump());
				if (get.equals("NOTHING")){
					
				} else {
					String numberA = new String(get.substring(0, 2));
					String numberB = new String(get.substring(2));
					x = Integer.parseInt(numberA);
					y = Integer.parseInt(numberB);
					map[x][y].setIcon(graph.getTopStump());
				}
			} 
			else if (i >= 1 && i <= 7 ) //Middle stumps
			{
				if (i == 1){get = (lvl.getStumpOne());}
				else if (i == 2){get = (lvl.getStumpTwo());}
				else if (i == 3){get = (lvl.getStumpThree());}
				else if (i == 4){get = (lvl.getStumpFour());}
				else if (i == 5){get = (lvl.getStumpFive());}
				else if (i == 6){get = (lvl.getStumpSix());}
				else if (i == 7){get = (lvl.getStumpSeven());}
				else {get = (lvl.getStumpFour());}
				if (get.equals("NOTHING")){
				
				}
				else
				{
					String numberA = new String(get.substring(0, 2));
					String numberB = new String(get.substring(2));
					x = Integer.parseInt(numberA);
					y = Integer.parseInt(numberB);
					map[x][y].setIcon(graph.getStump());	
				}
				
			} 
			else if (i == 8)//Bottom Stumps
			{
				get = (lvl.getBottomStump());
				if (get.equals("NOTHING"))
				{
				}
				else
				{
					String numberA = new String(get.substring(0, 2));
					String numberB = new String(get.substring(2));
					x = Integer.parseInt(numberA);
					y = Integer.parseInt(numberB);
					playerX = x;
					playerY = y;
					map[x][y].setIcon(graph.getBottomStumpMan());
					System.out.println("Player Updated X:" + playerX + " Y:" + playerY);
				}
				
			}
			else if (i >= 9)//Plank
			{
				if (i == 9){get = (lvl.getPlank());}
				else if (i == 10){get = (lvl.getPlankH());}
				else if (i == 11){get = (lvl.getLongPlank1());}
				else if (i == 12){get = (lvl.getLongPlank2());}
					if (get.equals("NOTHING"))
					{
						
					}
					else if (i == 10)
					{
						String numberA = new String(get.substring(0, 2));
						String numberB = new String(get.substring(2));
						x = Integer.parseInt(numberA);
						y = Integer.parseInt(numberB);
						map[x][y].setIcon(graph.getPlankH());
					}
					else
					{
						String numberA = new String(get.substring(0, 2));
						String numberB = new String(get.substring(2));
						x = Integer.parseInt(numberA);
						y = Integer.parseInt(numberB);
						map[x][y].setIcon(graph.getPlankV());
					}
				
			}
		}
	}
	
	public void getDifficulty(int lvl) // This gets the difficulty from the button clicked in the main menu.
	{
		difficulty = lvl;
	}
	
	public void setText()
	{
		textRefresh();
	}
	
	private void textRefresh()
	{
		if (difficulty ==1 ){
			difLabel.setText("Difficulty: Easy");
			levelLabel.setText("Level: "+(level+1)+" of 1");
		} 
		else if (difficulty == 2)
		{
			difLabel.setText("Difficulty: Medium");
			levelLabel.setText("Level: "+(level+1)+" of 3");
		} 
		else if (difficulty == 3)
		{
			difLabel.setText("Difficulty: Hard");
			levelLabel.setText("Level: "+(level+1)+" of 6");
		}
	}
	
	private void nextLevel()
	{
		backgroundRefresh();
		getLevel();
	}
	
	private void playerUpdate()
	{
		for (int i = 0; i > columns; i++)
		{
			if ((map[i][12].getIcon().equals(graph.getBottomStump())) || (map[i][12].getIcon().equals(graph.getBottomStumpMan())))
			{
				System.out.println("Position of the player is X:"+i+ "Y: 12");
				playerX = 12;
				playerY = i;
			}
		}
		String get = new String(lvl.getBottomStump());
		String numberA = new String(get.substring(0, 2));
		String numberB = new String(get.substring(2));
		int x = Integer.parseInt(numberA);
		int y = Integer.parseInt(numberB);
		playerX = x;
		playerY = y;
		System.out.println("Player Updated X:" + playerX + " Y:" + playerY);
		
	}
	
	private void levelComplete()
	{
		
		if (difficulty == 1){
			System.out.println("Finished easy!");
		} 
		else if(difficulty == 2)
		{
			if (level == 2)
			{
				System.out.println("Finished medium!");
			}
			else 
			{
				level++;
				backgroundRefresh();
				getLevel();
				playerX = 12;
				playerY = 1;
				playerUpdate();
				playerCheck = false;
				textRefresh();
			}
		}
		else if (difficulty == 3)
		{
			if (level == 5)
			{
				System.out.println("Finished hard!");
			}
			else 
			{
				level++;
				System.out.println(level + "/6");
				backgroundRefresh();
				getLevel();
				playerX = 12;
				playerY = 1;
				playerUpdate();
				playerCheck = false;
				textRefresh();
			}
		}
	}
}