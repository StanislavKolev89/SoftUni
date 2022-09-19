import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i <expr.length(); i++) {
            char ch = expr.charAt(i);
            if(ch=='('){
                indexes.push(i);
            } else if (ch ==')'){
                int startingPoint = indexes.pop();
                System.out.println(expr.substring(startingPoint,i+1));
            }
        }
    }
}
