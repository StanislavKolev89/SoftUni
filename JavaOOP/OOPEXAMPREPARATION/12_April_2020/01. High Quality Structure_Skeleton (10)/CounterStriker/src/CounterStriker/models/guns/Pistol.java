package CounterStriker.models.guns;

public class Pistol extends GunImpl {

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() > 0) {
            setBulletCount(getBulletsCount() - 1);
            return 1;
        }
        return 0;
    }
}
