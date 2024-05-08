package lang.concurrency.completable_future;

import lang.concurrency.basic_thread_runnable.PrimeNumberUtil;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class PrimeUsingCompletableFuture {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            System.out.println("Enter the value of n to find nth prime number: ");
            int n = sc.nextInt();
            if (n == 0) {
                executorService.close();
                break;
            } else {
                CompletableFuture
                        .supplyAsync(
                                () -> {
                                    return PrimeNumberUtil.findNthPrime(n);
                                },
                                executorService
                        )
                        .thenAccept(
                                (Consumer<Integer>) nthPrime -> {
                                    System.out.println(n + "th prime number is " + nthPrime);
                                }
                        );
            }
        }
    }
}
