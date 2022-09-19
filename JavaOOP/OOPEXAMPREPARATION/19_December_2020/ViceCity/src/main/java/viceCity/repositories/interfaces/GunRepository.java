package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.*;

public class GunRepository implements Repository<Gun> {

    private Queue<Gun> models = new ArrayDeque<>();

    @Override
    public Collection<Gun> getModels() {
        return this.models;
    }

    @Override
    public void add(Gun model) {
        models.offer(model);
    }

    @Override
    public boolean remove(Gun model) {
        return models.poll() != null;
    }

    @Override
    public Gun find(String name) {
        return models.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
