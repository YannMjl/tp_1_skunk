import edu.princeton.cs.introcs.StdOut;

public class Dice {
	private int lastRoll;
	private Die die1;
	private Die die2;
	
	private RandomDie d1;
	private RandomDie d2;
	
	public Dice(RandomDie d1, RandomDie d2)
	{
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public void Roll(){
		d1.roll();
		d2.roll();
	}
	
	public int getLastRoll_die1() 
	{
		return d1.getLastRoll();
	}
	
	public int getLastRoll_die2() 
	{
		return d2.getLastRoll();
	}
	
	public int getLastRoll_sum() 
	{
		return d1.getLastRoll()+d2.getLastRoll();
	}
	
	public Dice() {
		this.die1 = new Die();
		this.die2 = new Die();
		this.roll();
	}

	public Dice(Die die1, Die die2) {
		this.die1 = die1;
		this.die2 = die2;
	}

	public int getLastRoll() {
		return this.lastRoll;
	}

	public void roll() {
		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
	}

	public String toString() {
		return "Dice with last roll: " + getLastRoll() + " -> " + die1.getLastRoll() + " + " + die2.getLastRoll();
	}

	public Die getDie1() {
		return this.die1;
	}

	public Die getDie2() {
		return this.die2;
	}

	public void setDie1(Die d) {
		this.die1 = d;
	}

	public void setDie2(Die d) {
		this.die2 = d;
	}

	public static final int NUM_TRIALS = 360;

	public static void main(String[] args) {
		Dice dice1 = new Dice();
		int doubleSkunkCount = 0;

		for (int i = 0; i < NUM_TRIALS; i++) {
			dice1.roll();
			StdOut.println(dice1);

			if (dice1.getLastRoll() == 2)
				doubleSkunkCount++;
		}
		StdOut.println("Actual count: " + doubleSkunkCount);
		StdOut.println("Expected count: " + (NUM_TRIALS / 36.0));
	}

}
