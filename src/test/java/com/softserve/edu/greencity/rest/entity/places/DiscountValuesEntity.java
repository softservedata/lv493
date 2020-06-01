package com.softserve.edu.greencity.rest.entity.places;

public class DiscountValuesEntity {

    private int value;
    private SpecificationEntity specification;
    
    public DiscountValuesEntity() {
        this.value = -1;
        this.specification = new SpecificationEntity("");
    }

    public DiscountValuesEntity(int value, SpecificationEntity specification) {
       
        this.value = value;
        this.specification = specification;
    }

	public int getValue() {
		return value;
	}

	public SpecificationEntity getSpecification() {
		return specification;
	}

	@Override
	public String toString() {
		return "DiscountValuesEntity [value=" + value + ", specification=" + specification + "]";
	}
    
    
    
}
