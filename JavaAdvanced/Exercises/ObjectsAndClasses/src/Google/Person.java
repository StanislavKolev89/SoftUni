package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemon;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }

    public Person(String name, Company company) {
        this.name = name;
        this.company = company;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }

    public Person(String name, Company company, Car car) {
        this.name = name;
        this.company = company;
        this.car = car;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    @Override

    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(name).append("\n");
        build.append("Company:").append("\n");
        if (company != null) {
            build.append(company).append("\n");
        }
        build.append("Car:").append("\n");
        if (car != null) {
            build.append(car).append("\n");
        }
        build.append("Pokemon:").append("\n");
        if (!pokemon.isEmpty()) {
            for (Pokemon pokemon : pokemon) {
                build.append(pokemon.toString().replaceAll("[\\[\\]]", "")).append("\n");
            }
        }
        build.append("Parents:").append("\n");
        if (!parents.isEmpty()) {
            for (Parents parents : parents) {
                build.append(parents.toString().replaceAll("[\\[\\]]", "")).append("\n");
            }
        }
        build.append("Children:").append("\n");
        if (!children.isEmpty()) {
            for (Children children : children) {
                build.append(children.toString().replaceAll("[\\[\\]]", "")).append("\n");
            }
        }
        return build.toString();
    }

}
