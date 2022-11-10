package lotto.verifier;

import lotto.util.Constant;
import lotto.util.ExceptionMessage;

import java.math.BigInteger;

public class MoneyVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkOutOfRange(input);
        checkDivisible(input);
        checkPositive(input);
    }

    private void checkNumeric(String input) {
        try {
            new BigInteger(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_NUMERIC);
        }
    }

    private void checkOutOfRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE);
        }
    }

    private void checkDivisible(String input) {
        if (Integer.parseInt(input) % Constant.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIVISIBLE);
        }
    }

    private void checkPositive(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_POSITIVE);
        }
    }
}
