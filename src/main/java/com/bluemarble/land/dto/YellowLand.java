package com.bluemarble.land.dto;

public class YellowLand extends Land {
	public YellowLand(String landName,double landPrice, String landRegion) {
		super(landName, landPrice, landRegion);
		this.lineWeight = 1.3;
		this.landToll = landPrice * lineWeight;
	}
	
	public static Land eWorld = new YellowLand("이월드", 55000, "대구");
	public static Land seomunMarket = new YellowLand("서문시장", 50000, "대구");
	public static Land yangrimdong = new YellowLand("양림동", 45000, "광주");
	public static Land familyPark = new YellowLand("가족공원", 42000, "광주");
	public static Land expoSciencePark = new YellowLand("엑스포과학공원", 40000, "대전");
	public static Land uamHistoricalPark = new YellowLand("우암역사공원", 38000, "대전");
	


}
