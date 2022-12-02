package lotto.verifier;

public class MoneyVerifier {
    private final int DIVIDING_MONEY = 1000;

    private final String IS_NOT_NUMERIC = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private final String IS_NOT_POSITIVE = "[ERROR] 구입 금액은 양수여야 합니다.";
    private final String IS_NOT_DIVISIBLE = "[ERROR] " + DIVIDING_MONEY + "원으로 나누어 떨어지지 않는 값입니다.";

    public void check(String line) {
        checkNumeric(line);
        checkPositive(line);
        checkDivisible(line);
    }

    private void checkNumeric(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMERIC);
        }
    }

    private void checkPositive(String line) {
        if (Integer.parseInt(line) <= 0) {
            throw new IllegalArgumentException(IS_NOT_POSITIVE);
        }
    }

    private void checkDivisible(String line) {
        if (Integer.parseInt(line) % DIVIDING_MONEY != 0) {
            throw new IllegalArgumentException(IS_NOT_DIVISIBLE);
        }
    }
}
