import java.util.Scanner;

public class ReVolt {

    public static int playerRow = -1;
    public static int playerCol = -1;

    public static boolean finishReached = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = createMatrix(size, scanner);

        String command = scanner.nextLine();

        while (true) {
            numberOfCommands--;

            switch (command) {
                case "up":
                    movingPlayer(matrix, -1, 0);
                    break;
                case "down":
                    movingPlayer(matrix, 1, 0);
                    break;
                case "left":
                    movingPlayer(matrix, 0, -1);
                    break;
                case "right":
                    movingPlayer(matrix, 0, 1);
                    break;
            }
            if (finishReached) {
                break;
            }
            if (numberOfCommands == 0) {
                break;
            }
            command = scanner.nextLine();
        }

        if (finishReached) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static void movingPlayer(char[][] matrix, int row, int col) {
        int newRow = setRows(matrix, playerRow, row);
        int newCol = setRows(matrix, playerCol, col);

        matrix[playerRow][playerCol] = '-';
        if (matrix[newRow][newCol] == 'F') {
            matrix[newRow][newCol] = 'f';
            playerRow = newRow;
            playerCol = newCol;
            finishReached = true;
        } else if (matrix[newRow][newCol] == 'B') {
            movingPlayer(matrix, row + row, col + col);
            matrix[playerRow][playerCol] = 'f';
        } else if (matrix[newRow][newCol] == 'T') {
            matrix[playerRow][playerCol] = 'f';
        } else if (matrix[newRow][newCol] == '-') {
            matrix[newRow][newCol] = 'f';
            playerRow = newRow;
            playerCol = newCol;
        }

    }

    private static int setRows(char[][] matrix, int playerCoordinate, int number) {
        int newPosition = playerCoordinate + number;
        if (newPosition < 0) {
            newPosition = matrix.length - 1;
        } else if (newPosition > matrix.length - 1) {
            newPosition = 0;
        }
        return newPosition;
    }

    private static char[][] createMatrix(int size, Scanner scanner) {
        char[][] charMatrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            charMatrix[row] = line.toCharArray();

            if (line.contains("f")) {
                playerRow = row;
                playerCol = line.indexOf('f');
            }
        }
        return charMatrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }
}
