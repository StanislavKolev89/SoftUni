import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[data[0]][data[1]];
        fillingMatrix(matrix);

        printMatrix (matrix);

    }

    private static void printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    private static String[][] fillingMatrix(String[][] matrix) {
        char ch = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] =""+ ch + (char)(ch+col) + ch;
            }
            ch ++;
        }
        return matrix;

    }

    private static void changeWord(String word, int col) {
        char ch = word.charAt(1);
        StringBuilder newWord = new StringBuilder(word);
        newWord.replace(1, 1, String.valueOf(ch + col));

    }
}
