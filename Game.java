import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class Game implements MouseListener{
// variables and locals to this class
	private int rows = 13;
	private int columns = 9;
	private int invRows = 13;
	private int invColumns = 4;
	private int gameX = 0;
	private int gameY = 0;
	private int invX = 0;
	private int backSelect = 0; //This is for the random for the background select.
	private int checkLevel = 0;
	private int difficulty = 0;
	private int level = 0;
	private int mapX = 0;
	private int mapY = 0;
	private int playerX = 0;
	private int playerY = 0;
	
	
	private JButton map[][] = new JButton[rows][columns];
	private JButton inventory[][] = new JButton[invRows][invColumns];
	
	private JFrame screen;
	private JPanel mainPanel;
	private JPanel gamePanel;
	private JPanel invPanel;
	
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
		BorderLayout mainLayout = new BorderLayout();
		GridLayout gameLayout = new GridLayout(rows,columns);
		GridLayout invLayout = new GridLayout(invRows, invColumns);
		
		//timer = new Timer();
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
		getLevel();
		
		//JLabel score = new JLabel("Score: " + timer.getTime());
		
		//Settings for the window
		screen.setVisible(false);
		screen.setTitle("Puzzle Game...");
		screen.setSize(((16*32)-16),(rows*32));
		screen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		for (int i = 0; i<rows; i++)
		{
			map[i][gameX].addMouseListener(this);
			for (int j = 0; j<columns; j++)
			{
				map[i][j].addMouseListener(this);
				gameX = j;
			}
			gameX = 0;
		}
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			if (e.getSource() == map[1][2])
			{
				if ((map[1][2].getIcon().equals(graph.getPlankV())))
				{
					System.out.println("Works!!!");
					log(1,2);
					invUpdate();
				}				
			}
			if (e.getSource() == map[11][7])
			{
				if ((map[11][7].getIcon().equals(graph.getPlankV()))){
					if ((map[12][7].getIcon().equals(graph.getBottomStumpMan())))
					{
						map[11][7].setIcon(graph.getWaterOne());
						System.out.print("A: working!");
						log = true;
						invUpdate();
					}
				} else if (log == true)
				{
					if (map[11][7].getIcon().equals(graph.getWaterOne()))
					{
						log = false;
						map[11][7].setIcon(graph.getPlankV());
						invUpdate();
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
			System.out.println("Final: X:" + mapX + " Y:"+ mapY);
			
			
			if (map[mapX][mapY].getIcon().equals(graph.getPlankV()))
			{
				if (playerX == (mapX+1) || playerX == (mapX-1))
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
					map[mapX][mapY].setIcon(graph.getPlankVMan());
					playerX = mapX;
					playerY = mapY;
				} 
				
			}
			if (map[mapX][mapY].getIcon().equals(graph.getStump()))
			{
				if (playerX == (mapX+1) || playerX == (mapX-1))
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
					map[mapX][mapY].setIcon(graph.getStumpMan());
					playerX = mapX;
					playerY = mapY;
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
		
	}
	
	private void background()
	{
		backSelect = rnd.nextInt((20 - 0) + 1) + 0;
	}
	
	private void placeLog()
	{
		
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
	
	private void log(int x, int y)
	{
		if(log == false && longLog == false)
		{
			if(map[x][y].getIcon().equals(graph.getPlankV()))
			{
				if ((map[x+1][y].getIcon().equals(graph.getStumpMan()))||(map[x+2][y].getIcon().equals(graph.getStumpMan())))
				{
					System.out.print("This works!!!!!!!!!!!!");
				}/* else if ((map[x+1][y].getIcon().equals(graph.getBottomStumpMan())))
				{
					
				}	*/
			} else if (map[x][y].getIcon().equals(graph.getPlankH()))
			{
				if ((map[x][y+1].getIcon().equals(graph.getPlankH()))||(map[x][y-1].getIcon().equals(graph.getPlankH())))
				{
					invUpdate();
					map[x][y].setIcon(graph.getWaterOne());
				}
			}
		}
	}
	private void getLevel()
	{
		lvl.newLevel();
		int x = 0;
		int y = 0;
		String get = "";
		for (int i = 0; i < 12; i++)
		{
			
			if (i == 0)//Top Stump
			{
			get = (lvl.getTopStump());
			String numberA = new String(get.substring(0, 2));
			String numberB = new String(get.substring(2));
			x = Integer.parseInt(numberA);
			y = Integer.parseInt(numberB);
			map[x][y].setIcon(graph.getTopStump());
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
				String numberA = new String(get.substring(0, 2));
				String numberB = new String(get.substring(2));
				x = Integer.parseInt(numberA);
				y = Integer.parseInt(numberB);
				map[x][y].setIcon(graph.getStump());
			} 
			else if (i == 8)//Bottom Stumps
			{
				get = (lvl.getBottomStump());
				String numberA = new String(get.substring(0, 2));
				String numberB = new String(get.substring(2));
				x = Integer.parseInt(numberA);
				y = Integer.parseInt(numberB);
				playerX = x;
				playerY = y;
				map[x][y].setIcon(graph.getBottomStumpMan());
			}
			else if (i >= 9)
			{
				if (i == 9){get = (lvl.getPlank());}
				else if (i == 10){get = (lvl.getLongPlank1());}
				else if (i == 11){get = (lvl.getLongPlank2());}
				String numberA = new String(get.substring(0, 2));
				String numberB = new String(get.substring(2));
				x = Integer.parseInt(numberA);
				y = Integer.parseInt(numberB);
				map[x][y].setIcon(graph.getPlankV());
			}
		}
		
	}
	private void levelComplete()
	{
		
	}
}