package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;


    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean removeRabbit(String name) {
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)) {
                this.data.remove(rabbit);
                return true;
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(species)) {
                this.data.remove(i);
                i--;
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit1 = new Rabbit();
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                rabbit1 = rabbit;
                break;
            }
        }
        return rabbit1;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitList = new ArrayList<>();
        for (Rabbit rabbit1: data) {
            if(rabbit1.getSpecies().equals(species)){
                rabbitList.add(rabbit1);
                rabbit1.setAvailable(false);
            }
        }
        return rabbitList;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Rabbits available at %s:", this.name)).append(System.lineSeparator());
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()==true) {
                builder.append(rabbit).append(System.lineSeparator());
            }

        }
        return builder.toString().trim();
    }

    public void add(Rabbit rabbit) {
        if(this.data.size()<capacity){
            data.add(rabbit);
        }
    }
}
