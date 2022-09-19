package hell.interfaces;

import hell.interfaces.*;

import java.util.Collection;


public class HeroImpl implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;

    protected HeroImpl(String name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public long getStrength() {
        return 0;
    }

    @Override
    public long getAgility() {
        return 0;
    }

    @Override
    public long getIntelligence() {
        return 0;
    }

    @Override
    public long getHitPoints() {
        return 0;
    }

    @Override
    public long getDamage() {
        return 0;
    }

    @Override
    public Collection<Item> getItems() {
        return null;
    }

    @Override
    public void addRecipe(Recipe recipe) {

    }

    @Override
    public void addItem(Item item) {

    }
}
