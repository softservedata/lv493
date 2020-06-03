package com.softserve.edu.greencity.rest.data.econews;

public class ExpectedResponce {
	
	private int responcecode;

	
	public ExpectedResponce(int responcecode) {
		
		this.responcecode = responcecode;
	}
	
	public int getResponcecode() {
		return responcecode;
	}
	
	@Override
	public String toString() {
		return "EcspectedResponceCode [responcecode=" + responcecode + "]";
	}
	
	
	

}
