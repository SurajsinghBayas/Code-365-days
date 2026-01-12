package Day012;

public class second {
    public static void main(String[] args) {
        int arr[] = { 7, 7, 7, 7, 7, 7 };
        int n = arr.length;
        int count = 1;
        for (int i = 1; i < n; i++) {
            int temp = 0;
            int j = i - 1;
            while (j >= 0) {
                if (arr[i] > arr[i]) {
                    break;
                } else {
                    temp++;
                }
                j--;
            }
            if (temp == i) {
                count++;
            }
        }
        System.out.println("count =" + (count));
    }
}
