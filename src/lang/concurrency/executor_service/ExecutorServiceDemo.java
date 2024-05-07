package lang.concurrency.executor_service;

import lang.concurrency.basic_thread_runnable.PrimeNumberUtil;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorServiceDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Implement Thread factory as a separate class
        DaemonThreadFactory daemonThreadFactory = new DaemonThreadFactory();
        // Pass the number of threads and thread factory instance to newFixedThreadPool()
        ExecutorService executorService = Executors.newFixedThreadPool(3, daemonThreadFactory);

        /*
            // ThreadFactory is a functional interface. Hence, we can use Anonymous Inner Class
            ExecutorService executorService1 = Executors.newFixedThreadPool(
                3,
                new ThreadFactory() {

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        // other thread configurations
                        return t;
                    }
                });
        */

        /*
            // ThreadFactory is a functional interface. Hence, we can use Lambdas as well
            ExecutorService executorService2 = Executors.newFixedThreadPool(3, (r) -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                // other thread configurations
                return t;
            });
        */

        while (true) {
            System.out.println("Enter the value of n to find nth prime number: ");
            int n = sc.nextInt();
            if (n == 0) {
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
