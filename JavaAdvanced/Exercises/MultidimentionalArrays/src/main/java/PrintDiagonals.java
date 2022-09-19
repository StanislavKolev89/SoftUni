import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int [][] matrix = matrixFill(row, scanner, "\\s+");

       //printMatrix(firstMatrix);

       readDiagonals(matrix);

    }

    private static void readDiagonals(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(row == col){
                    System.out.print(matrix[row][col]+" ");
                }
            }
        }
        System.out.println();
        for (int row = matrix.length-1; row >= 0; row--) {
            for (int col = matrix.length-1; col >=0; col--) {
                if(row+col == matrix.length-1 ){
                    System.out.print(matrix[row][col]+" ");
                }
            }
        }
    }

    private static int [][] matrixFill(int rows, Scanner scanner, String pattern) {
        int [][] digits = new int[rows][];
        for (int row = 0; row < rows; row++) {
            digits[row] = Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
        }
        return digits;
    }

    private static void printMatrix(int[][] firstMatrix) {

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                System.out.print(firstMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
