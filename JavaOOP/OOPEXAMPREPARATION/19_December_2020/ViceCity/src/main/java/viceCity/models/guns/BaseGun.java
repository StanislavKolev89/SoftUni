package viceCity.models.guns;

import viceCity.utils.Validation;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {

    private final String name;
    private final int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.name = Validation.validateName(name, "Name cannot be null or whitespace!");
        if (totalBullets < 0) {
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;

        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
        this.canFire = totalBullets > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return canFire;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    protected abstract int bulletsPerShot();

    @Override
    public final int fire() {
        totalBullets -= bulletsPerShot();
        this.canFire = totalBullets > 0;
        return bulletsPerShot();
    }
}
