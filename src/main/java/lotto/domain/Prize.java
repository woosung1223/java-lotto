package lotto.domain;

import java.util.Arrays;

public enum Prize {
    THREE(5_000, 3, 0),
    FOUR(50_000, 4, 0),
    FIVE(1_500_000, 5, 0),
    FIVE_BONUS(30_000_000, 5, 1),
    SIX(2_000_000_000, 6, 1);

    private final int money;
    private final int matchedNumberCount;
    private final int matchedBonusNumberCount;

    Prize(int money, int matchedNumberCount, int matchedBonusNumberCount) {
        this.money = money;
        this.matchedNumberCount = matchedNumberCount;
        this.matchedBonusNumberCount = matchedBonusNumberCount;
    }

    public static Prize of(int matchedNumberCount, int matchedBonusNumberCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchedNumberCount == matchedNumberCount)
                .filter(prize -> prize.matchedBonusNumberCount == matchedBonusNumberCount)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public int getMoney() {
        return this.money;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public int getMatchedBonusNumberCount() {
        return matchedBonusNumberCount;
    }
}
