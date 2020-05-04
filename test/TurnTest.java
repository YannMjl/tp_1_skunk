import static org.junit.Assert.*;

import org.junit.Test;

public class TurnTest
{

	@Test
	public void test_createRoll()
	{
		Turn testTurn = new Turn();
		Roll testRoll = testTurn.createRoll_from_fakeDice();
		assertEquals(testRoll.getResult(),6);
	}
	
	@Test
	public void test_addScore()
	{
		Turn testTurn = new Turn();
		testTurn.createRoll_from_fakeDice();
		assertEquals(testTurn.addScore_test(),6);
		
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		assertEquals(testTurn.addScore_test(),18);
		
		assertEquals(testTurn.getTurnScore_test(),18);
		testTurn.createSkunkRoll();
		assertEquals(testTurn.addScore_test(),0);
		
		testTurn.createDoubleSkunk();
		assertEquals(testTurn.addScore_test(),0);
		assertEquals(testTurn.getTurnScore_test(),0);
	}
	
	@Test
	public void test_addScore_noSkunk()
	{
		Turn testTurn = new Turn();
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		assertEquals(testTurn.getTurnScore_test(),24);
	}
	
	@Test
	public void test_getTurnScore()
	{
		Turn testTurn = new Turn();
		assertEquals(testTurn.getTurnScore_test(),0);
		testTurn.createRoll_from_fakeDice();
		assertEquals(testTurn.getTurnScore_test(),6);
	}
	
}
