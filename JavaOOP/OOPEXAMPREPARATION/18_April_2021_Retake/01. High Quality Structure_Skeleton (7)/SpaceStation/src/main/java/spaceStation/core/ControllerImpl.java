package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.models.planets.PlanetRepository;
import spaceStation.repositories.AstronautRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private static int COUNTER_OF_LIVES = 0;
    private static int EXPLORED_PLANETS = 0;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();


    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        if (!type.equals("Biologist") && !type.equals("Geodesist") && !type.equals("Meteorologist")) {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        Astronaut astronaut = createAstronaut(type, astronautName);
        astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        planetRepository.getModels().add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut byName = astronautRepository.findByName(astronautName);
        if (byName == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(byName);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = planetRepository.findByName(planetName);
        List<Astronaut> collectedAstronauts = astronautRepository.getModels().stream().filter(e -> e.getOxygen() > 60).collect(Collectors.toList());
        if (collectedAstronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        mission.explore(planet, collectedAstronauts);
        COUNTER_OF_LIVES = collectingDeadAstronauts(collectedAstronauts);
        EXPLORED_PLANETS++;
        return String.format(PLANET_EXPLORED, planetName, COUNTER_OF_LIVES);
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(REPORT_PLANET_EXPLORED, EXPLORED_PLANETS)).append(System.lineSeparator());
        builder.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut astronaut : astronautRepository.getModels()) {
            builder.append(String.format(REPORT_ASTRONAUT_NAME, astronaut.getName())).append(System.lineSeparator());
            builder.append(String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen())).append(System.lineSeparator());
            List<String> items = (List<String>) astronaut.getBag().getItems();
            String none = items.isEmpty() ? "none" : String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, items);
            builder.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, none)).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }

    private Astronaut createAstronaut(String type, String astronautName) {
        if (type.equals("Biologist")) {
            return new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            return new Geodesist(astronautName);
        } else {
            return new Meteorologist(astronautName);
        }
    }

    private int collectingDeadAstronauts(List<Astronaut> collectedAstronauts) {
        int counter = 0;
        for (Astronaut astronaut : collectedAstronauts) {
            if (astronaut.getOxygen() == 0) {
                counter++;
            }
        }
        return counter;
    }
}
