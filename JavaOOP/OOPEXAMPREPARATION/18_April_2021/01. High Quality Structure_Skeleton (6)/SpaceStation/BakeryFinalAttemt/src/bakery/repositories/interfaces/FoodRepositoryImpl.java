package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;

import java.util.*;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private Map<String,BakedFood> foodList;

    public FoodRepositoryImpl() {
        this.foodList = new LinkedHashMap<>();
    }


    @Override
    public BakedFood getByName(String name) {
        return this.foodList.get(name);
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(foodList.values());
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.foodList.put(bakedFood.getName(),bakedFood);
    }


}
