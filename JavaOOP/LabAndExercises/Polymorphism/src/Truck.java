import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static final Double FUEL_CONSUMPTION_AIR_CONDITIONER = 1.6;


    protected Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_AIR_CONDITIONER, tankCapacity);
    }

    @Override
    protected Double setFuel(Double tankCapacity) {
        return null;
    }

    @Override
    public String distance(Double distance,boolean state) {
        return null;
    }


}
