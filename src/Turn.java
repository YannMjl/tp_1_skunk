import java.util.ArrayList;
import java.util.Scanner;

public class Turn
{
	private ArrayList<Roll> gameRoll; 
	private int turnScore;
	private boolean isDoubleSkunk;
	private boolean isSingleSkunk;
	
	public Turn() 
	{
		gameRoll = new ArrayList<Roll>();
	}
	
	public Roll createRoll() 
	{
		Roll aRoll = new Roll(new Dice (new Die(), new Die()));	
	//below line of code, store the new Roll object into array of Roll
		gameRoll.add(aRoll); 
		if(aRoll.checkDoubleSkunk()==true) 
			isDoubleSkunk=true;
		else if(aRoll.checkSkunk()==true) 
			isSingleSkunk=true;
		return aRoll;
	}

	public Roll getLastRoll()
	{	
		Roll aRoll = gameRoll.get(gameRoll.size()-1);
		return aRoll;
	}
	
	public int addScore() 
	{
		int lastScore = 0;
		for(int x=0; x < gameRoll.size(); x++) 
		{
			//below line of code, check double skunk first
			if(gameRoll.get(x).checkDoubleSkunk()==true) 
			{
				turnScore = 0;
				isDoubleSkunk = true;
				break;
			}
			else if(gameRoll.get(x).checkSkunk()==true) 
			{
				turnScore = 0;
				isSingleSkunk = true;
				break;
			}
			else
			{
				turnScore = lastScore + gameRoll.get(x).getResult();
				lastScore = turnScore;
			}
		}
		return turnScore;
	}

	public boolean isDoubleSkunk()
	{
		return isDoubleSkunk;
	}

	public boolean isSingleSkunk()
	{
		return isSingleSkunk;
	}
	
	public void setDoubleSkunk(boolean isDoubleSkunk)
	{
		this.isDoubleSkunk = isDoubleSkunk;
	}

	public int getTurnScore()
	{
		turnScore = addScore();
		return turnScore;
	}
	
	public ArrayList<Roll> getGameRoll()
	{
		return gameRoll;
	}

	// the following methods are for testing 
	protected Roll createRoll_from_fakeDice() {
		Roll testRoll = new Roll (new LoadedDice (new Die(new int[]{2,3,4}), new Die(new int[]{4,5,6})));
		gameRoll.add(testRoll);
		return testRoll;
	}
		
	protected Roll createSkunkRoll() {
		Roll testRoll = new Roll (new LoadedDice (new Die(new int[]{1,2,3}), new Die(new int[]{4,5,6})));
		gameRoll.add(testRoll);
		isSingleSkunk=true;
		return testRoll;
	}
	
	protected Roll createDeduce() {
		Roll testRoll = new Roll (new LoadedDice (new Die(new int[]{1,2,3}), new Die(new int[]{2,5,6})));
		gameRoll.add(testRoll);
		isSingleSkunk=true;
		return testRoll;
	}
		
	protected Roll createDoubleSkunk() {
		Roll testRoll = new Roll (new LoadedDice (new Die(new int[]{1,2,3}), new Die(new int[]{1,2,3})));
		gameRoll.add(testRoll);
		isDoubleSkunk=true;
		return testRoll;
	}

	protected int addScore_test() 
	{
		int lastScore = 0;
		for(int x=0; x < gameRoll.size(); x++) 
		{
			 //below line of code, check double skunk first
			if(gameRoll.get(x).checkDoubleSkunk_test()==true)
			{
				turnScore = 0;
				isDoubleSkunk = true;
				break;
			}
			else if(gameRoll.get(x).checkSkunk_test()==true) 
			{
				turnScore = 0;
				isSingleSkunk = true;
				break;
			}
			else
			{
				turnScore = lastScore + gameRoll.get(x).getResult();
				lastScore = turnScore;
			}
		}
		return turnScore;
	}

	public int getTurnScore_test()
	{
		turnScore = addScore_test();
		return turnScore;
	}
	
}
