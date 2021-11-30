import builder.ObjectBuilder;
import dropHere.searchengine.pagerepository.Document;
import dropHere.searchengine.pagerepository.Review;
import dropHere.searchengine.util.Date;
import range.Range;

import java.lang.reflect.Parameter;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws Exception {
        //ObjectBuilder.rangeSettings.setIntegerRange(new Range<Integer>(0, 24));
        ObjectBuilder b = ObjectBuilder.getObjectBuilderFromClass(Review.class);
        Review a = (Review) b.generateObject();
        System.out.println(b);

        /*Ts.class.getDeclaredConstructors()[0].newInstance(new Object[] {new Integer[] {2}});

        RandomObjectCreator a = new RandomObjectCreator();
        Object t = a.nextObject(Ts.class);
        System.out.println(t);

        String p = a.getParamSaver().getString();
        System.out.println(a.getParamSaver().getString());*/
    }
}
