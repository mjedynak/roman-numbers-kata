package pl.mjedynak;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Set;

public final class SubtractableRomanNumbers {

    private static final Set<ImmutablePair<RomanNumber, RomanNumber>> SUBTRACTABLE_PAIRS = ImmutableSet.of(
            ImmutablePair.of(RomanNumber.of("I"), RomanNumber.of("V")),
            ImmutablePair.of(RomanNumber.of("I"), RomanNumber.of("X")),
            ImmutablePair.of(RomanNumber.of("X"), RomanNumber.of("L")),
            ImmutablePair.of(RomanNumber.of("X"), RomanNumber.of("C")),
            ImmutablePair.of(RomanNumber.of("C"), RomanNumber.of("D")),
            ImmutablePair.of(RomanNumber.of("C"), RomanNumber.of("M"))
    );

    public static boolean canBeSubtracted(RomanNumber firstRomanNumber, RomanNumber secondRomanNumber) {
        return SUBTRACTABLE_PAIRS.contains(ImmutablePair.of(firstRomanNumber, secondRomanNumber));
    }
}
