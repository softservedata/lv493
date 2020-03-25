/**
 * @author Kristina
 * 
 */

package softserve.edu.com.taqc493;

/**
 * counT sum for last n digits of number m
 * 
 */
public class Suma implements ISuma {

	private int m;
	private int n;

	/**
	 * 
	 * @param m
	 * @param n
	 */
	public Suma(int m, int n) {
		this.m = m;
		this.n = n;
	}

	/**
	 * Convert m to string.
	 * 
	 * @return
	 */
	@Override
	public String[] sumToArray() {
		if (m <= 0) {
			throw new IllegalArgumentException("M should be a positive number");
		}
		String[] list = Integer.toString(m).split("");
		return list;
	}

	/**
	 * count sum
	 * @return
	 */
	@Override
	public int countSum() {
		if ((Integer.toString(m).length() <= n) ||  (n < 0)) {
			throw new IllegalArgumentException("N is invalid ");
		}
		String[] list = sumToArray();
		int sum = 0;
		for (int i = (list.length - n); i < list.length; i++) {
			sum = sum + Integer.valueOf(list[i]);
		}
		return sum;

	}

}
