package pl.mjedynak;

import com.google.common.collect.PeekingIterator;
import com.gs.collections.impl.list.mutable.FastList;

import java.util.List;

import static com.google.common.collect.Iterators.peekingIterator;
import static com.gs.collections.impl.list.mutable.FastList.newListWith;
import static pl.mjedynak.RomanToArabicMapping.getArabicFor;
import static pl.mjedynak.SubtractableRomanNumbers.canBeSubtracted;

public class RomanNumberConverter {

    private RomanNumberValidator validator = new RomanNumberValidator();

    public ArabicNumber convert(RomanNumber romanNumber) {
        validator.validate(romanNumber);

        List<RomanNumber> romanNumbers = romanNumber.singleNumbers();
        List<ArabicNumber> arabicNumbers = FastList.newList();

        PeekingIterator<RomanNumber> iterator = peekingIterator(romanNumbers.iterator());
        while (iterator.hasNext()) {
            populate(arabicNumbers, iterator);
        }
        return sum(arabicNumbers);
    }

    private void populate(List<ArabicNumber> arabicNumbers, PeekingIterator<RomanNumber> iterator) {
        RomanNumber number = iterator.next();
        if (onlyOneRomanNumber(iterator)) {
            arabicNumbers.add(getArabicFor(number));
        } else {
            arabicNumbers.add(computeForSequence(iterator, number));
        }
    }

    private boolean onlyOneRomanNumber(PeekingIterator<RomanNumber> iterator) {
        return !iterator.hasNext();
    }

    private ArabicNumber computeForSequence(PeekingIterator<RomanNumber> iterator, RomanNumber number) {
        ArabicNumber result;
        RomanNumber nextNumber = iterator.next();
        if (canBeSubtracted(number, nextNumber)) {
            result = subtract(number, nextNumber);
        } else if (nextPairCanBeSubtracted(iterator, nextNumber)) {
            result = sum(newListWith(getArabicFor(number), subtract(nextNumber, iterator.next())));
        } else {
            result = add(number, nextNumber);
        }
        return result;
    }

    private boolean nextPairCanBeSubtracted(PeekingIterator<RomanNumber> iterator, RomanNumber nextNumber) {
        return iterator.hasNext() && canBeSubtracted(nextNumber, iterator.peek());
    }

    private ArabicNumber add(RomanNumber number, RomanNumber nextNumber) {
        return getArabicFor(number).add(getArabicFor(nextNumber));
    }

    private ArabicNumber subtract(RomanNumber number, RomanNumber nextNumber) {
        return getArabicFor(nextNumber).subtract(getArabicFor(number));
    }

    private ArabicNumber sum(List<ArabicNumber> arabicNumbers) {
        ArabicNumber result = ArabicNumber.of(0);
        for (ArabicNumber arabicNumber : arabicNumbers) {
            result = result.add(arabicNumber);
        }
        return result;
    }

}
