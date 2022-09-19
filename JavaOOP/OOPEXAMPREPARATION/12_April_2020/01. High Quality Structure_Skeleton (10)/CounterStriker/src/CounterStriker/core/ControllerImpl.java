package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        guns = new GunRepository();
        players = new PlayerRepository();
        field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        if (!type.equals("Pistol") && !type.equals("Rifle")) {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        guns.getModels().add(type.equals("Pistol") ? new Pistol(name, bulletsCount) : new Rifle(name, bulletsCount));
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String typeOfPlayer, String username, int health, int armor, String gunName) {
        Gun gunToBeAdded = guns.getModels().stream().filter(e -> e.getName().equals(gunName)).findFirst().orElse(null);
        if (gunToBeAdded == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        if (!typeOfPlayer.equals("Terrorist") && !typeOfPlayer.equals("CounterTerrorist")) {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        Player player = (typeOfPlayer.equals("Terrorist") ? new Terrorist(username, health, armor, gunToBeAdded) :
                new CounterTerrorist(username, health, armor, gunToBeAdded));

        players.getModels().add(player);

        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return field.start((List<Player>) players.getModels());

    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
     TreeMap<String,Player> counter = new TreeMap<>();
     TreeMap<String,Player> ter = new TreeMap<>();
        players.getModels().stream().filter(e->e.getClass().getSimpleName().equals("CounterTerrorist")).forEach(e->counter.put(e.getUsername(),e));
        players.getModels().stream().filter(e->e.getClass().getSimpleName().equals("Terrorist")).forEach(e->ter.put(e.getUsername(),e));


        builder.append(extracted(counter)).append(System.lineSeparator());
       builder.append(extracted(ter));
        return builder.toString().trim();
    }

    private String extracted(TreeMap<String,Player> counter) {
        StringBuilder builder = new StringBuilder();
        counter.entrySet().stream().forEach((e->{
                    builder.append(String.format("%s: %s",e.getValue().getClass().getSimpleName(),e.getValue().getUsername())).append(System.lineSeparator());
                    builder.append(String.format("--Health: %d",e.getValue().getHealth())).append(System.lineSeparator());
                    builder.append(String.format("--Armor: %d",e.getValue().getArmor())).append(System.lineSeparator());
                    builder.append(String.format("--Gun: %s",e.getValue().getGun().getName())).append(System.lineSeparator());

                }));
        return builder.toString().trim();
    }
}
