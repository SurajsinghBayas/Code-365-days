package Day012;

import java.util.Scanner;

public class fifth {
    int n, r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n:");
        int n = sc.nextInt();
        System.out.println("Enter value of r:");
        int r = sc.nextInt();
    
        for (int i=0;i<=r;i++){
            int sum(n);
                
            
        }
    }

    static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum = sum + digit;
            n = n / 10;
        }
        return sum;
    }
}
