package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.*;

import static CounterStriker.common.ExceptionMessages.*;

public class GunRepository implements Repository<Gun> {
    private List<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.guns;
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new IllegalArgumentException(INVALID_GUN_REPOSITORY);
        }
        this.guns.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return guns.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        return guns.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
