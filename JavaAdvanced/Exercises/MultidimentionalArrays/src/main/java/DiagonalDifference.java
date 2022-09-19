import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        int[][] matrix = filingMatrix(scanner, rowsAndCols, " ");
        System.out.println(Math.abs(primaryDiagonal(matrix) - secondaryDiagonal(matrix)));
    }

    private static int secondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row+col == matrix.length-1) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int primaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int[][] filingMatrix(Scanner scanner, int size, String pattern) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(pattern))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

}
