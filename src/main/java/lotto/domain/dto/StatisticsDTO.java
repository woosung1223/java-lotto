package lotto.domain.dto;

import lotto.domain.Prize;

import java.util.Collections;
import java.util.List;

public class StatisticsDTO {
    private final List<Prize> prize;
    private final float yield;

    public StatisticsDTO(List<Prize> prize, float yield) {
        this.prize = Collections.unmodifiableList(prize);
        this.yield = yield;
    }

    public List<Prize> getPrize() {
        return prize;
    }

    public float getYield() {
        return yield;
    }
}
