package lotto.domain.dto;

import lotto.domain.Prize;

import java.util.Collections;
import java.util.List;

public class StatisticsDTO {
    private final List<Prize> prize;
    private final String yield;

    public StatisticsDTO(List<Prize> prize, String yield) {
        this.prize = Collections.unmodifiableList(prize);
        this.yield = yield;
    }

    public List<Prize> getPrize() {
        return prize;
    }

    public String getYield() {
        return yield;
    }
}
