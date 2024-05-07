package lang.concurrency.executor_service;

import lang.concurrency.basic_thread_runnable.PrimeNumberUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorServiceDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        while (true) {
            System.out.println("Enter the value of n to find nth prime number: ");
            int n = sc.nextInt();
            if (n == 0) {
                executorService.shutdown();
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

    static class DaemonThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    }
}
