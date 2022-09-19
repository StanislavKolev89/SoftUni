package StrategyPattern;

import java.util.Locale;

public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public char getLetter() {
        return name.toLowerCase(Locale.ROOT).charAt(0);
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}
