import builder.ObjectBuilder;
import dropHere.searchengine.util.Date;

import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) throws Exception {
        Object arr = new int[] {2};
        //TestClass.class.getDeclaredConstructors()[0].newInstance(new Object[] {1, 2L, new TestClass2(""),arr});

        ObjectBuilder b = ObjectBuilder.getObjectBuilderFromClass(TestClass.class);
        TestClass a = (TestClass) b.generateObject();
        System.out.println(b);
        /*Ts.class.getDeclaredConstructors()[0].newInstance(new Object[] {new Integer[] {2}});

        RandomObjectCreator a = new RandomObjectCreator();
        Object t = a.nextObject(Ts.class);
        System.out.println(t);

        String p = a.getParamSaver().getString();
        System.out.println(a.getParamSaver().getString());*/
    }
}
