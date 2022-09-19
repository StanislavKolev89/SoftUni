import SpeedRacing.Car;
import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
      Map<String,Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split("\\s+");
            Car car = new Car(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
            cars.put(data[0],car);
        }

        String command = scanner.nextLine();
        while(!command.equals("End")){
            String [] carInfo = command.split("\\s+");
                Car carToDrive = cars.get(carInfo[1]);
                int distanceToDrive = Integer.parseInt(carInfo[2]);

                if(!carToDrive.isTraveling(distanceToDrive)){
                    System.out.println("Insufficient fuel for the drive");
                }

            command = scanner.nextLine();
        }
        for(Car car: cars.values()){
            System.out.println(car.toString());
        }

    }
}
