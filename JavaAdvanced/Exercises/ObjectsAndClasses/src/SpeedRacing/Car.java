package SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double consumption;
    private int distanceTravelled;


    public Car(String model, double fuel, double price) {
        this.model = model;
        this.fuel = fuel;
         this.consumption = price;
        this.distanceTravelled = 0;
    }

    public double getPricePerKm() {
        return consumption;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public double getFuelAmount() {
        return this.fuel;
    }


    public boolean isTraveling(int distance) {
        double needFuel = distance * getPricePerKm();

        if(needFuel<=getFuelAmount()){
            this.distanceTravelled+=distance;
            this.fuel -= needFuel;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuel,this.distanceTravelled);
    }

}
