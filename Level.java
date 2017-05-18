import java.util.Random;

public class Level{
	//Top and Borrom Stumps
	private String topStump;
	private String bottomStump;
	// The rest of the stumps
	private String stump1;
	private String stump2;
	private String stump3;
	private String stump4;
	private String stump5;
	private String stump6;
	private String stump7;
	// The plank positions
	private String plank;
	private String plankH;
	private String longPlank1;
	private String longPlank2; //two of these as we need to know co-ords of each 
	
	private int levelPick = 0;
	private Random rand = new Random();
	
	public void newLevel()
	{
		pickLevel();
	}
	private void pickLevel()
	{
		levelPick = rand.nextInt(4) + 1;
		if (levelPick == 1)
		{
			levelOne();
		}
		else if (levelPick == 2)
		{
			levelTwo();
		}
		else if (levelPick == 3)
		{
			levelThree();
		}
		else if (levelPick == 4)
		{
			levelFour();
		}
		/*else if (levelPick == 5)
		{
			levelFive();
		}
		else if (levelPick == 6)
		{
			levelSix();
		}*/
	}
	private void levelOne()
	{
		topStump = "0003";
		stump1 = "0203";
		stump2 = "0205";
		stump3 = "0207";
		stump4 = "0407";
		stump5 = "0607";
		stump6 = "0405";
		stump7 = "0907";
		bottomStump = "1207";
		plank = "0507";
		plankH = "NOTHING";
		longPlank1 = "1107";
		longPlank2 = "1007";
	}
	private void levelTwo()
	{
		topStump = "0003";
		stump1 = "0203";
		stump2 = "0403";
		stump3 = "0603";
		stump4 = "0803";
		stump5 = "1003";
		stump6 = "0405";
		stump7 = "NOTHING";
		bottomStump = "1203";
		plank = "1103";
		plankH = "NOTHING";
		longPlank1 = "NOTHING";
		longPlank2 = "NOTHING";
	}
	private void levelThree()
	{
		topStump = "0003";
		stump1 = "0301";
		stump2 = "0501";
		stump3 = "0503";
		stump4 = "0303";
		stump5 = "0903";
		stump6 = "0901";
		stump7 = "0603";
		bottomStump = "1201";
		plank = "NOTHING";
		plankH = "0902";
		longPlank1 = "1101";
		longPlank2 = "1001";
	}
	private void levelFour()
	{
		topStump = "0004";
		stump1 = "0304";
		stump2 = "0302";
		stump3 = "0502";
		stump4 = "0305";
		stump5 = "0605";
		stump6 = "0603";
		stump7 = "0903";
		bottomStump = "1203";
		plank = "NOTHING";
		plankH = "0604";
		longPlank1 = "1103";
		longPlank2 = "1003";
	}
	public String getTopStump()
	{
		return topStump;
	}
	public String getBottomStump()
	{
		return bottomStump;
	}
	public String getStumpOne()
	{
		return stump1;
	}
	public String getStumpTwo()
	{
		return stump2;
	}
	public String getStumpThree()
	{
		return stump3;
	}
	public String getStumpFour()
	{
		return stump4;
	}
	public String getStumpFive()
	{
		return stump5;
	}
	public String getStumpSix()
	{
		return stump6;
	}
	public String getStumpSeven()
	{
		return stump7;
	}
	public String getPlank()
	{
		return plank;
	}
	public String getPlankH()
	{
		return plankH;
	}
	public String getLongPlank1()
	{
		return longPlank1;
	}
	public String getLongPlank2()
	{
		return longPlank2;
	}
}