import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> username = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        while(n-->0){
            username.add(scanner.nextLine());
        }
        username.forEach(e-> System.out.println(e));
    }
}
