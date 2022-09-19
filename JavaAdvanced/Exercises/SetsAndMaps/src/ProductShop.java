import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> data = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            if(!data.containsKey(shop)){
                data.put(shop,new LinkedHashMap<>());
                data.get(shop).put(product,price);
            }else{
                    data.get(shop).put(product,price);

            }
            input = scanner.nextLine();
        }
        data.entrySet().stream().forEach(e->{
            System.out.printf("%s->%n",e.getKey());
            for (var shop: e.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",shop.getKey(),shop.getValue());
            }
        });
    }
}
