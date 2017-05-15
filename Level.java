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
	private String longPlank1;
	private String longPlank2; //two of these as we need to know co-ords of each 
	
	private int levelPick = 0;
	
	public void newLevel()
	{
		pickLevel();
	}
	private void pickLevel()
	{
		if (levelPick == 0)
		{
			levelOne();
		}
		
	}
	private void levelOne()
	{
		topStump = "0002";
		stump1 = "0202";
		stump2 = "0204";
		stump3 = "0504";
		stump4 = "0505";
		stump5 = "0805";
		stump6 = "1005";
		stump7 = "1007";
		bottomStump = "1207";
		plank = "1107";
		longPlank1 = "0705";
		longPlank2 = "0605";
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
	public String getLongPlank1()
	{
		return longPlank1;
	}
	public String getLongPlank2()
	{
		return longPlank2;
	}
}