import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    public static int playerRow;
    public static int playerCol;
    public static int bombsInField;
    public static boolean bombFound = false;
    public static boolean endPointReached = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> directions = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toCollection(ArrayDeque::new));

        char[][] matrix = creatingMatrix(scanner, n);
        findingAllBombs(matrix);

        while (!directions.isEmpty()) {
            String command = directions.poll();
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
            if (bombFound) {
                System.out.println("You found a bomb!");
                bombFound = false;
            }
            if (bombsInField == 0) {
                break;
            }
            if (endPointReached) {
                break;
            }
        }

        if (endPointReached) {
            System.out.printf("END! %d bombs left on the field", bombsInField);
        }
        if (bombsInField == 0) {
            System.out.println("Congratulations! You found all bombs!");
        }
        if (!endPointReached && bombsInField > 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsInField, playerRow, playerCol);
        }
    }

    private static void movingPlayer(char[][] matrix, int row, int col) {
        int newRow = playerRow + row;
        int newCol = playerCol + col;
        if (inBounds(matrix, newRow, newCol)) {
            matrix[playerRow][playerCol] = '+';
            if (matrix[newRow][newCol] == 'B') {
                bombsInField--;
                matrix[newRow][newCol] = '+';
                bombFound = true;
            } else if (matrix[newRow][newCol] == 'e') {
                endPointReached = true;

            } else if (matrix[newRow][newCol] == '+') {
            }
            playerRow = newRow;
            playerCol = newCol;

        }
    }

    private static boolean inBounds(char[][] matrix, int newRow, int newCol) {
        return newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix.length;
    }

    private static void findingAllBombs(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    bombsInField++;
                }
            }
        }
    }


    private static char[][] creatingMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][];
        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            String word = "";
            for (String str : line) {
                word += str;
            }
            matrix[row] = word.toCharArray();
            if (word.contains("s")) {
                playerRow = row;
                playerCol = word.indexOf("s");
            }
        }
        return matrix;
    }
}
