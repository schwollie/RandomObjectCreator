package builder;

import range.Range;
import range.RangeSettings;

import java.util.Random;

public class RandomPrimitive {

    public static int getRandomInt(RangeSettings r, Random random) {
        return getRandomInteger(r.getIntegerRange(), random) ;
    }

    public static short getRandomShort(RangeSettings r, Random random) {
        return (short) random.nextInt();
    }

    public static byte getRandomByte(RangeSettings r, Random random) {
        return (byte) random.nextInt();
    }

    public static long getRandomLong(RangeSettings r, Random random) {
        return  random.nextLong();
    }

    public static float getRandomFloat(RangeSettings r, Random random) {
        return random.nextFloat();
    }

    public static double getRandomDouble(RangeSettings r, Random random) {
        return random.nextDouble();
    }

    public static boolean getRandomBool(RangeSettings r, Random random) {
        return random.nextBoolean();
    }

    public static char getRandomChar(RangeSettings r, Random random) {
        return (char) getRandomInteger(r.getCharacterRange(), random);
    }

    public static String getRandomString(RangeSettings r, Random random) {
        char[] chars = new char[random.nextInt(10)];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = getRandomChar(r, random);
        }

        return new String(chars);
    }

    private static int getRandomInteger(Range<Integer> range, Random random) {
        double d = random.nextDouble();
        int rand = (int)(random.nextDouble() * ((long)range.getMaxValue() - (long)range.getMinValue() +1) + range.getMinValue());
        return rand;
        //return random.nextInt(range.getMaxValue() - range.getMinValue()) + range.getMinValue();
        //return random.nextInt(range.getMaxValue() + Math.abs(range.getMinValue())) + range.getMinValue();
    }

}
