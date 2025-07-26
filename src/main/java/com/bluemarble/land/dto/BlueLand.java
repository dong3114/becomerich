package com.bluemarble.land.dto;


public class BlueLand extends Land {
	public BlueLand(String landName,double landPrice, String landRegion) {
		super(landName, landPrice, landRegion);
		this.lineWeight = 1.3;
		this.landToll = landPrice * lineWeight;
	}
	
	public static Land daewangamPark = new BlueLand("대왕암공원", 36000, "울산");
	public static Land whaleMuseum = new BlueLand("고래박물관", 34000, "울산");
	public static Land hwaseongHaenggung = new BlueLand("화성행궁", 32000, "수원");
	public static Land kbsSuwon = new BlueLand("KBS수원방송센터", 30000, "수원");
	public static Land namiIsland = new BlueLand("남이섬", 28000, "춘천");
	public static Land dakgalbiStreet = new BlueLand("닭갈비골목", 26000, "춘천");
	

	
	
	
	
}
