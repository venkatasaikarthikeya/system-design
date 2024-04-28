package lang.concurrency.basic_thread_runnable;

import java.util.Scanner;

public class PracticalUsage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the value of n to find nth prime number: ");
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println("Exiting as you entered zero");
                break;
            } else {
                /*
                    The problem with this approach is when you give large values of n like 50000,
                    the computation is very intensive that it will completely block the main thread
                    as it will be very busy in performing the computation. Because of this, the UI
                    is frozen, and the main thread will not be in a position to accept another input
                    before the computation of the previous number is complete.

                    To overcome this problem, we have the concept of Multi-threading

                    Now, with the below updated approach, the computation of each nth prime number is done
                    on a separate thread. Hence, the main thread is still active, and it accepts another
                    input in parallel when the previous computation is still in progress. This way the main
                    thread is not blocked by the long-running task.

                    But, this approach introduces us to a new problem. When the long-running computation is
                    being executed on another thread, if you try to exit the program using input 0, even though
                    the main method returns, the program doesn't stop until the long-running computation is
                    completed by the last thread. In other words, the main thread doesn't stop until all the
                    threads it ever spawned come to a halt. This is a crucial problem because even though the user
                    exits the application, the application will still run because the other threads it created
                    are still running in the background.

                    To address this problem, we have the concept of Daemon threads.
                */
                Thread t = new Thread(() -> {
                    int result = PrimeNumberUtil.findNthPrime(n);
                    System.out.println(n + "th prime number is " + result);
                });
                t.start();
            }
        }
    }
}
