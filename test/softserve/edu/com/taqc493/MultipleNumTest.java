/**
 * 
 */
package softserve.edu.com.taqc493;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Kristina
 */
public class MultipleNumTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class MultipleNumTest");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Before Class MultipleNumTest");
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
	public final void num1toSetTest() {
		IMultipleNum num = new MultipleNum (14, 12);
		Set<Integer> set1 = new HashSet<>();
				set1.add(112);
				set1.add(98);
				set1.add(84);
				set1.add(70);
				set1.add(56);
				set1.add(168);
				set1.add(42);
				set1.add(154);
				set1.add(28);
				set1.add(140);
				set1.add(126);
		Assert.assertEquals( num.num1toSet(), set1);
		System.out.println("\tNum1toSet");
	}
	
	@Test
	public final void num2toSetTest() {
		IMultipleNum num2 = new MultipleNum (8, 5);
		Set<Integer> set1 = new HashSet<>();
				set1.add(10);
				set1.add(15);
				set1.add(20);
				set1.add(25);
				set1.add(30);
				set1.add(35);
				set1.add(40);
		Assert.assertEquals( num2.num2toSet(), set1);
		System.out.println("\tNum2toSet");
	}
	
	@Test
	public final void comonSetTest() {
		IMultipleNum num3 = new MultipleNum (10, 5);
		Set<Integer> set1 = new HashSet<>();
				set1.add(20);
				set1.add(30);
				set1.add(40);
				set1.add(50);
		Assert.assertEquals( num3.comonSet(), set1);
		System.out.println("\tcomonSet");
	}
	
	@Test(expected = NullPointerException.class)
	public final void comonSetTest2() {
		IMultipleNum num3 = new MultipleNum (0, 5);
		num3.comonSet();
		System.out.println("\t\tcomonSet Exception");
	}
	
	@Test(expected = NullPointerException.class)
	public final void comonSetTest3() {
		IMultipleNum num4 = new MultipleNum (12, 0);
		num4.comonSet();
		System.out.println("\t\tcomonSet Exception");
	}

}
