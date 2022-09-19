import core.ControllerImpl;
import core.interfaces.Controller;
import entities.bakedFoods.interfaces.BakedFood;
import entities.drinks.interfaces.Drink;
import entities.tables.interfaces.Table;
import repositories.interfaces.DrinkRepository;
import repositories.interfaces.FoodRepository;
import repositories.interfaces.TableRepository;

public class Main {
    public static void main(String[] args) {

        String a = " ";
        int a1 = a.length();
        FoodRepository<BakedFood> foodRepository ; // TODO:  new FoodRepositoryImpl<>();
        DrinkRepository<Drink> drinkRepository;  // TODO:  new DrinkRepositoryImpl<>();
        TableRepository<Table> tableRepository; // TODO:  new TableRepositoryImpl<>();

        Controller controller = new ControllerImpl(foodRepository,drinkRepository,tableRepository); // TODO: new ControllerImpl(foodRepository, drinkRepository, tableRepository);

        // TODO:OPTIONAL
//        ConsoleReader reader = new ConsoleReader();
//        ConsoleWriter writer = new ConsoleWriter();
//        EngineImpl engine = new EngineImpl(reader, writer, controller);
//        engine.run();
    }
}
