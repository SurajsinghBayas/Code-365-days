package Day011;

public class primev0 {
    public static void main(String[] args) {
        // prime no.s Searching based on Time Complexity O(nlogn)
        int a[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int n = a.length;
        for (int i = 0; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(a[i]); j++) {
                if (a[i] % j == 0) {
                    isPrime = false;
                    break;
                }

            }
            if (isPrime) {
                System.out.println(a[i] + " is a prime number");
            }
        }
    }
}
