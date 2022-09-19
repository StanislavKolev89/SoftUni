import java.util.*;

public class Matrix2By2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] rowsAndCols = matrixDefine(scanner.nextLine(), ", ");

        for (int i = 0; i < rowsAndCols.length; i++) {
            fillingColumns(rowsAndCols, i, scanner.nextLine(), ", ");
        }

        int[][] biggest = findingBiggestMatrix(rowsAndCols);
        printBiggest(biggest);
        System.out.println(biggestSum(biggest));

    }

    private static int biggestSum(int[][] biggest) {
        int total = 0;
        for (int row = 0; row < biggest.length; row++) {
            for (int col = 0; col < biggest[row].length; col++) {
                total += biggest[row][col];
            }

        }
        return total;
    }

    private static void printBiggest(int[][] biggest) {
        for (int row = 0; row < biggest.length; row++) {
            for (int col = 0; col < biggest[row].length; col++) {
                System.out.print(biggest[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] findingBiggestMatrix(int[][] rowsAndCols) {
        int max = Integer.MIN_VALUE;
        int[][] matrix = new int[2][2];
        List<Integer> list = new ArrayList<>();
        int sumOfAll = 0;
        for (int row = 0; row < rowsAndCols.length - 1; row++) {
            for (int col = 0; col < rowsAndCols[row].length - 1; col++) {
                sumOfAll = rowsAndCols[row][col] + rowsAndCols[row][col + 1] +
                        rowsAndCols[row + 1][col] + rowsAndCols[row + 1][col + 1];

                if (sumOfAll > max) {
                    max = sumOfAll;
                    list.add(rowsAndCols[row][col]);
                    list.add(rowsAndCols[row][col + 1]);
                    list.add(rowsAndCols[row + 1][col]);
                    list.add(rowsAndCols[row + 1][col + 1]);
                    matrix = new int[][]{{list.get(0), list.get(1)}, {list.get(2), list.get(3)}};
                }
                list = new ArrayList<>();
            }
        }
        return matrix;
    }

    private static int[][] matrixDefine(String s, String pattern) {
        int[] colsAndRows = Arrays.stream(s.split(pattern)).mapToInt(Integer::parseInt).toArray();

        int[][] result = new int[colsAndRows[0]][colsAndRows[1]];
        return result;
    }

    private static void fillingColumns(int[][] rowsAndCols, int i, String nextLine, String pattern) {
        int[] array = Arrays.stream(nextLine.split(pattern)).mapToInt(Integer::parseInt).toArray();
        rowsAndCols[i] = array;
    }
}
