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

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double billsFromClosedTables;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.billsFromClosedTables = 0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood baseFood = this.foodRepository.getByName(name);
        if (baseFood != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

         baseFood = ((type.equals("Bread")) ? new Bread(name, price) : new Cake(name, price));
        this.foodRepository.add(baseFood);
        return String.format(FOOD_ADDED, baseFood.getName(), type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = this.drinkRepository.getByNameAndBrand(name, brand);

        if (drink != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, name, brand));
        }

         drink = ((type.equals("Water")) ? new Water(name, portion, brand) : new Tea(name, portion, brand));
        drinkRepository.add(drink);
        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        if (table != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

         table = (type.equals("InsideTable") ? new InsideTable(tableNumber, capacity) : new OutsideTable(tableNumber, capacity));
        tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table table = tableRepository.getAll().stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        table.reserve(numberOfPeople);
        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table tableSearched = tableRepository.getAll().stream().filter(e -> e.getTableNumber() == tableNumber).findFirst().orElse(null);
        if (tableSearched == null || !tableSearched.isReserved()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        BakedFood foodSearched = foodRepository.getAll().stream().filter(e -> e.getName().equals(foodName)).findFirst().orElse(null);
        if (foodSearched == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
        tableSearched.orderFood(foodSearched);
        return String.format(FOOD_ORDER_SUCCESSFUL, tableSearched.getTableNumber(), foodSearched.getName());
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table tableSearched = tableRepository.getAll().stream().filter(e -> e.getTableNumber() == tableNumber).findFirst().orElse(null);
        if (tableSearched == null || !tableSearched.isReserved()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        Drink drinkSearched = drinkRepository.getAll().stream().filter(e -> e.getName().equals(drinkName) && e.getBrand().equals(drinkBrand)).findFirst().orElse(null);
        if (drinkSearched == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        tableSearched.orderDrink(drinkSearched);
        return String.format(DRINK_ORDER_SUCCESSFUL, tableSearched.getTableNumber(), drinkSearched.getName(), drinkSearched.getBrand());
    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        billsFromClosedTables += bill;
        table.clear();
        return String.format(BILL, table.getTableNumber(), bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder builder = new StringBuilder();
        tableRepository.getAll().stream().filter(e -> !e.isReserved()).forEach(e -> builder.append(e.getFreeTableInfo()));
        return builder.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, billsFromClosedTables);
    }
}
