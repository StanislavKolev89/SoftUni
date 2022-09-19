package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    private List<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public List<Astronaut> getModels() {
        return astronauts;
    }

    @Override
    public void add(Astronaut astronaut) {
        astronauts.add(astronaut);
    }

    @Override
    public boolean remove(Astronaut astronaut) {
        return astronauts.remove(astronaut);
    }

    @Override
    public Astronaut findByName(String name) {
        for (Astronaut astronaut : astronauts) {
            if (astronaut.getName().equals(name)) {
                return astronaut;
            }
        }
        return null;
    }
}
