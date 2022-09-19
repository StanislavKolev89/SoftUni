package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;
    private int badges;
    private List<Pokemon> pokemon;

    public Trainer(String name){
        this.name = name;
        this.badges=0;
        this.pokemon = new ArrayList<>();
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public int getBadges() {
        return badges;
    }

    public String getName() {
        return name;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

@Override
    public String toString(){
      return  this.name+" "+getBadges()+" "+ this.pokemon.size();
}
}
