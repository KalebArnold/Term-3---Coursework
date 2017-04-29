import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class Game {
// variables and locals to this class
	private int rows = 9;
	private int columns = 13;
	private int tileNum = 0;
	private int backSelect = 0;
	
	private JButton map[] = new JButton[225];
	private JFrame screen;
	private JPanel menuPanel;

	
	private Random rnd = new Random();
	
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
		menuPanel = new JPanel();
		GridLayout mainLayout = new GridLayout(rows,columns);
		
		//Setting up the main components
		screen.setContentPane(menuPanel);
		menuPanel.setLayout(mainLayout);
		
		//Setting tiles
		backgroundSetup();
		
		
		//Settings for the window
		screen.setVisible(false);
		screen.setTitle("Puzzle Game...");
		screen.setSize(400,350);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void backgroundSetup()
	{
		for(int i = 0; i<rows; i++){
			
			background();
			
			if (i == 0){
				map[tileNum] = new JButton(topImage);
			} else if (i == 8){
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
			menuPanel.add(map[tileNum]);
			tileNum++;
			
			for (int j = 0; j<columns; j++){
				background();
				if (i == 0){
					map[tileNum] = new JButton(topImage);
				} else if (i == 8){
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
				menuPanel.add(map[tileNum]);
				tileNum++;
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