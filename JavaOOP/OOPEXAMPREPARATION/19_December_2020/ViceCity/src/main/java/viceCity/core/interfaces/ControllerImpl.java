package viceCity.core.interfaces;

import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private LinkedHashMap<String, Player> civilPlayers = new LinkedHashMap();
    private Deque<Gun> gunShop = new ArrayDeque<>();
    private Player mainPlayer = new MainPlayer();

    @Override
    public String addPlayer(String name) {
        civilPlayers.put(name, new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        if (type == null || (!type.equals("Pistol") && !type.equals("Rifle"))) {
            return GUN_TYPE_INVALID;
        }
        gunShop.offer(type.equals("Pistol") ? new Pistol(name) : new Rifle(name));
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (gunShop.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        Gun gunToAdd =gunShop.peek();

        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gunToAdd);
            gunShop.poll();
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gunToAdd.getName(), mainPlayer.getName());
        }

        Player civilPlayer = civilPlayers.get(name);
        if (civilPlayer == null) {
            return "Civil player with that name doesn't exists!";
        }else {
            civilPlayer.getGunRepository().add(gunToAdd);
            gunShop.poll();
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gunToAdd.getName(), civilPlayer.getName());
        }
    }

    @Override
    public String fight() {
        GangNeighbourhood gangNeighbourhood = new GangNeighbourhood();

        int totalBulletsInTheGame = 0;

        for (Gun model : mainPlayer.getGunRepository().getModels()) {
            totalBulletsInTheGame += model.getTotalBullets();
        }
        for (Player civilPlayer : civilPlayers.values()) {
            for (Gun model : civilPlayer.getGunRepository().getModels()) {
                totalBulletsInTheGame += model.getTotalBullets();
            }
        }

        if (totalBulletsInTheGame == 0) {
            return ("Everything is okay!");
        }

        gangNeighbourhood.action(mainPlayer, civilPlayers.values());

        StringBuilder stats = new StringBuilder();
        stats.append("A fight happened:").append(System.lineSeparator());
        stats.append(String.format("Tommy live points: %d!", mainPlayer.getLifePoints())).append(System.lineSeparator());

        long deadPlayers = civilPlayers.values().stream()
                .filter(player -> !player.isAlive())
                .count();

        stats.append(String.format("Tommy has killed: %d players!", deadPlayers)).append(System.lineSeparator());
        stats.append(String.format("Left Civil Players: %d!", civilPlayers.values().size() - deadPlayers));

        return stats.toString().trim();
    }
}
