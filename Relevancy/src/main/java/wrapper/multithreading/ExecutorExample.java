package wrapper.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
   String taskID;
   public Processor(String taskID){
    this.taskID = taskID;
   }

    @Override
    public void run() {
        System.out.println("started process "+ this.taskID);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("completed process "+ this.taskID);
    }
}

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(String.valueOf(i)));
        }
        System.out.println("tasks submitted");

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task Completed");
    }
}



