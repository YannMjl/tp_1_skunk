import edu.princeton.cs.introcs.*;

public class SkunkUI implements UI
{

	public Game game;

	public void setDomain(Game game)
	{
		this.game = game;

	}

	public String promptReadAndReturn(String question)
	{
		StdOut.print(question + " -> ");
		String result = StdIn.readLine();
		return result;
	}

	public void print(String toPrint)
	{
		StdOut.print(toPrint);

	}

	public void println(String toPrint)
	{
		StdOut.println(toPrint);

	}

}
