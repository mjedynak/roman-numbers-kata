package pl.mjedynak;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(JUnitParamsRunner.class)
public class RomanNumberConverterTest {

    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks private RomanNumberConverter converter;
    @Mock private RomanNumberValidator validator;

    @Test
    @Parameters({
            "I, 1",
            "V, 5",
            "X, 10",
            "L, 50",
            "C, 100",
            "D, 500",
            "M, 1000"})
    public void shouldConvertSingleRomanNumeral(String romanValue, int arabicValue) {
        assertThat(converter.convert(RomanNumber.of(romanValue))).isEqualTo(ArabicNumber.of(arabicValue));
    }

    @Test
    @Parameters({"IV, 4", "IX, 9"})
    public void shouldHandleICharacterSubtraction(String romanValue, int arabicValue) {
        assertThat(converter.convert(RomanNumber.of(romanValue))).isEqualTo(ArabicNumber.of(arabicValue));
    }

    @Test
    @Parameters({"XL, 40", "XC, 90"})
    public void shouldHandleXCharacterSubtraction(String romanValue, int arabicValue) {
        assertThat(converter.convert(RomanNumber.of(romanValue))).isEqualTo(ArabicNumber.of(arabicValue));
    }

    @Test
    @Parameters({"CD, 400", "CM, 900"})
    public void shouldHandleCCharacterSubtraction(String romanValue, int arabicValue) {
        assertThat(converter.convert(RomanNumber.of(romanValue))).isEqualTo(ArabicNumber.of(arabicValue));
    }

    @Test
    @Parameters({"XIV, 14", "XIX, 19", "XXXIV, 34", "LIV, 54"})
    public void shouldHandleSubtractionInLongerSequenceOfNumbers(String romanValue, int arabicValue) {
        assertThat(converter.convert(RomanNumber.of(romanValue))).isEqualTo(ArabicNumber.of(arabicValue));
    }

    @Test
    @Parameters({
            "CDXLIV, 444",
            "CDXLIX, 449",
            "CDXCIV, 494",
            "CDXCIX, 499",
            "CMXLIV, 944",
            "CMXLIX, 949",
            "CMXCIV, 994",
            "CMXCIX, 999"})
    public void shouldHandleMultipleSubtractions(String romanValue, int arabicValue) {
        assertThat(converter.convert(RomanNumber.of(romanValue))).isEqualTo(ArabicNumber.of(arabicValue));
    }

    @Test
    @Parameters({
            "II, 2",
            "III, 3",
            "XX, 20",
            "XXX, 30",
            "CC, 200",
            "CCC, 300",
            "MM, 2000",
            "MMM, 3000",
    })
    public void shouldHandleRepeatedCharacters(String romanValue, int arabicValue) {
        assertThat(converter.convert(RomanNumber.of(romanValue))).isEqualTo(ArabicNumber.of(arabicValue));
    }

    @Test
    @Parameters({
            "VI, 6",
            "VII, 7",
            "VIII, 8",
            "XI, 11",
            "XII, 12",
            "XIII, 13",
            "XVI, 16",
            "MCXVI, 1116",
            "MDCLXVI, 1666"
          })
    public void shouldHandleAdditions(String romanValue, int arabicValue) {
        assertThat(converter.convert(RomanNumber.of(romanValue))).isEqualTo(ArabicNumber.of(arabicValue));
    }

    @Test
    public void shouldUseValidator() {
        RomanNumber romanNumber = RomanNumber.of("I");

        converter.convert(romanNumber);

        verify(validator).validate(romanNumber);
    }
}