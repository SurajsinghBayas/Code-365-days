package Day012;

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class first {
    static int array[];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array:");
        n = sc.nextInt();
        array = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            System.out.println("Element " + (i + 1) + ":");
            array[i] = sc.nextInt();
        }

        System.out.println("Array: " + Arrays.toString(array));

        System.out.println("Enter the number of queries:");
        int q = sc.nextInt();

        int totalSum = 0;

        for (int i = 0; i < q; i++) {
            System.out.println("\nQuery " + (i + 1) + ":");
            System.out.println("Enter query type (1 or 2):");
            int choice = sc.nextInt();

            System.out.println("Enter l:");
            int l = sc.nextInt();

            System.out.println("Enter r:");
            int r = sc.nextInt();

            if (choice == 1) {
                q1(l, r);
            } else if (choice == 2) {
                totalSum += q2(l, r);
            } else {
                System.out.println("Invalid query type!");
            }
        }

        System.out.println("\n--- Results ---");
        System.out.println("Revised Array: " + Arrays.toString(array));
        System.out.println("Total Sum (from all query 2): " + totalSum);

    }

    static void q1(int l, int r) {
        for (int i = l; i <= r; i++) {
            array[i] = (i - l + 1) * array[l];
        }
    }

    static int q2(int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum = sum + array[i];
        }
        return sum;
    }
}
