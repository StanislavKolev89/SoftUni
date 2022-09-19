package Military.entities;

import Military.interfaces.Private;
import Military.interfaces.Soldier;

public class SoldierImpl implements Soldier, Private {
    private int id;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String firstName;
    private String lastName;

    protected SoldierImpl(int id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String firstName() {
        return this.firstName;
    }

    @Override
    public String lastName() {
        return this.lastName;
    }

    @Override
    public double getSalary() {
        return 0;
    }
}
