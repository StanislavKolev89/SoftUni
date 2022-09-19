import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;

    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food.getQuantity());

    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", this.getClass().getSimpleName(),
                this.getAnimalName(), format.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
