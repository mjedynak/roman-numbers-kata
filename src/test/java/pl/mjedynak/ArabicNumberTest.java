package pl.mjedynak;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArabicNumberTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ArabicNumber.class).verify();
    }

    @Test
    public void shouldHaveStringRepresentation() {
        assertThat(ArabicNumber.of(1).toString()).isEqualTo("ArabicNumber{value=1}");
    }

    @Test
    public void shouldAddTwoNumbers() {
        assertThat(ArabicNumber.of(1).add(ArabicNumber.of(2))).isEqualTo(ArabicNumber.of(3));
    }

    @Test
    public void shouldSubtractTwoNumbers() {
        assertThat(ArabicNumber.of(2).subtract(ArabicNumber.of(1))).isEqualTo(ArabicNumber.of(1));
    }

}