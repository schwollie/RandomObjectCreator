package builder;

import java.lang.reflect.InvocationTargetException;

public class PrimitiveBuilder extends ObjectBuilder{

    public PrimitiveBuilder(Class<?> class2create) {
        super(class2create);
    }

    @Override
    public Object generateObject() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return super.generateObject();
    }

    @Override
    protected Object newRandomObject() {
        Object o = null;

        if (class2create == Integer.class || class2create == int.class) {
            o = RandomPrimitive.getRandomInt(rangeSettings, random);
            o = class2create == Integer.class ? (Integer)o : (int)o;

        } else if (class2create == Character.class || class2create == char.class) {
            o = RandomPrimitive.getRandomChar(rangeSettings, random);
            o = class2create == Character.class ? (Character)o : (char)o;

        } else if (class2create == Boolean.class || class2create == boolean.class) {
            o = RandomPrimitive.getRandomBool(rangeSettings, random);
            o = class2create == Boolean.class ? (Boolean)o : (boolean)o;

        } else if (class2create == Byte.class || class2create == byte.class) {
            o = RandomPrimitive.getRandomByte(rangeSettings, random);
            o = class2create == Byte.class ? (Byte)o : (byte)o;

        } else if (class2create == Float.class || class2create == float.class) {
            o = RandomPrimitive.getRandomFloat(rangeSettings, random);
            o = class2create == Float.class ? (Float)o : (float)o;

        } else if (class2create == Double.class || class2create == double.class) {
            o = RandomPrimitive.getRandomDouble(rangeSettings, random);
            o = class2create == Double.class ? (Double)o : (double)o;

        } else if (class2create == Long.class || class2create == long.class) {
            o = RandomPrimitive.getRandomLong(rangeSettings, random);
            o = class2create == Long.class ? (Long)o : (long)o;

        } else if (class2create == Short.class || class2create == short.class) {
            o = RandomPrimitive.getRandomShort(rangeSettings, random);
            o = class2create == Short.class ? (Short)o : (short)o;

        }else if (class2create == String.class) {
            o = RandomPrimitive.getRandomString(rangeSettings, random);
        }
        
        return o;
    }

    @Override
    protected void getParameters() {
    }

    @Override
    public String toString() {
        if (this.class2create == String.class) {
            return "\"" + this.object.toString() + "\"";
        }
        return this.object.toString();
    }
}
