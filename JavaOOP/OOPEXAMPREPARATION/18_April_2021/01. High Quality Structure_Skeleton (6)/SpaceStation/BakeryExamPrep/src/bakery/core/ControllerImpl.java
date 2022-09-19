package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.BaseFood;
import bakery.entities.bakedFoods.interfaces.Bread;
import bakery.entities.bakedFoods.interfaces.Cake;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.drinks.interfaces.Tea;
import bakery.entities.drinks.interfaces.Water;
import bakery.entities.tables.interfaces.InsideTable;
import bakery.entities.tables.interfaces.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;


import java.util.stream.Collectors;

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private DrinkRepository drinkRepository;
    private TableRepository tableRepository;
    private static double billsFromClosedTables = 0;

    public ControllerImpl(FoodRepository foodRepository, DrinkRepository drinkRepository, TableRepository tableRepository) {
        this.foodRepository = new FoodRepositoryImpl();
        this.drinkRepository = new DrinkRepositoryImpl();
        this.tableRepository = new TableRepositoryImpl();
    }


    @Override
    public String addFood(String type, String name, double price) {
        BaseFood baseFood = ((type.equals("Bread")) ? new Bread(name, price) : new Cake(name, price));
        for (BakedFood food : foodRepository.getAll()) {
            if (food.getName().equals(name)) {
                throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,food.getClass().getSimpleName(), name));
            }
        }
        foodRepository.getAll().add(baseFood);
        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = ((type.equals("Water")) ? new Water(name, portion, brand) : new Tea(name, portion, brand));
        for (Drink drinkk : drinkRepository.getAll()) {
            if (drinkk.getName().equals(name)) {
                throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,name,brand));
            }
        }
        drinkRepository.getAll().add(drink);
        return String.format(DRINK_ADDED, name ,brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = (type.equals("InsideTable") ? new InsideTable(tableNumber, capacity) : new OutsideTable(tableNumber, capacity));
        for (Table table1 : tableRepository.getAll()) {
            if (table1.getTableNumber() == tableNumber) {
                throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
            }
        }
        tableRepository.getAll().add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        for (Table table : tableRepository.getAll()) {
            if (!table.isReserved()) {
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED, table.getTableNumber(),numberOfPeople);
            }
        }

        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table tableSearched = tableRepository.getAll().stream().filter(e -> e.getTableNumber() == tableNumber).findFirst().orElse(null);
        BakedFood foodSearched = foodRepository.getAll().stream().filter(e -> e.getName().equals(foodName)).findFirst().orElse(null);
        if (tableSearched == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if (foodSearched == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
            tableSearched.orderFood(foodSearched);
        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table tableSearched = tableRepository.getAll().stream().filter(e -> e.getTableNumber() == tableNumber).findFirst().orElse(null);
        Drink drinkSearched = drinkRepository.getAll().stream().filter(e -> e.getName().equals(drinkName) && e.getBrand().equals(drinkBrand)).findFirst().orElse(null);
        if (tableSearched == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if (drinkSearched == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        tableSearched.orderDrink(drinkSearched);
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = tableRepository.getAll().stream().filter((e -> e.getTableNumber() == tableNumber)).findFirst().orElse(null);
        int tableNumber1 = table.getTableNumber();
        double bill = table.getBill();
        billsFromClosedTables+=bill;
        table.clear();
        return String.format(BILL,tableNumber1 , bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder builder = new StringBuilder();
        tableRepository.getAll().stream().filter(e -> !e.isReserved()).forEach(e -> builder.append(e.getTableInfo()));
        return builder.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        //TODO:

        return String.format(TOTAL_INCOME,billsFromClosedTables);
    }
}
