package range;

public class RangeSettings {

    private Range<Integer> integerRange = new Range<>(Integer.MIN_VALUE, Integer.MAX_VALUE);
    private Range<Double> doubleRange = new Range<>(Double.MIN_VALUE, Double.MAX_VALUE);
    private Range<Float> floatRange = new Range<>(Float.MIN_VALUE, Float.MAX_VALUE);
    private Range<Integer> characterRange = new Range<>(65, 122);
    private Range<Byte> byteRange = new Range<>(Byte.MIN_VALUE, Byte.MAX_VALUE);
    private Range<Short> shortRange = new Range<>(Short.MIN_VALUE, Short.MAX_VALUE);
    private Range<Long> longRange = new Range<>(Long.MIN_VALUE, Long.MAX_VALUE);
    private Range<Integer> stringRange = new Range<>(0, 20);
    private Range<Integer> arrayLength = new Range<>(0, 5);

    public Range<Integer> getArrayLength() {
        return arrayLength;
    }

    public void setArrayLength(Range<Integer> arrayLength) {
        this.arrayLength = arrayLength;
    }

    public Range<Integer> getStringRange() {
        return stringRange;
    }

    public void setStringRange(Range<Integer> stringRange) {
        this.stringRange = stringRange;
    }

    public Range<Integer> getIntegerRange() {
        return integerRange;
    }

    public void setIntegerRange(Range<Integer> integerRange) {
        this.integerRange = integerRange;
    }

    public Range<Double> getDoubleRange() {
        return doubleRange;
    }

    public void setDoubleRange(Range<Double> doubleRange) {
        this.doubleRange = doubleRange;
    }

    public Range<Float> getFloatRange() {
        return floatRange;
    }

    public void setFloatRange(Range<Float> floatRange) {
        this.floatRange = floatRange;
    }

    public Range<Integer> getCharacterRange() {
        return characterRange;
    }

    public void setCharacterRange(Range<Integer> characterRange) {
        this.characterRange = characterRange;
    }

    public Range<Byte> getByteRange() {
        return byteRange;
    }

    public void setByteRange(Range<Byte> byteRange) {
        this.byteRange = byteRange;
    }

    public Range<Short> getShortRange() {
        return shortRange;
    }

    public void setShortRange(Range<Short> shortRange) {
        this.shortRange = shortRange;
    }

    public Range<Long> getLongRange() {
        return longRange;
    }

    public void setLongRange(Range<Long> longRange) {
        this.longRange = longRange;
    }
}
