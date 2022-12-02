package lotto.domain;

import lotto.domain.dto.LottoDTO;
import lotto.domain.dto.StatisticsDTO;

import java.util.List;

public class LottoSystem {
    private List<Lotto> userLotto;
    private int userMoney;

    public void putMoney(int money) {
        userMoney = money;
    }

    public LottoDTO getPurchasedLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        userLotto = lottoMachine.buyLotto(userMoney);
        return new LottoDTO(userMoney, userLotto);
    }

    public StatisticsDTO getStatistics(List<Integer> numbers, int bonusNumber) {
        Lotto winningLotto = new Lotto(numbers);
        Judge judge = new Judge();
        List<Prize> award = judge.makeAward(userLotto, winningLotto, bonusNumber);
        float yield = judge.makeYield(userMoney, award);

        return new StatisticsDTO(award, yield);
    }
}
