import java.util.ArrayList;

import org.junit.Test;

public class FirstTest {

	@Test
	public void testM1() {

		int uno = 3;
		int dos = 5;

		ArrayList<Integer> Numbers = new ArrayList<Integer>();
		Numbers.add(uno);
		Numbers.add(dos);

		if (Numbers.size()>0) {
		System.out.println("PASS");
		}
		for (Integer number : Numbers) {
			if ((number % 3 == 0) && (number == 3)) {
				System.out.println("PASS " + number + " is dividible by 3!");
			}
		}
		for (Integer number : Numbers) {
			if ((number % 5 == 0) && (number == 5)) {
				System.out.println("PASS " + number + " is dividible by 5!");
			}
		}

	}
}
