package com.bluemarble.land.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.bluemarble.land.dto.Land;
import com.bluemarble.land.repository.LandRepository;

@Service
public class LandServiceImpl implements LandService{
	
	@Autowired
	private LandRepository landRepository;

	

	@Override
	public void changeLandUser(String landName, String userName) {
		Land landTarget = landRepository.findLandname(landName);
		landTarget.setLandUserName(userName);
	}


	@Override
	public void bulildTower() {
		// TODO Auto-generated method stub
		
	}
	

		
	}
	

		  





