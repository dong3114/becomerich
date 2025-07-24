package com.bluemarble.utils.rule;

import java.util.List;

import com.bluemarble.board.dto.Board;
import com.bluemarble.user.dto.User;

public class RuleUtils {
    private GameRule gameRule;

    public static CheckRule<User> isBankruptcy() {
        return (user , rule) -> rule.isBankruptcyRule(); // && user.getUserMoney() <= 0;
    }

    public static CheckRule<Board> maxTurn(List<User> users) {
        // 최종턴 되면 유저의 모든 자산을 현금화 한 뒤 남은 유저들 중 가장 돈 많은 유저가 승자로리턴
        for(User user : users){
            // TODO 유저 서비스에서 ALL SELL 메서드 완성되면 작성.
        }
        return ((board, rule) -> rule.getMaxTurn() < board.getCurrentTurn());
    }

}
