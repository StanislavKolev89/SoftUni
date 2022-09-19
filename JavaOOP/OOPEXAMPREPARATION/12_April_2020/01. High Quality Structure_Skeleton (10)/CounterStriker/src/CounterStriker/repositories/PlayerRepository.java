package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;
import static CounterStriker.common.ExceptionMessages.*;

public class PlayerRepository implements Repository<Player> {


    private List<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>();
    }


    @Override
    public Collection<Player> getModels() {
        return this.players;
    }

    @Override
    public void add(Player model) {
        if (model == null) {
            throw new IllegalArgumentException(INVALID_PLAYER_REPOSITORY);
        }
        this.players.add(model);
    }

    @Override
    public boolean remove(Player model) {
        return players.remove(model);
    }

    @Override
    public Player findByName(String name) {
        return players.stream().filter(e->e.getUsername().equals(name)).findFirst().orElse(null);
    }
}
