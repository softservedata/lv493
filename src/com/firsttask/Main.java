package com.firsttask;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
static int aaa;
	public Main(int a) {
		//aaa = a;
	}
	public static void main(String[] args) {
		Main first = new Main(aaa);
		first.m1();
	}
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

		System.out.println("У масиві " + Numbers.size() + " числа");
		for (Integer number:Numbers) {
			if (number%3==0) {
				System.out.println(number + " ділиться на 3!");
			}
		}
		for (Integer number:Numbers) {
		   if (number%5==0) {
			System.out.println(number + " ділиться на  5!");
		   }
}
	}
}