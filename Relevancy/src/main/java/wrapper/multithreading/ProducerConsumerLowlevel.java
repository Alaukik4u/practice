package wrapper.multithreading;

import lombok.Synchronized;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerLowlevel {
    static LinkedList<Integer> list = new LinkedList<>();
    static Object lock = new Object();
    static final Integer LIMIT =10;

    public static void producer(){
        Random random =  new Random();

        while(true){
            synchronized (lock){
                while(list.size() == LIMIT){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int value = random.nextInt(100);
                System.out.println("putting value" + value );

                list.add(value);
                lock.notify();
            }

        }
    }

    public static void consumer() throws InterruptedException {
        Random random =  new Random();


        while(true){
            synchronized (lock){
                while(list.size() == 0){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print("list size is " +list.size());
                System.out.println(" value pulled is "+ list.removeFirst());
                lock.notify();
            }

            Thread.sleep(1000);
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
