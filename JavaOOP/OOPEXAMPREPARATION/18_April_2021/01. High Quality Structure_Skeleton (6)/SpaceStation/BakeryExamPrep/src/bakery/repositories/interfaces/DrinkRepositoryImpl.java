package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public  class DrinkRepositoryImpl<T extends  Drink> implements DrinkRepository {


    @Override
    public T getByNameAndBrand(String drinkName, String drinkBrand) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void add(T t) {

    }
}
