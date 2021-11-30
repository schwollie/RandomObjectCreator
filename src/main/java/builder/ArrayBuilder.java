package builder;

import range.Range;
import range.RangeSettings;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ArrayBuilder extends builder.ObjectBuilder {


    public ArrayBuilder(Class<?> class2create) {
        super(class2create);
    }

    @Override
    public Object generateObject() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return super.generateObject();
    }

    @Override
    protected Object newRandomObject() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Object[] array = getArray(Array.newInstance(class2create, parameters.size()));

        for (int i = 0; i < parameters.size(); i++) {
            array[i] = parameters.get(i).generateObject();
        }

        Object a = toArray(array, class2create.getComponentType());
        return a;
    }

    protected Object[] getArray(Object val){
        int arrlength = Array.getLength(val);
        Object[] outputArray = new Object[arrlength];
        for(int i = 0; i < arrlength; ++i){
            outputArray[i] = Array.get(val, i);
        }
        return outputArray;
    }

    protected static <T> T[] toArray(Object[] arr, Class<?> classType) {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(classType, arr.length);
        for (int i = 0; i < arr.length; i++) {
            result[i] = (T)arr[i];
        }
        return result;
    }

    @Override
    protected void getParameters() {
        int length = random.nextInt(rangeSettings.getArrayLength().getMaxValue()) + 1;

        for (int i = 0; i < length; i++) {
            parameters.add(ObjectBuilder.getObjectBuilderFromClass(class2create.getComponentType()));
        }
    }

    @Override
    public String toString() {
        String s = "new " + class2create.getSimpleName() + " {";
        int count = 0;
        for (Object param : parameters) {
            s += param.toString();
            if (count != parameters.size()-1) {
                s+= ", ";
            }
            count++;
        }
        s += "}";

        return s;
    }
}
