package pl.mjedynak;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public final class ArabicNumber {

    private final int value;

    private ArabicNumber(int value) {
        this.value = value;
    }

    public static ArabicNumber of(int value) {
        return new ArabicNumber(value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ArabicNumber other = (ArabicNumber) obj;
        return Objects.equals(this.value, other.value);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("value", value)
                .toString();
    }

    public ArabicNumber add(ArabicNumber other) {
        return ArabicNumber.of(this.value + other.value);
    }

    public ArabicNumber subtract(ArabicNumber other) {
        return ArabicNumber.of(this.value - other.value);
    }

}
