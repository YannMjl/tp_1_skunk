import static org.junit.Assert.*;

import org.junit.Test;

public class RollTest {

	@Test
	public void test_checkSkunk() {
		LoadedDice testDice = new LoadedDice(new Die(new int[]{3,2,1}), new Die(new int[]{1,2,3})); 
		Roll testRoll = new Roll(testDice);
		assertEquals(testRoll.checkSkunk_test(),true);
	}

	@Test
	public void test_checkDoubleSkunk() {
		LoadedDice testDice = new LoadedDice(new Die(new int[]{1,2,3}), new Die(new int[]{1,2,3})); 
		Roll testRoll = new Roll(testDice);
		assertEquals(testRoll.checkDoubleSkunk_test(),true);
	}
	
	@Test
	public void test_checkDeuce() {
		LoadedDice testDice = new LoadedDice(new Die(new int[]{1,2,3}), new Die(new int[]{2,1,3})); 
		Roll testRoll = new Roll(testDice);
		assertEquals(testRoll.checkDeuce_test(),true);
		
		LoadedDice testDice2 = new LoadedDice(new Die(new int[]{2,2,3}), new Die(new int[]{1,1,3})); 
		Roll testRoll2 = new Roll(testDice2);
		assertEquals(testRoll2.checkDeuce_test(),true);
	}
	
}
