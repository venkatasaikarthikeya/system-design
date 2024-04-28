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
                */
                int result = PrimeNumberUtil.findNthPrime(n);
                System.out.println(n + "th prime number is " + result);
            }
        }
    }
}
