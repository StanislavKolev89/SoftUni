import java.util.*;
import java.util.stream.Collectors;

public class MakeASalad {

    public static int caloriesFromStack = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vegetablesQ = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> caloriesS = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(e -> caloriesS.push(e));
        List<Integer> madeSalads = new ArrayList<>();

        caloriesFromStack = caloriesS.peek();

        while (!vegetablesQ.isEmpty() && !caloriesS.isEmpty()) {
            int vegetableCalories = CheckCalorie(vegetablesQ.poll());
            caloriesFromStack-=vegetableCalories;
            if(caloriesFromStack<=0 || vegetablesQ.isEmpty()){
                madeSalads.add(caloriesS.pop());
                if(!caloriesS.isEmpty()) {
                    caloriesFromStack = caloriesS.peek();
                }
            }

        }

        if(!madeSalads.isEmpty()){
            madeSalads.stream().forEach(e-> System.out.print(e+" "));
            System.out.println();
        }
        if (!vegetablesQ.isEmpty()){
            vegetablesQ.stream().forEach(e-> System.out.print(e+" "));
            System.out.println();
        }else {
            while(caloriesS.size()>0){
                System.out.print(caloriesS.pop()+" ");

            }

        }
    }

    private static int CheckCalorie(String vegetable) {
        return vegetable.equals("tomato") ? 80 : vegetable.equals("carrot") ? 136 :
                vegetable.equals("lettuce") ? 109 : vegetable.equals("potato") ? 215 : 0;

    }
}
