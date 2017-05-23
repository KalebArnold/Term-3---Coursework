import java.util.Timer;
import java.util.TimerTask;
public class GameTimer{
	
	/**
	** @author Kaleb Arnold
	** This class is the main menu class:
	** Easy/medium/hard buttons and leaderboard. (this is also used for the transfer of variables from the game to the leaderboard)
	** Declaring variables
	** Including: 
	** - Buttons for the main menu
	** - Player postions
	** - Level stats and all the Swing variables
	**/
	private Timer time = new Timer();
	private TimerTask timeT = new TimerTask()
	{
		public void run()// this keeps the time updating
		{
			seconds++;
		}
	};
	
	private int seconds = 0;
	public GameTimer()
	{
		time.scheduleAtFixedRate(timeT, 1000, 1000); // this increments every 1000 miliseconds a milisecond
		
		
	}
	// this returns the time to the main menu
	public int getTime()
	{
		return seconds;
	}
	//this can be called and reset
	public void timerReset()
	{
		seconds = 0;
	}
}




