import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheGArden {
    public static Map<String, Integer> vegetables = new LinkedHashMap<>();
    public static int harmedCounter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        vegetables = fillingMap();
        char[][] matrix = new char[n][];
        for (int row = 0; row < n; row++) {
            String line = extractingData(scanner);
            matrix[row] = line.toCharArray();

        }


        String command = scanner.nextLine();

        while (!command.equals("End of Harvest")) {
            String[] tokens = command.split("\\s+");
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            switch (tokens[0]) {
                case "Harvest":
                    if (placeExistAndValid(row, col, matrix)) {
                        String ch = String.valueOf(matrix[row][col]);
                        mapFilling(vegetables, ch);
                        matrix[row][col] = ' ';
                    }
                    break;
                case "Mole":
                    String direction = tokens[3];
                    if (placeExistAndValid(row, col, matrix)) {
                        String ch = String.valueOf(matrix[row][col]);
                        matrix[row][col] = ' ';
                        harmedCounter++;
                        harmCells(matrix, row, col, direction);

                    }
                    break;
            }

            command = scanner.nextLine();

        }
        printMatrix(matrix);
        vegetables.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        System.out.printf("Harmed vegetables: %d", harmedCounter);

    }

    private static void mapFilling(Map<String, Integer> vegetables, String ch) {
        if (ch.equals("P")) {
            vegetables.put("Potatoes", vegetables.get("Potatoes") + 1);
        } else if (ch.equals("L")) {
            vegetables.put("Lettuce", vegetables.get("Lettuce") + 1);
        } else if (ch.equals("C")) {
            vegetables.put("Carrots", vegetables.get("Carrots") + 1);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < matrix[row].length - 1) {
                    System.out.print(matrix[row][col] + " ");
                } else {
                    System.out.print(matrix[row][col]);
                }
            }
            System.out.println();
        }
    }

    private static String extractingData(Scanner scanner) {
        String[] str = scanner.nextLine().split("\\s+");
        String chars = "";
        for (String s : str) {
            chars += s;
        }
        return chars;
    }

    private static void harmCells(char[][] matrix, int newRow, int newCol, String direction) {
        switch (direction) {
            case "up":
                for (int i = newRow; i >= 0; i -= 2) {
                    if (matrix[i].length >= newCol) {
                        if (matrix[i][newCol] != ' ') {
                            String ch = String.valueOf(matrix[i][newCol]);
                            matrix[i][newCol] = ' ';
                            harmedCounter++;
                        }
                    }
                }
                break;
            case "down":
                for (int i = newRow; i <= matrix.length; i += 2) {
                    if (matrix[i].length >= newCol) {
                        if (matrix[i][newCol] != ' ') {
                            String ch = String.valueOf(matrix[i][newCol]);
                            matrix[i][newCol] = ' ';
                            harmedCounter++;
                        }
                    }
                }
                break;
            case "left":
                for (int i = newCol; i >= 0; i -= 2) {
                    if (matrix[newRow][i] != ' ') {
                        String ch = String.valueOf(matrix[newRow][i]);

                        matrix[i][newCol] = ' ';
                        harmedCounter++;
                    }
                }
                break;
            case "right":
                for (int i = newCol; i < matrix[newRow].length; i += 2) {
                    if (matrix[newRow][i] != ' ') {
                        String ch = String.valueOf(matrix[newRow][i]);
                        matrix[newRow][i] = ' ';
                        harmedCounter++;
                    }
                }

                break;

        }
    }


    private static Map<String, Integer> fillingMap() {
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("Carrots", 0);
        map.put("Potatoes", 0);
        map.put("Lettuce", 0);

        return map;
    }

    private static boolean placeExistAndValid(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length
               ;
    }
}
