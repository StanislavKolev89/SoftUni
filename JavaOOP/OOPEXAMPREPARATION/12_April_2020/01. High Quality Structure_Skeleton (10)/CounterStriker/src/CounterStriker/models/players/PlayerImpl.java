package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {

    private String username;
    private int health;
    private int armor;
    private int isAlive;
    private Gun gun;
    private static boolean armorAlreadyZero = false;

    protected PlayerImpl(String name, int health, int armor, Gun gun) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = name;
        setHealth(health);
        setArmor(armor);
        setGun(gun);
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {
        int pointLeft = 0;
        int result = getArmor() - points;
            if (result > 0) {
                setArmor(result);
            } else if (result == 0) {
                setArmor(result);
            } else {
                pointLeft = Math.abs(result);
                setArmor(0);
                int result2 = getHealth()-pointLeft;
                if(result2>0) {
                    setHealth(getHealth() - pointLeft);
                }else{
                    setHealth(0);
                }
            }

    }
}
