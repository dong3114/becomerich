package com.bluemarble.board.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemarble.board.dto.Board;
import com.bluemarble.user.dto.User;
import com.bluemarble.utils.rule.CheckRule;
import com.bluemarble.utils.rule.GameRule;
import com.bluemarble.utils.rule.RuleUtils;
/**
 * 최종수정 (2025.07.24 한동환)  
 * BoardService는 단일 User나 Land 객체를 직접 다루기 위한 서비스가 아닙니다.
 * 이 클래스는 생존한 모든 사용자, 보유한 모든 토지 등 게임 진행에 필요한
 * 복수의 객체 집합을 대상으로 조작을 수행하는 서비스 레이어입니다.
 * 
 * 예: 턴 종료 처리, 전체 자산 평가, 게임 종료 조건 판단 등.
 */
@Service
public class BoardServiceImpl implements BoardService{
	private Board board;
	private GameRule gameRule;
	
	@Autowired
	public BoardServiceImpl(Board board, GameRule gameRule) {
		this.board = board;
		this.gameRule = gameRule;
	}
	
	
	@Override
	public boolean checkElimination(User user) {
		return RuleUtils.isBankruptcy().apply(user, gameRule);
	}
	
	@Override
	public User endGame() {
		
		return null;
	}

	@Override
	public void endTurnBoard() {
		// 1. 보드 객체의 남은 유저로드
		List<User> aliveUsers = board.getAliveUser();
		// 2. 생존여부를 통해서 생존리스트에서 out
		aliveUsers.removeIf(user -> !user.isAlive());
		// 3. max턴 여부 확인 후 아니면 nextTurn으로 턴 증가
		if(gameRule.getMaxTurn() > board.getCurrentTurn()) {
			board.nextTurn();
		} // 4. max턴 일때 GameRule에 의해서 maxTurn 메서드 실행
		else {
			RuleUtils.maxTurn(aliveUsers);	// 전체 유저의 모든 땅 판매
		}
		board.setAliveUser(aliveUsers);
	}
	
	@Override
	public void startGame(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	
}
