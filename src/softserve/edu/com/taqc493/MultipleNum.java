/**
 * found common multiple numbers for two number,
 * but less than their product
 */
package softserve.edu.com.taqc493;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kristina
 */
public class MultipleNum implements IMultipleNum {

	private int num1;
	private int num2;

	/**
	 * @param num1
	 * @param num2
	 */
	public MultipleNum(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	/**
	 * create set num1
	 * 
	 * @return HashSet
	 */
	@Override
	public Set<Integer> num1toSet() {
		if((num1 == 0) || (num2 == 0)) {
			throw new NullPointerException("Those numbers do not have any common multiple");
		}else {
		Set<Integer> set1 = new HashSet<>();
		int i = 2;
		while ((num1 * i) <= (num1 * num2)) {
			set1.add(num1 * i);
			i++;
		}
		return set1;
		}
	}

	/**
	 * create set num2
	 * 
	 * @return HashSet
	 */
	@Override
	public Set<Integer> num2toSet() {
		Set<Integer> set1 = new HashSet<>();
		int i = 2;
		while ((num2 * i) <= (num1 * num2)) {
			set1.add(num2 * i);
			i++;
		}
		return set1;

	}

	/**
	 * common multiple 
	 * @return HashSet
	 */
	@Override
	public Set<Integer> comonSet() {
		Set<Integer> uniSet = new HashSet<>();
		uniSet.addAll(num1toSet());
		uniSet.addAll(num2toSet());
		Set<Integer> unX = new HashSet<>(uniSet);
		unX.removeAll(num1toSet());
		Set<Integer> unY = new HashSet<>(uniSet);
		unY.removeAll(num1toSet());
		Set<Integer> intersection = new HashSet<>(uniSet);
		intersection.removeAll(unX);
		intersection.removeAll(unY);
		return intersection;

	}

}
