import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private static final Double FUEL_CONSUMPTION_AIR_CONDITIONER = 1.4;

    protected Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String distance(Double distance, boolean state) {
        Double ableDistance = fuelQuantity / (this.fuelConsumption + FUEL_CONSUMPTION_AIR_CONDITIONER);
        if (distance <= ableDistance) {
            fuelQuantity -= distance * (fuelConsumption+FUEL_CONSUMPTION_AIR_CONDITIONER);
            DecimalFormat format = new DecimalFormat("#.##");
           return String.format("%s travelled %s km", this.getClass().getSimpleName(), format.format(distance));
        } else {
            return String.format("%s needs refueling"
                    , this.getClass().getSimpleName());
        }
    }
}
