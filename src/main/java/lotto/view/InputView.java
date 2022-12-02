package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.verifier.MoneyVerifier;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public int readMoney() {
        String line = Console.readLine();
        MoneyVerifier moneyVerifier = new MoneyVerifier();
        moneyVerifier.check(line);
        return Integer.parseInt(line);
    }

    public List<String> readWinningNumber() {
        String line = Console.readLine();
        // TODO: 검증
        return Arrays.asList(line.split(","));
    }

    public int readBonusNumber() {
        String line = Console.readLine();
        // TODO: 검증
        return Integer.parseInt(line);
    }
}
