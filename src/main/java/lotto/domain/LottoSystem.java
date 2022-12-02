package lotto.domain;

import lotto.domain.dto.LottoDTO;
import lotto.domain.dto.StatisticsDTO;

import java.util.List;

public class LottoSystem {
    private List<Lotto> userLotto;
    private int userMoney;

    public LottoDTO getPurchasedLotto(int money) {
        LottoMachine lottoMachine = new LottoMachine();
        userLotto = lottoMachine.buyLotto(money);
        userMoney = money;
        return new LottoDTO(userMoney, userLotto);
    }

    public StatisticsDTO getStatistics(Lotto winningLotto, int bonusNumber) {
        Judge judge = new Judge();
        List<Prize> award = judge.makeAward(userLotto, winningLotto, bonusNumber);
        float yield = judge.makeYield(userMoney, award);

        return new StatisticsDTO(award, yield);
    }
}
