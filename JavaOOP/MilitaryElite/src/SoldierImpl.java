public abstract class SoldierImpl implements Soldier {
    private int id;
    private String firstName;
    private String lastName;

    protected SoldierImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int Id() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
}
