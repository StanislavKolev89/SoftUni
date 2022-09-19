package HealthyHeaven.src.healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();

    }

    public void add(Salad salad) {
        data.add(salad);
    }

    public boolean buy(String name) {
        for (Salad salad : data) {
            if (salad.getName().equals(name)) {
                data.remove(salad);
                return true;
            }
        }
        return false;
    }

    public String  getHealthiestSalad() {
        Salad theSalad = null;
        int min = Integer.MAX_VALUE;
        for (Salad salad : data) {
            if (salad.getTotalCalories() < min) {
                min = salad.getTotalCalories();
                theSalad = salad;
            }
        }
        return theSalad.getName();
    }


    public String generateMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s have %d salads:",this.name,data.size())).append(System.lineSeparator());

        for (Salad salad : data) {
            builder.append(salad).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
