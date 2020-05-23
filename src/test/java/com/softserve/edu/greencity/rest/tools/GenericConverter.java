package com.softserve.edu.greencity.rest.tools;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericConverter<T> {

	public Type getGenericType() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		//System.out.println("parameterizedType = " + parameterizedType.toString());
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		//System.out.println("actualTypeArguments[0] = " + actualTypeArguments[0].toString());
		return actualTypeArguments[0];
	}
	
	public Class<?> getGenericClass() {
		return (Class<?>) getGenericType();
	}
}
