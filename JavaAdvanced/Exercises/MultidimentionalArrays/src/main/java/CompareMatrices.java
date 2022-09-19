import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] rowsAndCols = matrixDefine(scanner.nextLine(), "\\s+");

        for (int i = 0; i < rowsAndCols[0].length-1; i++) {
            fillingColumns(rowsAndCols, i, scanner.nextLine());
        }
        int[][] firstMatrix = rowsAndCols;

        int[][] rowsAndCols2 = matrixDefine(scanner.nextLine(),"\\s+");

        for (int i = 0; i < rowsAndCols[0].length-1; i++) {
            fillingColumns(rowsAndCols2, i, scanner.nextLine());
        }
        int[][] secondMatrix = rowsAndCols2;

        boolean areEqual = CheckIfEqual(firstMatrix,secondMatrix);
        if(areEqual){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }

    private static boolean CheckIfEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length!= secondMatrix.length) {
            return false;
        }
            for (int i = 0; i < firstMatrix.length; i++) {
                int[] first =firstMatrix[i];
                int[] second =secondMatrix[i];

                if(first.length!= second.length){
                    return false;
                }
                for (int j = 0; j < first.length; j++) {
                    if(first[j]!= second[j]){
                        return false;
                    }
                }
            }
        return true;
    }


    private static void fillingColumns(int[][] rowsAndCols, int i, String nextLine) {
        int[] array = Arrays.stream(nextLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        rowsAndCols[i] = array;
    }

    private static int[][] matrixDefine(String s, String pattern) {
        int[] colsAndRows = Arrays.stream(s.split(pattern)).mapToInt(Integer::parseInt).toArray();

        int[][] result = new int[colsAndRows[0]][colsAndRows[1]];
        return result;
    }
}
