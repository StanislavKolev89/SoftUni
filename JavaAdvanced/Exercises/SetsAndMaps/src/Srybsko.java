import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Srybsko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Map<String,Integer>> placesAndSingers = new LinkedHashMap<>();
        while(!input.equals("End")){
            if(!input.contains("@") || input.charAt(input.indexOf("@")-1) != ' '){
                input = scanner.nextLine();
                continue;
            }
            String singerName = input.substring(0,input.indexOf("@")-1);
            int indexOfStart = input.indexOf("@")+1;
            int indexOfEnd=0;
            for (int i = input.indexOf("@"); i < input.length(); i++) {
                if(Character.isDigit(input.charAt(i)) && input.charAt(i-1) ==' '){
                    indexOfEnd = i;
                    break;
                }
            }
            if(indexOfEnd==0){
                input=scanner.nextLine();
                continue;
            }

            String place = input.substring(indexOfStart,indexOfEnd-1);
            String [] digits = input.substring(indexOfEnd,input.length()).split("\\s+");
            if(digits.length!=2){
                input= scanner.nextLine();
                continue;
            }
            int totalSum = Integer.parseInt(digits[0])*Integer.parseInt(digits[1]);

            if(!placesAndSingers.containsKey(place)){
                placesAndSingers.put(place,new LinkedHashMap<>());
                placesAndSingers.get(place).put(singerName,totalSum);
            }else{
                if(!placesAndSingers.get(place).containsKey(singerName)){
                    placesAndSingers.get(place).put(singerName,totalSum);
                }else{
                    placesAndSingers.get(place).put(singerName,placesAndSingers.get(place).get(singerName)+totalSum);
                }
            }
            input= scanner.nextLine();
        }
        placesAndSingers.entrySet().stream().forEach(e->{
            System.out.println(e.getKey());
            e.getValue().entrySet().stream().sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue())).forEach(el->
                    System.out.printf("#  %s -> %d%n",el.getKey(),el.getValue()));
        });
    }
}
