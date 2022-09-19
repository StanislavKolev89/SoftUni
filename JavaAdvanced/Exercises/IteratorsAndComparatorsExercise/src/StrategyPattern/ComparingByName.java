package StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class ComparingByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int result = 0;
        result = Integer.compare(o2.getName().length(),o1.getName().length());
        if(result==0){
            result=Integer.compare((int) o1.getLetter(),(int)o2.getLetter());
        }
        return result;
    }
}
