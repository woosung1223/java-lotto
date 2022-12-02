package lotto.verifier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WinningLottoVerifier {
    private final int RANGE_LOWERBOUND = 1;
    private final int RANGE_UPPERBOUND = 45;
    private final String DELIMITER = ",";

    private final String EACH_IS_NOT_NUMERIC = "[ERROR] 입력된 당첨번호 중 숫자가 아닌 값이 존재합니다.";
    private final String EACH_IS_NOT_DISTINCT = "[ERROR] 입력된 당첨번호 중 중복이 존재합니다.";
    private final String EACH_IS_NOT_IN_RANGE = "[ERROR] 입력된 당첨번호 중 범위를 벗어나는 값이 존재합니다.";

    public void check(String line) {
        List<String> splitElement = Arrays.asList(line.split(DELIMITER));
        checkEachNumeric(splitElement);
        checkEachDistinct(splitElement);
        checkEachInRange(splitElement);
    }

    private void checkEachNumeric(List<String> splitElement) {
        try {
            splitElement.forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EACH_IS_NOT_NUMERIC);
        }
    }

    private void checkEachDistinct(List<String> splitElement) {
        HashSet<String> hashSet = new HashSet<>(splitElement);

        if (splitElement.size() != hashSet.size()) {
            throw new IllegalArgumentException(EACH_IS_NOT_DISTINCT);
        }
    }

    private void checkEachInRange(List<String> splitElement) {
        int ineligibleCount = (int) splitElement.stream()
                .filter(element -> Integer.parseInt(element) < RANGE_LOWERBOUND ||
                        Integer.parseInt(element) > RANGE_UPPERBOUND)
                .count();
        if (ineligibleCount != 0) {
            throw new IllegalArgumentException(EACH_IS_NOT_IN_RANGE);
        }
    }
}
