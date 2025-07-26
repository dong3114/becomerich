package com.bluemarble.land.dto;

public class GreenLand extends Land {
	public GreenLand(String landName,double landPrice, String landRegion) {
		super(landName, landPrice, landRegion);
		this.lineWeight = 1.5;
		this.landToll = landPrice * lineWeight;
		
	}

	
	public static Land hanokVillage = new GreenLand("한옥마을", 24000, "전주");
	public static Land bibimbapStreet = new GreenLand("비빔밥거리", 22000, "전주");
	public static Land bulguksa = new GreenLand("불국사", 20000, "경주");
	public static Land cheomseongdae = new GreenLand("첨성대", 18000, "경주");
	public static Land hallasanMountain = new GreenLand("한라산", 16000, "제주");
	public static Land seongsanIlchulbong = new GreenLand("성산일출봉", 14000, "제주");


	
	
}
