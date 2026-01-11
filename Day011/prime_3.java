package Day011;

public class prime_3 {
    public static void main(String[] args) {
        int n = 100;
        boolean[] prime = new boolean[n + 1];

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        System.out.println("Prime numbers from 2 to " + n + " (Sieve of Eratosthenes):");
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                System.out.println(i + " is a prime number");
            }
        }
    }
}
