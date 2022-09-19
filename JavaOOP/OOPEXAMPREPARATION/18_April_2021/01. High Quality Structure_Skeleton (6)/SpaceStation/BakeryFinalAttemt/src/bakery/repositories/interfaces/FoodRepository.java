package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;

public interface FoodRepository<T> extends Repository<T> {
    T getByName(String name);
}
