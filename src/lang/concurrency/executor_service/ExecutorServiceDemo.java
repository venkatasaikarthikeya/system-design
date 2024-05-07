package lang.concurrency.executor_service;

import lang.concurrency.basic_thread_runnable.PrimeNumberUtil;
import java.util.Scanner;
import java.util.concurrent.*;

public class ExecutorServiceDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        /*
            Scheduled Thread Pool Executor:
            Similar to Cached Thread Pool Executor, the scheduled thread pool executor service also does not take any number upfront
            number as it scales the thread instances based on the requirement by growing and shrinking the instances.
            But, it does accept an argument by name corePoolSize which is the number of threads it has to keep even if they are idle.
            We didn't have this flexibility with Cached Thread Pool Executor.

            Executors.newScheduledThreadPool(1) this does not actually return an ExecutorService instead it returns ScheduledExecutorService.
            The reason for this is ExecutorService being the main interface it does not offer any method to schedule runnable.
            Hence, Executors.newScheduledThreadPool(1) returns a ScheduledExecutorService object so that we have two flexibilities.

            1. scheduledExecutorService.schedule(runnable, delay, TimeUnit):    This method schedules the runnable for some delay in TimeUnit
            units, so that the runnable is executed only after that delay.
            Example: scheduledExecutorService.schedule(runnable, 5, TimeUnit.SECONDS);

            2. scheduledExecutorService.scheduleAtFixedRate(runnable, initialDelay, period, TimeUnit):   This method schedules a runnable for
            some initial delay. After the initial delay, the runnable gets executed. After execution of the runnable, after a 'period' delay
            the runnable is executed repeatedly over and again.
            This can be used when you want to execute something repeatedly after a period of time.
            Example: scheduledExecutorService.scheduleAtFixedRate(runnable, 1, 5, TimeUnit.SECONDS);

            In our previous prime number generation problem, we used to report the number of active threads using a thread.sleep approach.
            Now, we can replace that approach with scheduleAtFixedRate() method.
        */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable runnable = () -> {
            System.out.println("Running report: ");
            System.out.println("Active threads: " + executorService.getActiveCount());
            System.out.println("Completed threads: " + executorService.getCompletedTaskCount());
        };
        scheduledExecutorService.scheduleAtFixedRate(runnable, 1, 5, TimeUnit.SECONDS);

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
