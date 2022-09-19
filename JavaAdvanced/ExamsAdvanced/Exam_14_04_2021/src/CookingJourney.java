import java.util.Scanner;

public class CookingJourney {

    public static int playerRow = -1;
    public static int playerCol = -1;
    public static int firstPillarRow = -1;
    public static int firstPillarCol = -1;
    public static int secondPillarRow = -1;
    public static int secondPillarCol = -1;
    public static int dollars = 0;
    public static boolean outOfBound = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];


        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")) {
                playerRow = row;
                playerCol = line.indexOf("S");
            }
            if (line.contains("P")) {
                if (firstPillarCol < 0 && firstPillarCol < 0) {
                    firstPillarRow = row;
                    firstPillarCol = line.indexOf("P");
                } else {
                    secondPillarRow = row;
                    secondPillarCol = line.indexOf("P");
                }
            }
        }


        while (dollars < 50) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    movingMatrix(matrix, -1, 0);
                    break;
                case "down":
                    movingMatrix(matrix, 1, 0);
                    break;
                case "left":
                    movingMatrix(matrix, 0, -1);
                    break;
                case "right":
                    movingMatrix(matrix, 0, 1);
                    break;
            }
            if (outOfBound) {
                break;
            }
            if(dollars>50){
                break;
            }
        }
        if (outOfBound) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + dollars);
        printMatrix(matrix);

    }

    private static void movingMatrix(char[][] matrix, int row, int col) {
        int newRow = playerRow + row;
        int newCol = playerCol + col;
        matrix[playerRow][playerCol] = '-';
        if (inBounds(matrix, newRow, newCol)) {
            if (Character.isDigit(matrix[newRow][newCol])) {
                dollars += Integer.parseInt(String.valueOf(matrix[newRow][newCol]));
                matrix[newRow][newCol] = 'S';
                playerRow = newRow;
                playerCol = newCol;
            } else if (matrix[newRow][newCol] == '-') {
                matrix[newRow][newCol] = 'S';
                playerRow= newRow;
                playerCol = newCol;
            } else if (matrix[newRow][newCol] == 'P') {
                if (newRow == firstPillarRow) {
                    matrix[firstPillarRow][firstPillarCol] = '-';
                    playerRow = secondPillarRow;
                    playerCol = secondPillarCol;
                } else {
                    matrix[secondPillarRow][secondPillarCol] = '-';

                    playerRow = firstPillarRow;
                    playerCol = firstPillarCol;

                }
                matrix[playerRow][playerCol] = 'S';
            }

        } else {
            outOfBound = true;
        }
    }

    private static boolean inBounds(char[][] matrix, int newRow, int newCol) {
        return newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix.length;
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
