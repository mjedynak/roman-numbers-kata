package pl.mjedynak;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumberTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(RomanNumber.class).verify();
    }

    @Test
    public void shouldHaveStringRepresentation() {
        assertThat(RomanNumber.of("VI").toString()).isEqualTo("RomanNumber{value=VI}");
    }

    @Test
    public void shouldReturnListOfSingleRomanNumbers() {
        assertThat(RomanNumber.of("XVI").singleNumbers()).containsSequence(RomanNumber.of("X"), RomanNumber.of("V"), RomanNumber.of("I"));
        assertThat(RomanNumber.of("X").singleNumbers()).containsSequence(RomanNumber.of("X"));
    }

}