package com.softserve.edu.opencart.data.comparator;

import java.math.BigDecimal;
import java.util.Comparator;

public class StrPriceDescComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		if (o1 == null && o2 == null) {
			return 0;
		} else if (o1 == null) {
			return 1;
		} else if (o2 == null) {
			return -1;
		}
		BigDecimal bd1 = new BigDecimal(o1.replace(",", ""));
		BigDecimal bd2 = new BigDecimal(o2.replace(",", ""));
		// return -o1.compareTo(o2);
		return bd2.compareTo(bd1);
	}
}
