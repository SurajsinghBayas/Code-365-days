package Day012;

import java.util.Scanner;

public class thrid {
    public static void main(String[] args) {
        System.out.println("Enter n: Total days in a month");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter n: 1: Sunday 2: Monday 3: Tuesday 4: Wednesday 5: Thursday 6: Friday 7: Saturday");
        int c = sc.nextInt();
        String arr[];

        int sun_count = 1;
        ;
        switch (c) {
            case 1:
                break;

            case 2:
                n = n - 6;
                break;
            case 3:
                n = n - 5;
                break;
            case 4:
                n = n - 4;
                break;
            case 5:
                n = n - 3;
                break;
            case 6:
                n = n - 2;
                break;
            case 7:
                n = n - 1;
                break;
            default:
                System.out.println("Invalid Input");
        }

        sun_count = sun_count + n / 7;
        System.out.println("Number of Sundays in " + n + " days: " + sun_count);
    }

}
