import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Game {
// variables and locals to this class
	private int rows = 6;
	private int columns = 6;
	private JButton map[] = new JButton[225];
	private JFrame screen;
	private int tileNum = 0;
	public Game(){
		//Below is the decloration of the main components of the interface.
		screen = new JFrame(); 
		JPanel menuPanel = new JPanel();
		GridLayout mainLayout = new GridLayout(rows,columns);
		
		//Setting up the main components
		screen.setContentPane(menuPanel);
		menuPanel.setLayout(mainLayout);
		
		//Setting tiles
		for(int i = 0; i<columns; i++){
			map[tileNum] = new JButton("");
			map[tileNum].setBorder(null);

			menuPanel.add(map[tileNum]);
			tileNum++;
			for (int j = 0; j<rows; j++){
				map[tileNum] = new JButton("");
				map[tileNum].setBorder(null);
				menuPanel.add(map[tileNum]);
				tileNum++;
			}
		}
		
		
		//Settings for the window
		screen.setVisible(false);
		screen.setTitle("Puzzle Game...");
		screen.setSize(400,350);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void visible()
	{
		screen.setVisible(true);
		
	}
	

}