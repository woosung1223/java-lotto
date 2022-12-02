package lotto.domain.dto;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoDTO {
    private final int lottoAmount;
    private final List<Lotto> lotto;

    public LottoDTO(int lottoAmount, List<Lotto> lotto) {
        this.lottoAmount = lottoAmount;
        this.lotto = lotto;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public List<Lotto> getLotto() {
        return Collections.unmodifiableList(lotto);
    }
}
