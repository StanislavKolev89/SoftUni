package bakery.entities.bakedFoods.interfaces;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseFood implements BakedFood {

    private String name;
    private double portion;
    private double price;

    protected BaseFood(String name, double portion, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
        setPortion(portion);
        setPrice(price);
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    protected void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f", this.getName(), this.getPortion(), this.getPrice());
    }
}
