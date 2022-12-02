package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    public List<Prize> makeAward(List<Lotto> userLotto, Lotto winningLotto, int bonusNumber) {
        List<Prize> award = new ArrayList<>();
        userLotto.forEach(lotto -> {
            int sameNumberCount = lotto.countSameNumberWith(winningLotto);
            award.add(Prize.of(sameNumberCount, bonusNumber));
        });
        return award;
    }
}
