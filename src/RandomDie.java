
public class RandomDie {
	
	private int lastRoll;
	
	public RandomDie(){
		
	}
	
	public void roll() {
		lastRoll = ((int)(Math.random()*6+1));
	    
	    }
	public int getLastRoll(){
		return lastRoll;
	}
}


