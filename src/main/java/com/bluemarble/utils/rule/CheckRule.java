package com.bluemarble.utils.rule;

/**
 * 2025.07.18
 * 이 인터페이스는 T 타입의 객체가 특정 EliminationRule에 따라
 * 탈락 대상인지 판단하는 전략을 정의합니다.
 * @param <T> 탈락여부를 확인할 객체
 * (사용예시)
 * {CheckElimination<User> rule = (user, rule) ->
 *     rule.isBankruptcyRule() && user.getAsset() <= 0;}
 *
 *  2025.07.21 수정
 *  rule에 의거해서 T, F 반환하도록만 하는 함수로 전환
 */
@FunctionalInterface
public interface CheckRule<T> {
	boolean apply(T target, GameRule gameRule);
}
