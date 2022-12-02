package lotto.verifier;

import java.util.Arrays;
import java.util.List;

public class BonusNumberVerifier {
    private final int RANGE_LOWERBOUND = 1;
    private final int RANGE_UPPERBOUND = 45;
    private final String DELIMITER = ",";

    private final String IS_NOT_NUMERIC = "[ERROR] 입력된 보너스번호는 숫자가 아닙니다.";
    private final String EACH_IS_NOT_IN_RANGE = "[ERROR] 입력된 보너스번호는 범위를 벗어납니다.";

    public void check(String line) {
        checkNumeric(line);
        checkEachInRange(line);
    }

    //TODO: 당첨 번호와 중복되는지 체크하는 기능 추가(public)

    private void checkNumeric(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMERIC);
        }
    }

    private void checkEachInRange(String line) {
        List<String> splitElement = Arrays.asList(line.split(DELIMITER));
        int ineligibleCount = (int) splitElement.stream()
                .filter(element -> Integer.parseInt(element) < RANGE_LOWERBOUND ||
                        Integer.parseInt(element) > RANGE_UPPERBOUND)
                .count();
        if (ineligibleCount != 0) {
            throw new IllegalArgumentException(EACH_IS_NOT_IN_RANGE);
        }
    }
}
