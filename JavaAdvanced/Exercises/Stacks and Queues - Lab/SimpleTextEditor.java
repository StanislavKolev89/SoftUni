import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfOperations = Integer.parseInt(scanner.nextLine());
        StringBuilder words = new StringBuilder();
        for (int i = 1; i <=numberOfOperations ; i++) {
            String [] commands = scanner.nextLine().split("\\s+");
            String digit = commands[0];

            switch (digit){
                case "1":
                    String text = commands[1];
                    appending(words,text);
                break;
                case "2":
                    int count = Integer.parseInt(commands[1]);
                    erasing(words,count);
                    break;
                case "3":
                    int index = Integer.parseInt(commands[1]);
                    char ch = returningCharacter(words,index);
                     break;
                case "4":
                    break;
            }
        }
    }

    private static char returningCharacter(StringBuilder words, int index) {
        return words.toString().charAt(index);
    }

    private static void erasing(StringBuilder words, int count) {
        words.delete(words.length()-count,words.length());
    }

    private static void appending(StringBuilder words, String text) {
        words.append(text);
    }
}
