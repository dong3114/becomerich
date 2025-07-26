package com.bluemarble.land.dto;

public class Land {
	protected String landUserName;
	protected double landPrice;
	protected String landName;
	protected double lineWeight;
	protected String landRegion;
	protected double landToll;
	protected int level;
	
	public Land(String landName,double landPrice, String landRegion) {
		this.landName = landName;
		this.landPrice = landPrice;
		this.landRegion = landRegion;
		this.level = 0;
				
	}
	

	public double getLandPrice() {
		return landPrice;
	}


	public String getLandName() {
		return landName;
	}


	public String getLandRegion() {
		return landRegion;
	}


	public String getLandUserName() {
		return landUserName;
	}

	public void setLandUserName(String landUserName) {
		this.landUserName = landUserName;
	}

	public double getLineWeight() {
		return lineWeight;
	}

	public void setTaxWeight(double lineWeight) {
		this.lineWeight = lineWeight;
	}

	public double getLandToll() {
		return landToll;
	}

	public void setLandToll(double landToll) {
		this.landToll = landToll;
	}
	
	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "Land [landUserName=" + landUserName + ", landPrice=" + landPrice + ", landName=" + landName
				+ ", lineWeight=" + lineWeight + ", landRegion=" + landRegion + ", landToll=" + landToll + ", level="
				+ level + "]";
	}


	
}

	
	
	
	
	
