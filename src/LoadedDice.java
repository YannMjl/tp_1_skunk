
public class LoadedDice
{
	private Die d1;
	private Die d2;
	
	public LoadedDice(Die d1, Die d2)
	{
		this.d1 = d1;
		this.d2 = d2;
	}

	public void dice_roll() 
	{
		d1.roll();
		d2.roll();	
	}
	
	public int dice_getLastRoll_die1() 
	{
		return d1.getLastRoll();
	}
	
	public int dice_getLastRoll_die2() 
	{
		return d2.getLastRoll();
	}
	
	public int dice_getLastRoll_sum() 
	{
		return d1.getLastRoll() + d2.getLastRoll();
	}
}
