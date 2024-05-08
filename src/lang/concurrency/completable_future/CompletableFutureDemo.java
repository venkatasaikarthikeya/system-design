package lang.concurrency.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        /*
            Motivation:
            Why do we need CompletableFuture if we have Future?
                The problem with Future is that, when we call future.get() method to get the data returned by
            the Callable's call() method, the main thread is blocked by the future.get(), as a result of which,
            the code below future.get() method doesn't execute until this method returns a value.
                To avoid this, what one could do is to create a list of future objects and peep into it
            periodically to see, if it has the updated value.

            Goal: We need a mechanism, which takes the return value from Callable and notify us that the value
            is available.

            The solution to this is CompletableFuture

            CompletableFuture.supplyAsync(Supplier, Optional: Executor): This method takes a Supplier instance,
            execute it by using a thread which it picks up from Fork-Join Pool or from Executor if you have provided.
            Once the result of that code is available, then it calls
            .thenAccept(Consumer): This method takes a Consumer instance and run its accept method on current thread.

            Objectives of CompletableFuture:
            1. No more blocking of main thread
            2. No peeping into Future for a result

            You can see the below implementation of CompletableFuture
        */

        /*
            In the below code, we have not provided any Executor to execute the supplier concurrently, hence
            the CompletableFuture will pick up a thread from default Fork-Join Pool and executes the Supplier.
        */
        CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("Long-running task has started - being run by thread from Fork-Join pool");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                return "Long-running task has ended - which was ran by Fork-Join pool";
            }
        }).thenAccept(new Consumer<String>() {

            @Override
            public void accept(String resultOfLongRunningTask) {
                System.out.println(resultOfLongRunningTask);
            }
        }).join();


        ExecutorService executorService = Executors.newCachedThreadPool();
        /*
            In the below code, we have provided the executor to the supplyAsync method, hence it executes the
            supplier by picking up a thread from CachedThreadPool.
        */
        CompletableFuture
                .supplyAsync(
                        () -> {
                            System.out.println("Long-running task has started - being run by thread from CachedThreadPool");
                            try {
                                Thread.sleep(7000);
                            } catch (InterruptedException e) {
                                System.out.println(e.getMessage());
                            }
                            return "Long-running task has ended - which was ran by CachedThreadPool";
                        },
                        executorService
                ).thenAccept(
                        (Consumer<String>) resultOfLongRunningTask -> {
                            System.out.println(resultOfLongRunningTask);
                        }
                );
        System.out.println("Let's Check:");
    }
}
