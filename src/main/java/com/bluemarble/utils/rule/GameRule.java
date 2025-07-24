package com.bluemarble.utils.rule;

/**
 * (2025.07.19 "한동환")
 *
 * 이 클래스는 게임의 탈락 조건과 종료 조건에 대한 룰을 정의합니다.
 * 현재는 '파산 시 탈락 여부'와 '최대 턴 수'를 정의하며,
 * 추후 다른 규칙(예: 강제 탈락, 특수 이벤트 등)이 추가될 수 있습니다.
 *
 * 이 클래스는 값 객체로 사용되며, CheckRule<T>와 함께 전달되어
 * 해당 룰에 따라 대상 객체가 탈락 조건을 만족하는지를 판단하는 데 사용됩니다.
 *
 * 예: rule.isBankruptcyRule() && user.getMoney() <= 0
 *     rule.getMaxTurn() < board.getCurrentTurn()
 */
public class GameRule {
    private final int maxTurn; // 초기 룰 셋팅 시 입력할 값
    private final boolean bankruptcyRule;   // 파산이면 게임종료 하도록 할건지 체크

    public int getMaxTurn() {
        return maxTurn;
    }
    public boolean isBankruptcyRule(){
        return bankruptcyRule;
    }

    public GameRule(Builder builder) {
        this.maxTurn = builder.maxTurn;
        this.bankruptcyRule = builder.bankruptcyRule;
    }

    public static class Builder {
        private int maxTurn;
        private boolean bankruptcyRule = true;

        public Builder bankruptcyRule(boolean bring_in) {
            this.bankruptcyRule = bring_in;
            return this;
        }
        public Builder maxTurn(int maxTurn){
            this.maxTurn = maxTurn;
            String message = """
                    %d턴이 되면 게임이 종료됩니다.
                    """.formatted(maxTurn);
            System.out.println(message);
            return this;
        }
        public GameRule build() {
            return new GameRule(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
