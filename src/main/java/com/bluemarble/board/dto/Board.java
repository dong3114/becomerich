package com.bluemarble.board.dto;

import java.util.List;
import java.util.Map;

import com.bluemarble.land.dto.Land;
import com.bluemarble.user.dto.User;

/**
 * 최종 수정(2025.07.19 "한동환")
 * 1. Board 객체는 게임 내에서 단 한번 생성 되고, 이후 게임 종료까지 동일 객체를 가져야해서 Builder 패턴도입 안하기로 결정
 * 2.
 */
public class Board {
    private Map<User, Integer>userPosition;
    private int aliveCount;
    private List<User> aliveUser;
    private int currentTurn;
    private List<Land> boardTiles;

    // getter
    public Map<User, Integer> getUserPosition(User user) {
        return userPosition;
    }
    public int getAliveCount() {
        return aliveCount;
    }
    public List<User> getAliveUser() {
        return aliveUser;
    }
    public List<Land> getBoardTiles() {
        return boardTiles;
    }
    public int getCurrentTurn() {
        return currentTurn;
    }
    // setter
    public void nextTurn() {
        this.currentTurn += 1;
    }
    public void setBoardTiles(List<Land> boardTiles) {
        this.boardTiles = boardTiles;
    }
    public void setUserPosition(Map<User, Integer> userPosition) {

        this.userPosition = userPosition;
    }
    public void setAliveUser(List<User> aliveUser) {
        this.aliveUser = aliveUser;
    }
    public void setAliveCount(int aliveCount) {
        this.aliveCount = aliveCount;
    }
}
