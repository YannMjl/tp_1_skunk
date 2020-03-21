
public class SkunkApp
{
	public SkunkUI skunkUI;
	public Game game;
	public int numberOfPlayers;
	public String[] playerNames;

	public SkunkApp()
	{
		skunkUI = new SkunkUI();
		game = new Game(skunkUI);
		skunkUI.setDomain(game);
		this.numberOfPlayers = 0;
		this.playerNames = new String[20];
	}

	public boolean run()
	{
		return game.run();
	}

	public static void main(String[] args)
	{
		new SkunkApp().run();
	}

}
