package lang.concurrency.executor_service;

import lang.concurrency.basic_thread_runnable.PrimeNumberUtil;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorServiceDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            Cached Thread Pool Executor Service:
            Doesn't take arguments because it does not need any number up front like newFixedThreadPool(nThreads)
            The under lying thread pool grows and shrinks in size as per the requirement
            When all the threads are currently running, then when a runnable comes, then it created a new thread instance and uses it
            It does not create thread instances forever
            When ever a returned thread is not used for 60 seconds, it removes that thread
        */
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            System.out.println("Enter the value of n to find nth prime number: ");
            int n = sc.nextInt();
            if (n == 0) {
                executorService.close();
                break;
            } else {
                Runnable r = () -> {
                    int result = PrimeNumberUtil.findNthPrime(n);
                    System.out.println(n + "th prime number is " + result);
                };
                executorService.execute(r);
            }
        }
    }
}
