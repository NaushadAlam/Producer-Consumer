import java.util.Iterator;

/**
 * Created by kkk on 3/5/2015.
 */
class Consumer2 extends Thread {

    Consumer2(){
        super("consumer");
    }

    @Override
    public void run(){
        for(;;){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            Iterator it = StartProducerConsumer.data.iterator();
            while (it.hasNext()){

                System.out.println("Consumer Consumed : " + (String)it.next());

            }
        }

    }
}
