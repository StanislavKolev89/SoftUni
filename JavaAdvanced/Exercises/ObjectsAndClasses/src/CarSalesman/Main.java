package CarSalesman;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Engine> engines = new ArrayList<>();

        int enginesNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < enginesNumber; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            fillingEngineList(engineData, engines);
        }
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String Model = carData[0];
            Engine engineToPut = findingEngine(engines, carData[1]);
            fillingCarList(carData, engineToPut, cars);

        }
        cars.forEach(e-> System.out.println(e));
    }

    private static void fillingCarList(String[] carData, Engine engineToPut, List<Car> cars) {
        Car car = null;
        String carModel = carData[0];
        if (carData.length == 2) {
            car = new Car(carModel, engineToPut);
        } else if (carData.length == 3) {
            try {
                int weigth = Integer.parseInt(carData[2]);
                car = new Car(carModel, engineToPut, weigth);
            } catch (NumberFormatException e) {
                String color = carData[2];
                car = new Car(carModel, engineToPut, color);
            }
        } else {
            car = new Car(carModel, engineToPut, Integer.parseInt(carData[2]), carData[3]);
        }
        cars.add(car);
    }

    private static Engine findingEngine(List<Engine> engines, String carDatum) {
        Engine engineToPut = null;
        for (Engine engine : engines) {
            if (carDatum.equals(engine.getModel())) {
                engineToPut = engine;
                break;
            }
        }
        return engineToPut;
    }

    private static void fillingEngineList(String[] engineData, List<Engine> engines) {
        Engine engine = null;
        String engineModel = engineData[0];
        int horsePower = Integer.parseInt(engineData[1]);
        if (engineData.length == 3) {
            try {
                int displacement = Integer.parseInt(engineData[2]);
                engine = new Engine(engineModel, horsePower, displacement);
            } catch (NumberFormatException e) {
                String efficiency = engineData[2];
                engine = new Engine(engineModel, horsePower, efficiency);
            }
        } else if(engineData.length==4){
            engine = new Engine(engineModel, horsePower, Integer.parseInt(engineData[2]), engineData[3]);
        }else{
            engine = new Engine(engineModel, horsePower);
        }
        engines.add(engine);
    }
}
