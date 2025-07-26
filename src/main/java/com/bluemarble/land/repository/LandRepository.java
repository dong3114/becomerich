package com.bluemarble.land.repository;

import java.util.ArrayList;
import java.util.List;
import com.bluemarble.land.dto.Land;
import org.springframework.stereotype.Repository;
import com.bluemarble.land.dto.RedLand;
import com.bluemarble.land.dto.YellowLand;
import com.bluemarble.land.dto.BlueLand;
import com.bluemarble.land.dto.GreenLand;

@Repository
public class LandRepository {
	List<Land> lands = new ArrayList<>();
	
    public LandRepository() {
        lands.add(RedLand.gyeongbokgung);
        lands.add(RedLand.myeongdong);
        lands.add(RedLand.haeundaeBeach);
        lands.add(RedLand.gamcheonVillage);
        lands.add(RedLand.chinatown);
        lands.add(YellowLand.eWorld);
        lands.add(YellowLand.seomunMarket);
        lands.add(YellowLand.yangrimdong);
        lands.add(YellowLand.familyPark);
        lands.add(YellowLand.expoSciencePark);
        lands.add(YellowLand.uamHistoricalPark);
        lands.add(BlueLand.daewangamPark);
        lands.add(BlueLand.whaleMuseum);
        lands.add(BlueLand.hwaseongHaenggung);
        lands.add(BlueLand.kbsSuwon);
        lands.add(BlueLand.namiIsland);
        lands.add(GreenLand.hanokVillage);
        lands.add(GreenLand.bibimbapStreet);
        lands.add(GreenLand.bulguksa);
        lands.add(GreenLand.cheomseongdae);
        lands.add(GreenLand.hallasanMountain);
        lands.add(GreenLand.seongsanIlchulbong);

    }
    public List<Land> getLands() { 
    	return lands;
    }
    
    public Land findLandname(String landName) {
    	for (Land land : lands) {
    		if (land.getLandName().equals(landName)) {
    			return land;
    		}
    		
    	} return null;
    }


}
