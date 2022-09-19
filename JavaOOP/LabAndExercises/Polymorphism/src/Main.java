
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(createVehicle(scanner));
        vehicleList.add(createVehicle(scanner));
        vehicleList.add(createVehicle(scanner));
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            switch (data[0]) {
                case "Drive":
                    switch (data[1]) {
                        case "Car":
                            System.out.println(vehicleList.get(0).distance(Double.parseDouble(data[2])));
                            break;
                        case "Truck":
                            System.out.println(vehicleList.get(1).distance(Double.parseDouble(data[2])));
                            break;
                        case "Bus":
                            vehicleList.get(2).distance(Double.parseDouble(data[2]),true);
                    }
                    break;
                case "Refuel":
                    switch (data[1]) {
                        case "Car":
                            vehicleList.get(0).refuel(Double.parseDouble(data[2]));
                            break;
                        case "Truck":
                            vehicleList.get(1).refuel(Double.parseDouble(data[2]));
                            break;
                        case"Bus":
                            vehicleList.get(2).refuel(Double.parseDouble(data[2]));
                            break;
                    }
                    break;
                case"DriveEmpty":
                    System.out.println(vehicleList.get(2).distance(Double.parseDouble(data[2])));
            }
        }

        System.out.println(vehicleList.get(0).toString());
        System.out.println(vehicleList.get(1).toString());
        System.out.println(vehicleList.get(2).toString());
    }

    private static Vehicle createVehicle(Scanner scanner) {
        Vehicle vehicle = null;
        String[] line = scanner.nextLine().split("\\s+");
        switch (line[0]) {
            case "Car":
                vehicle = new Car(Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3]));
                break;
            case "Truck":
                vehicle = new Truck(Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3]));
                break;
            case "Bus":
                vehicle = new Bus(Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3]));
        }
        return vehicle;
    }
}
