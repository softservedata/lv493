package com.softserve.edu.greencity.rest.data.places;

import com.softserve.edu.greencity.rest.data.PlaceStatus;

public class PlacePredicate {
	
	private DiscountDto discountDto;
	private DistanceFromUserDto  distanceFromUserDto;
	private MapBoundsDto mapBoundsDto;
	
	private String searchReg;
	private PlaceStatus status;
	private String time;
	
	public PlacePredicate() {
		this.discountDto = null;
		this.distanceFromUserDto = null;
		this.mapBoundsDto = null;
		this.searchReg = "";
		this.status = null;
		this.time = "";
	}
	
	public PlacePredicate(DiscountDto discountDto, DistanceFromUserDto distanceFromUserDto, MapBoundsDto mapBoundsDto,
			String searchReg, PlaceStatus status, String time) {
		this.discountDto = discountDto;
		this.distanceFromUserDto = distanceFromUserDto;
		this.mapBoundsDto = mapBoundsDto;
		this.searchReg = searchReg;
		this.status = status;
		this.time = time;
	}

	public DiscountDto getDiscountDto() {
		return discountDto;
	}

	public DistanceFromUserDto getDistanceFromUserDto() {
		return distanceFromUserDto;
	}

	public MapBoundsDto getMapBoundsDto() {
		return mapBoundsDto;
	}

	public String getSearchReg() {
		return searchReg;
	}

	public PlaceStatus getStatus() {
		return status;
	}

	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "PlacePredicate [discountDto=" + discountDto + ", distanceFromUserDto=" + distanceFromUserDto
				+ ", mapBoundsDto=" + mapBoundsDto + ", searchReg=" + searchReg + ", status=" + status + ", time="
				+ time + "]";
	}
	
}


		class Specification {
			
			private String name;
			
			public Specification() {
				this.name = "";
			}
		
			public Specification(String name) {
				this.name = name;
			}
		
			public String getName() {
				return name;
			}
		
			@Override
			public String toString() {
				return "Specification [name=" + name + "]";
			}
			
		}
		
		class DistanceFromUserDto {
		   
			private double distance;
		    private double lat;
		    private double lng;
		    
		    public DistanceFromUserDto() {
				this.distance = 0;
				this.lat = 0;
				this.lng = 0;
			}
		    
			public DistanceFromUserDto(double distance, double lat, double lng) {
				this.distance = distance;
				this.lat = lat;
				this.lng = lng;
			}

			public double getDistance() {
				return distance;
			}

			public double getLat() {
				return lat;
			}

			public double getLng() {
				return lng;
			}

			@Override
			public String toString() {
				return "DistanceFromUserDto [distance=" + distance + ", lat=" + lat + ", lng=" + lng + "]";
			}
		   }
		
		
		class MapBoundsDto {
			
			private double northEastLat;
			private double northEastLng;
			private double southWestLat; 
			private double southWestLng;
			
			public MapBoundsDto() {

				this.northEastLat = 0;
				this.northEastLng = 0;
				this.southWestLat = 0;
				this.southWestLng = 0;
			}
			
			public MapBoundsDto(double northEastLat, double northEastLng, double southWestLat, double southWestLng) {
				super();
				this.northEastLat = northEastLat;
				this.northEastLng = northEastLng;
				this.southWestLat = southWestLat;
				this.southWestLng = southWestLng;
			}

			public double getNorthEastLat() {
				return northEastLat;
			}

			public double getNorthEastLng() {
				return northEastLng;
			}

			public double getSouthWestLat() {
				return southWestLat;
			}

			public double getSouthWestLng() {
				return southWestLng;
			}

			@Override
			public String toString() {
				return "MapBoundsDto [northEastLat=" + northEastLat + ", northEastLng=" + northEastLng
						+ ", southWestLat=" + southWestLat + ", southWestLng=" + southWestLng + "]";
			}
			     
		}

