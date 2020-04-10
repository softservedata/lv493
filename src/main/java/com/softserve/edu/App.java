package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	public static void main(String[] args) {
		/*-
		// System.out.println( "Hello World!" );
		String s = "abc";
		StringBuilder sb = new StringBuilder("abc");
		System.out.println("s.equals(sb): " + s.equals(sb));
		System.out.println("s.contentEquals(sb): " + s.contentEquals(sb));
		//
		String s1 = "Java";
		String s2 = "Java";
		String s3 = new String("Java");
		//
		// Invalid Solution
		System.out.println("(s1 == s2): " + (s1 == s2));  // true
		System.out.println("(s1 == s3): " + (s1 == s3));  // false
		//
		// Correct
		System.out.println("s1.equals(s2): " + s1.equals(s2));
		System.out.println("s1.equals(s3): " + s1.equals(s3));
		//
		System.out.println("(s1.compareTo(s2) == 0): " + (s1.compareTo(s2) == 0));
		System.out.println("(s1.compareTo(s3) == 0): " + (s1.compareTo(s3) == 0));
		//
		System.out.println("s1.hashCode(): " + s1.hashCode());
		System.out.println("s2.hashCode(): " + s2.hashCode());
		System.out.println("s3.hashCode(): " + s3.hashCode());
		//
		System.out.println("(s1.hashCode() == s2.hashCode()): " + (s1.hashCode() == s2.hashCode()));
		System.out.println("(s1.hashCode() == s3.hashCode()): " + (s1.hashCode() == s3.hashCode()));
		*/
		//
		/*-
		//String pattern = "[ Na-z]+";
		String pattern = "[a-z]+";
		String text = "Now is the time";
		//
		String pattern = "\\w*\\Bbb\\B\\w*";
		String text = "abba  bb abb bba ccbba";
		//
		//String pattern = "<.+>";
		//String pattern = "<[^>]+>"; // All Tags
		String pattern = ">[^<]+<"; // All Text
		String text = "<p><b>Beginning with bold text</b> next, text body,<i>italic text</i> end of text.</p>";
		/
		String pattern = "<([^>]+)>[^<]+</\\1>";
		String text = "<p><b>Beginning with bold text</b> next, <span>text</span> body,<i>italic text</i> end of text.</p>";
		//
		String pattern = "\\w+(\\.\\w+)*@(\\w+\\.)+\\w{2,}";
		String text = "a.b.c@i.ua aaa@i.u  bbb.@gmail.com my@ukr.net";
		//
		String pattern = "^\\d+";
		String text = " 1 item(s) - $602.00";
		text = text.trim();
		*/
		String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}";
		String text = " 2 item(s) - $1,204.00";
		//
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		//
		if (m.matches()) {
			System.out.println("Text <=> Pattern");
		}
		m.reset();
		//
		// List<String> list = new ArrayList<>();
		while (m.find()) {
			System.out.print(text.substring(m.start(), m.end()) + "*");
			//
			// String current = text.substring(m.start() + 1, m.end() -1).trim();
			// list.add(current);
			//
//			int count = m.group(1).length();
//			String s = text.substring(m.start() + count + 2, m.end() - count - 3);
//			System.out.println(s);
			//
			double d = Double.valueOf(text.substring(m.start(), m.end()).replace(",", ""));
			System.out.println("\nd + 0.01 = "+ (d + 0.01));
		}
		// System.out.println("list: " + list);
	}
}
