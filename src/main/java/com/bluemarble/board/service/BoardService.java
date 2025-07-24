package com.bluemarble.board.service;

import java.util.List;
import java.util.Scanner;

import com.bluemarble.user.dto.User;

public interface BoardService {
	/**
	 * 현재 유저가 Rule에 의거해서 탈락 여부를 확인하는 메서드
	 * @param user
	 * @return T 생존, F 탈락
	 */
    boolean checkElimination(User user);
    /**
     * 현재 턴에 게임이 끝났는지의 여부를 확인하는 메서드 
     * @return alive 생존 유저 반환 
     */
    void endTurnBoard();
    
    /**
     * 
     * @param sc 외부에서 받아올 입력 객체 (유저정보 입력)
     */
    void startGame(Scanner sc);
    List<User> endGame();
}
