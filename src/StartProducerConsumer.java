import java.util.ArrayList;
import java.util.List;


/**
 * Created by kkk on 3/5/2015.
 */
public class StartProducerConsumer {

    public static List<Object> data = new ArrayList<Object>();
    private static Object obj;
    public static void main(String[] args){
        String test = "Program Start";
        obj = test;
        System.out.println(obj);
        new Producer2().start();
        new Consumer2().start();
    }

}
