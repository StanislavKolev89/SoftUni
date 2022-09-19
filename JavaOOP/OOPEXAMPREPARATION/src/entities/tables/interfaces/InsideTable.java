package entities.tables.interfaces;

import entities.drinks.interfaces.Drink;

public class InsideTable extends BaseTable{
    protected InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, 2.50);
    }

}
