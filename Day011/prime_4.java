package Day011;

import java.util.ArrayList;

public class prime_4 {
    // Linear Sieve - O(n) Time Complexity
    // Each composite is marked exactly ONCE by its smallest prime factor

    public static void main(String[] args) {
        int n = 100;
        boolean[] isComposite = new boolean[n + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            // If not marked, it's prime
            if (!isComposite[i]) {
                primes.add(i);
            }

            // Mark composites using current number * each prime
            // Key: stop when prime divides i (ensures each composite marked once)
            for (int j = 0; j < primes.size() && i * primes.get(j) <= n; j++) {
                isComposite[i * primes.get(j)] = true;

                // CRUCIAL: if prime divides i, stop here
                // This ensures i * primes.get(j) is marked by its SMALLEST prime factor
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }

        // Print all primes
        System.out.println("Prime numbers from 2 to " + n + " (Linear Sieve - O(n)):");
        for (int p : primes) {
            System.out.println(p + " is a prime number");
        }
    }
}
