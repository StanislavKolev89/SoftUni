public class Tiger extends Felime {

    protected Tiger(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            super.eat(food);
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
