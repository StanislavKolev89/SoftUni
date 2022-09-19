import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final Double FUEL_CONSUMPTION_AIR_CONDITIONER = 0.9;


    protected Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption+FUEL_CONSUMPTION_AIR_CONDITIONER,tankCapacity);
    }

    @Override
    protected Double setFuel(Double tankCapacity) {
        return null;
    }

    @Override
    public String distance(Double parseDouble,boolean state) {
        return null;
    }
}
