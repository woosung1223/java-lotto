package lotto.controller;

import lotto.domain.Award;
import lotto.domain.manager.AwardManager;
import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.domain.manager.YieldManager;
import lotto.view.OutputView;

import java.util.List;

public class SettlementSystem {
    private static List<Award> awards;
    private static float yield;

    public static void startProcess(WinningLotto winningLotto, UserLotto userLotto, BonusNumber bonusNumber) {
        makeResults(winningLotto, userLotto, bonusNumber);
        OutputView.printReward(awards);
        OutputView.printYield(yield);
    }

    private static void makeResults(WinningLotto winningLotto, UserLotto userLotto, BonusNumber bonusNumber) {
        awards = AwardManager.makeAwards(winningLotto, userLotto, bonusNumber);
        yield = YieldManager.makeYield(awards, userLotto.size());
    }
}