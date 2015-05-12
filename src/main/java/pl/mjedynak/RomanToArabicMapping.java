package pl.mjedynak;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public final class RomanToArabicMapping {
    private static final Map<RomanNumber, ArabicNumber> romanToArabicMap = new ImmutableMap.Builder<RomanNumber, ArabicNumber>()
            .put(RomanNumber.of("I"), ArabicNumber.of(1))
            .put(RomanNumber.of("V"), ArabicNumber.of(5))
            .put(RomanNumber.of("X"), ArabicNumber.of(10))
            .put(RomanNumber.of("L"), ArabicNumber.of(50))
            .put(RomanNumber.of("C"), ArabicNumber.of(100))
            .put(RomanNumber.of("D"), ArabicNumber.of(500))
            .put(RomanNumber.of("M"), ArabicNumber.of(1000))
            .build();

    public static ArabicNumber getArabicFor(RomanNumber romanNumber) {
        return romanToArabicMap.get(romanNumber);
    }
}
