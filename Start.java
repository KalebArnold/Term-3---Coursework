import javax.swing.*;

public class Start {
	
	public static void main(String[] args){
		MainMenu m = new MainMenu();
		
		// this is so that the timer will constantly update
		while(true){
			m.updateTime();
		}
		
		
	}
	
}