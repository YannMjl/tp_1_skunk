import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceDieTest {
	private Die die;

	@Before
	public void setUp() throws Exception {
		int[] init_values = new int[] { 3, 2, 1 };
		die = new Die(init_values);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test()
	public void test_null_initial_int_array2() {
		try {
			Die die1 = new Die(null);
			die1.roll();
		} catch (RuntimeException rexp) {
			return;
		}

		fail();
	}
	
	@Test
	public void test_constructor()
	{
		int[] iArray = {1};
		
		Die d = new Die(iArray);
		
		d.roll();
		
		int result = d.getLastRoll();
		
		assertEquals("first roll is 1", 1,result);
	
	}

	@Test
	public void test_length_2_seq()
	{
		int[] arr2 = {1,2}	;
		Die d = new Die(arr2);	
		d.roll();
		int result = d.getLastRoll();
		assertEquals(1,result);
		d.roll();
		assertEquals(2,d.getLastRoll());
		
	}
	
	@Test
	public void test_length_3_seq()
	{
		int[] arr3 = {1,2,3}	;
		Die d = new Die(arr3);	
		d.roll();
		int result = d.getLastRoll();
		assertEquals(1,result);
		d.roll();
		assertEquals(2,d.getLastRoll());
		d.roll();
		assertEquals(3,d.getLastRoll());
		
	}
	
	@Test
	public void test_length_2_seq_3_rolls()
	{ 
		int[] arr = {2,1}	;
		Die d = new Die(arr);	
		d.roll();
		assertEquals(2,d.getLastRoll());
		d.roll();
		assertEquals(1,d.getLastRoll());
		d.roll();
		assertEquals(2,d.getLastRoll());
	}
	 
	@Test
	public void test_length_3_seq_6_rolls()
	{ 
		int[] arr1 = {1,2,3};
		Die d = new Die(arr1);	
		d.roll();
		assertEquals(1,d.getLastRoll());
		d.roll();
		assertEquals(2,d.getLastRoll());
		d.roll();
		assertEquals(3,d.getLastRoll());
		
		d.roll();
		assertEquals(1,d.getLastRoll());
		d.roll();
		assertEquals(2,d.getLastRoll());
		d.roll();
		assertEquals(3,d.getLastRoll());	
	}
	@Test
	public void test_roll()
	{
		Die d = new Die(new int[] {1,2,3,4,5,6});
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);
		d.roll();
		assertEquals(d.getLastRoll(),3);
		d.roll();
		assertEquals(d.getLastRoll(),4);
		d.roll();
		assertEquals(d.getLastRoll(),5);
		d.roll();
		assertEquals(d.getLastRoll(),6);
	}
	
	@Test
	public void test_roll_wrap_around()
	{
		Die d = new Die(new int[] {1,2,3,4,5,6});
		d.roll();
		d.roll();
		d.roll();
		d.roll();
		d.roll();
		d.roll();	
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);	
	}

	@Test
	public void test_initialization_of_predictable_die() {
		die.roll();
		int value = die.getLastRoll();

		assertEquals("first value not 3", 3, value);

	}

	@Test
	public void test_roll_2_of_predictable_die() {
		die.roll();
		assertEquals("first value not 3", 3, die.getLastRoll());
		die.roll();
		assertEquals("second value not 2", 2, die.getLastRoll());
	}

	@Test
	public void test_roll_3_of_predictable_die() {
		die.roll();
		die.roll();
		die.roll();
		assertEquals("third value not 1", 1, die.getLastRoll());
	}

	@Test
	public void test_roll_4_of_predictable_die_with_3_rolls() {
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals("fourth value not wrapping back to first value 3", 3, die.getLastRoll());
	}

	@Test
	public void test_roll_5_of_predictable_die_with_3_rolls() {
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals("fourth value not wrapping back to first value 3", 2, die.getLastRoll());
	}

	@Test
	public void test_roll_6_of_predictable_die_with_3_rolls() {
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals("fourth value not wrapping back to first value 3", 1, die.getLastRoll());
	}

	@Test(expected = RuntimeException.class)
	public void test_null_initial_int_array() {
		Die die1 = new Die(null);
		die1.roll();
	}
}
