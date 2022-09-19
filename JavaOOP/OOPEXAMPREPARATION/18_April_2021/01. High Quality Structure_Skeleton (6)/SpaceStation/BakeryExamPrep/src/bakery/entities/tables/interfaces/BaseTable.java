package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private List<BakedFood> foodOrders;
    private List<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;



    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        foodOrders = new ArrayList<>();
        drinkOrders = new ArrayList<>();
        setTableNumber(tableNumber);
        setCapacity(capacity);
        setPricePerPerson(pricePerPerson);
        this.price = 0;
    }

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    protected void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.price = numberOfPeople * this.pricePerPerson;

    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double billCounter = 0;
        billCounter+= drinkOrders.stream().mapToDouble(e->e.getPrice()).sum();
        billCounter+= foodOrders.stream().mapToDouble(e->e.getPrice()).sum();
        billCounter += getPrice();
        return billCounter;
    }

    @Override
    public void clear() {
        foodOrders.clear();
        drinkOrders.clear();
        isReserved = false;
        setPrice(0);
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = number;
        this.isReserved =true;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getTableInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Table: %d", getTableNumber())).append(System.lineSeparator());
        builder.append(String.format("Type: %s", this.getClass().getSimpleName())).append(System.lineSeparator());
        builder.append(String.format("Capacity: %s", this.getCapacity())).append(System.lineSeparator());
        builder.append(String.format("Price per Person: %.2f", getPricePerPerson())).append(System.lineSeparator());
        return builder.toString();
    }
}
