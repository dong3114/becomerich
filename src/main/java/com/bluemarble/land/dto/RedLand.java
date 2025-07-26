package com.bluemarble.land.dto;

public class RedLand extends Land {
	public RedLand(String landName,double landPrice, String landRegion) {
		super(landName, landPrice, landRegion);
		this.lineWeight = 2;
		this.landToll = landPrice * lineWeight;
		
	}
	public static Land gyeongbokgung = new RedLand("경복궁", 85000, "서울");
	public static Land myeongdong = new RedLand("명동", 80000, "서울");
	public static Land haeundaeBeach = new RedLand("해운대해수욕장", 75000, "부산");
	public static Land gamcheonVillage = new RedLand("감천문화마을", 70000, "부산");
	public static Land chinatown = new RedLand("차이나타운", 65000, "인천");
	public static Land songdo = new RedLand("송도", 60000, "인천");
	


}
