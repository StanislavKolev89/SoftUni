package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;


    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getTotalCalories() {
        int sum = 0;
        for (Vegetable vegetable : this.products) {
            sum += vegetable.getCalories();
        }
        return sum;
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable vegetable) {
        this.products.add(vegetable);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("* Salad %s is %d calories and have %d products:"
                , this.name, this.getTotalCalories(),
                this.getProductCount())).append(System.lineSeparator());
        for (Vegetable vegetable : products) {
            builder.append(vegetable.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
