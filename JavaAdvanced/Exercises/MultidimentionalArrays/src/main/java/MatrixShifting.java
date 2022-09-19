import java.util.Arrays;
import java.util.Scanner;

public class MatrixShifting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        String[][] matrix = matrixFill(Integer.parseInt(data[0]), scanner, "\\s+");

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            if (valid(tokens, matrix)) {
                String temporary = matrix[Integer.parseInt(tokens[1])][Integer.parseInt(tokens[2])];
                matrix[Integer.parseInt(tokens[1])][Integer.parseInt(tokens[2])] = matrix[Integer.parseInt(tokens[3])][Integer.parseInt(tokens[4])];
                matrix[Integer.parseInt(tokens[3])][Integer.parseInt(tokens[4])] = temporary;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }


    }

    private static boolean valid(String[] tokens, String[][] matrix) {
        if (!tokens[0].equals("swap")) {
            return false;
        }
        if (tokens.length - 1 != 4) {
            return false;
        }

        if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(tokens[1]) >= matrix[0].length ||
                Integer.parseInt(tokens[2]) < 0 || Integer.parseInt(tokens[2]) >= matrix[0].length
                || Integer.parseInt(tokens[3]) < 0 || Integer.parseInt(tokens[3]) >= matrix[0].length ||
                Integer.parseInt(tokens[4]) < 0 || Integer.parseInt(tokens[4]) >= matrix[0].length) {
            return false;
        }

        return true;
    }

    private static String[][] matrixFill(int rows, Scanner scanner, String pattern) {
        String[][] digits = new String[rows][];
        for (int row = 0; row < rows; row++) {
            digits[row] = scanner.nextLine().split(pattern);
        }
        return digits;
    }

    private static void printMatrix(String[][] firstMatrix) {

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                System.out.print(firstMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
