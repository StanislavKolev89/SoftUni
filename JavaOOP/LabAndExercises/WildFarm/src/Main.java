import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            Animal animal = null;
            String[] data = input.split("\\s+");
            if (data.length == 5) {
                animal = new Cat(data[0], data[1], Double.parseDouble(data[2]), data[3], data[4]);
            } else {
                switch (data[0]) {
                    case "Tiger":
                        animal = new Tiger(data[0], data[1], Double.parseDouble(data[2]), data[3]);
                        break;
                    case "Mouse":
                        animal = new Mouse(data[0], data[1], Double.parseDouble(data[2]), data[3]);
                        break;
                    case "Zebra":
                        animal = new Zebra(data[0], data[1], Double.parseDouble(data[2]), data[3]);
                        break;
                }
            }

            animal.makeSound();
            String [] foodData = scanner.nextLine().split("\\s+");
            Food food = null;
            String foodType = foodData[0];
            int foodQuantity = Integer.parseInt(foodData[1]);
            if(foodType.equals("Vegetable")){
                food = new Vegetable(foodQuantity);
            }else{
                food = new Meat(foodQuantity);
            }
            try{
                animal.eat(food);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            animalList.add(animal);
            input = scanner.nextLine();
        }

       animalList.stream().forEach(e->
           System.out.println(e.toString()));



    }
}
