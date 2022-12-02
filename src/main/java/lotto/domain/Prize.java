package lotto.domain;

import java.util.Arrays;

public enum Prize {
    ZERO(0, 0),
    ONE(0, 1),
    TWO(0, 2),
    THREE(5_000, 3),
    FOUR(50_000, 4),
    FIVE(1_500_000, 5),
    FIVE_BONUS(30_000_000, 5),
    SIX(2_000_000_000, 6);

    private final int money;
    private final int matchedNumberCount;

    Prize(int money, int matchedNumberCount) {
        this.money = money;
        this.matchedNumberCount = matchedNumberCount;
    }

    public static Prize of(int matchedNumberCount, boolean hasBonusNumber) {
        Prize result = Arrays.stream(values())
                .filter(prize -> prize.matchedNumberCount == matchedNumberCount)
                .findFirst()
                .orElseThrow(RuntimeException::new);

        if (result == Prize.FIVE && hasBonusNumber) {
            return Prize.FIVE_BONUS;
        }
        return result;
    }

    public int getMoney() {
        return this.money;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }
}
