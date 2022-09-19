package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.BaseFood;

public interface FoodRepository extends Repository<BakedFood> {
    BakedFood getByName(String name);
}
