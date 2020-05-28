package com.softserve.edu.greencity.rest.entity.places;

public class DiscountValuesEntity {

    private int value;
    private Specification specification;
    
    public DiscountValuesEntity() {
        this.value = -1;
        this.specification = new Specification("");
    }

    public DiscountValuesEntity(int value, Specification specification) {
        System.out.println("DiscountValuesEntity value: " + value);
        System.out.println("DiscountValuesEntity specification: " + specification);
        this.value = value;
        this.specification = specification;
    }
    
    
    private class Specification{
        private String name;

        public Specification(String name) {
            this.name = name;
        }
    }


    public int getValue() {
        return value;
    }

    public Specification getSpecification() {
        return specification;
    }

    @Override
    public String toString() {
        return "DiscountValuesEntity [value=" + value + ", specification=" + specification + "]";
    }
    
    
}
