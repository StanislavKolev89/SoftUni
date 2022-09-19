package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.BaseFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public  class FoodRepositoryImpl implements FoodRepository {
    private List<BakedFood> bakedFoods;


    public FoodRepositoryImpl() {
        this.bakedFoods = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        return this.bakedFoods.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<BakedFood> getAll() {
        return this.bakedFoods;
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.bakedFoods.add(bakedFood);
    }
}
