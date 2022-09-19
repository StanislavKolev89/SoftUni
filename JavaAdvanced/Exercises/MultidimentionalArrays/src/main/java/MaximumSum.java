import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = matrixFill(rowsAndCols[0], scanner, "\\s+");

        int[][] bestMatrix = findingMaxMatrix(matrix, rowsAndCols[0], rowsAndCols[1]);

        System.out.println("Sum = "+sumOfBestMatrix(bestMatrix));
        printMatrix(bestMatrix);

    }

    private static int sumOfBestMatrix(int[][] bestMatrix) {
        int sum = 0;
        for (int[] arr : bestMatrix) {
            for (int number : arr) {
                sum += number;
            }
        }
        return sum;
    }

    private static int[][] findingMaxMatrix(int[][] matrix, int rows, int cols) {
        int[][] matrixOfThreeRowsAndCols = new int[3][3];
        int max = Integer.MIN_VALUE;
        int stopperForRows = rows - 2;
        int stopperForCols = cols - 2;
        int sumOFAll = 0;
        for (int row = 0; row < stopperForRows; row++) {
            for (int col = 0; col < stopperForCols; col++) {
                sumOFAll += matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sumOFAll > max) {
                    max = sumOFAll;
                    matrixOfThreeRowsAndCols[0] = new int[]{matrix[row][col], matrix[row][col + 1], matrix[row][col + 2]};
                    matrixOfThreeRowsAndCols[1] = new int[]{matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]};
                    matrixOfThreeRowsAndCols[2] = new int[]{matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]};
                }
                sumOFAll = 0;
            }
        }

        return matrixOfThreeRowsAndCols;
    }

    private static int[][] matrixFill(int rows, Scanner scanner, String pattern) {
        int[][] digits = new int[rows][];
        for (int row = 0; row < rows; row++) {
            digits[row] = Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
        }
        return digits;
    }

    private static void printMatrix(int[][] firstMatrix) {

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if(col<firstMatrix[row].length-1){
                    System.out.print(firstMatrix[row][col] + " ");
                }else{
                    System.out.print(firstMatrix[row][col]);
                }
            }
            System.out.println();
        }
    }
}
