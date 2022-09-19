package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;
import java.util.Collections;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        attack(mainPlayer, civilPlayers);

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                attack(civilPlayer, Collections.singletonList(mainPlayer));
                if (!mainPlayer.isAlive()) {
                    break;
                }
            }
        }
    }

    private void attack(Player attacker, Collection<Player> victims) {
        for (Gun gun : attacker.getGunRepository().getModels()) {
            for (Player civilPlayer : victims) {
                while (gun.canFire() && civilPlayer.isAlive()) {
                    int bulletsShot = gun.fire();
                    civilPlayer.takeLifePoints(bulletsShot);
                }

                if (!gun.canFire()) {
                    break;
                }
            }
        }
    }
}
