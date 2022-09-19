import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberToConvert = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> digitsInStack = new ArrayDeque<>();

        while(numberToConvert!=0){
            digitsInStack.push(numberToConvert%2);
            numberToConvert/=2;
        }
        while(!digitsInStack.isEmpty()){
            System.out.print(digitsInStack.pop());
        }
    }
}
