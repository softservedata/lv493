/**
 * Mersen number = pow((2, n) -1) if is simple;
 * foound Mersen numbers, less than some value.
 */

package softserve.edu.com.taqc493;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristina
 */
public class MersenNumbers {

	/**
	 * Found numbers not more than mersen.
	 */
	private int mersen;

	public MersenNumbers(int mersen) {
		this.mersen = mersen;
	}

	/**
	 * Array of simple numbers
	 */
	public List<Integer> isNumberSimple() {
		List<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= mersen; i++) {
			int count = 0;
			for (int k = 1; k <= mersen; k++) {
				if (i % k == 0) {
					count++;
				}
			}
			if (count <= 2) {
				arr.add(i);
			}
		}
		return arr;
	}

	public List<Integer> countMersen() {
		List<Integer> arr1 = new ArrayList<>();
		List<Integer> arr = isNumberSimple();
		for (int i = 0; i < Math.sqrt(arr.size()); i++) {
			int a1 = (int) (Math.pow(2, arr.get(i)) - 1);

			for (int j = 0; j < arr.size(); j++)
				if (a1 == arr.get(j)) {
					arr1.add(a1);
				}

		}

		return arr1;
	}

}
