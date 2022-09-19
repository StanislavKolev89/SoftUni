import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> expStack = new ArrayDeque<>();
        for (int i = input.length-1; i >=0 ; i--) {
            expStack.push(input[i]);
        }
        int total = 0;
        while(expStack.size()>1){
           int leftOperand = Integer.parseInt(expStack.pop());
           String operator = expStack.pop();
           int rightOperand = Integer.parseInt(expStack.pop());

           int result = operator.equals("+")? leftOperand+rightOperand : leftOperand-rightOperand;
            expStack.push(String.valueOf(result));

        }
        System.out.println(expStack.toString().replaceAll("[\\[\\]]",""));
    }
}
