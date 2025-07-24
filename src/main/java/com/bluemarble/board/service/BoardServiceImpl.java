package com.bluemarble.board.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemarble.board.dto.Board;
import com.bluemarble.user.dto.User;
import com.bluemarble.user.service.UserService;
import com.bluemarble.utils.rule.GameRule;
import com.bluemarble.utils.rule.RuleUtils;
/**
 * 최종수정: 2025.07.24 (작성자: 한동환)
 *
 * BoardServiceImpl은 단일 User나 Land 객체를 직접 조작하지 않습니다.
 * 이 클래스는 게임 흐름 전반에 관여하며, 생존한 모든 사용자 목록, 전체 보유 토지 등
 * 복수의 도메인 객체 컬렉션을 대상으로 동작하는 서비스 레이어입니다.
 *
 * 주요 기능
 * - 턴 종료 시 유저 생존 여부 확인 및 턴 증가
 * - 최대 턴 도달 시 게임 종료 절차 수행
 * - 전체 유저 자산 평가 및 승자 판단 등
 *
 * 설계 의도
 * 사용자 개별 조작은 다른 도메인 서비스에서 처리하고,
 * 이 서비스는 게임 판(Board)과 규칙(GameRule)을 기반으로 전체 흐름을 관리합니다.
 */
@Service
public class BoardServiceImpl implements BoardService{
	private Board board;
	private GameRule gameRule;
	private UserService userServiceImpl;
	
	@Autowired
	public BoardServiceImpl(Board board, GameRule gameRulem, UserService userService) {
		this.board = board;
		this.gameRule = gameRule;
		this.userServiceImpl = userService;
	}
	
	@Override
	public boolean checkElimination(User user) {
		return RuleUtils.isBankruptcy().apply(user, gameRule);
	}
	
	@Override
	public List<User> endGame() {
		
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
			for(User user : aliveUsers) {
			}
			RuleUtils.maxTurn(aliveUsers);	// 전체 유저의 모든 땅 판매
		}
		board.setAliveUser(aliveUsers);
	}
	
	@Override
	public void startGame(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	
}
