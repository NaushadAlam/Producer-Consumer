import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

import java.util.Objects;

/**
 * Created by kkk on 3/5/2015.
 */
public class Producer2 extends Thread {
    private int data = 1;
    Producer2(){
        super("Producer");
    }

    @Override
    public void run(){
        for (;;){
            ++data;
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            synchronized (StartProducerConsumer.data) {
                String da = " " + data;
                Object obj = da;
                System.out.println("Producer Produced " + data);
                StartProducerConsumer.data.add(obj);
                if (StartProducerConsumer.data.size() > 1000) {
                    StartProducerConsumer.data.remove(StartProducerConsumer.data.size() - 1);
                }
            }
        }
    }
}
