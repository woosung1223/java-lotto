package lotto.controller;

import lotto.domain.LottoSystem;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final LottoSystem lottoSystem = new LottoSystem();
    private final OutputView outputView = new OutputView();

    public void run() {
        startPayRoutine();
        startPrizeRoutine();
    }

    private void startPayRoutine() {
        int money = inputView.readMoney();
        lottoSystem.putMoney(money);
        outputView.printBuyResult(lottoSystem.getPurchasedLotto());
    }

    private void startPrizeRoutine() {
        List<Integer> winningLotto = inputView.readWinningLotto();
        int bonusNumber = inputView.readBonusNumber();
        outputView.printStatistics(lottoSystem.getStatistics(winningLotto, bonusNumber));
    }
}