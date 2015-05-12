package pl.mjedynak;

import com.google.common.collect.ImmutableList;
import com.gs.collections.impl.list.mutable.FastList;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.gs.collections.impl.list.mutable.FastList.newListWith;

public final class RomanNumber {

    private final String value;

    private RomanNumber(String value) {
        this.value = value;
    }

    public static RomanNumber of(String value) {
        return new RomanNumber(value);
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
        final RomanNumber other = (RomanNumber) obj;
        return Objects.equals(this.value, other.value);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("value", value)
                .toString();
    }

    public List<RomanNumber> singleNumbers() {
        FastList<String> values = newListWith(value.split(""));
        return ImmutableList.copyOf(values.collect(RomanNumber::of));
    }
}
