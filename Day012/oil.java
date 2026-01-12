package Day012;

import java.util.Scanner;

// oil tank capacity problem
// inputs - oil tank capacity , no. of persons in row 
// -1 buy oil ,+1 sell oil ...  ex. 3liters , array mai 5 , [-1,-1,-1,+1,-1]
public class oil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = 3;
        int arr[] = { +1, -1, -1, -1 };

        int currentCapacity = 0;
        int i = 0;

        while (i < arr.length) {
            currentCapacity += arr[i];
            i++;
        }

        System.out.println("Mininmum :" + (currentCapacity * -1));
    }
}
