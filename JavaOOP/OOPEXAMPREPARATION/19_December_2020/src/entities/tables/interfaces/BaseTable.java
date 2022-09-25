package entities.tables.interfaces;

import entities.bakedFoods.interfaces.BakedFood;
import entities.drinks.interfaces.Drink;

import java.util.Collection;

public abstract class BaseTable implements Table{
   private  Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson){

    }

    @Override
    public int getTableNumber() {
        return 0;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getNumberOfPeople() {
        return 0;
    }

    @Override
    public double getPricePerPerson() {
        return 0;
    }

    @Override
    public boolean isReserved() {
        return false;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void reserve(int numberOfPeople) {

    }

    @Override
    public void orderFood(BakedFood food) {

    }

    @Override
    public void orderDrink(Drink drink) {

    }

    @Override
    public double getBill() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getFreeTableInfo() {
        return null;
    }
}