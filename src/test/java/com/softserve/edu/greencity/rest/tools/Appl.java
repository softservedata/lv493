package com.softserve.edu.greencity.rest.tools;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.HabitDictionaryIdEntity;

public class Appl {
	public static void main(String[] args) {
		//System.out.println("result = "+ new GenericConverter<String>() {}.getGenericClass().toString());

	    List<HabitDictionaryIdEntity> habits = new ArrayList<>();
	    habits.add(new HabitDictionaryIdEntity(1));
	    habits.add(new HabitDictionaryIdEntity(2));
	    habits.add(new HabitDictionaryIdEntity(3));

	    String json = new JsonUtils().entityToJson(habits, new GenericConverter<List<HabitDictionaryIdEntity>>() {}.getGenericType());

	    System.out.println("json =" +json);

	}
}
