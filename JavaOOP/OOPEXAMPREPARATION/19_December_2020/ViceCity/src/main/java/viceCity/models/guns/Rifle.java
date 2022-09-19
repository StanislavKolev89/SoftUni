package viceCity.models.guns;

public final class Rifle extends BaseGun{

    public Rifle(String name){
        super(name, 10, 500);
    }

    @Override
    protected final int bulletsPerShot() {
        return 5;
    }
}
