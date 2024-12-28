package lang.concurrency.thread_states_more;

public class ThreadStateDriver {

    public static void main(String[] args) throws InterruptedException {

        Runnable helloRunnable = () -> {
            try {
                Thread.sleep(5000);
                System.out.println("Hello Karthik");
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };

        Runnable karthikRunnable = () -> {
            System.out.println("...Welcome to Java Concurrency");
        };

        Thread t1 = new Thread(helloRunnable);
        t1.start();

        t1.join(3000);

        Thread t2 = new Thread(karthikRunnable);
        t2.start();
    }
}
