package com.softserve.edu.greencity.rest.data.places;

public class DiscountDto {
			
			private double discountMax;
			private double discountMin;
			private Specification specification;
			
			public DiscountDto() {
				this.discountMax = 0;
				this.discountMin = 0;
				this.specification = null;
			}
			
			public DiscountDto(double discountMax, double discountMin, Specification specification) {
				this.discountMax = discountMax;
				this.discountMin = discountMin;
				this.specification = specification;
			}
		
			public double getDiscountMax() {
				return discountMax;
			}
		
			public double getDiscountMin() {
				return discountMin;
			}
		
			public Specification getSpecification() {
				return specification;
			}
		
			@Override
			public String toString() {
				return "discountDto [discountMax=" + discountMax + ", discountMin=" + discountMin + ", specification="
						+ specification + "]";
			}
		

}
