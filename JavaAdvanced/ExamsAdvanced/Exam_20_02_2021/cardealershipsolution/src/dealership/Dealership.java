package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    public String name;
    public int capacity;
    public List<Car> data;


    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < this.capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        return data.stream().max((e1, e2) -> Integer.compare(e1.getYear(), e2.getYear())).get();
    }

    public Car getCar(String man, String model) {
        return data.stream().filter(e -> e.getManufacturer().equals(man) && e.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are in a car dealership %s:",this.name)).append(System.lineSeparator());
        for (Car car: data) {
            builder.append(car).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
