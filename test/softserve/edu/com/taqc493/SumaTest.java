package softserve.edu.com.taqc493;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SumaTest {
	
	Suma suma = new Suma(12345, 2);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class Suma");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class Suma ");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before Method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After Method");
	}

	@Test
	public final void testSumToArray() {
		ISuma suma = new Suma(12345, 2);
		String[] actuals = suma.sumToArray();
		String[] expecteds = {"1","2","3","4","5"};
		Assert.assertArrayEquals(expecteds, actuals);
		System.out.println("\tSumToArray " );
	}


	@Test
	public final void testCountSum1() {
		ISuma suma = new Suma(12345, 2);
		Assert.assertEquals("12345 sum from 2nd gigits", 9, suma.countSum());
		System.out.println("\tCountSum1");
	}
	
	/*
	 * check Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testCountSum2() throws IllegalArgumentException {
		ISuma suma1 = new Suma(12345, -6);
		suma1.countSum();
		System.out.println("\tException");
	}
	
	@Test
	public final void testCountSum3() {
		ISuma suma3 = new Suma(12345, 5);
		Assert.assertEquals(15, suma3.countSum());
		System.out.println("\tCountSum3 " );
	}
	
	@Test
	public final void testCountSum4() {
		ISuma suma4 = new Suma(4321, 3);
		Assert.assertEquals(6, suma4.countSum());
		System.out.println("\tCountSum4 " );
	}

	/*
	 * check Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testCountSum5() throws IllegalArgumentException {
		ISuma suma1 = new Suma(-12345, 6);
		suma1.countSum();
		System.out.println("\tException");
	}
	
	/*
	 * check Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testCountSum6() throws IllegalArgumentException {
		ISuma suma1 = new Suma(0, 0);
		suma1.countSum();
		System.out.println("\tException");
	}
	
	/*
	 * check Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testCountSum7() throws IllegalArgumentException {
		ISuma suma7 = new Suma(12345, 0);
		suma7.countSum();
		System.out.println("\tException");
	}

}
