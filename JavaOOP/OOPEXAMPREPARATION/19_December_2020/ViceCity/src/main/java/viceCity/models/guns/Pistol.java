package viceCity.models.guns;

public final class Pistol extends BaseGun {

    public Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    protected final int bulletsPerShot() {
        return 1;
    }
}
