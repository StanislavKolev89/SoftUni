import java.util.Arrays;
import java.util.Scanner;

public class IntersectionsOFTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());


        String[][] firstMatrix = matrixFill(row, scanner, "\\s+");
        String[][] secondMatrix = matrixFill(row, scanner, "\\s+");

        printingEqualPositions(firstMatrix, secondMatrix);
    }

    private static void printingEqualPositions(String[][] firstMatrix, String[][] secondMatrix) {

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (!firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    System.out.print("* ");
                } else {
                    System.out.print(firstMatrix[row][col] +" ");
                }
            }
            System.out.println();
        }

    }

    private static void printMatrix(String[][] firstMatrix) {

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                System.out.print(firstMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] matrixFill(int rows, Scanner scanner, String pattern) {
        String[][] symbols = new String[rows][];
        for (int row = 0; row < rows; row++) {
            symbols[row] = scanner.nextLine().split(pattern);
        }
        return symbols;
    }

    private static int[] readSizes(Scanner scanner, String pattern) {

        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();

    }
}
