package com.firsttask;
import java.util.Scanner;
import java.util.ArrayList;

interface FirstInterface {
	public void m1();
}

public class M1 implements FirstInterface {


public void m1(){

	Scanner sc = new Scanner(System.in);
       System.out.println("Введіть число та натисніть ENTER, потім повторіть операцію ще раз:");

       int uno = sc.nextInt();
       int dos = sc.nextInt();
       int tre = sc.nextInt();


       sc.close();
	
	ArrayList <Integer> Numbers = new ArrayList<Integer>();
	Numbers.add(uno);
	Numbers.add(dos);
	Numbers.add(tre);

	System.out.println(Numbers.size());
	for (Integer number:Numbers) {
		if (number%3==0) {
			System.out.println(number + " is dividible by 3!");
		}
	}
	for (Integer number:Numbers) {
	   if (number%5==0) {
		System.out.println(number + " is dividible by 5!");
	   }
	}
}
}

	/*
	public static void M1 (String[]args) {
		ArrayList <Integer> Numbers = new ArrayList<Integer>();
	 Numbers.add(3) ;
	 Numbers.add(4);
	 Numbers.add(5);
	 int a = Numbers.get(0); 
	 int b = Numbers.get(1); 
	 int c = Numbers.get(2); 

			if (a*a+b*b==c*c) {
				System.out.println("Pifagors number!");
			}
			else {				
				System.out.println("Not a Pifagors number!");
}
		}
	*/
	
