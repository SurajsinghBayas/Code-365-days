package Day012;

import java.util.Scanner;

public class forth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value N on product:");
        int N = sc.nextInt();
        int digit;
        int price = 1;
        while (N > 0) {
            digit = N % 10;
            price = price * digit;
            N = N / 10;
        }
        System.out.println("Price of Product is " + price);
    }
}
