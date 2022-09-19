import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] rowsAndCols = matrixDefine(scanner.nextLine());

        for (int i = 0; i < rowsAndCols.length; i++) {
            fillingColumns(rowsAndCols, i, scanner.nextLine());
        }
        System.out.println(rowsAndCols.length);
        System.out.println(rowsAndCols[1].length);

        int sumOfAll= findingTotalSum(rowsAndCols);
        System.out.println(sumOfAll);
    }

    private static int findingTotalSum(int[][] rowsAndCols) {
        int sum = 0;
        for (int rows = 0; rows < rowsAndCols.length; rows++) {

            for (int cols = 0; cols < rowsAndCols[rows].length; cols++) {
                int number = rowsAndCols[rows][cols];
                sum+=number;
            }
        }
        return sum;
    }

    private static int[][] matrixDefine(String s) {
        int[] colsAndRows = Arrays.stream(s.split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] result = new int[colsAndRows[0]][colsAndRows[1]];
        return result;
    }

    private static void fillingColumns(int[][] rowsAndCols, int i, String nextLine) {
        int[] array = Arrays.stream(nextLine.split(", ")).mapToInt(Integer::parseInt).toArray();
        rowsAndCols[i] = array;
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
