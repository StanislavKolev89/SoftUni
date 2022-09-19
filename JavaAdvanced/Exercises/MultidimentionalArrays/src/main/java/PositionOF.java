import java.util.Arrays;
import java.util.Scanner;

public class PositionOF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] rowsAndCols = matrixDefine(scanner.nextLine());
        for (int i = 0; i < rowsAndCols.length; i++) {
            fillingColumns(rowsAndCols, i, scanner.nextLine());
        }

        int number = Integer.parseInt(scanner.nextLine());
        boolean equalFound = isThereEqual(rowsAndCols,number);
        if(equalFound) {
            printingIFEqual(rowsAndCols, number);
        }else{
            System.out.println( "not found");
        }
    }

    private static boolean isThereEqual(int[][] rowsAndCols, int number) {
        for (int rows = 0; rows < rowsAndCols[0].length-1; rows++) {
            for (int cols = 0; cols < rowsAndCols[1].length; cols++) {
                int numberToCompare = rowsAndCols[rows][cols];
                if(number==numberToCompare) {
                   return true;
                }
            }
        }
        return false;
    }

    private static void printingIFEqual(int[][] rowsAndCols, int number) {
        for (int rows = 0; rows < rowsAndCols[0].length-1; rows++) {

            for (int cols = 0; cols < rowsAndCols[1].length; cols++) {
                int numberToCompare = rowsAndCols[rows][cols];
                if(number==numberToCompare) {
                    System.out.println(rows + " " + cols);
                }
            }
        }
    }

    private static int[][] matrixDefine(String s) {
        int[] colsAndRows = Arrays.stream(s.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] result = new int[colsAndRows[0]][colsAndRows[1]];
        return result;
    }
    private static void fillingColumns(int[][] rowsAndCols, int i, String nextLine) {
        int[] array = Arrays.stream(nextLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        rowsAndCols[i] = array;
    }
}
