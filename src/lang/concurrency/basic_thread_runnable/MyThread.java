package lang.concurrency.basic_thread_runnable;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("Run method of MyThread is running");
    }
}
