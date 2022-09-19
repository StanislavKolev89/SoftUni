import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;
    protected Cat(String animalType, String animalName, double animalWeight, String livingRegion,String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getClass().getSimpleName(),
                this.getAnimalName(), this.breed, format.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
