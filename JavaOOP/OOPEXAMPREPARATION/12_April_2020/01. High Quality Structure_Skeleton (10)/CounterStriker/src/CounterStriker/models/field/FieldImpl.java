package CounterStriker.models.field;

import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {

    @Override
    public String start(List<Player> players) {
        List<Player> terrorists = players.stream().filter(e -> e.getClass().getSimpleName().
                equals("Terrorist")).collect(Collectors.toList());
        List<Player> counterTerrorists = players.stream().filter(e -> e.getClass().getSimpleName().
                equals("CounterTerrorist")).collect(Collectors.toList());

        String output = null;
        int counterForTerrorists = terrorists.size();
        int counterForCounterTerrorists = counterTerrorists.size();
        while (true) {
            for (Player attacker : terrorists) {
                if (attacker.isAlive()) {
                    for (Player attacked : counterTerrorists) {
                        if (attacked.isAlive()) {
                            int firePower = attacker.getGun().fire();
                            attacked.takeDamage(firePower);
                            if (attacked.getHealth() <= 0) {
                                counterForCounterTerrorists--;
                            }
                        }
                    }
                }
                if (counterForCounterTerrorists == 0) {
                    output = TERRORIST_WINS;
                    break;
                }
            }


            for (Player attacker : counterTerrorists) {
                if (attacker.isAlive()) {
                    for (Player attacked : terrorists) {
                        if (attacked.isAlive()) {
                            int firePower = attacker.getGun().fire();
                            attacked.takeDamage(firePower);
                            if (attacked.getHealth() <= 0) {
                                counterForTerrorists--;
                            }
                        }
                    }
                }

                if (counterForTerrorists == 0) {
                    output = COUNTER_TERRORIST_WINS;
                    break;
                }
            }


            if (output != null) {
                break;
            }
        }
        return output;
    }
}
