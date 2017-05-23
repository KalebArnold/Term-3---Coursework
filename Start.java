import javax.swing.*;
	/**
* @author Kaleb Arnold
* This class is the start class:
* This just loads the program then updates the time.
**/
	
public class Start {
	
	public static void main(String[] args){
		MainMenu m = new MainMenu();
		
		// this is so that the timer will constantly update
		while(true){
			m.updateTime();
		}
		
		
	}
	
}