package PokemonTrainer;

import javax.lang.model.element.Element;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String pokemonName = tokens[1];
            String elementOfPokemon = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            Trainer trainer = new Trainer(name);

            Pokemon pokemon = new Pokemon(pokemonName, elementOfPokemon, health);

            if (!trainers.containsKey(name)) {
                trainers.put(name, trainer);
                trainer.getPokemon().add(pokemon);
            } else {
                trainers.get(name).getPokemon().add(pokemon);
            }

            input = scanner.nextLine();
        }

        String commands = scanner.nextLine();
        int counter = 0;
        while (!commands.equals("End")) {
            counter++;
            for (var trainer : trainers.entrySet()) {
                if (elementExist(commands, trainer.getValue())) {
                    trainer.getValue().setBadges(trainer.getValue().getBadges() + 1);
                } else {
                    for (Pokemon pokemon : trainer.getValue().getPokemon()) {
                        pokemon.setHealth(pokemon.getHealth() - 10);
                        if(pokemon.getHealth()<=0){
                            int index = trainer.getValue().getPokemon().indexOf(pokemon);
                            trainer.getValue().getPokemon().set(index,new Pokemon("null","null",0));
                            if(trainer.getValue().getPokemon().isEmpty()){
                                break;
                            }
                    }
                }
            }

        }
        commands = scanner.nextLine();
    }
        for (Trainer trainer: trainers.values()) {

                for (int i = 0; i < trainer.getPokemon().size(); i++) {
                    if(trainer.getPokemon().get(i).getElement().equals("null")){
                        trainer.getPokemon().remove(trainer.getPokemon().remove(i));
                        i--;
                    }
            }
        }
        trainers.entrySet().
                stream().sorted((e1,e2)-> Integer.compare(e2.getValue().getBadges(),e1.getValue().getBadges())).forEach(e-> System.out.printf("%s%n",e.getValue()));


}

    private static boolean elementExist(String commands, Trainer value) {

        for (Pokemon pokemon : value.getPokemon()) {
            if (pokemon.getElement().equals(commands)) {
                return true;
            }
        }
        return false;
    }
}