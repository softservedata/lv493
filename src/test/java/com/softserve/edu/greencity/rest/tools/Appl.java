package com.softserve.edu.greencity.rest.tools;

public class Appl {
	public static void main(String[] args) {
		System.out.println("result = "+ new GenericConverter<String>() {}.getGenericClass().toString());
	}
}
