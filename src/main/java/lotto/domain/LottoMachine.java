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

    private List<Integer> makeRandomList() {
        List<Integer> randomLotto = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_SIZE);
        return randomLotto.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
