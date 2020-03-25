/**
 * 
 */
package softserve.edu.com.taqc493;

import java.util.Arrays;

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
public class MersenNumbersTest {
	
	MersenNumbers mers = new MersenNumbers(15);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass");
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

	@Test
	public final void  isNumberSimpleTest()  {

		Integer[] arr = {1, 2, 3, 5, 7, 11, 13};
		Assert.assertEquals( mers.isNumberSimple(), Arrays.asList(arr));
		System.out.println("\tisNumberSimple");
		
	}
	
	@Test
	public final void  countMersenTest()   {
	
		Integer[] arr = {1, 3, 7};
		Assert.assertEquals( mers.countMersen(), Arrays.asList(arr));
		System.out.println("\tcountMersen");
		
	}

}
