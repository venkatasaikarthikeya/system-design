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
            Single Thread executor:
            It just creates one thread instance and re-uses it over and again.
            If a new runnable comes in the meantime, it has to wait until that thread returns after its execution
        */
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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
