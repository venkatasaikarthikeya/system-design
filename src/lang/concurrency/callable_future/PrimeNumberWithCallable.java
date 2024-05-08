package lang.concurrency.callable_future;

import lang.concurrency.basic_thread_runnable.PrimeNumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class PrimeNumberWithCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner sc = new Scanner(System.in);
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            System.out.println("Enter the value of n to find nth prime number: ");
            int n = sc.nextInt();
            if (n == 0) {
                executorService.close();
                break;
            } else {
                Callable<Integer> callable = () -> {
                    return PrimeNumberUtil.findNthPrime(n);
                };
                Future<Integer> future = executorService.submit(callable);
                // The below blocks the main thread...
                System.out.println(n + "th prime number is " + future.get());
                // The loop will not continue until the future.get() returns and unblocks main thread
            }
        }
    }
}
