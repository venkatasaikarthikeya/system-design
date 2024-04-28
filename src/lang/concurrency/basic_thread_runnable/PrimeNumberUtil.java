package lang.concurrency.basic_thread_runnable;

public class PrimeNumberUtil {

    // A very naive approach to find the value of the nth prime number...kept it inefficient to test the power of multi-threading
    public static int findNthPrime(int n) {

        int cnt = 0, num = 2;

        while (true) {

            boolean isPrime = true;

            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                cnt += 1;
            }
            if (cnt == n) {
                return num;
            }
            num += 1;
        }
    }
}
