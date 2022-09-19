import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class pPre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> newListOfNames = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> filter = str-> str.startsWith("oto");

        for (String name: newListOfNames) {
         if(filter.test(name)){
             newListOfNames.remove(name);
         }
        }
        System.out.println(newListOfNames);
    }
}
