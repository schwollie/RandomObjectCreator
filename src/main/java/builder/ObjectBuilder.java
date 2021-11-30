package builder;

import range.RangeSettings;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ObjectBuilder {

    public static final RangeSettings rangeSettings = new RangeSettings();
    public static final Random random = new Random(1020);

    protected Class<?> class2create;
    protected Object object;

    protected ArrayList<ObjectBuilder> parameters = new ArrayList<>(); // parameters of constructor

    protected ObjectBuilder(Class<?> class2create) {
        this.class2create = class2create;
    }

    public Object generateObject() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        getParameters();
        this.object = newRandomObject();
        return this.object;
    }

    protected Object newRandomObject() throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Object[] arguments = new Object[parameters.size()];
        for (int i = 0; i<parameters.size(); i++) {
            //Object argument = parameters.get(i).generateObject();
            arguments[i] = parameters.get(i).generateObject();
        }

        return class2create.getDeclaredConstructors()[0].newInstance(arguments);
    }

    protected void getParameters() {
        int constructor = 0;

        for (Class<?> argumentType : class2create.getConstructors()[constructor].getParameterTypes()) {
            parameters.add(getObjectBuilderFromClass(argumentType));
        }
    }

    public static ObjectBuilder getObjectBuilderFromClass(Class<?> classType) {
        if (classType.isArray()) {
            if (classType.getComponentType().isPrimitive()) {
                return new PrimitiveArrayBuilder(classType);
            } else {
                return new ArrayBuilder(classType);
            }
        } else if (isPrimitiveObject(classType)) {
            return new PrimitiveBuilder(classType);
        } else
        return new ObjectBuilder(classType);
    }

    protected static boolean isPrimitiveObject(Class<?> classType) {
        if (classType.isPrimitive()) {
            return true;
        }

        if (classType == Integer.class || classType == Character.class ||
                classType == Boolean.class || classType == Byte.class || classType == Float.class ||
                classType == Double.class || classType == Long.class || classType == Short.class ||
                classType == String.class) {
            return true;
        }
        return false;
    }

    public String toString() {
        String s = "new " + class2create.getName() + "(";
        int count = 0;
        for (ObjectBuilder param : parameters) {
            s += param.toString();
            if (count != parameters.size()-1) {
                s+= ", ";
            }
            count++;
        }
        s += ")";

        return s;
    }

}
