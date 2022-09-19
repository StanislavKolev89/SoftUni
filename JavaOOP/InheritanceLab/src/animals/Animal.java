package animals;

import java.security.PublicKey;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
       setName(name);
        setAge(age);
       setGender(gender);
    }

    protected  void setGender(String gender){
        if(gender.equals("")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    protected void setAge(int age){
        if(age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;

    }

    protected  void setName(String name){
        if(name.equals("")){
            throw new IllegalArgumentException("Invalid input!");
        }
      this.name = name;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.getClass().getSimpleName()).append(System.lineSeparator());
        builder.append(String.format("%s %d %s", this.name, this.age, this.gender)).append(System.lineSeparator());
        builder.append(produceSound()).append(System.lineSeparator());
        return builder.toString().trim();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String produceSound(){
      return "";
    }
}
