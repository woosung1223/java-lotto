package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.verifier.BonusNumberVerifier;
import lotto.verifier.MoneyVerifier;
import lotto.verifier.WinningLottoVerifier;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String DELIMITER = ",";

    public int readMoney() {
        String line = Console.readLine();
        MoneyVerifier moneyVerifier = new MoneyVerifier();
        moneyVerifier.check(line);
        return Integer.parseInt(line);
    }

    public List<String> readWinningLotto() {
        String line = Console.readLine();
        WinningLottoVerifier winningLottoVerifier = new WinningLottoVerifier();
        winningLottoVerifier.check(line);
        return Arrays.asList(line.split(DELIMITER));
    }

    public int readBonusNumber() {
        String line = Console.readLine();
        BonusNumberVerifier bonusNumberVerifier = new BonusNumberVerifier();
        bonusNumberVerifier.check(line);
        return Integer.parseInt(line);
    }
}
