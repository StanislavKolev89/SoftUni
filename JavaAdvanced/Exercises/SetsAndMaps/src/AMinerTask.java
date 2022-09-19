import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer > metals = new LinkedHashMap<>();
        String command = scanner.nextLine();

        int counter = 1;
        while (!command.equals("stop")) {
            String resource = command;
            counter++;
            if (counter % 2 == 0) {
                String quantity = scanner.nextLine();
                collecting(metals,resource,quantity);
            }

            counter++;

            command = scanner.nextLine();
        }

        metals.entrySet().stream().forEach(e-> System.out.printf("%s -> %d%n",e.getKey(),e.getValue()));

    }

    private static void collecting(Map<String, Integer> metals, String resource, String quantity) {
        if(!metals.containsKey(resource)){
            metals.put(resource, Integer.parseInt(quantity));
        }else{
            metals.put(resource, metals.get(resource)+Integer.parseInt(quantity));
        }
    }
}
