/**
 * 
 */
package softserve.edu.com.taqc493;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Kristina
 *
 */
public class FibonacciTest {
	
	IFibonacci f1 = new Fibonacci(12);
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class Fibonacci");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class Fibonacci");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Before Method");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("After Method");
	}

	/**
	 * Test method for {@link softserve.edu.com.taqc493.Fibonacci#firstWay()}.
	 */
	@Test
	public final void testFirstWay() {
		Integer[] actual =  f1.firstWay();
		Integer[] expected  = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
		Assert.assertArrayEquals( actual, expected);
		System.out.println("\tFirstWay()");
	}

	/**
	 * Test method for {@link softserve.edu.com.taqc493.Fibonacci#secondWay()}.
	 */
	@Test
	public final void testSecondWay() {
		Integer[]  actual =  f1.secondWay();
		Integer[]  expected  = {0, 0, 1, 1, 3, 4, 8, 12, 21, 33, 55, 88};
		Assert.assertArrayEquals( actual, expected);
		System.out.println("\tSecondWay()");
	}

	/**
	 * Test method for {@link softserve.edu.com.taqc493.Fibonacci#compareWay()}.
	 */
	@Test
	public final void testCompareWay() {
		Integer[]  actual =  f1.compareWay();
		Integer[]  expected  = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
		Assert.assertArrayEquals( actual, expected);
		System.out.println("\tCompareWay()");
	}

}
