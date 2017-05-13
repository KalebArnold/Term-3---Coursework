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
	
	
	private JButton map[][] = new JButton[rows][columns];
	private JButton inventory[][] = new JButton[invRows][invColumns];
	
	private JFrame screen;
	private JPanel mainPanel;
	private JPanel gamePanel;
	private JPanel invPanel;
	
	private Random rnd = new Random();
	private Graphics graph = new Graphics();

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
		levelSetup();
		
		//JLabel score = new JLabel("Score: " + timer.getTime());
		
		//Tile print
		
		//Settings for the window
		screen.setVisible(false);
		screen.setTitle("Puzzle Game...");
		screen.setSize(576,456);
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
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			if (e.getSource() == map[1][2])
			{
				//System.out.print("This works..");
				if ((level == 0 && map[1][2].getIcon().equals(graph.getPlankH()) &&  map[2][2].getIcon().equals(graph.getStumpMan())))
				{
					System.out.println("Works!!!");
					map[1][2].setIcon(graph.getWaterOne());
					log(1,2);
				}
				/*if ((level == 1 && map[1][2].getIcon().equals(graph.getWaterOne()) &&  map[2][2].getIcon().equals(graph.getStumpMan())))
					map[1][2].setIcon(graph.getPlankH());
				}*/
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
				inventory[i][invX] = new JButton(graph.getPlankH());
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
	
	private void levelSetup(){
		
		if (checkLevel == 0){
			levelOne();
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
	private void log(int x, int y)
	{
		if(log == false && longLog == false)
		{
			if(map[x][y].getIcon().equals(graph.getPlankH()))
			{
				if ((map[x+1][y].getIcon().equals(graph.getStumpMan()))||(map[x+2][y].getIcon().equals(graph.getStumpMan())))
				{
					System.out.print("This works!!!!!!!!!!!!");
				}
			}
		}
	}
	
	private void levelOne()
	{
		map[0][2].setIcon(graph.getTopStump());
		map[1][2].setIcon(graph.getPlankH());
		map[2][2].setIcon(graph.getStump());
		map[2][4].setIcon(graph.getStump());
		map[5][4].setIcon(graph.getStump());
		map[5][5].setIcon(graph.getStump());
		map[8][5].setIcon(graph.getStump());
		map[10][5].setIcon(graph.getStump());
		map[10][7].setIcon(graph.getStump());
		map[12][7].setIcon(graph.getBottomStumpMan());
	}
	private void levelTwo()
	{
		map[0][3].setIcon(graph.getTopStump());
		map[1][2].setIcon(graph.getPlankV());
		
		map[2][2].setIcon(graph.getStump());
		map[2][4].setIcon(graph.getStump());
		map[5][4].setIcon(graph.getStump());
		map[5][5].setIcon(graph.getStump());
		map[8][5].setIcon(graph.getStump());
		map[10][5].setIcon(graph.getStump());
		map[10][7].setIcon(graph.getStump());
		
		map[12][3].setIcon(graph.getBottomStumpMan());
	}
	private void levelThree()
	{
		map[0][2].setIcon(graph.getTopStump());
		map[1][2].setIcon(graph.getPlankH());
		map[2][2].setIcon(graph.getStump());
		map[2][4].setIcon(graph.getStump());
		map[5][4].setIcon(graph.getStump());
		map[5][5].setIcon(graph.getStump());
		map[8][5].setIcon(graph.getStump());
		map[10][5].setIcon(graph.getStump());
		map[10][7].setIcon(graph.getStump());
		map[12][7].setIcon(graph.getBottomStumpMan());
	}
}