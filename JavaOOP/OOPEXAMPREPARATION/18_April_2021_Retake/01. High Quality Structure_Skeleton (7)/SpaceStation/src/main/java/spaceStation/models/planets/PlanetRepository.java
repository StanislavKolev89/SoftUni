package spaceStation.models.planets;

import spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlanetRepository implements Repository<Planet> {
    private List<Planet> planets;

    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }

    @Override
    public List<Planet> getModels() {
        return planets;
    }

    @Override
    public void add(Planet planet) {
        planets.add(planet);
    }

    @Override
    public boolean remove(Planet planet) {
        return planets.remove(planet);
    }

    @Override
    public Planet findByName(String name) {
        Planet planet = null;
        for (Planet planet1 : planets) {
            if (planet1.getName().equals(name)) {
                planet = planet1;
            }
        }
        return planet;
    }
}
