package healthyHeaven;

import java.util.Scanner;

public class TheHeiganDance {
    public static int playerRow = 7;
    public static int playerCol = 7;
    public static int playerPoints = 18500;
    public static int heiganPoints = 3000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = creatingMatrix();
        System.out.println();

        while (playerPoints > 0 && heiganPoints > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            int hitRow = Integer.parseInt(input[1]);
            int hitCol = Integer.parseInt(input[2]);
            switch (input[0]) {
                case "Cloud":
                    break;
                case "Eruption":
                    break;
            }
        }
    }

    private static char[][] creatingMatrix() {
        char[][] matrix = new char[15][15];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == 7 && col == 7) {
                    matrix[row][col] = 'P';
                } else {
                    matrix[row][col] = '-';

                }
            }
        }
        return matrix;
    }
}
