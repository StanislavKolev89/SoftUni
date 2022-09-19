import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Map<String, List<Double>> studentsGrades = new TreeMap<>();

            int n = Integer.parseInt(scanner.nextLine());

            while(n-->0){
                String[] data = scanner.nextLine().split("\\s+");
                String name = data[0];
                double grade = Double.parseDouble(data[1]);

                if(!studentsGrades.containsKey(name)){
                    studentsGrades.put(name,new ArrayList<>());
                    studentsGrades.get(name).add(grade);
                }else{
                    studentsGrades.get(name).add(grade);
                }
            }

            studentsGrades.entrySet().stream().forEach(e->{
                System.out.printf("%s -> ",e.getKey());
                double average = 0;
                for (double grade: e.getValue()) {
                    System.out.printf("%.2f ", grade);
                    average +=grade;
                }
                average /=e.getValue().size();
                System.out.printf("(avg: %.2f)%n", average);
                    });


    }
}
