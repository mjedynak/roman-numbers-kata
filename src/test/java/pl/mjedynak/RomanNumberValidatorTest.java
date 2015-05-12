package pl.mjedynak;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.then;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static java.lang.String.format;
import static pl.mjedynak.RomanNumberValidator.ERROR_MESSAGE;

@RunWith(JUnitParamsRunner.class)
public class RomanNumberValidatorTest {

    private RomanNumberValidator validator = new RomanNumberValidator();

    @Test
    @Parameters({"I", "II", "III"})
    public void shouldDoNothingWhenCorrectRomanNumberIsProvided(String romanNumberValue) {
        validator.validate(RomanNumber.of(romanNumberValue));
    }

    @Test
    @Parameters({"VV", "LL", "DD"})
    public void shouldThrowExceptionWhenNonRepeatableNumberIsRepeated(String romanNumberValue) {
        when(() -> validator.validate(RomanNumber.of(romanNumberValue)));

        then(caughtException()).isInstanceOf(IllegalArgumentException.class).hasMessage(format(ERROR_MESSAGE, RomanNumber.of(romanNumberValue)));
    }

    @Test
    @Parameters({"IIII", "XXXX", "CCCC", "MMMM"})
    public void shouldThrowExceptionWhenRepeatableNumberRepeatedMoreThanThreeTimes(String romanNumberValue) {
        when(() -> validator.validate(RomanNumber.of(romanNumberValue)));

        then(caughtException()).isInstanceOf(IllegalArgumentException.class).hasMessage(format(ERROR_MESSAGE, RomanNumber.of(romanNumberValue)));;
    }
}
