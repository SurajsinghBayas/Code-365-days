package Day011;

public class prime_1 {
    public static void main(String[] args) {
        int n = 15;
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + isprime(i));

        }
    }

    static boolean isprime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
