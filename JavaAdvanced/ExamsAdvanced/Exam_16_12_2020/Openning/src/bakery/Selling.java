import java.util.Scanner;

public class Selling {
    public static int playerRow = 0;
    public static int playerCol = 0;
    public static int firstPillarRow = -1;
    public static int firstPillarCol = -1;
    public static int secondPillarRow = -1;
    public static int secondPillarCol = -1;
    public static int dollars = 0;
    public static boolean outOfBounds = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("S")) {
                playerRow = 0;
                playerCol = line.indexOf("S");
            }
            if (line.contains("O")) {
                if (firstPillarRow == -1) {
                    firstPillarRow = i;
                    firstPillarCol = line.indexOf("O");
                }else{
                    secondPillarRow = i;
                    secondPillarCol=line.indexOf("O");
                }
            }
        }

//        print(matrix);
        while (dollars < 50) {
            String command = scanner.nextLine();


            if (command.equals("right")) {
                movingPlayer(matrix, 0, 1);
            } else if (command.equals("left")) {
                movingPlayer(matrix, 0, -1);
            } else if (command.equals("up")) {
                movingPlayer(matrix, -1, 0);
            } else if (command.equals("down")) {
                movingPlayer(matrix, +1, 0);
            }

            if (outOfBounds) {
                break;
            }
//            print(matrix);
        }

        if (!outOfBounds) {
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.printf("Money: %d%n", dollars);
        } else {
            System.out.println("Bad news, you are out of the bakery.");
            System.out.printf("Money: %d%n", dollars);
        }
        print(matrix);

    }

    private static void movingPlayer(char[][] matrix, int addToRow, int addToCol) {
        int newRowOfPlayer = playerRow + addToRow;
        int newColOfPlayer = playerCol + addToCol;
        matrix[playerRow][playerCol] = '-';
        if (inBounds(matrix, newRowOfPlayer, newColOfPlayer)) {
            if (Character.isDigit(matrix[newRowOfPlayer][newColOfPlayer])) {
                dollars += Integer.parseInt(String.valueOf(matrix[newRowOfPlayer][newColOfPlayer]));
                playerRow = newRowOfPlayer;
                playerCol = newColOfPlayer;
                matrix[playerRow][playerCol] = 'S';
            } else if (matrix[newRowOfPlayer][newColOfPlayer] == '-') {
                playerRow = newRowOfPlayer;
                playerCol = newColOfPlayer;
                matrix[playerRow][playerCol] = 'S';
            } else if (matrix[newRowOfPlayer][newColOfPlayer] == 'O') {
                if (newRowOfPlayer == firstPillarRow) {
                    playerRow = secondPillarRow;
                    playerCol = secondPillarCol;
                    matrix[firstPillarRow][firstPillarCol] = '-';
                } else {
                    playerRow = firstPillarRow;
                    playerCol = firstPillarCol;
                    matrix[secondPillarRow][secondPillarCol] = '-';
                }
                matrix[playerRow][playerCol] = 'S';
            }
        } else {
            outOfBounds = true;
        }
    }

    private static void print(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean inBounds(char[][] matrix, int newRowOfPlayer, int newColOfPlayer) {
        return (newRowOfPlayer >= 0 && newRowOfPlayer < matrix.length) && (newColOfPlayer >= 0 && newColOfPlayer < matrix.length);
    }
}
