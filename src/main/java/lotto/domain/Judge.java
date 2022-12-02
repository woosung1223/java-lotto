package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Judge {
    public List<Prize> makeAward(List<Lotto> userLotto, Lotto winningLotto, int bonusNumber) {
        List<Prize> award = new ArrayList<>();
        userLotto.forEach(lotto -> {
            int sameNumberCount = lotto.countSameNumberWith(winningLotto);
            boolean hasBonusNumber = lotto.contains(bonusNumber);
            award.add(Prize.of(sameNumberCount, hasBonusNumber));
        });
        return award;
    }

    public String makeYield(int userMoney, List<Prize> award) {
        int awardMoney = 0;
        for (Prize prize : award) {
            awardMoney += prize.getMoney();
        }
        return formatYield(((userMoney + (float)awardMoney) / userMoney - 1) * 100);
    }

    private String formatYield(float toFormat) {
        DecimalFormat decFormat = new DecimalFormat("###,##0.0");
        return decFormat.format(toFormat);
    }
}
