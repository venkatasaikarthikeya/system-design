package lang.concurrency.callable_future;

import lang.concurrency.basic_thread_runnable.PrimeNumberUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.*;

public class PrimeNumberWithCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner sc = new Scanner(System.in);
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> futures = new ArrayList<>();
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
                futures.add(future);
            }
        }
        // To avoid blocking the main thread, we can store future objects and use them later
        Iterator<Future<Integer>> iterator = futures.iterator();
        while (iterator.hasNext()) {
            Future<Integer> future = iterator.next();
            if (future.isDone()) {
                System.out.println(future.get());
                iterator.remove();
            }
        }
    }
}
