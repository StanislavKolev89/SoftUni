package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private Collection<Drink> drinks;

    public DrinkRepositoryImpl(){
        this.drinks = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        return drinks.stream().filter(e -> e.getName().equals(drinkName) && e.getBrand().equals(drinkBrand)).findFirst().orElse(null);
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(drinks);
    }

    @Override
    public void add(Drink drink) {
        drinks.add(drink);
    }


}
