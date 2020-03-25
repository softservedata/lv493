
package softserve.edu.com.taqc493;

import java.util.Arrays;
import java.util.Scanner;

public final class Appl {

	public static void main(final String[] args) {

		System.out.println("Enter m = ");
		System.out.println("Enter numbers of digits m, n = ");

		int m = 0;
		int n = 0;

		try (Scanner sc = new Scanner(System.in)) {

			m = Integer.parseInt(sc.nextLine());
			n = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Exception");
		}

		ISuma suma = new Suma(m, n);
		System.out.println("Suma =" + suma.countSum());
		
		try {
			MultipleNum mt = new MultipleNum(8, 5);
			System.out.println("1 Method " + mt.num1toSet());
			System.out.println("2 Method " + mt.num2toSet());
			System.out.println("Multiple = " + mt.comonSet());
		} catch (NullPointerException e) {
			System.out.println("Exception!");
		}
		
		MersenNumbers mn = new MersenNumbers(244);
		System.out.println("MR = " + mn.isNumberSimple());

		IFibonacci f = new Fibonacci(12);
		System.out.println(Arrays.asList(f.firstWay()));
		System.out.println(Arrays.asList(f.secondWay()));
		System.out.println(Arrays.asList(f.compareWay()));

	}
}
