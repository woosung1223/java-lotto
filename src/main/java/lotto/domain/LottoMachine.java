package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private final int DIVIDING_MONEY = 1000;
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 45;
    private final int LOTTO_SIZE = 6;

    private int receipt;

    public List<Lotto> buyLotto(int money) {
        int lottoAmount = money / DIVIDING_MONEY;
        receipt = lottoAmount;
        return Stream.iterate(0, i -> i + 1)
                .limit(lottoAmount)
                .map(i -> new Lotto(makeRandomList()))
                .collect(Collectors.toList());
    }

    public int getReceipt() {
        return receipt;
    }

    private List<Integer> makeRandomList() {
        List<Integer> randomLotto = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_SIZE);
        return randomLotto.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
