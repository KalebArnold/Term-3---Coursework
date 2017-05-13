import javax.swing.ImageIcon;
public class Graphics{
	//Top and bottom banks
	private ImageIcon topBank = new ImageIcon("Images/bank2.jpg");
	private ImageIcon bottomBank = new ImageIcon("Images/bank1.jpg");
	//Water and fish
	private ImageIcon waterOne = new ImageIcon("Images/water1.jpg");
	private ImageIcon waterTwo = new ImageIcon("Images/water2.jpg");
	private ImageIcon waterThree = new ImageIcon("Images/water3.jpg");
	private ImageIcon waterFour = new ImageIcon("Images/water4.jpg");
	//All stumps (inc' man standing on them)
	private ImageIcon topStumpMan = new ImageIcon("Images/stump3_man.jpg");
	private ImageIcon topStump = new ImageIcon("Images/stump3.jpg");
	private ImageIcon bottomStumpMan = new ImageIcon("Images/stump2_man.jpg");
	private ImageIcon bottomStump = new ImageIcon("Images/stump2.jpg");
	private ImageIcon stump = new ImageIcon("Images/stump1.jpg");
	private ImageIcon stumpMan = new ImageIcon("Images/stump1_man.jpg");
	//Planks
	private ImageIcon plankH = new ImageIcon("Images/plank2.jpg");
	private ImageIcon plankV = new ImageIcon("Images/plank1.jpg");
	private ImageIcon plankHMan = new ImageIcon("Images/plank2_man.jpg");
	private ImageIcon plankVMan = new ImageIcon("Images/plank1_man.jpg");
	public Graphics(){
		
	}
	
	public ImageIcon getTopBank(){
		return topBank;
	}
	public ImageIcon getBottomBank(){
		return bottomBank;
	}
	public ImageIcon getWaterOne(){
		return waterOne;
	}
	public ImageIcon getWaterTwo(){
		return waterTwo;
	}
	public ImageIcon getWaterThree(){
		return waterThree;
	}
	public ImageIcon getWaterFour(){
		return waterFour;
	}
	public ImageIcon getTopStumpMan(){
		return topStumpMan;
	}
	public ImageIcon getTopStump(){
		return topStump;
	}
	public ImageIcon getBottomStumpMan(){
		return bottomStumpMan;
	}
	public ImageIcon getBottomStump(){
		return bottomStump;
	}
	public ImageIcon getStump(){
		return stump;
	}
	public ImageIcon getStumpMan(){
		return stumpMan;
	}
	public ImageIcon getPlankV(){
		return plankV;
	}
	public ImageIcon getPlankVMan(){
		return plankVMan;
	}
	public ImageIcon getPlankH(){
		return plankH;
	}
	public ImageIcon getPlankHMan(){
		return plankHMan;
	}
	
}