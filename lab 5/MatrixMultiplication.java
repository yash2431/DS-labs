import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowsMatrix1 = 3;
        int colsMatrix1 = 2;
        int rowsMatrix2 = 2;
        int colsMatrix2 = 3;
        int[][] matrix1 = new int[rowsMatrix1][colsMatrix1];
        int[][] matrix2 = new int[rowsMatrix2][colsMatrix2];
        int[][] resultMatrix = new int[rowsMatrix1][colsMatrix2];

        System.out.println("Enter the elements of the first 3x2 matrix:");
        for (int i = 0; i < rowsMatrix1; i++) {
            for (int j = 0; j < colsMatrix1; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the elements of the second 2x3 matrix:");
        for (int i = 0; i < rowsMatrix2; i++) {
            for (int j = 0; j < colsMatrix2; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix2[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < rowsMatrix1; i++) {
            for (int j = 0; j < colsMatrix2; j++) {
                resultMatrix[i][j] = 0; // Initialize the result matrix element
                for (int k = 0; k < colsMatrix1; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("Resulting matrix after multiplication:");
        for (int i = 0; i < rowsMatrix1; i++) {
            for (int j = 0; j < colsMatrix2; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
