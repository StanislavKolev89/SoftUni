import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];
        matrix = fillMatrixOfLists(rows, cols);
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] commands = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if(inBounds(commands[0],commands[1],matrix)) {
                matrix = matrixDestruction(matrix, commands[0], commands[1], commands[2], rows, cols);
                matrixChange(matrix);
            }
            input = scanner.nextLine();

        }
        printMatrixAfterDestruction(matrix);
    }

    private static boolean inBounds(int row, int col,int[][]matrix ) {
        return row>=0 && row<matrix.length && col>=0 && col<=matrix[row].length;
    }

    private static void matrixChange(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0 && col < matrix[row].length - 1) {
                    matrix[row][col] = matrix[row][col + 1];
                    matrix[row][col + 1] = 0;
                }

            }
        }
    }

    private static void printMatrixAfterDestruction(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (notEmptyRow(matrix, row)) {
                List<Integer> line = new ArrayList<>();
                for (int col = 0; col < matrix[row].length; col++) {
                 if(matrix[row][col]!=0){
                     line.add(matrix[row][col]);
                 }
                }
                for (int i = 0; i < line.size(); i++) {
                    if(i<line.size()-1){
                        System.out.print(line.i);
                    }
                }
                System.out.println();
            }
        }
    }

    private static boolean notEmptyRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix.length; col++) {
            if (matrix[row][col] != 0) {
                return true;
            }
        }
        return false;
    }

    private static int[][] matrixDestruction(int[][] matrix, int row, int col, int radius, int rows, int cols) {
        int[][] newMatrix = new int[rows][cols];
        int countUp = validatingPowerUp(matrix, radius, row);
        int countDown = validatingPowerDown(matrix, radius, row);
        int countLeft = validatingPowerLeft(matrix, radius, col);
        int countRight = validatingPowerRight(matrix, radius, col);
        int numberToDelete = matrix[row][col];
        newMatrix = changeMatrix(matrix, countUp, countDown, countLeft, countRight, row, col);
        return newMatrix;
    }

    private static int[][] changeMatrix(int[][] matrix, int countUp, int countDown, int countLeft, int countRight, int row, int col) {
        for (int i = countUp; i <= countDown; i++) {
            matrix[i][col] = 0;
        }
        for (int i = countLeft; i <= countRight; i++) {
            matrix[row][i] = 0;
        }
        return matrix;
    }


    private static int validatingPowerRight(int[][] matrix, int radius, int col) {
        return (col + radius > matrix.length - 1) ? matrix.length - 1 : col + radius;

    }

    private static int validatingPowerDown(int[][] matrix, int radius, int row) {
        int result = row + radius;
        if (result > matrix.length - 1) {
            result = matrix.length - 1;
        }
        return result;
    }

    private static int validatingPowerUp(int[][] matrix, int radius, int row) {
        int result = row - radius;
        if (result < 0) {
            result = 0;
        }
        return result;

    }

    private static int validatingPowerLeft(int[][] matrix, int radius, int col) {
        int result = col - radius;
        if (result < 0) {
            result = 0;
        }
        return result;
    }

    private static int[][] fillMatrixOfLists(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = counter++;
            }

        }
        return matrix;
    }
}
