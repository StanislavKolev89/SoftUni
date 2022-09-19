import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String data = scanner.nextLine();
        while(!data.equals("END")){
            String [] input = data.split(", ");
                setChange(cars,input[0],input[1]);

            data = scanner.nextLine ();
        }
            printSet(cars);
    }

    private static void printSet(Set<String> cars) {
        if(cars.isEmpty()){
            System.out.println("Parking lot is Empty");
        }else{
            cars.forEach(System.out::println);
        }
    }

    private static void setChange(Set<String> cars, String s, String s1) {
        if(s.equals("IN")){
            cars.add(s1);
        }else{
            cars.remove(s1);
        }
    }
}
