import java.util.Timer;
import java.util.TimerTask;
public class GameTimer{
	
	
	private Timer time = new Timer();
	private TimerTask timeT = new TimerTask()
	{
		public void run()
		{
			seconds++;
		}
	};
	
	private int seconds = 0;
	public GameTimer()
	{
		time.scheduleAtFixedRate(timeT, 1000, 1000);
		
		
	}
	
	public int getTime()
	{
		return seconds;
	}
	public void timerReset()
	{
		seconds = 0;
	}
	
}