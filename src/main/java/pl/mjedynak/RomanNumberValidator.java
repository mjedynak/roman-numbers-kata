package pl.mjedynak;

import java.util.List;

import static java.lang.String.format;
import static pl.mjedynak.NonRepeatableRomanNumbers.isNonRepeatableRomanNumber;

public class RomanNumberValidator {

    static final String ERROR_MESSAGE = "Invalid number %s";

    public void validate(RomanNumber romanNumber) throws IllegalArgumentException {
        List<RomanNumber> romanNumbers = romanNumber.singleNumbers();

        for (int i = 0; i < romanNumbers.size(); i++) {
            if (romanNumbers.size() > i + 1) {
                RomanNumber number = romanNumbers.get(i);
                RomanNumber nextNumber = romanNumbers.get(++i);
                checkRepeatedCharacter(romanNumber, romanNumbers, i, number, nextNumber);
            }
        }
    }

    private void checkRepeatedCharacter(RomanNumber romanNumber, List<RomanNumber> romanNumbers, int index, RomanNumber number, RomanNumber nextNumber) {
        if (number.equals(nextNumber) && containsIllegalRepeating(romanNumbers, index, number, nextNumber)) {
            throw new IllegalArgumentException(format(ERROR_MESSAGE, romanNumber));
        }
    }

    private boolean containsIllegalRepeating(List<RomanNumber> romanNumbers, int index, RomanNumber number, RomanNumber nextNumber) {
        return isNonRepeatableRomanNumber(nextNumber) || hasFourRepeatedCharacters(romanNumbers, index, number);
    }

    private boolean hasFourRepeatedCharacters(List<RomanNumber> romanNumbers, int index, RomanNumber number) {
        boolean result = false;
        if (romanNumbers.size() > index + 2) {
            result = romanNumbers.get(index + 1).equals(number) && romanNumbers.get(index + 2).equals(number);
        }
        return result;
    }
}
