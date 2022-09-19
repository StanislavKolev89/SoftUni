package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;


    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }

    public void add(Car car) {
        if (data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;

    }

    public Car getLatestCar() {
        if (this.data.size() == 0) {
            return null;
        } else {
            return this.data.stream().max(Comparator.comparingInt(Car::getYear)).get();
        }
    }

    public Car getCar(String manufacturer, String model) {
        if(this.data.size()==0){
            return null;
        }else {
            for (Car car : this.data) {
                if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                    return car;
                }
            }
            return null;
        }
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {

        StringBuilder builder = new StringBuilder();
        builder.append("The car is parked in ").append(this.type).append(":").append(System.lineSeparator());
        for (Car car : this.data) {
            builder.append(car).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
