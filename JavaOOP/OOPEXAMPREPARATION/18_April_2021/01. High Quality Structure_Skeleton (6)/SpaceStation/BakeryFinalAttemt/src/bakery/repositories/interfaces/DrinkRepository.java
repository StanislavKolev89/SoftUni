package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;

public interface DrinkRepository<T> extends Repository<T>{
    public T getByNameAndBrand(String drinkName, String drinkBrand);
}
