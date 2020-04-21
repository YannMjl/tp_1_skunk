import java.util.ArrayList;
import edu.princeton.cs.introcs.*;

public class Game {
	public SkunkUI skunkUI;
	public UI ui;
	public int numberOfPlayers;
	public String[] playerNames;
	public ArrayList<Player> players;
	public int kitty;

	public Player activePlayer;
	public int activePlayerIndex;

	public boolean wantsToQuit;
	public boolean oneMoreRoll;

	public Dice skunkDice;

	public Game(SkunkUI ui) {
		this.skunkUI = ui;
		this.ui = ui;
		this.playerNames = new String[20];
		this.players = new ArrayList<Player>();
		this.skunkDice = new Dice();
		this.wantsToQuit = false;
		this.oneMoreRoll = false;
	}
	
//	everything is packed inside the run method. This practice makes the code hard to read and understand
//	and even very hard to debug. 
//	The run method have way to many tasks, does many things and has so many responsibilities. 
//	To improve its legibility and structure; I'm going to create methods that are easy to read, 
//	well structure and perform one task. 
	
//	this method will get the number of players and pass them to other method when needed.
	public int getNumberOfPlayers() 
	{
		String numberPlayersString = skunkUI.promptReadAndReturn("How many players?");
		this.numberOfPlayers = Integer.parseInt(numberPlayersString);
		
		return this.numberOfPlayers;
	}
	
//	this method getPlayersNames and will pass them to the run method
	public void getPlayersNames()
	{
		int numberOfPlayers = getNumberOfPlayers();

		for (int playerNumber = 0; playerNumber < numberOfPlayers; playerNumber++)
		{
			ui.print("Enter name of player " + (playerNumber + 1) + ": ");
			playerNames[playerNumber] = StdIn.readLine();
			this.players.add(new Player(50));
		}
	}
	
//  get player choice to roll the dice or not
	public boolean getPlayerChoice()
	{
		String wantsToRollStr = ui.promptReadAndReturn("Would you like to roll the dice? y or n");
		boolean wantsToRoll = 'y' == wantsToRollStr.toLowerCase().charAt(0);
		
		return wantsToRoll;

	}
	
//  get player choice to display turn score and score board
	public boolean showScore()
	{
		String wantsToDisplayStr = ui.promptReadAndReturn("Do you want to see the turn score and score board? y or n");
		boolean showscore = 'y' == wantsToDisplayStr.toLowerCase().charAt(0);
		
		return showscore;
	}
	
//	display a turn result
	public void displayTurnResult(boolean value)
	{
		
		ui.println("Score for this turn is " + activePlayer.getTurnScore() + ", added to...");
		ui.println("Previous round score of " + activePlayer.getRoundScore());
		activePlayer.setRoundScore(activePlayer.getRoundScore() + activePlayer.getTurnScore());
		ui.println("Giving new round score of " + activePlayer.getRoundScore());

		ui.println("");
		if (activePlayer.getRoundScore() >= 100)
			value = false;

		ui.println("Scoreboard: ");
		ui.println("kitty has " + kitty);
		ui.println("player name - turn score - round score - chips");
		ui.println("______________________________________________\n");

		for (int i = 0; i < numberOfPlayers; i++) {
			ui.println(playerNames[i] + " ---- " + players.get(i).turnScore + " ---- " + players.get(i).roundScore
					+ " ---- " + players.get(i).getNumberChips());
		}
		
		ui.println("______________________________________________\n");

		ui.println("Turn passes to right...");

		activePlayerIndex = (activePlayerIndex + 1) % numberOfPlayers;
		activePlayer = players.get(activePlayerIndex);

	}

