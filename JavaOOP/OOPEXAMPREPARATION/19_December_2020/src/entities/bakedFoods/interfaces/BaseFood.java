package entities.bakedFoods.interfaces;

public abstract class BaseFood implements BakedFood{
    private String name;
    private double portion;
    private double price;

    protected BaseFood(String name, double portion,double price){

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPortion() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString(){
        return "TODO";
    }
}
