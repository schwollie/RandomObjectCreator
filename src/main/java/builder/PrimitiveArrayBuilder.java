package builder;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

public class PrimitiveArrayBuilder extends ArrayBuilder {

    public PrimitiveArrayBuilder(Class<?> class2create) {
        super(class2create);
    }

    @Override
    protected Object newRandomObject() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Object[] array = getArray(Array.newInstance(class2create, parameters.size()));

        for (int i = 0; i < parameters.size(); i++) {
            array[i] = parameters.get(i).generateObject();
        }

        return toArrayPrimitive(array, class2create);
    }

    protected static Object toArrayPrimitive(Object[] arr, Class<?> classType) {
        if (classType.getSimpleName().equals("int[]")) {
            return ArrayUtils.toPrimitive((Integer[]) toArray(arr, Integer.class));
        } else if (classType.getSimpleName().equals("int[][]")) {
            return ArrayUtils.toPrimitive((Integer[]) toArray(arr, Integer[].class));
        }else if (classType.getSimpleName().equals("int[][][]")) {
            return ArrayUtils.toPrimitive((Integer[]) toArray(arr, Integer[][].class));
        }else if (classType.getSimpleName().equals("int[][][][]")) {
            return ArrayUtils.toPrimitive((Integer[]) toArray(arr, Integer[][][].class));
        }


        if (classType.getSimpleName().equals("byte[]")) {
            return ArrayUtils.toPrimitive((Byte[]) toArray(arr, Byte.class));
        } else if (classType.getSimpleName().equals("byte[][]")) {
            return ArrayUtils.toPrimitive((Byte[]) toArray(arr, Byte[].class));
        }else if (classType.getSimpleName().equals("byte[][][]")) {
            return ArrayUtils.toPrimitive((Byte[]) toArray(arr, Byte[][].class));
        }else if (classType.getSimpleName().equals("byte[][][][]")) {
            return ArrayUtils.toPrimitive((Byte[]) toArray(arr, Byte[][][].class));
        }

        if (classType.getSimpleName().equals("short[]")) {
            return ArrayUtils.toPrimitive((Short[]) toArray(arr, Short.class));
        } else if (classType.getSimpleName().equals("short[][]")) {
            return ArrayUtils.toPrimitive((Short[]) toArray(arr, Short[].class));
        }else if (classType.getSimpleName().equals("short[][][]")) {
            return ArrayUtils.toPrimitive((Short[]) toArray(arr, Short[][].class));
        }else if (classType.getSimpleName().equals("short[][][][]")) {
            return ArrayUtils.toPrimitive((Short[]) toArray(arr, Short[][][].class));
        }

        if (classType.getSimpleName().equals("boolean[]")) {
            return ArrayUtils.toPrimitive((Boolean[]) toArray(arr, Boolean.class));
        } else if (classType.getSimpleName().equals("boolean[][]")) {
            return ArrayUtils.toPrimitive((Boolean[]) toArray(arr, Boolean[].class));
        }else if (classType.getSimpleName().equals("boolean[][][]")) {
            return ArrayUtils.toPrimitive((Boolean[]) toArray(arr, Boolean[][].class));
        }else if (classType.getSimpleName().equals("boolean[][][][]")) {
            return ArrayUtils.toPrimitive((Boolean[]) toArray(arr, Boolean[][][].class));
        }

        if (classType.getSimpleName().equals("char[]")) {
            return ArrayUtils.toPrimitive((Character[]) toArray(arr, Character.class));
        } else if (classType.getSimpleName().equals("char[][]")) {
            return ArrayUtils.toPrimitive((Character[]) toArray(arr, Character[].class));
        }else if (classType.getSimpleName().equals("char[][][]")) {
            return ArrayUtils.toPrimitive((Character[]) toArray(arr, Character[][].class));
        }else if (classType.getSimpleName().equals("char[][][][]")) {
            return ArrayUtils.toPrimitive((Character[]) toArray(arr, Character[][][].class));
        }

        if (classType.getSimpleName().equals("long[]")) {
            return ArrayUtils.toPrimitive((Long[]) toArray(arr, Long.class));
        } else if (classType.getSimpleName().equals("long[][]")) {
            return ArrayUtils.toPrimitive((Long[]) toArray(arr, Long[].class));
        }else if (classType.getSimpleName().equals("long[][][]")) {
            return ArrayUtils.toPrimitive((Long[]) toArray(arr, Long[][].class));
        }else if (classType.getSimpleName().equals("long[][][][]")) {
            return ArrayUtils.toPrimitive((Long[]) toArray(arr, Long[][][].class));
        }

        if (classType.getSimpleName().equals("double[]")) {
            return ArrayUtils.toPrimitive((Double[]) toArray(arr, Double.class));
        } else if (classType.getSimpleName().equals("double[][]")) {
            return ArrayUtils.toPrimitive((Double[]) toArray(arr, Double[].class));
        }else if (classType.getSimpleName().equals("double[][][]")) {
            return ArrayUtils.toPrimitive((Double[]) toArray(arr, Double[][].class));
        }else if (classType.getSimpleName().equals("double[][][][]")) {
            return ArrayUtils.toPrimitive((Double[]) toArray(arr, Double[][][].class));
        }

        if (classType.getSimpleName().equals("float[]")) {
            return ArrayUtils.toPrimitive((Float[]) toArray(arr, Float.class));
        } else if (classType.getSimpleName().equals("float[][]")) {
            return ArrayUtils.toPrimitive((Float[]) toArray(arr, Float[].class));
        }else if (classType.getSimpleName().equals("float[][][]")) {
            return ArrayUtils.toPrimitive((Float[]) toArray(arr, Float[][].class));
        }else if (classType.getSimpleName().equals("float[][][][]")) {
            return ArrayUtils.toPrimitive((Float[]) toArray(arr, Float[][][].class));
        }

        return null;
    }
}
