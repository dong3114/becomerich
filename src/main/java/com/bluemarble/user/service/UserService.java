package com.bluemarble.user.service;

import java.util.ArrayList;

import com.bluemarble.land.dto.Land;
import com.bluemarble.user.dto.User;

public interface UserService {
	
    User createUser(String userName, int userMoney); // 유저를 생성하여 리턴한다.
    
    int rollDice(int diceNum); // 주사위의 개수를 입력 받아 주사위 굴리기, 각 1~6사이의 값을 리턴
    void moveByDice(User user, int diceNum); // 주사위 값으로 유저를 다음 위치의 인덱스로 이동시킨다.

    
    void payToll(User user, ArrayList<User> users, Land land); // 주인 있는 땅의 땅 통행료를 지불한다.

    void buyLand(User user, Land land); //유저가 땅을 구매한다.
    void sellLand(User user, Land land); //유저가 땅을 판매한다.
    void sellAllLands(User user); //유저가 소유한 땅을 전부 판매한다.
    
    boolean isUserAlive(User user); //유저의 소지금액이 1 이상인지 확인하여 생존 여부를 리턴한다.
}
