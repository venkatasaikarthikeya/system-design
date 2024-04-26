package lang.concurrency.basic_thread_runnable;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Run method of MyRunnable is running");
    }
}