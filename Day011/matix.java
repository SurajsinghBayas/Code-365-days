package Day011;

public class matix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Transpose of Matrix:");
        for (int k = 0; k <= 2; k++) {
            for (int l = 0; l <= 2; l++) {
                System.out.print(matrix[l][k] + " ");
            }
            System.out.println();
        }

        System.out.println("Reverse of Transpose Matrix:");
        for (int k = 0; k <= 2; k++) {
            for (int l = 2; l >= 0; l--) {
                System.out.print(matrix[l][k] + " ");
            }
            System.out.println();
        }

    }
}
