package entities.drinks.interfaces;

public abstract class BaseDrink implements Drink{

    private String name;
    private int portion;
    private double price;
    private String brand;

    protected BaseDrink(String name, int portion, double price, String brand){

    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getPortion() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getBrand() {
        return "BaseDrink";
    }
}
