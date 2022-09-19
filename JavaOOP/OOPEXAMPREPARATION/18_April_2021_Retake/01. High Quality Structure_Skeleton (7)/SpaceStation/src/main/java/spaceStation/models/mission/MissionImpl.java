package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;
import spaceStation.repositories.AstronautRepository;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, List<Astronaut> astronauts) {
        List<String> items = (List<String>) planet.getItems();

        for (Astronaut astro : astronauts) {
            if (items.isEmpty()) {
                break;
            }
            while (!items.isEmpty()) {
                if (astro.getOxygen() > 0) {
                    String remove = items.remove(0);
                    astro.getBag().getItems().add(remove);
                    astro.breath();
                } else {
                    break;
                }
            }
        }
    }
}
