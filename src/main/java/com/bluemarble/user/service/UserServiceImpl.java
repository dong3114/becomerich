package com.bluemarble.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.bluemarble.land.dto.Land;
import com.bluemarble.user.dto.User;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public User createUser(String userName, int userMoney) {
    	/*
    	 * 유저의 이름과 유저 시작 금액을 입력 받아 User 객체를 new 해서 리턴한다.
    	 */
        return new User(userName, userMoney);
    }
	
    @Override
    public int rollDice(int diceNum) {
    	/*
    	 * 1부터 6사이의 랜덤한 숫자를 리턴한다.
    	 */
        Random random = new Random();
        int sum = 0;
        
        for (int i = 0; i<diceNum; i++) {
        	sum += random.nextInt(6) + 1;
        }
        
        return sum;
    }

    @Override
    public void moveByDice(User user, int landIndex) {
    	/*
    	 * 움직이는 유저 객체와, 다음으로 도착한 땅의 인덱스를 입력 받아, 유저의 현재 서있는 땅 인덱스를 저장한다.
    	 */
        user.setUserLocationIndex(landIndex);
    }
    
    @Override
    public void payToll(User user, ArrayList<User> users, Land land) {
    	/*
    	 * 통행료를 지불할 유저, 전체 유저 리스트, 통행료를 지불할 땅 객체를 입력 받아
    	 * 땅 toll에 맞춰 통행료 지불하는 사람의 돈을 차감하고, 땅 주인의 소지금을 증가시킨다.
    	 */
    	try {
    		int tollFee = -land.getLandToll();
            String landOwnerName = land.getLandUserName();
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		System.out.println("없는 땅 입니다.");
    	}
    	
        if (landOwnerName != null) {
        	User landOwner = users.stream().filter(u -> u.getUserName().equals(landOwnerName)).findFirst().orElse(null); // 이 부분 exception 처리가 필요할 듯?
            try {
            	changeUserMoney(user, tollFee);
                receiveToll(landOwner, tollFee);
            }
            catch (Exception e) {
            	System.out.println(e.getMessage());
            	System.out.println("땅 주인인 유저를 찾을 수 없습니다.");
            }
        }
    }

    @Override
    public void buyLand(User user,Land land) {
    	/*
    	 * 땅을 살 유저와 사고자 하는 땅 객체를 입력받아
    	 * 땅 가격만큼 유저의 금액을 차감하고, 유저 소유 땅 리스트에 매개 변수로 받은 땅 객체를 저장함.
    	 */
        int payment = -(land.getLandPrice());
        changeUserMoney(user, payment);
        user.getUserLands().add(land);
    }

    @Override
    public void sellLand(User user, Land land) {
    	/*
    	 * 땅을 팔 유저와, 팔고자 하는 땅 객체를 입력 받아
    	 * 땅 가격만큼 유저의 금액을 추가하고, 유저 소유 땅 리스트에서 땅 객체를 삭제함.
    	 */
        int income = land.getLandPrice();
        changeUserMoney(user, income);
        user.getUserLands().removeIf(l -> l.getLandName().equals(land.getLandName()));
    }


    @Override
    public void sellAllLands(User user) {
    	/*
    	 * 유저가 소유한 전체 땅을 팔고 땅들의 가격 만큼 유저의 소지금을 증가시킨다.
    	 */
        List<Land> userOwnLands = user.getUserLands();
        
//        System.out.println("sellAllLands 를 실행합니다."); 
        while (!userOwnLands.isEmpty()) { // 리스트가 비어있지 않은지 확인
            Land lastItem = userOwnLands.remove(userOwnLands.size() - 1); // 마지막 요소 제거 및 반환
        }         
    }
    
    @Override
	public boolean isUserAlive(User user) {
    	/*
    	 * 유저가 소유한 금액이 0 초과이면 True, 0 이하이면 False를 리턴한다. 
    	 */
		return (user.getUserMoney() > 0) ? true : false;
	}
    
    
    private void receiveToll(User user, int tollFee) {
    	/*
    	 * 내부에서 유저에게 toll 비용을 지불하는 메서드
    	 */
        changeUserMoney(user, tollFee);
    }

    private void changeUserMoney(User user, int changedAmount) {
    	/*
    	 * 유저의 소지금을 변경시키는 메서드
    	 */
        int moneyHaving = user.getUserMoney();
        user.setUserMoney(moneyHaving + changedAmount);
    }

	

	

}
