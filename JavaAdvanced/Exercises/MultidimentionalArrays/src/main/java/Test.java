import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int a = 4;
        int b = 5;
        int result = (a+b>number)? number:a+b;
        for (int i = 0; i <result ; i++) {

        }
    }
}
