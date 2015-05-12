package pl.mjedynak;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public final class NonRepeatableRomanNumbers {

    private static final Set<RomanNumber> NON_REPEATABLE_ROMAN_NUMBERS = ImmutableSet.of(RomanNumber.of("V"), RomanNumber.of("L"), RomanNumber.of("D"));

    public static boolean isNonRepeatableRomanNumber(RomanNumber romanNumber) {
        return NON_REPEATABLE_ROMAN_NUMBERS.contains(romanNumber);
    }
}
