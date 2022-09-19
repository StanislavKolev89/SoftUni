import java.util.*;

public class CookingExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsDeque = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        int[] liquids = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int liquid : liquids) {
            liquidsDeque.offer(liquid);
        }
        for (int ingredient : ingredients) {
            ingredientsStack.push(ingredient);
        }
        List<String> products = new ArrayList<>();

        while (true) {
            int numberToAddInStack = ingredientsStack.peek() + 3;
            int sum = liquidsDeque.peek() + ingredientsStack.peek();
            boolean isNotCooked = checkSum(sum);

            ingredientsStack.pop();
            if (isNotCooked) {
                addingProduct(products, sum);
                liquidsDeque.poll();
            } else {

                ingredientsStack.push(numberToAddInStack);
                liquidsDeque.poll();
            }
            if (liquidsDeque.isEmpty() || ingredientsStack.isEmpty()) {
                break;
            }
        }

    }


    private static void addingProduct(List<String> products, int sum) {
        switch(sum){
            case 25:
                products.add("bread");
                break;
            case 50:
                products.add("cake");
                break;
            case 75:
                products.add("Pastry");
                break;
            case 100:
                products.add("Fruit Pie");
                break;
        }
    }

    private static boolean checkSum(int sum) {
        if(sum!=25 && sum!=50 && sum!= 75 && sum!=100){
            return false;
        }
        return true;
    }
}
