import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String word = scanner.nextLine();
        List<String> words = new ArrayList<>();

        while (!word.equals("END")) {
            words.add(word);
            word = scanner.nextLine();
        }

        int biggestWord = FindingBIggestWord(words);

        String[][] matrix = creatingMatrix(words, biggestWord);

        int degree = findingDegrees(input);

        if (degree > 360) {
            degree %= 360;
        }

        switch (degree) {
            case 90:
                matrix = shiftingNinety(matrix, words);
                break;
            case 180:
                matrix = ShiftingOneEighty(matrix, words);
                break;
            case 270:
                matrix = ShiftingTwoSeventy(matrix, words);
                break;
            default:
                matrix = matrix;
                break;

        }
        printMatrix(matrix);

    }

    private static String[][] ShiftingTwoSeventy(String[][] matrix, List<String> words) {
        String[][] newMatrix = new String[matrix[0].length][matrix.length];

        for (int col = 0; col < matrix.length; col++) {
            String wordToFill = words.get(col);
            if (wordToFill.length() <= matrix[0].length) {
                wordToFill = addingSpacesReversed(wordToFill, matrix[0].length - wordToFill.length());
            }
            for (int row = 0; row < matrix[0].length; row++) {
                newMatrix[row][col] = String.valueOf(wordToFill.charAt(row));
            }
        }
        return newMatrix;
    }

    private static String[][] ShiftingOneEighty(String[][] matrix, List<String> words) {
        String[][] newMatrix = new String[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            String wordToFill = words.get(matrix.length - 1 - row);
            if (wordToFill.length() <=matrix[0].length) {
                wordToFill = addingSpacesReversed(wordToFill, matrix[0].length - wordToFill.length());
            }
            for (int col = 0; col < matrix[0].length; col++) {
                newMatrix[row][col] = String.valueOf(wordToFill.charAt(col));
            }
        }
        return newMatrix;
    }

    private static String addingSpacesReversed(String wordToFill, int i) {
        StringBuilder newWord = new StringBuilder(wordToFill);
        for (int j = 0; j < i; j++) {
            newWord.append(" ");
        }
        newWord = newWord.reverse();
        return String.valueOf(newWord);
    }


    private static String[][] shiftingNinety(String[][] matrix, List<String> words) {
        String[][] newMatrix = new String[matrix[0].length][matrix.length];

        for (int col = 0; col < matrix.length; col++) {
            String wordToFill = words.get(matrix.length - 1 - col);
            if (wordToFill.length() < matrix[0].length) {
                wordToFill = addingSpaces(wordToFill, matrix[0].length - wordToFill.length());
            }
            for (int row = 0; row < matrix[0].length; row++) {
                newMatrix[row][col] = String.valueOf(wordToFill.charAt(row));
            }
        }
        return newMatrix;
    }

    private static String addingSpaces(String wordToFill, int i) {
        StringBuilder newWord = new StringBuilder(wordToFill);
        for (int j = 0; j < i; j++) {
            newWord.append(" ");

        }
        return String.valueOf(newWord);
    }

    private static String[][] creatingMatrix(List<String> words, int biggestWord) {
        String[][] matrix = new String[words.size()][biggestWord];
        for (int row = 0; row < words.size(); row++) {
            for (int col = 0; col < biggestWord; col++) {
                if (col <= words.get(row).length() - 1) {
                    matrix[row][col] = String.valueOf(words.get(row).charAt(col));
                } else {
                    matrix[row][col] = " ";
                }
            }

        }
        return matrix;
    }

    private static int FindingBIggestWord(List<String> words) {
        int biggest = 0;
        for (String word : words) {
            if (word.length() >= biggest) {
                biggest = word.length();
            }
        }
        return biggest;
    }

    private static int findingDegrees(String input) {
        String regex = "(?<deg>(\\d{1,}))";
        String degree = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            degree = matcher.group("deg");
        }
        return Integer.parseInt(degree);
    }

    private static void printMatrix(String[][] firstMatrix) {

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                System.out.print(firstMatrix[row][col]);
            }
            System.out.println();
        }
    }
}
