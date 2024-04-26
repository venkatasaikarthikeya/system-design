package lang.concurrency.basic_thread_runnable;

public class BasicThreadDriver {

    public static void main(String[] args) {

        /*
            You may think that doing the below is going to create a new thread. But, it does not. Because, Runnable has no
            semantics that are related to Thread. The below is just creating an instance of a class that implements
            Runnable interface and calling the run method on the instance of that class. However, the run() method does
            execute on the main thread of the Java Process.
        */
        Runnable nonFunctioningRunnable = new MyRunnable();
        nonFunctioningRunnable.run();

        /*
            Steps to create a thread:
            1. Identify the code you want to run in a separate thread.
            2. Put it into a runnable
            3. Create a new thread from that runnable
            4. Start the thread
            t.start() triggers a new thread to be created by this Java Process in which this code is running.
        */
        Runnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();

        // Syntax Alternatives

        // 1.1 Instead of creating a class that implements Runnable we can use the Anonymous Inner class like below
        Runnable anonymousRunnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("Run method of AnonymousRunnable is running");
            }
        };
        Thread t1 = new Thread(anonymousRunnable);
        t1.start();

        // 1.2 We can simply use a lambda instead, as we know that Runnable is a functional interface
        Runnable lambdaRunnable = () -> System.out.println("Run method of Lambda is running");
        new Thread(lambdaRunnable).start();

        // 1.3 We can even improve this by using an Inline Lambda Runnable like below
        new Thread(() -> System.out.println("Run method of Inline Lambda is running")).start();

        /*
            2. Extending Thread class:
            We can even create a thread by extending thread class and overriding its run() method. Thread itself is
            runnable as it implements Runnable by default. But, this approach is not recommended.

            It is always recommended to have a separate runnable so that 'Thread' class can only take care
            of the infrastructure aspects of a Thread. This way, we can have separation of concerns and loosely
            coupled code.

        */
        new MyThread().start();
    }
}
