package com.bluemarble.user.dto;

import java.util.List;

import com.bluemarble.land.dto.Land;

public class User {

    static int globalUserUID = 1;
    private int userUID;
    private String userName;
    private int userMoney;

    private boolean isAlive;
    private boolean isLoan;
    private List<Land> userLands; // List는 인터페이스, 실제 저장 값은 ArrayList
    private int userTurn;
    private int userLocationIndex;

    public User(String userName, int userMoney) {
        this.userName = userName;
        this.userMoney = userMoney;
        this.userUID ++;
    }

    public int getUserUID() {
        return userUID;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isLoan() {
        return isLoan;
    }

    public List<Land> getUserLands() {
        return userLands;
    }

    public int getUserTurn() {
        return userTurn;
    }

    public int getUserLocationIndex() {
        return userLocationIndex;
    }

    public void setUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setLoan(boolean loan) {
        isLoan = loan;
    }

    public void setUserLands(List<Land> userLands) {
        this.userLands = userLands;
    }

    public void setUserTurn(int userTurn) {
        this.userTurn = userTurn;
    }

    public void setUserLocationIndex(int userLocationIndex) {
        this.userLocationIndex = userLocationIndex;
    }
}