	public boolean run() {
		ui.println("\n Welcome to Skunk App Game!");
		ui.println("*--------------------------*\n");

		// getting players info before the game begin
		getPlayersNames();
			
		activePlayerIndex = 0;
		activePlayer = players.get(activePlayerIndex);

		ui.println("\n Starting game...\n");
		boolean gameNotOver = true;

		while (gameNotOver) {
			
			ui.println("Next player is: " + playerNames[activePlayerIndex] + ".");
			
			// get player choice to roll dice or not
			boolean wantsToRoll = getPlayerChoice();
			
			activePlayer.setTurnScore(0);

			while (wantsToRoll) {
				activePlayer.setRollScore(0);
				skunkDice.roll();
				if (skunkDice.getLastRoll() == 2) {
					ui.println("Two Skunks! You lost the turn, the round score, plus pay 4 chips to the kitty");
					scoreRoll(4);
					wantsToRoll = false;
					break;
				} else if (skunkDice.getLastRoll() == 3) {
					ui.println("Skunks and Deuce! You lost the turn, the turn score, plus pay 2 chips to the kitty");
					scoreRoll(3);
					wantsToRoll = false;
					break;
				} else if (skunkDice.getDie1().getLastRoll() == 1 || skunkDice.getDie2().getLastRoll() == 1) {
					ui.println("One Skunk! You lost the turn, the turn score, plus pay 1 chip to the kitty");
					kitty += 1;
					activePlayer.setNumberChips(activePlayer.getNumberChips() - 1);
					activePlayer.setTurnScore(0);
					wantsToRoll = false;
					break;

				}

				activePlayer.setRollScore(skunkDice.getLastRoll());
				activePlayer.setTurnScore(activePlayer.getTurnScore() + skunkDice.getLastRoll());
				ui.println(
						"Roll of " + skunkDice.toString() + ", gives new turn score of " + activePlayer.getTurnScore());

				// get player choice to roll dice or not
				wantsToRoll = getPlayerChoice();

			}

			ui.println("End of turn for " + playerNames[activePlayerIndex]);
			
			boolean showScore = showScore();
			
			if (showScore == true) {
				// display turn result and score board
				displayTurnResult(gameNotOver);
			} else {
				ui.println("Turn passes to right...");
				ui.println("______________________________________________\n");

				activePlayerIndex = (activePlayerIndex + 1) % numberOfPlayers;
				activePlayer = players.get(activePlayerIndex);
			}
			
		}

		ui.println("Last turn for all...");

		for (int i = activePlayerIndex, count = 0; count < numberOfPlayers - 1; i = (i++) % numberOfPlayers, count++) {
			ui.println("Last round for player " + playerNames[activePlayerIndex] + "...");
			activePlayer.setTurnScore(0);

			// get player choice to roll dice or not
			boolean wantsToRoll = getPlayerChoice();

			while (wantsToRoll) {
				skunkDice.roll();
				ui.println("Roll is " + skunkDice.toString() + "\n");

				if (skunkDice.getLastRoll() == 2) {
					ui.println("Two Skunks! You lost the turn, the turn score, plus pay 4 chips to the kitty");
					scoreRoll(4);
					wantsToRoll = false;
					break;
				} else if (skunkDice.getLastRoll() == 3) {
					ui.println("Skunks and Deuce! You lost the turn, the turn score, plus pay 2 chips to the kitty");
					scoreRoll(1);
					wantsToRoll = false;

				} else if (skunkDice.getDie1().getLastRoll() == 1 || skunkDice.getDie2().getLastRoll() == 1) {
					ui.println("One Skunk! You lost the turn, the turn core, plus pay 1 chip to the kitty");
					scoreRoll(1);
					wantsToRoll = false;
				} else {
					activePlayer.setTurnScore(activePlayer.getRollScore() + skunkDice.getLastRoll());
					ui.println("Roll of " + skunkDice.toString() + ", giving new turn score of "
							+ activePlayer.getTurnScore());

					ui.println("Scoreboard: ");
					ui.println("kitty has: " + kitty);
					ui.println("player name - turn score - round score - total chips");
					ui.println("-----------------------");

					for (int pNumber = 0; pNumber < numberOfPlayers; pNumber++) {
						ui.println(playerNames[pNumber] + " -- " + players.get(pNumber).turnScore + " -------- "
								+ players.get(pNumber).roundScore + " -------- "
								+ players.get(pNumber).getNumberChips());
					}
					ui.println("-----------------------");

					// get player choice to roll dice or not
					wantsToRoll = getPlayerChoice();
				}

			}

			activePlayer.setTurnScore(activePlayer.getRollScore() + skunkDice.getLastRoll());
			ui.println("Last roll of " + skunkDice.toString() + ", giving final round score of "
					+ activePlayer.getRollScore());

		}

		int winner = 0;
		int winnerScore = 0;

		for (int player = 0; player < numberOfPlayers; player++) {
			Player nextPlayer = players.get(player);
			ui.println("Final round score for " + playerNames[player] + " is " + nextPlayer.getRoundScore() + ".");
			if (nextPlayer.getRoundScore() > winnerScore) {
				winner = player;
				winnerScore = nextPlayer.getRoundScore();
			}
		}

		ui.println("Round winner is " + playerNames[winner] + " with score of " + players.get(winner).getRoundScore());
		players.get(winner).setNumberChips(players.get(winner).getNumberChips() + kitty);
		ui.println("\nRound winner earns " + kitty + ", finishing with " + players.get(winner).getNumberChips());

		ui.println("\nFinal scoreboard for this round:");
		ui.println("player name - round score - total chips");
		ui.println("-----------------------");

		for (int pNumber = 0; pNumber < numberOfPlayers; pNumber++) {
			ui.println(playerNames[pNumber] + " ----- " + players.get(pNumber).roundScore + " ----- "
					+ players.get(pNumber).getNumberChips());
		}

		ui.println("-----------------------");
		return true;
	}

	private void scoreRoll(int chipsLost) {
		kitty += 4;
		activePlayer.setNumberChips(activePlayer.getNumberChips() - 4);
		activePlayer.setTurnScore(0);
		activePlayer.setRoundScore(0);
	}
}
