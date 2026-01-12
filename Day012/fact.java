package Day012;

import java.util.Scanner;

public class fact {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of Presidents");
        int n = sc.nextInt();

        int ways = fact(n - 1);
        System.out.println("No. of ways = " + (ways));

    }

    static int fact(int num) {
        if (num == 1) {
            return 1;
        }
        return ((num) * fact(num - 1));
    }
}
