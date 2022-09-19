import java.text.DecimalFormat;

public abstract class Vehicle {
    protected Double fuelQuantity;
    protected Double fuelConsumption;
    protected Double tankCapacity;


    protected Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = setFuel(tankCapacity);
    }

    protected abstract Double setFuel(Double tankCapacity);

    protected String distance(Double distance) {
        Double ableDistance = this.fuelQuantity / this.fuelConsumption;
        if (distance <= ableDistance) {
            fuelQuantity -= distance * fuelConsumption;
            DecimalFormat format = new DecimalFormat("##.##");
            return String.format("%s travelled %s km%n", this.getClass().getSimpleName(), format.format(distance));
        }
        return String.format("%s needs refueling", this.getClass().getSimpleName());
    }


    protected void refuel(Double liters) {
        if (liters > 0) {
            if ((this.fuelQuantity + liters) <= this.tankCapacity) {
                if (this.getClass().getSimpleName().equals("Car")) {
                    fuelQuantity += liters;
                } else if (this.getClass().getSimpleName().equals("Truck")) {
                    fuelQuantity += liters * 0.95;
                }
            }else{
                System.out.println("Cannot fit fuel in tank");
            }
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    @Override

    public String toString() {

        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    protected abstract String distance(Double distance, boolean hasPassengers);
}
