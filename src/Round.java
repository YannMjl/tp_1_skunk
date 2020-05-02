import java.util.ArrayList;

public class Round
{
	private ArrayList<Turn> gameTurn;
	private int roundScore;
	
	public Round() 
	{
		gameTurn = new ArrayList<Turn>();
	}
	
	public Turn createTurn()
	{
		Turn aTurn = new Turn();
		gameTurn.add(aTurn);
		return aTurn;
	}
	
	public Turn get_currentTurn() {
		Turn current_turn = gameTurn.get(gameTurn.size()-1);
		return current_turn;
	}
	
	public int addScore()
	{
		if(gameTurn.size()==1) {
			if(gameTurn.get(0).isDoubleSkunk() || gameTurn.get(0).isSingleSkunk()) 
				roundScore = 0;
			else 
				roundScore = gameTurn.get(0).getTurnScore();
		}else if(gameTurn.size()>1) {
			for(int i=1; i < gameTurn.size(); i++)
			{
				if(gameTurn.get(i).isDoubleSkunk()) {
					roundScore = 0;
				}else if (gameTurn.get(i).isSingleSkunk()){
					roundScore = gameTurn.get(i-1).getTurnScore();
				}
				else 
				{
					roundScore += gameTurn.get(i).getTurnScore();
				}
			}
		}
		return roundScore;
	}

	public ArrayList<Turn> getGameTurn()
	{
		return gameTurn;
	}

	public int getRoundScore()
	{
		roundScore = addScore();
		return roundScore;
	}
		
	// the following methods are for testing 
	public int addScore_test()
	{
		if(gameTurn.size()==1) {
			if(gameTurn.get(0).isDoubleSkunk() || gameTurn.get(0).isSingleSkunk()) 
				roundScore = 0;
			else 
				roundScore = gameTurn.get(0).getTurnScore_test();
		}else if(gameTurn.size()>1){
			for(int i=1; i < gameTurn.size(); i++)
			{
				if(gameTurn.get(i).isDoubleSkunk()) {
					roundScore = 0;
				}
				else if (gameTurn.get(i).isSingleSkunk()){
					roundScore = gameTurn.get(i-1).getTurnScore_test();
				}
				else {
					roundScore += gameTurn.get(i).getTurnScore_test();
				}
			}
		}
		return roundScore;
	}
	
	public int getRoundScore_test()
	{
		roundScore = addScore_test();
		return roundScore;
	}

}
