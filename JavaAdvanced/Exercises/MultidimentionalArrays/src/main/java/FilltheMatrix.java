import java.util.Scanner;

public class FilltheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(", ");
        int numberOfRowsAndCols = Integer.parseInt(command[0]);
        String typeOfPatter = command[1];
        int[][] matrix = new int[numberOfRowsAndCols][numberOfRowsAndCols];
        if (typeOfPatter.equals("A")) {
            designPatterA(matrix);
        } else if (typeOfPatter.equals("B")) {
            designPatterB(matrix);
        }
        printingMatrix(matrix);
    }

    private static void printingMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }


    private static void designPatterB(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter++;
                }
            }
        }
    }


        private static void designPatterA ( int[][] matrix){
            int counter = 1;
            for (int col = 0; col < matrix.length; col++) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter++;
                }
            }
        }

}
