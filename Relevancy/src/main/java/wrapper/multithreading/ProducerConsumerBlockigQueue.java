package wrapper.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockigQueue {
    static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

    public static void producer(){
        Random random =  new Random();

        while(true){
            int value = random.nextInt(100);
            System.out.println("putting value" + value );
            try {
                blockingQueue.put(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void consumer() throws InterruptedException {
        Random random =  new Random();


        while(true){
            Thread.sleep(100);
            if(random.nextInt(10) == 0){
                System.out.println( "taken element value ==> "+blockingQueue.take());
                System.out.println( "blocking queue size ==> "+blockingQueue.size());
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
