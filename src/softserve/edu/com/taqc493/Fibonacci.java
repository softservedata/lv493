/**
 * Found Fibonacci numbers & compare.
 * 
 * First way : f(1) =0; f(2)= 1; f(n )= f(n-1) = f(n-2);
 * Second way : f(n) = (1/Math.sqrt(5)) * (1 + (Math.sqrt(5))) / 2);
 */
package softserve.edu.com.taqc493;

/**
 * 
 * @author Kristina
 *
 */
public class Fibonacci implements IFibonacci {

	private static final double m = Math.sqrt(5.0);
	private static final double k = 1.0 / m;
	private static final double l = (1 + m) / 2.0;
	private int times;

	/**How many numbers shold count..
	 * @param times
	 */
	public Fibonacci(int times) {
		this.times = times;
	}

	/**
	 * Found Fibonacci nubers by first way.
	 * @return
	 */
	@Override
	public Integer[] firstWay() {
		Integer[] array = new Integer[times];
		array[0] = 0;
		array[1] = 1;
		for (int i = 2; i < array.length; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array;
	}
	
	/**
	 * Found Fibonacci nubers by second way.
	 * @return
	 */
	@Override
	public  Integer[]  secondWay() {
		Integer[]  array = new Integer[times];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (k * Math.pow(l, i));
		}
		return array;
	}
	
	/**
	 * Comparation
	 * @return
	 */
	@Override
	public Integer[]  compareWay() {
		Integer[]  arrayCompare = new Integer[times] ;
		for (int i = 0; i < arrayCompare.length; i++) {
			arrayCompare[i] = Math.abs(secondWay()[i] - firstWay()[i]);
		}
		return arrayCompare;
	}

}
