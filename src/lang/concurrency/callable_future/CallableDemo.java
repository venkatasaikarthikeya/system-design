package lang.concurrency.callable_future;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        /*
            Motivation: Why do we need a callable in the first place?
            Assume a scenario where you created a runnable, and you gave the runnable to a thread or executor
            service. Everything works fine. But, what if you want to return something from a runnable to the
            main thread that actually called t.start()?

            Can I return?
            The answer is NO, and the obvious reason being a runnable is a one-way task.

            @FunctionalInterface
            public interface Runnable {
                    void run();
            }

            The return type of run() method is void, which is the obvious reason for a runnable being a
            one-way task.

            This is the exact reason for the existence of Callable in Java

            What is Callable?
            Callable is a functional interface with the one and only method being "call()"

            @FunctionalInterface
            public interface Callable<V> {
                V call() throws Exception;
            }

            So, if you have a long-running task that needs to run on another thread and if you want that
            long-running task to return something to the thread that initiated this task, then you can
            use Callable interface

            Usage:
        */

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Printing inside a Callable's call() method");
                Thread.sleep(3000);
                return "Returning from Callable's call() method";
            }
        };

        /*
            Now, how do you run this on a separate thread?

            -> Can you use Thread?
            Ans: No, because thread class only accepts a runnable but not a callable
            Thread t = new Thread(runnable);
            callable is not allowed in Thread class's constructor.

            -> Can you use Executor Service?
            Ans: Yes, you can use an ExecutorService but the execute() method only accepts runnable
        */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        /*
            executorService.execute(runnable);
            The execute() method does not accept a callable.
            So, executor service provides an alternative method for this:
            executorService.submit(runnable/callable);

            The submit() method can take either a runnable or a callable.

            Now, how do you get the returned object from a Callable's call() method?
            To do this we need a Future object.

            Future<T> object:
            The submit() method of executor service returns the object returned by the Callable's
            call() method using a Future<T> object.

            See below for usage:
        */

        Future<String>  future = executorService.submit(callable);

        /*
            future.get() is blocking call, that blocks the main thread and resumes its execution once
            the result is made available in the Future object.

            So, the code below future.get() will not execute until we get the object from the get() method.
        */
        String objectReturnedByCallMethod = future.get();
        // The code from this line will execute only after future.get() returns an object
        System.out.println(objectReturnedByCallMethod);



    }
}
