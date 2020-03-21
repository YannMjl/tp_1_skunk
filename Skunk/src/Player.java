
public class Player
{
	public int rollScore;
	public int turnScore;
	public int roundScore;
	public int gameScore; 
	public int numberChips;

	public Player()
	{
		this.rollScore = 0;
		this.turnScore = 0;
		this.roundScore = 0;
		this.gameScore = 0;
		this.numberChips = 50; 
	}

	public Player(int startingChipsPerPlayer)
	{
		this();
		this.numberChips = startingChipsPerPlayer;
	}

	public void addToRollScore(int lastTotal)
	{
		rollScore += lastTotal;
	}

	public void setRollScore(int newRollScore)
	{
		this.rollScore = newRollScore;
	}

	public int getRollScore()
	{
		return this.rollScore;
	}

	public int getNumberChips()
	{
		return this.numberChips;
	}

	public void setNumberChips(int newChips)
	{
		this.numberChips = newChips;
	}

	public void setTurnScore(int newScore)
	{
		this.turnScore = newScore;
	}

	public int getTurnScore()
	{
		return this.turnScore;
	}

	public String getName()
	{
		return null;
	}

	public void setRoundScore(int i)
	{
		this.roundScore = i;
	}

	public int getRoundScore()
	{
		return this.roundScore;
	}

}
