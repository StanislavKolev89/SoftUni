package animals;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal {


    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Meow meow";
    }
}

