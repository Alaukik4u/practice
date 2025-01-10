package wrapper.multithreading;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class MailSender implements Runnable {
    private String taskID;

    public MailSender(String taskID) {
        this.taskID = taskID;
    }

    @Override
    public void run() {
        System.out.println("started taskID :: " + taskID);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed taskID :: " + taskID);

    }
}


class ExecutorS {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10000; i++) {
            executorService.submit(new MailSender(String.valueOf(i)));
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


