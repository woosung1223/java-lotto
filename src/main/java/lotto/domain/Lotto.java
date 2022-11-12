package lotto.domain;

import lotto.verifier.LottoVerifier;
import lotto.view.OutputView;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int compare(Lotto another) {
        return another.compareRealValue(this.numbers);
    }

    public int compareRealValue(List<Integer> anotherNumbers) {
        return (int) numbers.stream()
                        .filter(old -> anotherNumbers.stream()
                        .anyMatch(Predicate.isEqual(old)))
                        .count();
    }


    public void printLottoInfo() {
        OutputView.printIOMessage(numbers.toString());
    }

    private void validate(List<Integer> numbers) {
        String forCheck = numbers.toString();
        forCheck = forCheck.substring(1, forCheck.length() - 1);
        forCheck = forCheck.replaceAll(" ", "");
        new LottoVerifier().check(forCheck.strip());
    }
}
